package au.net.woodberry.d2d.cafe.domain;

import java.math.BigDecimal;

/**
 * An extension of a menu item to represent a preparation item.
 */
public class MenuItemPreparation extends MenuItem {

    public MenuItemPreparation(String itemName, BigDecimal price) {
        super(itemName, price);
    }
}
