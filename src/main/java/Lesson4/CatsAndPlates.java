package Lesson4;

public class CatsAndPlates {

    public static void main(String[] args) { // создаём массив котов

        Cat[] cat = new Cat[4];
        cat[0] = new Cat("Глория", 70);
        cat[1] = new Cat("Мелман", 41);
        cat[2] = new Cat("Марти", 40);
        cat[3] = new Cat("Алекс", 1);

        Plate p = new Plate(110); // создаём тарелку с едой

        for (Cat c : cat) { // просим всех котов поесть тарелки

            if (p.checkFood(c.getAppetite())) { // если у кота аппетит больше, чем еды в тарелке, то он её просто не трогает; в тарелке с едой не может получиться отрицательное количество еды
                c.eat(p);
                c.setBellyful(true); // если коту удалось поесть (хватило еды), сытость = true
                System.out.println("Кот " + c.getName() + " съел " + c.getAppetite() + " граммов еды");
            } else System.out.println("Кот " + c.getName() + " не поел");
        }

        System.out.println();

        for (Cat c : cat) { // выводим  информацию о сытости котов в консоль
            System.out.print("Кот " + c.getName());
            if (c.isBellyful()) System.out.println(" сыт");
            else System.out.println(" голоден");
        }

        System.out.println();

        p.incFood(222); // пополним запас еды
        System.out.println("Корма в тарелке стало — " + p.getFood() + " грамма");
    }
}

class Plate {

    private int food;

    Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    void decFood(int n) {
        food -= n;
    }

    void incFood(int n) { // метод, с помощью которого можно добавлять еду в тарелку
        this.food += n;
    }

    boolean checkFood(int n) {
        return (food - n) >= 0;
    }
}

class Cat {

    private String name;
    private int appetite;
    private boolean bellyful; // коту добавили поле сытость

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        bellyful = false; // когда создаем котов, они голодны
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isBellyful() {
        return bellyful;
    }

    public void setBellyful(boolean bellyful) {
        this.bellyful = bellyful;
    }

    void eat(Plate p) {
        p.decFood(appetite);
    }
}