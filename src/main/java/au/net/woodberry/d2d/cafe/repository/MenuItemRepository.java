package au.net.woodberry.d2d.cafe.repository;

import au.net.woodberry.d2d.cafe.domain.MenuItem;

public class MenuItemRepository implements Repository<MenuItem> {

    @Override
    public MenuItem findByValue(String value) {
        return RepositoryData.MENU_ITEMS.get(value);
    }
}
