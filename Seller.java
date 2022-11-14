package entity;

import java.util.Scanner;

public class Seller extends Person {
    public static int AUTO_ID = 1000;
    private int id;
    private String date;

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", id=" + id +
                ", date='" + date + '\'' +
                '}';
    }
    public void inputInfo(){
        super.inputInfo();
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.println("Ngày ký hợp đồng: ");
        this.date = new Scanner(System.in).next();
    }
}
