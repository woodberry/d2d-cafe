package au.net.woodberry.d2d.cafe.repository;

import au.net.woodberry.d2d.cafe.domain.MenuItemPreparation;

public class MenuItemPreparationRepository implements Repository<MenuItemPreparation> {

    @Override
    public MenuItemPreparation findByValue(String value) {
        return RepositoryData.MENU_ITEM_PREPARATIONS.get(value);
    }
}