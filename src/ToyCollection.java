import java.util.ArrayList;
import java.util.List;

public class ToyCollection {
    private List<Toy> toys;

    public ToyCollection() {
        toys = new ArrayList<>();
    }

    public boolean addToy(Toy toy) {
        if (!toyExists(toy.getId())) {
            toys.add(toy);
            return true;
        } else {
            return false;
        }
    }

    public boolean toyExists(int toyId) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                return true;
            }
        }
        return false;
    }

    public void decreaseToyQuantity(int toyId) {
        Toy toyToRemove = null;
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                int newQuantity = toy.getQuantity() - 1;
                if (newQuantity <= 0) {
                    toyToRemove = toy;
                } else {
                    toy.setQuantity(newQuantity);
                }
                break;
            }
        }
        if (toyToRemove != null) {
            toys.remove(toyToRemove);
        }
    }

    public List<Toy> getToys() {
        return new ArrayList<>(toys);
    }

    public void displayToys() {
        if (toys.isEmpty()) {
            System.out.println("Список игрушек пуст.");
        } else {
            System.out.println("Список игрушек:");
            for (Toy toy : toys) {
                System.out.println(toy);
            }
        }
    }
}
