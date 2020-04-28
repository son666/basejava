package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization {

    private final Link name;
    private List<Position> positions;

    public Organization(String nameOrganization, String urlOrganization, Position... positions) {
        this.name = new Link(nameOrganization, urlOrganization);
        this.positions = Arrays.asList(positions);
    }

    public Link getNameOrganization() {
        return name;
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return name.equals(that.name) &&
                positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, positions);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "nameOrganization=" + name +
                ", positions=" + positions +
                '}';
    }
}
