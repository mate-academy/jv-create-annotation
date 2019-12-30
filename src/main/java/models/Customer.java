package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer {

    private String name;
    private int age;
    private int money;
    private LocalDate attendanceDate;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Customer(String name, int age, int money, String attendanceDate) {
        this.name = name;
        this.age = age;
        this.money = money;
        this.attendanceDate = LocalDate.parse(attendanceDate, formatter);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getAttendanceDate() {
        return attendanceDate.toString();
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = LocalDate.parse(attendanceDate, formatter);
    }

    @Override
    public String toString() {
        return "Customer{" + "name='" + name + '\'' + ", age=" + age
                + ", money=" + money + ", attendanceDate=" + attendanceDate + '}';
    }
}
