public class Main {

    public static void main(String[] args) {
        UserInputHandler inputHandler = new UserInputHandler();
        ToyCollection toyCollection = new ToyCollection();
        ToyLottery toyLottery = new ToyLottery(toyCollection);

        while (true) {
            Integer choice = (Integer) inputHandler.getUserInput("\nВыберите действие (1. Добавить игрушку, 2. Провести розыгрыш, 3. Вывести список игрушек, 4. Выход): ", Integer.class);

            if (choice == null) continue;

            switch (choice) {
                case 1 -> addToy(toyCollection, inputHandler);
                case 2 -> toyLottery.drawPrizeToy();
                case 3 -> toyCollection.displayToys();
                case 4 -> {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверный выбор. Пожалуйста, выберите 1, 2, 3 или 4.");
            }
        }
    }

    private static void addToy(ToyCollection toyCollection, UserInputHandler inputHandler) {
        Integer id = (Integer) inputHandler.getUserInput("Введите ID игрушки: ", Integer.class);
        if (id == null) return;

        if (toyCollection.toyExists(id)) {
            System.out.println("Игрушка с таким ID уже существует. Пожалуйста, введите другой ID.");
            return;
        }

        String name = (String) inputHandler.getUserInput("Введите название игрушки: ", String.class);
        if (name == null) return;

        Integer quantity = (Integer) inputHandler.getUserInput("Введите количество: ", Integer.class);
        if (quantity == null) return;

        Double dropRate = (Double) inputHandler.getUserInput("Введите частоту выпадения (%): ", Double.class);
        if (dropRate == null) return;

        toyCollection.addToy(new Toy(id, name, quantity, dropRate));
        System.out.println("Игрушка добавлена.");
    }
}
