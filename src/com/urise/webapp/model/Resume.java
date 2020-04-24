package com.urise.webapp.model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    private final String uuid;
    private final String fullName;
    private Map<SectionContact, String> contacts = new EnumMap<>(SectionContact.class);
    private Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

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
        contacts.put(typeContact, value);
    }

    public void addSection(SectionType typeSection, Section objectSection) {
        sections.put(typeSection, objectSection);
    }

    public String getContact(SectionContact typeContact) {
        return contacts.get(typeContact);
    }

    public Section getSection(SectionType typeSection) {
        return sections.get(typeSection);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;
        boolean result = ((uuid.equals(resume.getUuid())) &&
                (fullName.equals(resume.getFullName())) &&
                (contacts.equals(resume.contacts)) &&
                (sections.equals(resume.sections)));
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, contacts, sections);
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
