package com.six.plugins.intellij.swift.mt.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SwiftMtFileType extends LanguageFileType {
    public static final SwiftMtFileType INSTANCE = new SwiftMtFileType();
    private static final Icon FILE_ICON = IconLoader.getIcon("/icons/swift-language.png");

    public SwiftMtFileType() {
        super(SwiftMtLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return SwiftMtLanguage.DISPLAY_NAME;
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Language supporting Swift MT messages according to ISO 15022";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "smt";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return FILE_ICON;
    }
}
