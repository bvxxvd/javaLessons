package Lesson4;

public class KotsAndDogs {
    public static void main(String[] args) {
        Kot kotTjoma = new Kot("Тёма");
        Kot kotPunsh = new Kot("Пунш");
        Kot kotNascar = new Kot("Наскар");
        Dog dogSprinter = new Dog("Спринтер");
        Dog dogNepej = new Dog("Непей");

        System.out.println("Забег!");
        System.out.println();

        kotTjoma.run(199);
        kotPunsh.run(200);
        kotNascar.run(201);
        dogSprinter.run(500);
        dogNepej.run(501);

        System.out.println();
        System.out.println("Заплыв!");
        System.out.println();

        kotTjoma.swim(199);
        kotPunsh.swim(200);
        kotNascar.swim(201);
        dogSprinter.swim(10);
        dogNepej.swim(11);

        System.out.println();

        System.out.println("В соревнованиях участвовало " + Animal.getCount() + " животных: " + Kot.getCount() +
                " кота и " + Dog.getCount() + " собаки.");
    }
}

class Animal {
    protected String name;
    protected int maxRun;
    protected int maxSwim;
    private static int count;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public void run(int length) {
        if (length <= maxRun) System.out.println(name + " пробежал " + length + " м.");
        else System.out.println(name + " не смог пробежать " + length + "м.");
    }

    public void swim(int length) {
        if (length <= maxSwim) System.out.println(name + " проплыл " + length + " м.");
        else System.out.println(name + " не смог проплыть " + length + "м.");
    }

    public static int getCount() {
        return count;
    }
}

class Kot extends Animal {
    private static int count;

    public Kot(String name) {
        super(name);
        this.maxRun = 200;
        count++;
    }

    @Override
    public void swim(int length) {
        System.out.println(name + " не умеет плавать!");
    }

    public static int getCount() {
        return count;
    }
}

class Dog extends Animal {
    private static int count;

    public Dog(String name) {
        super(name);
        this.maxRun = 500;
        this.maxSwim = 10;
        count++;
    }

    public static int getCount() {
        return count;
    }
}