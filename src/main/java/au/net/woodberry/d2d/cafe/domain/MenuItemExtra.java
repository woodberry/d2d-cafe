package au.net.woodberry.d2d.cafe.domain;

import java.math.BigDecimal;

/**
 * A representation of the cafe menu item's extras as denoted by (+). Extra's are an extended form
 * of a menu item. Extra's are categorised by an {@link MenuItemExtra.Type}. Consumers of this class
 * can use the type of menu extra item to provide additional context to the order being prepared.
 */
public class MenuItemExtra extends MenuItem {

    private final Type extraType;

    public MenuItemExtra(String itemName, BigDecimal price, Type extraType) {
        super(itemName, price);
        this.extraType = extraType;
    }

    /**
     * An enumeration of all the extra item types available
     */
    public enum Type {
        PREPARATION,
        CONDIMENT
    }

    public Type getExtraType() {
        return extraType;
    }
}
