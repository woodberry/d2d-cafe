package au.net.woodberry.d2d.cafe;

import au.net.woodberry.d2d.cafe.domain.MenuItem;
import au.net.woodberry.d2d.cafe.exception.UnableToFulfilOrderException;
import au.net.woodberry.d2d.cafe.repository.MenuItemExtraRepository;
import au.net.woodberry.d2d.cafe.repository.MenuItemPreparationRepository;
import au.net.woodberry.d2d.cafe.repository.MenuItemRepository;
import au.net.woodberry.d2d.cafe.repository.MenuItemSizeRepository;
import au.net.woodberry.d2d.cafe.service.OrderService;
import au.net.woodberry.d2d.cafe.service.OrderServiceImpl;

import java.util.Arrays;
import java.util.List;

/**
 * A simple demo of the cafe point of sale
 */
public class CafeDemo {

    public static void main(String... args) throws UnableToFulfilOrderException {

        String item = "House blend";
        String preparation = "Mocha";
        String size = "Standard";
        String[] extras = new String[]{"Milk", "Sugar", "Coco powder"};

        OrderService orderService = new OrderServiceImpl(new MenuItemRepository(),
                new MenuItemExtraRepository(),
                new MenuItemPreparationRepository(),
                new MenuItemSizeRepository());
        System.out.println("Preparing order...");
        System.out.println("--------");
        System.out.println("Item            : " + item);
        System.out.println("Preparation     : " + preparation);
        System.out.println("Size            : " + size);
        System.out.println("Optional Extras : " + Arrays.toString(extras));

        List<MenuItem> items = orderService.prepareOrder(item, preparation, extras);

        System.out.println("--------");
        System.out.println("Total cost      : " + orderService.getTotalCost(items, size));
    }
}
