package au.net.woodberry.d2d.cafe.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * An interface for retrieving information.
 *
 * @param <T> The type of data this repository is retrieving.
 */
public interface Repository<T> {

    /**
     * Find a value from this repository.
     *
     * @param value The single value to query on.
     * @return The result if found, null otherwise.
     */
    T findByValue(String value);

    /**
     * Find a list of values from this repository.
     *
     * @param values The list of values to query on.
     * @return The result if found, empty otherwise.
     */
    default List<T> findByValuesIn(String... values) {
        return Stream.of(values).map(this::findByValue).collect(Collectors.toList());
    }
}
