package com.urise.webapp.model;

public enum SectionContact {
    PHONE("Тел.:"),
    SKYPE("Skype:"),
    MAIL("Email:"),
    MEDIA("Media:");

    private String title;

    SectionContact(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}