package au.net.woodberry.d2d.cafe.repository;

import au.net.woodberry.d2d.cafe.domain.MenuItem;
import au.net.woodberry.d2d.cafe.domain.MenuItemExtra;
import au.net.woodberry.d2d.cafe.domain.MenuItemPreparation;
import au.net.woodberry.d2d.cafe.domain.MenuItemSize;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * A static representation of repository data.
 * In a real-world scenario, this would typically be in a persistent datastore, and hence, easily changed
 * however, for demo and purposes, they are hard-coded here..
 */
public class RepositoryData {

    static final Map<String, MenuItem> MENU_ITEMS = new HashMap<>();
    static final Map<String, MenuItemPreparation> MENU_ITEM_PREPARATION = new HashMap<>();
    static final Map<String, MenuItemExtra> MENU_ITEM_EXTRAS = new HashMap<>();
    static final Map<String, MenuItemSize> MENU_ITEM_SIZES = new HashMap<>();

    static {
        MENU_ITEMS.put("House Blend", new MenuItem("House Blend", BigDecimal.valueOf(1.00)));
        MENU_ITEMS.put("Dark roast", new MenuItem("Dark roast", BigDecimal.valueOf(1.50)));
        MENU_ITEMS.put("Robusta", new MenuItem("Robusta", BigDecimal.valueOf(2.00)));
        MENU_ITEMS.put("Arabica", new MenuItem("Arabica", BigDecimal.valueOf(2.50)));

        MENU_ITEM_PREPARATION.put("Espresso", new MenuItemPreparation("Espresso", BigDecimal.valueOf(1.00)));
        MENU_ITEM_PREPARATION.put("Latte", new MenuItemPreparation("Latte", BigDecimal.valueOf(1.25)));
        MENU_ITEM_PREPARATION.put("Cappuccino", new MenuItemPreparation("Cappuccino", BigDecimal.valueOf(1.50)));
        MENU_ITEM_PREPARATION.put("Macchiato", new MenuItemPreparation("Macchiato", BigDecimal.valueOf(1.75)));
        MENU_ITEM_PREPARATION.put("Mocha", new MenuItemPreparation("Mocha", BigDecimal.valueOf(2.00)));

        MENU_ITEM_EXTRAS.put("Milk", new MenuItemExtra("Milk", BigDecimal.valueOf(1.00)));
        MENU_ITEM_EXTRAS.put("Sugar", new MenuItemExtra("Expresso", BigDecimal.valueOf(0.25)));
        MENU_ITEM_EXTRAS.put("Coco powder", new MenuItemExtra("Expresso", BigDecimal.valueOf(0.10)));

        MENU_ITEM_SIZES.put("Standard", new MenuItemSize("Standard", BigDecimal.ZERO));
        MENU_ITEM_SIZES.put("Child", new MenuItemSize("Child", BigDecimal.valueOf(0.75)));
        MENU_ITEM_SIZES.put("Large", new MenuItemSize("Large", BigDecimal.valueOf(1.50)));
        MENU_ITEM_SIZES.put("Addict", new MenuItemSize("Addict", BigDecimal.valueOf(2.00)));
    }
}
