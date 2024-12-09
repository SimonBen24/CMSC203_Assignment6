import java.util.Scanner;

public class BevShopDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nWelcome to the Beverage Shop!");
            System.out.println("1. Start a New Order");
            System.out.println("2. Add Coffee to Current Order");
            System.out.println("3. Add Alcohol to Current Order");
            System.out.println("4. Add Smoothie to Current Order");
            System.out.println("5. View Current Order Details");
            System.out.println("6. View Total Income");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    if (bevShop.isMaxOrdersReached()) {
                        System.out.println("Maximum orders reached for the day.");
                        break;
                    }
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter order time (hour): ");
                    int orderTime = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Select order day:");
                    for (Day day : Day.values()) {
                        System.out.println(day.ordinal() + 1 + ". " + day);
                    }
                    System.out.print("Enter day number: ");
                    int dayChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Day orderDay = Day.values()[dayChoice - 1];
                    bevShop.startNewOrder(orderTime, orderDay, name, age);
                    System.out.println("New order started for " + name + " on " + orderDay + ".");
                    break;

                case 2:
                    System.out.print("Enter coffee name: ");
                    String coffeeName = scanner.nextLine();
                    System.out.print("Enter size (SMALL, MEDIUM, LARGE): ");
                    Size coffeeSize = Size.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Add extra shot? (true/false): ");
                    boolean extraShot = scanner.nextBoolean();
                    System.out.print("Add extra syrup? (true/false): ");
                    boolean extraSyrup = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline
                    bevShop.addCoffeeToCurrentOrder(coffeeName, coffeeSize, extraShot, extraSyrup);
                    System.out.println("Coffee added to the order.");
                    break;

                case 3:
                    System.out.print("Enter alcohol name: ");
                    String alcoholName = scanner.nextLine();
                    System.out.print("Enter size (SMALL, MEDIUM, LARGE): ");
                    Size alcoholSize = Size.valueOf(scanner.nextLine().toUpperCase());
                    try {
                        bevShop.addAlcoholToCurrentOrder(alcoholName, alcoholSize);
                        System.out.println("Alcohol added to the order.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter smoothie name: ");
                    String smoothieName = scanner.nextLine();
                    System.out.print("Enter size (SMALL, MEDIUM, LARGE): ");
                    Size smoothieSize = Size.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Enter number of fruits: ");
                    int numFruits = scanner.nextInt();
                    System.out.print("Add protein? (true/false): ");
                    boolean proteinAdded = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline
                    try {
                        bevShop.addSmoothieToCurrentOrder(smoothieName, smoothieSize, numFruits, proteinAdded);
                        System.out.println("Smoothie added to the order.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        Order currentOrder = bevShop.getCurrentOrder();
                        System.out.println("\nCurrent Order Details:");
                        System.out.println(currentOrder);
                    } catch (IllegalStateException e) {
                        System.out.println("No current order available.");
                    }
                    break;

                case 6:
                    System.out.printf("Total Income: $%.2f%n", bevShop.calculateTotalIncome());
                    break;

                case 7:
                    exit = true;
                    System.out.println("Thank you for using the Beverage Shop!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
