package au.net.woodberry.d2d.cafe.domain;

import java.math.BigDecimal;

/**
 * A representation of a menu item size as denoted by (x) e.g. x0.75
 * Each size represented by this class will have a multiplier that affects the overall final cost of all menu items
 */
public class MenuItemSize {

    private final String sizeName;
    private final BigDecimal multiplier;

    public MenuItemSize(String sizeName, BigDecimal multiplier) {
        this.sizeName = sizeName;
        this.multiplier = multiplier;
    }

    public String getSizeName() {
        return sizeName;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }
}
