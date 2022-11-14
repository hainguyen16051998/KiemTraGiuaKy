package run;

import entity.Commodity;
import entity.CommodityManagement;
import entity.Seller;
import logichandle.CommodityLogic;
import logichandle.CommodityManagementLogic;
import logichandle.SellerLogic;

import java.util.Scanner;

public class MainRun {

    public static  Commodity[] commoditys = new Commodity[100];
    public static  Seller[] sellers = new Seller[100];
    public static CommodityManagement[] commodityManagements= new CommodityManagement[100];

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            showMenu();
            int functionchoice = functionchoice();

            switch (functionchoice) {
                case 1:
                    CommodityLogic.addNewCommodity();
                    break;
                case 2:
                    CommodityLogic.showCommodityInfo();
                    break;
                case 3:
                    SellerLogic.addNewSeller();
                    break;
                case 4:
                    SellerLogic.showSellerInfo();
                    break;
                case 5:
                    CommodityManagementLogic.addNewCommodityManagements();
                    break;
                case 6:
                    CommodityManagementLogic.showCommodityManagementInfo();
                    break;
                case 7:
                    showSortMenu();
                    break;
                case 8:
                    CommodityManagementLogic.calculateSalarry();
                    break;
                case 9:
                    return;
            }
        }
    }



    private static void showSortMenu() {
        System.out.print("Chọn tiêu chí sắp xếp: ");
        System.out.println("1. Theo họ tên");
        System.out.println("2. Theo nhón hàng");
        System.out.println("Thoát ra ngoài Menu chính");
        System.out.println(" Chọn: ");
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 2) {
                break;
            }
            System.out.print("nhập lại tiêu chí: ");
        } while (true);
        switch (choice) {
            case 1:
                CommodityManagementLogic.sortWriterByName();
                break;
            case 2:

                break;
            case 3:
                return;
        }
    }


    private static void showMenu() {
        System.out.println("-----PHẦN MỀM QUẢN LÝ DANH SÁCH BÁN HÀNG-----");
        System.out.println("1. Nhập danh sách mặt hàng mới ");
        System.out.println("2. In ra danh sách các mặt hàng đã có");
        System.out.println("3, Nhập danh sách nhân viên");
        System.out.println("4. In ra danh sách nhân viên đã có ");
        System.out.println("5. Lập Bảng danh sách bán hàng cho từng nhân viên");
        System.out.println("6. In danh sách bán hàng cho từng nhân viên");
        System.out.println("7. Sắp xếp danh sách Bảng danh sách bán hàng");
        System.out.println("8. Lập bảng kê doanh thu cho mỗi nhân viên");
        System.out.println("9.Thoát");
        System.out.print("Mời chọn chức năng: ");
    }

    private static int functionchoice() {
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextByte();
            if (choice > 0 && choice <= 9)
                break;
            System.out.print("nhập sai, mời nhập lại: ");
        } while (true);
        return choice;
    }

}
