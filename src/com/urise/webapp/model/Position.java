package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class Position {
    private String namePosition;

    private YearMonth startDate;
    private YearMonth endDate;
    private String position;
    private String activity;

    public Position(String namePosition, YearMonth startDate, YearMonth endDate, String position, String activity) {
        Objects.requireNonNull(namePosition, "Name organization must not be null");
        Objects.requireNonNull(startDate, "Start Date must not be null");
        Objects.requireNonNull(endDate, "End Date must not be null");
        Objects.requireNonNull(position, "Position must not be null");
        this.namePosition = namePosition;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.activity = activity;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public YearMonth getStartDate() {
        return startDate;
    }

    public YearMonth getEndDate() {
        return endDate;
    }

    public String getPosition() {
        return position;
    }

    public String getActivity() {
        return activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position that = (Position) o;
        return Objects.equals(namePosition, that.namePosition) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(position, that.position) &&
                Objects.equals(activity, that.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePosition, startDate, endDate, position, activity);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "nameOrganization='" + namePosition + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", position='" + position + '\'' +
                ", activity='" + activity + '\'' +
                '}';
    }

}
