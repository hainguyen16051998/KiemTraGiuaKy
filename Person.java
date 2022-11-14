package entity;

import java.util.Scanner;

public class Person implements inputAble {
    protected String name;
    protected String address;
    protected int phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }

    public void inputInfo(){
        System.out.println("Họ và tên nhân viên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Địa chỉ nhân viên: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("SĐT nhân viên: ");
        this.phone = new Scanner(System.in).nextInt();
    }
}
