package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void update(Resume r) {
        Resume resume = findResume(r.getUuid());
        if (resume instanceof Resume) {
            int index = Arrays.asList(storage).indexOf(resume);
            storage[index] = r;
        }
        else {
            System.out.println("Resume отсутсвует в хранилище");
        }
    }

    public void save(Resume r) {
        Resume resume = findResume(r.getUuid());
        if (resume instanceof Resume) {
            System.out.println("Resume уже присутствует в хранилище");
        }
        else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        Resume resume = findResume(uuid);
        if (!(resume instanceof Resume)) {
            System.out.println("Resume с №" + uuid + " отсутсвует в хранилище");
        }
        return resume;
    }

    public void delete(String uuid) {
        Resume resume = findResume(uuid);
        if (resume instanceof Resume) {
            int index = Arrays.asList(storage).indexOf(resume);
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
        else {
            System.out.println("Resume отсутсвует в хранилище");
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

    private Resume findResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }
}
