package com.six.plugins.intellij.swift.mt.syntax;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SwiftMtHighlighter extends SyntaxHighlighterBase {
    private static final TextAttributesKey BLOCK_BOUND = createTextAttributesKey("BLOCK_BOUND", DefaultLanguageHighlighterColors.CONSTANT);
    private static final TextAttributesKey HEADER_BLOCK = createTextAttributesKey("HEADER_BLOCK", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    private static final TextAttributesKey SYS_FIELD = createTextAttributesKey("SYS_FIELD", DefaultLanguageHighlighterColors.METADATA);
    private static final TextAttributesKey MESSAGE_TEXT = createTextAttributesKey("MESSAGE_TEXT", DefaultLanguageHighlighterColors.STRING);
    private static final TextAttributesKey BAD_CHAR = createTextAttributesKey("BAD_CHAR", HighlighterColors.BAD_CHARACTER);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SwiftMtSyntaxHighlighterAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if(tokenType == SwiftMtTypes.HEADER_BLOCK || tokenType == SwiftMtTypes.USER_BLOCK) {
            return new TextAttributesKey[]{HEADER_BLOCK};
        } else if(tokenType == SwiftMtTypes.BLOCK_BOUND) {
            return new TextAttributesKey[]{BLOCK_BOUND};
        } else if(tokenType == SwiftMtTypes.SYSTEM_FIELD) {
            return new TextAttributesKey[]{SYS_FIELD};
        } else if(tokenType == SwiftMtTypes.MESSAGE_TEXT) {
            return new TextAttributesKey[]{MESSAGE_TEXT};
        } else if(tokenType == SwiftMtTypes.INVALID_CHAR) {
            return new TextAttributesKey[]{BAD_CHAR};
        } else {
            return new TextAttributesKey[0];
        }
    }

    public static class Factory extends SyntaxHighlighterFactory {
        @NotNull
        @Override
        public SyntaxHighlighter getSyntaxHighlighter(@Nullable Project project, @Nullable VirtualFile virtualFile) {
            return new SwiftMtHighlighter();
        }
    }
}
