package Lesson4;

import java.util.Scanner;

public class ParkMain {
    public static void main(String[] args) {
        Park park = new Park("Парк культуры и отдыха имени Челюскинцев");
        park.addRide();
        System.out.println();
        park.printRide();
    }
}

class Park {
    private String fullName;
    private Ride[] rides;

    private static class Ride {                     // внутренний класс
        private String name;
        private String workingHours;
        private int price;

        public Ride(String name, String workingHours, int price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }
    }                                               // конец внутреннего класса

    public Park(String fullName) {
        this.fullName = fullName;
    }


    public void addRide() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество аттракционов: ");
        rides = new Ride[scanner.nextInt()];
        for (int i = 0; i < rides.length; i++) {
            System.out.println("Аттракцион " + (i + 1));
            System.out.print("Название аттракциона: ");
            scanner.nextLine();
            String ride_name = scanner.nextLine();
            System.out.print("Время работы аттракциона: ");
            String ride_workingHours = scanner.nextLine();
            System.out.print("Стоимость аттракциона: ");
            int ride_price = scanner.nextInt();
            rides[i] = new Ride(ride_name, ride_workingHours, ride_price);
        }
    }

    public void printRide() {

        System.out.println(this.fullName + ". Количество аттракционов " + rides.length + " шт.");

        for (int i = 0; i < rides.length; i++) {
            System.out.println("Аттракцион " + (i + 1));
            System.out.println("Название: " + rides[i].name);
            System.out.println("Время работы: " + rides[i].workingHours);
            System.out.println("Стоимость: " + rides[i].price);
        }
    }
}
