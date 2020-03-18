package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.UUID;


public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private String uuid = UUID.randomUUID().toString();

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume resume = storage.get(UUID_2);
        storage.update(resume);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        Resume resume = new Resume(uuid);
        storage.update(resume);
    }

    @Test
    public void save() {
        storage.save(new Resume(uuid));
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExistStorageException() {
        storage.save(new Resume(UUID_1));
    }

    @Test(expected = StorageException.class)
    public void saveStorageException() throws Exception {
        storage.clear();
        //TODO доделать
        for (int i = 0; i < 10000; i++) {
            try {
                storage.save(new Resume());
            } catch (StorageException e) {
                Assert.fail("Возникала ошибка в процессе заполнения хранилища: " + e.getMessage());
            }
        }
        storage.save(new Resume()); //Переполняем массив
    }

    @Test
    public void get() {
        Resume resume = storage.get(UUID_1);
        Assert.assertEquals(storage.get(UUID_1), resume);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(uuid);
    }

    @Test
    public void getAll() {
        Resume[] resumes = storage.getAll();
        for (int i = 0; i < storage.size(); i++) {
            Assert.assertEquals(storage.get(resumes[i].toString()), resumes[i]);
        }
    }

}