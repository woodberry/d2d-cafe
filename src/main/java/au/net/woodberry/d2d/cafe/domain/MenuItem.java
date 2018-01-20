package au.net.woodberry.d2d.cafe.domain;

import java.math.BigDecimal;

/**
 * A representation of the cafe's menu item as denoted by ($).
 * As the cafe is known for its wide range of coffee's most menu items will be coffee-based, however from
 * a domain-perspective, "coffee" is just another menu item.
 * <p>
 * A base menu item consists of a name and a price.
 * </p>
 */
public class MenuItem {

    private final String itemName;
    private final BigDecimal price;

    public MenuItem(String itemName, BigDecimal price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
