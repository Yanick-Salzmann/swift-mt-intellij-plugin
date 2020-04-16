package com.six.plugins.intellij.swift.mt.syntax;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

%%

%class SwiftMtSyntaxHighlighter
%implements FlexLexer
%unicode

%function advance
%type IElementType

CRLF=\R
BH_START=\{1:
AH_START=\{2:
UH_START=\{3:
MT_START=\{4:{CRLF}
MT_END={CRLF}-}
BLOCK_CONTENT=[^}]
BLOCK_END=\}

SYS_FIELD_START=\{
SYS_FIELD_END=\}
SYS_FIELD_CONTENT=[^}]

%state HEADER_BLOCK
%state USER_HEADER
%state SYS_FIELD
%state MESSAGE_TEXT

%%

<YYINITIAL> {BH_START} { yybegin(HEADER_BLOCK); return SwiftMtTypes.BLOCK_BOUND; }
<YYINITIAL> {AH_START} { yybegin(HEADER_BLOCK); return SwiftMtTypes.BLOCK_BOUND; }

<HEADER_BLOCK> {BLOCK_END} { yybegin(YYINITIAL); return SwiftMtTypes.BLOCK_BOUND; }
<HEADER_BLOCK> [^] { return SwiftMtTypes.HEADER_BLOCK; }

<YYINITIAL> {UH_START} { yybegin(USER_HEADER); return SwiftMtTypes.BLOCK_BOUND; }

<USER_HEADER> {SYS_FIELD_START} { yybegin(SYS_FIELD); return SwiftMtTypes.SYSTEM_FIELD; }
<SYS_FIELD> {SYS_FIELD_END} { yybegin(USER_HEADER); return SwiftMtTypes.SYSTEM_FIELD; }
<SYS_FIELD> [^] { return SwiftMtTypes.SYSTEM_FIELD; }
<USER_HEADER> {BLOCK_END} { yybegin(YYINITIAL); return SwiftMtTypes.BLOCK_BOUND; }

<YYINITIAL> {MT_START} { yybegin(MESSAGE_TEXT); return SwiftMtTypes.BLOCK_BOUND; }
<MESSAGE_TEXT> {MT_END} { yybegin(YYINITIAL); return SwiftMtTypes.BLOCK_BOUND; }
<MESSAGE_TEXT> [^] { return SwiftMtTypes.MESSAGE_TEXT; }

[^] { return SwiftMtTypes.INVALID_CHAR; }