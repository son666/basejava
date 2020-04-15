package com.urise.webapp.model;

import java.util.Objects;

public class TextSection extends Section<String> {
    private String content;

    public TextSection(String content) {
        Objects.requireNonNull(content, "Text must not be null");
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}
