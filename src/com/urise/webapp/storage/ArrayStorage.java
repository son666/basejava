package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = findResume(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
        } else {
            System.out.println("Resume c № " + resume.getUuid() + " отсутсвует в хранилище");
        }
    }

    public void save(Resume resume) {
        if (findResume(resume.getUuid()) != -1) {
            System.out.println("Resume c № " + resume.getUuid() + " уже присутствует в хранилище");
        } else if (size == storage.length) {
            System.out.println("В хранилище нет места!");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = findResume(uuid);
        if (index == -1) {
            System.out.println("Resume с № " + uuid + " отсутсвует в хранилище");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = findResume(uuid);
        if (index == -1) {
            System.out.println("Resume с № " + uuid + " отсутсвует в хранилище");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int findResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
