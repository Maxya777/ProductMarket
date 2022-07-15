import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] prods = new String[]{"Хлеб", "Вода", "Суп", "Сырок", "Картофель 1кг.", "Макароны", "Гречка",
                "Шоколадка", "Водочка", "Цезарь", "Селёдка", "Горох", "Сникерс", "Сыр", "Булочка с ничем"};
        int[] price1 = new int[]{45, 100, 150, 61, 77, 56, 98, 99, 455, 320, 250, 130, 56, 199, 55};
        int[] price2 = new int[]{50, 110, 135, 58, 70, 60, 95, 105, 520, 305, 265, 120, 65, 203, 50};
        int[] price3 = new int[]{53, 95, 140, 65, 84, 53, 100, 102, 430, 310, 225, 100, 49, 174, 45};
        System.out.println("Выберите магазин для покупки товаров: ");
        System.out.println("1. Пятёрочка, " + "2. Магнит " + "3. Перекрёсток");

        String input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                System.out.println("Список товаров и цен в магазине Пятерочка: ");
                for (int i = 0; i < prods.length; i++) {
                    System.out.println((i + 1) + " " + prods[i] + " " + price1[i] + " руб");
                }
            }
            case "2" -> {
                System.out.println("Список товаров и цен в магазине Магнит: ");
                for (int i = 0; i < prods.length; i++) {
                    System.out.println((i + 1) + " " + prods[i] + " " + price2[i] + " руб");
                }
            }
            case "3" -> {
                System.out.println("Список товаров и цен в магазине Перекрёсток: ");
                for (int i = 0; i < prods.length; i++) {
                    System.out.println((i + 1) + " " + prods[i] + " " + price3[i] + " руб");
                }
            }
        }
        int productNumber = 0;
        int productCount = 0;
        int sumProducts = 0;
        int totalAmount = 0;

        int[] basket = new int[prods.length];
        while (true) {
            System.out.println("Введи номер товара и количество или end для завершения покупки");
            String input2 = scanner.nextLine();
            if (input2.equals("end")) {
                break;
            }
            String[] parts = input2.split(" ");

            productNumber = Integer.parseInt(parts[0]) - 1;
            productCount = Integer.parseInt(parts[1]);

            basket[productNumber] += productCount;

            System.out.println("Выбранный продукт: " + prods[productNumber] + " в количестве " + productCount + " шт.");
        }

        System.out.println("Ваша корзина: ");
        for (int i = 0; i < prods.length; i++) {
            if (basket[i] == 0) {
                continue;
            }
            switch (input) {
                case "1" -> {
                    sumProducts = price1[i] * basket[i];
                    totalAmount += sumProducts;
                    System.out.println(prods[i] + " " + price1[i] + " руб/шт." + " " + basket[i] + " шт." + sumProducts + " руб.");

                }
                case "2" -> {
                    sumProducts = price2[i] * basket[i];
                    totalAmount += sumProducts;
                    System.out.println(prods[i] + " " + price2[i] + " руб/шт." + " " + basket[i] + " шт." + sumProducts + " руб.");

                }
                case "3" -> {
                    sumProducts = price3[i] * basket[i];
                    totalAmount += sumProducts;
                    System.out.println(prods[i] + " " + price3[i] + " руб/шт." + " " + basket[i] + " шт." + sumProducts + " руб.");

                }
            }
        }
        System.out.println("Общая сумма продуктов: " + totalAmount + " рублей");
    }
}


