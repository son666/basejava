import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    public static void main(String[] args) {

    }

    void clear() {
        if (this.storage[0] != null) {
            for (int i = this.size() - 1; i >= 0; i--) {
                this.storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        this.storage[this.size()] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < this.size(); i++) {
            if (this.storage[i].uuid.equals(uuid)) {
                return this.storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < this.size(); i++) {
            if (this.storage[i].uuid.equals(uuid)) {
                for (int j = i; j < this.size(); j++) {
                    this.storage[j] = this.storage[j + 1];
                }
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(this.storage, this.size());
    }

    int size() {
        if (this.storage[0] != null) {
            int count = 0;
            for (int i = 0; i < this.storage.length; i++) {
                if (this.storage[i] != null) {
                    count++;
                }
                else { break; }
            }
            return count;
        }
        else { return 0; }
    }
}
