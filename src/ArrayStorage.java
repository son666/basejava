import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = size();

    void clear() {
        if (storage[0] != null) {
            for (int i = size - 1; i >= 0; i--) {
                storage[i] = null;
            }
            size = size();
        }
    }

    void save(Resume r) {
        storage[size] = r;
        size = size();
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                for (int j = i; j < size; j++) {
                    storage[j] = storage[j + 1];
                }
                size = size();
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        if (storage[0] != null) {
            int count = 0;
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] != null) {
                    count++;
                }
                else { break; }
            }
            return count;
        }
        else { return 0; }
    }
}
