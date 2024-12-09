public class Smoothie extends Beverage {
    private int numFruits;
    private boolean proteinAdded;

    public Smoothie(String name, Size size, int numFruits, boolean proteinAdded) {
        super(name, Type.SMOOTHIE, size);
        this.numFruits = numFruits;
        this.proteinAdded = proteinAdded;
    }

    @Override
    public double calcPrice() {
        double price = 2.0 + addSizePrice();
        price += numFruits * 0.5;
        if (proteinAdded) price += 1.5;
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj) && obj instanceof Smoothie) {
            Smoothie other = (Smoothie) obj;
            return numFruits == other.numFruits && proteinAdded == other.proteinAdded;
        }
        return false;
    }
}
