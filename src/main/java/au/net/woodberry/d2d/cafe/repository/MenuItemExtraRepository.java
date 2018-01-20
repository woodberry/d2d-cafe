package au.net.woodberry.d2d.cafe.repository;

import au.net.woodberry.d2d.cafe.domain.MenuItemExtra;

public class MenuItemExtraRepository implements Repository<MenuItemExtra> {

    @Override
    public MenuItemExtra findByValue(String value) {
        return RepositoryData.MENU_ITEM_EXTRAS.get(value);
    }
}
