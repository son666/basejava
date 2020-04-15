package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> listResume = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < listResume.size(); i++) {
            if (uuid.equals(listResume.get(i).getUuid())) return i;
        }
        return null;
    }

    @Override
    protected void updateElement(Integer searchKey, Resume resume) {
        listResume.set(searchKey, resume);

    }

    @Override
    protected void saveElement(Resume resume, Integer searchKey) {
        listResume.add(resume);
    }

    @Override
    protected Resume getElement(Integer searchKey) {
        return listResume.get(searchKey);
    }

    @Override
    protected void deleteElement(Integer searchKey) {
        int indexNumber = searchKey;
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
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }
}
