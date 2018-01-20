package au.net.woodberry.d2d.cafe.repository;

import au.net.woodberry.d2d.cafe.domain.MenuItemSize;

public class MenuItemSizeRepository implements Repository<MenuItemSize> {

    @Override
    public MenuItemSize findByValue(String value) {
        return RepositoryData.MENU_ITEM_SIZES.get(value);
    }
}
