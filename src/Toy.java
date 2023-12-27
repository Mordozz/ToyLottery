public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double dropRate;

    public Toy(int id, String name, int quantity, double dropRate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.dropRate = dropRate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDropRate() {
        return dropRate;
    }

    public void setDropRate(double dropRate) {
        this.dropRate = dropRate;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", dropRate=" + dropRate +
                '}';
    }
}
