public class Alcohol extends Beverage {
    private boolean isWeekend;

    public Alcohol(String name, Size size, boolean isWeekend) {
        super(name, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = 2.0 + addSizePrice();
        if (isWeekend) price += 0.6;
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj) && obj instanceof Alcohol) {
            Alcohol other = (Alcohol) obj;
            return isWeekend == other.isWeekend;
        }
        return false;
    }
}
