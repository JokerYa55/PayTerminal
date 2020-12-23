package app.dao;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author vasil
 */
public interface DaoInterface<T, K> {

    public Optional<T> findById(K id);

    public List<T> getItemList(long resCount, long skipCount);

    public List<T> getAllList();

    public T update(T item);

    public void delete(T item);
}
