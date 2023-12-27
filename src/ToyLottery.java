import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyLottery {
    private ToyCollection toyCollection;
    private List<Toy> prizeToys;
    private Random random;

    public ToyLottery(ToyCollection toyCollection) {
        this.toyCollection = toyCollection;
        this.prizeToys = new ArrayList<>();
        this.random = new Random();
    }

    public void drawPrizeToy() {
        List<Toy> toys = toyCollection.getToys();
        double totalDropRate = calculateTotalDropRate(toys);

        double randomValue = random.nextDouble() * totalDropRate;
        double cumulativeRate = 0.0;

        for (Toy toy : toys) {
            cumulativeRate += toy.getDropRate();
            if (cumulativeRate >= randomValue) {
                prizeToys.add(toy);
                toyCollection.decreaseToyQuantity(toy.getId());
                System.out.println("Выиграна игрушка: " + toy.getName() + " (ID: " + toy.getId() + ")");
                PrizeToyLogger.logPrizeToy(toy);
                break;
            }
        }
    }

    private double calculateTotalDropRate(List<Toy> toys) {
        double totalDropRate = 0.0;
        for (Toy toy : toys) {
            totalDropRate += toy.getDropRate();
        }
        return totalDropRate;
    }
}
