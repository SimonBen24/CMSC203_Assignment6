import java.util.ArrayList;

public class BevShop {
    private ArrayList<Order> orders;
    private static final int MAX_FRUITS = 5;
    private static final int MIN_AGE_FOR_ALCOHOL = 21;
    private static final int MAX_ORDERS_PER_DAY = 50;

    public BevShop() {
        orders = new ArrayList<>();
    }

    // Add a new order
    public void startNewOrder(int orderNumber, Day orderDay, String customerName, int customerAge) {
        orders.add(new Order(orderNumber, orderDay, new Customer(customerName, customerAge)));
    }

    // Add a coffee to the current order
    public void addCoffeeToCurrentOrder(String name, Size size, boolean extraShot, boolean extraSyrup) {
        getCurrentOrder().addNewBeverage(name, size, extraShot, extraSyrup);
    }

    // Add an alcohol to the current order
    public void addAlcoholToCurrentOrder(String name, Size size) {
        getCurrentOrder().addNewBeverage(name, size);
    }

    // Add a smoothie to the current order
    public void addSmoothieToCurrentOrder(String name, Size size, int numFruits, boolean proteinAdded) {
        if (numFruits > MAX_FRUITS) {
            throw new IllegalArgumentException("Number of fruits exceeds maximum limit.");
        }
        getCurrentOrder().addNewBeverage(name, size, numFruits, proteinAdded);
    }

    // Retrieve the current order
    public Order getCurrentOrder() {
        if (orders.isEmpty()) {
            throw new IllegalStateException("No orders available.");
        }
        return orders.get(orders.size() - 1);
    }

    // Check if a customer is eligible to order alcohol
    public boolean eligibleForAlcohol(int customerAge) {
        return customerAge >= MIN_AGE_FOR_ALCOHOL;
    }

    // Get the total number of orders
    public int getTotalOrders() {
        return orders.size();
    }

    // Calculate the total income from all orders
    public double calculateTotalIncome() {
        double totalIncome = 0;
        for (Order order : orders) {
            totalIncome += order.calcOrderTotal();
        }
        return totalIncome;
    }

    // Get a specific order by index
    public Order getOrderAt(int index) {
        if (index < 0 || index >= orders.size()) {
            throw new IndexOutOfBoundsException("Invalid order index.");
        }
        return orders.get(index);
    }

    // Check if the shop has reached the daily order limit
    public boolean isMaxOrdersReached() {
        return orders.size() >= MAX_ORDERS_PER_DAY;
    }
}
