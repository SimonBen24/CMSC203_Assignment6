import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    public Order(int orderNumber, Day orderDay, Customer customer) {
        this.orderNumber = orderNumber;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // Deep copy
        this.beverages = new ArrayList<>();
    }

    public void addNewBeverage(String name, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(name, size, extraShot, extraSyrup));
    }

    public void addNewBeverage(String name, Size size) {
        beverages.add(new Alcohol(name, size, orderDay == Day.SATURDAY || orderDay == Day.SUNDAY));
    }

    public void addNewBeverage(String name, Size size, int numFruits, boolean proteinAdded) {
        beverages.add(new Smoothie(name, size, numFruits, proteinAdded));
    }

    public Beverage getBeverage(int index) {
        return beverages.get(index);
    }

    public int getTotalItems() {
        return beverages.size();
    }

    public double calcOrderTotal() {
        double total = 0;
        for (Beverage b : beverages) {
            total += b.calcPrice();
        }
        return total;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNumber).append("\n");
        sb.append("Order Day: ").append(orderDay).append("\n");
        sb.append("Beverages:\n");

        for (Beverage bev : beverages) {
            sb.append("- ").append(bev).append("\n");
        }

        return sb.toString();
    }

}
