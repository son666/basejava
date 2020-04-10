package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        storage.clear();
        for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
            try {
                storage.save(new Resume("fullName" + i));
            } catch (StorageException e) {
                Assert.fail("Возникала ошибка в процессе заполнения хранилища: " + e.getMessage());
            }
        }
        storage.save(new Resume("fullName" + AbstractArrayStorage.STORAGE_LIMIT + 1)); //Переполняем массив
    }

}