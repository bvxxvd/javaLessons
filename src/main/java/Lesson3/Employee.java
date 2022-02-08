package Lesson3;

public class Employee {
    String fullName;      //ФИО
    String position;      //должность
    String email;         //email
    String phone_number;  //телефон
    int salary;           //зарплата
    int age;              //возраст

    public Employee(String fullName, String position, String email, String phone_number, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone_number = phone_number;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("ФИО - " + fullName + ", должность - " + position + ", email - " + email + ", телефон - " + phone_number + ", зарплата - " + salary + ", возраст - " + age);
    }
}
