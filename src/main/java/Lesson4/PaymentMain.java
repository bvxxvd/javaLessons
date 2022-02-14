package Lesson4;

import java.util.Scanner;

public class PaymentMain {
    public static void main(String[] args) {
        Payment p = new Payment("Кассовый чек");
        p.makePurchase();
        p.printBill();
    }
}

class Payment {
    private String name;
    private Product[] products;
    private int cost = 0;

    private static class Product { // внутренний класс
        private String productName;
        private int productCost;

        public Product(String productName, int productCost) {
            this.productName = productName;
            this.productCost = productCost;
        }
    }

    public Payment(String name) {
        this.name = name;
    }

    public void makePurchase() { // формируем покупку
        Scanner s = new Scanner(System.in);
        System.out.print("Введите количество товаров, которое вы хотите приобрести: ");
        int number = s.nextInt();
        products = new Product[number]; // создаём массив продуктов
        for (int i = 0; i < number; i++) {
            System.out.println("Товар " + (i + 1) + ": ");
            System.out.print("Введите наименование товара: ");
            s.nextLine();
            String prod_name = s.nextLine();
            System.out.print("Введите цену товара: ");
            int prod_cost = s.nextInt();
            products[i] = new Product(prod_name, prod_cost);
            this.cost += products[i].productCost; // считаем общую стоимость покупки
        }
    }

    public void printBill() { // печатаем чек
        System.out.println(this.name);
        for (int i = 0; i < this.products.length; i++) {
            System.out.print(i + 1);
            System.out.printf("%20s", this.products[i].productName);
            System.out.printf("%10d", this.products[i].productCost);
            System.out.println();
        }
        System.out.print("Итог: ");
        System.out.printf("%25d", this.cost);
        System.out.println();
    }
}
