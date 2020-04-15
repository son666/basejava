package com.urise.webapp.model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    private final String uuid;
    private final String fullName;
    private Map<SectionContact, String> contact = new EnumMap<>(SectionContact.class);
    private Map<SectionType, Section> section = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void addContact(SectionContact typeContact, String value) {
        contact.put(typeContact, value);
    }

    public void addSection(SectionType typeSection, Section objectSection) {
        section.put(typeSection, objectSection);
    }

    public String getContact(SectionContact typeContact) {
        return contact.get(typeContact);
    }

    public Section getSection(SectionType typeSection) {
        return section.get(typeSection);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.getUuid())) return false;
        return fullName.equals(resume.getFullName());
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }


    @Override
    public int compareTo(Resume o) {
        int result = fullName.compareTo(o.getFullName());
        if (result == 0) {
            return uuid.compareTo(o.getUuid());
        }
        return result;
    }
}
