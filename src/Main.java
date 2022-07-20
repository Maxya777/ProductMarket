
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] prods = new String[]{"Хлеб", "Вода", "Суп", "Сырок Б.Ю.Александров", "Картофель 1кг.", "Макароны", "Гречка",
                "Шоколадка", "Водочка", "Цезарь", "Селёдка", "Горох", "Сникерс", "Сыр", "Булочка с ничем"};
        int[] price1 = new int[]{45, 100, 150, 61, 77, 56, 98, 99, 455, 320, 250, 130, 56, 199, 55};
        int[] price2 = new int[]{50, 110, 135, 58, 70, 60, 95, 105, 520, 305, 265, 120, 65, 203, 50};
        int[] price3 = new int[]{53, 95, 140, 65, 84, 53, 100, 102, 430, 310, 225, 100, 49, 174, 45};
        System.out.println("Список товаров: ");

        for(int i = 0; i < prods.length; i++) {
            System.out.println((i + 1) + "." + prods[i]);
        }

        int productNumber = 0;
        int productCount = 0;
        int sumProducts = 0;
        int sumProducts1 = 0;
        int sumProducts2 = 0;
        int totalAmount = 0;
        int totalAmount1 = 0;
        int totalAmount2 = 0;

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
            sumProducts = price1[i] * basket[i];
            totalAmount += sumProducts;

            sumProducts1 = price2[i] * basket[i];
            totalAmount1 += sumProducts1;

            sumProducts2 = price3[i] * basket[i];
            totalAmount2 += sumProducts2;

            if(totalAmount < totalAmount1 && totalAmount < totalAmount2) {
                System.out.println(prods[i] + " " + price1[i] + " руб/шт. " + basket[i] + " шт. " + sumProducts + " руб.");
            } else if (totalAmount1 < totalAmount2 && totalAmount1 < totalAmount) {
                System.out.println(prods[i] + " " + price2[i] + " руб/шт. " + basket[i] + " шт. " + sumProducts1 + " руб.");
            } else {
                System.out.println(prods[i] + " " + price3[i] + " руб/шт. " + basket[i] + " шт. " + sumProducts2 + " руб.");
            }
        }
        if(totalAmount < totalAmount1 && totalAmount < totalAmount2) {
            System.out.println("Наиболее выгодный для покупок магазин 'Пятерочка' ");
            System.out.println("Общая сумма товаров " + totalAmount + " руб.");
        } else if (totalAmount1 < totalAmount2 && totalAmount1 < totalAmount) {
            System.out.println("Наиболее выгодный для покупок магазин 'Перекрёсток' ");
            System.out.println("Общая сумма товаров " + totalAmount1 + " руб.");
        } else {
            System.out.println("Наиболее выгодный для покупок магазин 'Лента' ");
            System.out.println("Общая сумма товаров " + totalAmount2 + " руб.");
        }
    }
}


