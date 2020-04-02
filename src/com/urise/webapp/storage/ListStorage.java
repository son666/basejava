package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> listResume = new ArrayList<>();

    @Override
    protected Integer getKey(String uuid) {
        for (int i = 0; i < listResume.size(); i++) {
            if (uuid.equals(listResume.get(i).getUuid())) return i;
        }
        return -1;
    }

    @Override
    protected void updateElement(Object index, Resume resume) {
        listResume.set((Integer) index, resume);

    }

    @Override
    protected void saveElement(Resume resume, Object index) {
        listResume.add(resume);
    }

    @Override
    protected Resume getElement(Object index) {
        return listResume.get((Integer) index);
    }

    @Override
    protected void deleteElement(Object index) {
        int indexNumber = (Integer) index;
        listResume.remove(indexNumber);
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

    @Override
    protected boolean isKeyNotExist(Object searchKey, String uuid) {
        return (Integer) searchKey >= 0;
    }

    @Override
    protected boolean isKeyExist(Object searchKey, String uuid) {
        return (Integer) searchKey < 0;
    }
}
