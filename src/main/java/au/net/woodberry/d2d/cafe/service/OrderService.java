package au.net.woodberry.d2d.cafe.service;

import au.net.woodberry.d2d.cafe.domain.MenuItem;
import au.net.woodberry.d2d.cafe.exception.UnableToFulfilOrderException;

import java.math.BigDecimal;
import java.util.List;

/**
 * An ordering service that can process incoming order requests. These requests can come from clients such as a point of
 * sale system, but the interface should also be able to accept orders by other means (online web site or app for example).
 */
public interface OrderService {

    /**
     * Prepare an order so its total cost can be determined.
     *
     * @param item           The base item being ordered.
     * @param preparation    The preparation requirements for the order.
     * @param optionalExtras Additional optional extras.
     * @return An itemised list of menu items that make up the order.
     * @throws UnableToFulfilOrderException If the order is invalid
     */
    List<MenuItem> prepareOrder(String item, String preparation, String... optionalExtras) throws UnableToFulfilOrderException;

    /**
     * Calculates and returns the total cost of the order.
     *
     * @param menuItems A list of menu items that make up the order.
     * @param sizeName  The size of the order.
     * @return The total cost of the order
     * @throws UnableToFulfilOrderException If the order is invalid and the total cost cannot be determined.
     */
    BigDecimal getTotalCost(List<MenuItem> menuItems, String sizeName) throws UnableToFulfilOrderException;
}
