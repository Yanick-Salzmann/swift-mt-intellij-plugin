package com.six.plugins.intellij.swift.mt.language;

import com.intellij.lang.Language;

public class SwiftMtLanguage extends Language {
    public static final String LANGUAGE_ID = "swift-mt-language";
    public static final String DISPLAY_NAME = "Swift MT";
    public static final SwiftMtLanguage INSTANCE = new SwiftMtLanguage();

    private SwiftMtLanguage() {
        super(LANGUAGE_ID);
    }
}
