package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> listResume = new ArrayList<>();

    @Override
    protected int getIndex(String uuid) {
        Resume resume = new Resume(uuid);
        return listResume.indexOf(resume);
    }

    @Override
    protected void updateElement(int index, Resume resume) {
        listResume.set(index, resume);

    }

    @Override
    protected void saveElement(Resume resume) {
        listResume.add(resume);
    }

    @Override
    protected Resume getElement(int index) {
        return listResume.get(index);
    }

    @Override
    protected void deleteElement(int index) {
        listResume.remove(index);
    }

    @Override
    public void clear() {
        listResume.clear();
    }

    @Override
    public Resume[] getAll() {
        return listResume.toArray(new Resume[listResume.size()]);
    }

    @Override
    public int size() {
        return listResume.size();
    }
}
