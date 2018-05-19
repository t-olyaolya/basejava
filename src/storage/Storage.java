package storage;

import com.sun.org.apache.regexp.internal.RE;
import model.Resume;

public interface Storage {

    void clear();
    void update(Resume r);
    void save(Resume r);
    Resume get(String uuid);
    void delete(String uuid);
    Resume[] getAll();
    int size();

}
