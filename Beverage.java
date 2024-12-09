public abstract class Beverage {
    private String name;
    private Type type;
    private Size size;
    private static final double BASE_PRICE = 2.0;
    private static final double SIZE_PRICE = 0.5;

    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public double addSizePrice() {
        switch (size) {
            case MEDIUM:
                return SIZE_PRICE;
            case LARGE:
                return SIZE_PRICE * 2;
            default:
                return 0.0;
        }
    }

    public abstract double calcPrice();

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Beverage) {
            Beverage other = (Beverage) obj;
            return name.equals(other.name) && type == other.type && size == other.size;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", name, type, size);
    }
}
