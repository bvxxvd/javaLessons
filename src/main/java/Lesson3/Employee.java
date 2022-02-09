package Lesson3;

public class Employee {
    private String fullName;      //ФИО
    private String position;      //должность
    private String email;         //email
    private String phone_number;  //телефон
    private int salary;           //зарплата
    private int age;              //возраст

    public Employee(String fullName, String position, String email, String phone_number, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone_number = phone_number;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("ФИО - " + fullName + ", должность - " + position + ", email - " + email + ", телефон - " + phone_number + ", зарплата - " + salary + ", возраст - " + age);
    }
}
