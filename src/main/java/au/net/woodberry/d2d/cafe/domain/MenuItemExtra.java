package au.net.woodberry.d2d.cafe.domain;

import java.math.BigDecimal;

/**
 * A representation of the cafe menu item's extras as denoted by (+).
 */
public class MenuItemExtra extends MenuItem {

    public MenuItemExtra(String itemName, BigDecimal price) {
        super(itemName, price);
    }
}
