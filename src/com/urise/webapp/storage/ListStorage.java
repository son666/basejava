package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> listResume = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < listResume.size(); i++) {
            if (uuid.equals(listResume.get(i).getUuid())) return i;
        }
        return null;
    }

    @Override
    protected void updateElement(Object searchKey, Resume resume) {
        listResume.set((Integer) searchKey, resume);

    }

    @Override
    protected void saveElement(Resume resume, Object searchKey) {
        listResume.add(resume);
    }

    @Override
    protected Resume getElement(Object searchKey) {
        return listResume.get((Integer) searchKey);
    }

    @Override
    protected void deleteElement(Object searchKey) {
        int indexNumber = (Integer) searchKey;
        listResume.remove(indexNumber);
    }

    @Override
    public List<Resume> getCopyAllElement() {
        return new ArrayList<>(listResume);
    }

    @Override
    public void clear() {
        listResume.clear();
    }


    @Override
    public int size() {
        return listResume.size();
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }
}
