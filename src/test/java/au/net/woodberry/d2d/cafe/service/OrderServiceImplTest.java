package au.net.woodberry.d2d.cafe.service;

import au.net.woodberry.d2d.cafe.domain.MenuItem;
import au.net.woodberry.d2d.cafe.exception.UnableToFulfilOrderException;
import au.net.woodberry.d2d.cafe.repository.MenuItemExtraRepository;
import au.net.woodberry.d2d.cafe.repository.MenuItemPreparationRepository;
import au.net.woodberry.d2d.cafe.repository.MenuItemRepository;
import au.net.woodberry.d2d.cafe.repository.MenuItemSizeRepository;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

    @Rule
    public JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    // Normally, there would have separate tests for the repository layer and these would be mocked, but given that
    // the repository layer implementation is essentially itself mocked through te use of static data, there isn't much
    // value in creating unit tests for the various repositories.
    // Instead, the best way to test is to spy on the repository classes so that we can still verify
    // the correctness of the service in interacting with the repository.
    @Spy
    private MenuItemRepository menuItemRepository;

    @Spy
    private MenuItemExtraRepository menuItemExtraRepository;

    @Spy
    private MenuItemPreparationRepository menuItemPreparationRepository;

    @Spy
    private MenuItemSizeRepository menuItemSizeRepository;

    private OrderService orderService;

    @Before
    public void beforeTest() {
        orderService = new OrderServiceImpl(menuItemRepository,
                menuItemExtraRepository,
                menuItemPreparationRepository,
                menuItemSizeRepository);
    }

    @Test
    public void testPrepareOrderReturnsCorrectList() throws UnableToFulfilOrderException {
        List<MenuItem> order = orderService.prepareOrder("House blend", "Espresso", "Milk", "Sugar");
        softly.assertThat(order).hasSize(4);
        softly.assertThat(order).extracting("itemName")
                .containsOnly("House blend", "Espresso", "Milk", "Sugar");

        // Verify repository interactions
        verify(menuItemRepository).findByValue(eq("House blend"));
        verify(menuItemPreparationRepository).findByValue(eq("Espresso"));
        verify(menuItemExtraRepository).findByValuesIn(eq("Milk"), eq("Sugar"));
    }

    @Test
    public void testPrepareOrderNoOptionalExtras() throws UnableToFulfilOrderException {
        List<MenuItem> order = orderService.prepareOrder("Robusta", "Macchiato");
        softly.assertThat(order).hasSize(2);
        softly.assertThat(order).extracting("itemName")
                .containsOnly("Robusta", "Macchiato");
    }

    @Test
    public void testPrepareOrderHandlesInvalidMenuItem() throws UnableToFulfilOrderException {
        expectedException.expect(UnableToFulfilOrderException.class);
        expectedException.expectMessage("Could not find menu item: 'Unicorn blend'. Ensure that this item exists.");
        orderService.prepareOrder("Unicorn blend", "Espresso", "Milk", "Sugar");
    }

    @Test
    public void testPrepareOrderHandlesInvalidPreparation() throws UnableToFulfilOrderException {
        expectedException.expect(UnableToFulfilOrderException.class);
        expectedException.expectMessage("Could not find menu preparation item: 'Espresso Martini'. Ensure that this item exists.");
        orderService.prepareOrder("Dark roast", "Espresso Martini", "Milk", "Sugar");
    }

    @Test
    public void testPrepareOrderInvalidOptionalExtra() throws UnableToFulfilOrderException {
        expectedException.expect(UnableToFulfilOrderException.class);
        expectedException.expectMessage("Could not find one or more of optional extra menu items: Ensure that all optional items exist.");
        orderService.prepareOrder("Arabica", "Cappuccino", "Milk", "Sugar", "Sprinkles");
    }

    @Test
    public void testGetTotalCostChildSizeReducesTotalCost() throws UnableToFulfilOrderException {
        List<MenuItem> order = new ArrayList<>();
        order.add(menuItemRepository.findByValue("Dark roast"));
        order.add(menuItemPreparationRepository.findByValue("Macchiato"));
        order.add(menuItemExtraRepository.findByValue("Coco powder"));

        BigDecimal totalCost = orderService.getTotalCost(order, "Child");
        assertThat(totalCost).isEqualByComparingTo("2.51");
    }

    @Test
    public void testGetTotalCostStandardSizeDoesNotChangeTotalCost() throws UnableToFulfilOrderException {
        List<MenuItem> order = new ArrayList<>();
        order.add(menuItemRepository.findByValue("Robusta"));
        order.add(menuItemPreparationRepository.findByValue("Espresso"));

        BigDecimal totalCost = orderService.getTotalCost(order, "Standard");
        assertThat(totalCost).isEqualByComparingTo("3.00");
    }

    @Test
    public void testGetTotalCostAddictSizeIncreasesTotalCost() throws UnableToFulfilOrderException {
        List<MenuItem> order = new ArrayList<>();
        order.add(menuItemRepository.findByValue("Arabica"));
        order.add(menuItemPreparationRepository.findByValue("Mocha"));
        order.addAll(menuItemExtraRepository.findByValuesIn("Milk", "Sugar", "Coco powder"));

        BigDecimal totalCost = orderService.getTotalCost(order, "Addict");
        assertThat(totalCost).isEqualByComparingTo("11.70");
    }
}