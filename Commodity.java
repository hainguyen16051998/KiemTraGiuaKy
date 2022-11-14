package entity;

import constant.CommodityConstant;

import java.util.Scanner;

public class Commodity implements inputAble {
    public static int AUTO_ID = 1000;
    private int id;
    private String name;
    private String group;
    private int price;
    private int quantity;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return quantity;
    }

    public void setAmount(int amount) {
        this.quantity = amount;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public void inputInfo() {
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.println("Tên mặt hàng: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Giá bán: ");
        this.price = new Scanner(System.in).nextByte();
        System.out.println("Số lượng bán: ");
        this.quantity = new Scanner(System.in).nextByte();
        System.out.println("Mời chọn nhóm hàng: ");
        System.out.println("1. ĐIỆN TỬ");
        System.out.println("2. ĐIỆN LẠNH");
        System.out.println("3. MÁY TÍNH");
        System.out.println("4. THIẾT BỊ VĂN PHÒNG");
        System.out.print("Mời chọn: ");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice < 5 && choice > 0) {
                break;
            }
            System.out.print("chọn sai, mời nhập lại: ");
        } while (true);
        switch (choice) {
            case 1:
                this.group = CommodityConstant.Electronic.value;
                break;
            case 2:
                this.group = CommodityConstant.Refrigeration.value;
                break;
            case 3:
                this.group = CommodityConstant.Computer.value;
                break;
            case 4:
                this.group = CommodityConstant.Office.value;
                break;

        }

    }
}
