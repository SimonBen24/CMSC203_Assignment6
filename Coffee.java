public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = 2.0 + addSizePrice();
        if (extraShot) price += 0.5;
        if (extraSyrup) price += 0.5;
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj) && obj instanceof Coffee) {
            Coffee other = (Coffee) obj;
            return extraShot == other.extraShot && extraSyrup == other.extraSyrup;
        }
        return false;
    }
}
