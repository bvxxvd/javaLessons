package Lesson3;

public class Main {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Михеев Моисей Семенович", "Менеджер по персоналу", "o0my@gmail.com", "+79(6599)689-87-30", 32425, 38);
        empArray[1] = new Employee("Баранов Игорь Онисимович", "Администратор торгового зала", "715qy08@gmail.com", "+057(4018)015-32-01", 99497, 39);
        empArray[2] = new Employee("Поляков Максимилиан Игнатьевич", "Начальник отдела ИТ", "vubx0t@mail.ru", "+8(6860)503-23-41", 45838, 40);
        empArray[3] = new Employee("Шилов Касьян Лукьевич", "Главный энергетик", "wnhborq@outlook.com", "+98(49)245-40-87", 52821, 41);
        empArray[4] = new Employee("Родионов Гордей Федосеевич", "Заместитель главного бухгалтера", "gq@yandex.ru", "+9(0758)629-76-21", 22204, 42);
        for (Employee e : empArray) if (e.getAge() > 40) e.printInfo();
    }
}
