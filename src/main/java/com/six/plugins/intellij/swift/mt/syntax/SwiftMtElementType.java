package com.six.plugins.intellij.swift.mt.syntax;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import com.six.plugins.intellij.swift.mt.language.SwiftMtLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SwiftMtElementType extends IElementType {
    public SwiftMtElementType(@NotNull String debugName) {
        super(debugName, SwiftMtLanguage.INSTANCE);
    }
}
