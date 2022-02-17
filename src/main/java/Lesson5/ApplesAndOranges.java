package Lesson5;

import java.util.ArrayList;

public class ApplesAndOranges {

    public static void main(String[] args) {

        Box<Apple> a1 = new Box<>();
        Box<Apple> a2 = new Box<>();
        Box<Orange> o1 = new Box<>();
        Box<Orange> o2 = new Box<>();

        a1.addFruit(new Apple(), 15);
        a2.addFruit(new Apple(), 32);
        o1.addFruit(new Orange(), 10);
        o2.addFruit(new Orange(), 20);

        System.out.println("Box1: " + a1.getWeight());
        System.out.println("Box2: " + a2.getWeight());
        System.out.println("Box3: " + o1.getWeight());
        System.out.println("Box4: " + o2.getWeight());

        System.out.println("Is Box1 equal to Box3? " + a1.compare(o1)); // сравним коробку яблок с коробкой апельсинов
        System.out.println("Is Box1 equal to Box2? " + a1.compare(a2)); // сравним коробку яблок с другой коробкой яблок

        a1.pourTo(a2);
        o1.pourTo(o2);

        System.out.println("Box1: " + a1.getWeight());
        System.out.println("Box2: " + a2.getWeight());
        System.out.println("Box3: " + o1.getWeight());
        System.out.println("Box4: " + o2.getWeight());
    }
}


class Box<T extends Fruit> {
    private final ArrayList<T> box = new ArrayList<>();

    public void addFruit(T fruit, int num) { // добавляет фрукты в коробку
        for (int i = 0; i < num; i++) {
            box.add(fruit);
        }
    }

    public float getWeight() { // высчитывает вес коробки
        float weight = 0.0f;
        for (T fruit : box) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box anotherBox) { // сравнивает коробки, true – если их массы равны
        return getWeight() == anotherBox.getWeight();
    }

    public void pourTo(Box<T> anotherBox) { // пересыпает фрукты из текущей коробки в другую
        anotherBox.box.addAll(box);
        box.clear();
    }
}

abstract class Fruit {
    abstract float getWeight();
}

class Apple extends Fruit {
    @Override
    float getWeight() {
        return 1.0f; // вес яблока – 1.0f
    }
}

class Orange extends Fruit {
    @Override
    float getWeight() {
        return 1.5f; // вес апельсина – 1.5f
    }
}
