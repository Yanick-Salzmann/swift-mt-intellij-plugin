package com.six.plugins.intellij.swift.mt.syntax;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;
import org.jetbrains.annotations.NotNull;

public class SwiftMtSyntaxHighlighterAdapter extends FlexAdapter {
    public SwiftMtSyntaxHighlighterAdapter() {
        super(new SwiftMtSyntaxHighlighter(null));
    }
}
