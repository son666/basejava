package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class Position {

    private final YearMonth startDate;
    private final YearMonth endDate;
    private final String position;
    private final String activity;

    public Position(YearMonth startDate, YearMonth endDate, String position, String activity) {
        Objects.requireNonNull(startDate, "Start Date must not be null");
        Objects.requireNonNull(endDate, "End Date must not be null");
        Objects.requireNonNull(position, "Position must not be null");
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.activity = activity;
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
        Position position1 = (Position) o;
        return startDate.equals(position1.startDate) &&
                endDate.equals(position1.endDate) &&
                position.equals(position1.position) &&
                Objects.equals(activity, position1.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, position, activity);
    }

    @Override
    public String toString() {
        return "Positions{" +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", position='" + position + '\'' +
                ", activity='" + activity + '\'' +
                '}';
    }

}
