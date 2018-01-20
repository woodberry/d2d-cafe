package au.net.woodberry.d2d.cafe.repository;

import au.net.woodberry.d2d.cafe.domain.MenuItem;
import au.net.woodberry.d2d.cafe.domain.MenuItemExtra;
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
    static final Map<String, MenuItemExtra> MENU_ITEM_EXTRAS = new HashMap<>();
    static final Map<String, MenuItemSize> MENU_ITEM_SIZES = new HashMap<>();

    static {
        MENU_ITEMS.put("House Blend", new MenuItem("House Blend", BigDecimal.valueOf(1.0)));
        MENU_ITEMS.put("Dark roast", new MenuItem("Dark roast", BigDecimal.valueOf(1.5)));
        MENU_ITEMS.put("Robusta", new MenuItem("Robusta", BigDecimal.valueOf(2.0)));
        MENU_ITEMS.put("Arabica", new MenuItem("Arabica", BigDecimal.valueOf(2.5)));


    }
}
