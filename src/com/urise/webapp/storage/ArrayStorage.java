package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("Resume c № " + resume.getUuid() + " уже присутствует в хранилище");
        } else if (size == storage.length) {
            System.out.println("В хранилище нет места!");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
