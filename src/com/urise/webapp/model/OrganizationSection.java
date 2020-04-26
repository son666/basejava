package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class OrganizationSection extends Section<List<Organization>> {
    private List<Organization> content;

    public OrganizationSection(List<Organization> listOrganization) {
        Objects.requireNonNull(listOrganization, "List Organization must not be null");
        content = listOrganization;
    }

    public List<Organization> getContent() {
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
