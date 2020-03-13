package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("Resume c № " + resume.getUuid() + " уже присутствует в хранилище");
        } else if (size == storage.length) {
            System.out.println("В хранилище нет места!");
        } else {
            index = -index - 1;
            System.arraycopy(storage, index, storage, index + 1, storage.length - 1 - index);
            storage[index] = resume;
            size++;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume resume = new Resume();
        resume.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, resume);
    }
}
