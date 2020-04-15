package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class Position {
    private String nameOrganization;

    private YearMonth startDate;
    private YearMonth endDate;
    private String position;
    private String activity;

    public Position(String nameOrganization, YearMonth startDate, YearMonth endDate, String position, String activity) {
        Objects.requireNonNull(nameOrganization, "Name organization must not be null");
        Objects.requireNonNull(startDate, "Start Date must not be null");
        Objects.requireNonNull(endDate, "End Date must not be null");
        Objects.requireNonNull(position, "Position must not be null");
        this.nameOrganization = nameOrganization;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position that = (Position) o;
        return Objects.equals(nameOrganization, that.nameOrganization) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(position, that.position) &&
                Objects.equals(activity, that.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOrganization, startDate, endDate, position, activity);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "nameOrganization='" + nameOrganization + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", position='" + position + '\'' +
                ", activity='" + activity + '\'' +
                '}';
    }

}
