public class Main {
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(new Rose("Красный", 100));
        bouquet.addFlower(new Tulip("Желтый", 50));
        bouquet.addAccessory(new Accessory("Лента", 20));
        bouquet.addAccessory(new Accessory("Упаковочная бумага", 10));

        System.out.println("Букет: " + bouquet);
        System.out.println("Итоговая цена: " + bouquet.calculateTotalPrice());
    }
}
