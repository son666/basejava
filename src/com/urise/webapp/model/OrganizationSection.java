package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class OrganizationSection extends Section<List<Position>> {
    private List<Position> content;

    public OrganizationSection(List<Position> listPosition) {
        Objects.requireNonNull(listPosition, "List Position must not be null");
        content = listPosition;
    }

    public List<Position> getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
