package logichandle;

import entity.Seller;
import run.MainRun;

import java.util.Scanner;

public class SellerLogic {
    public static void showSellerInfo() {
        for (int i = 0; i < MainRun.sellers.length; i++) {
            if (MainRun.sellers[i] != null)
                System.out.println(MainRun.sellers[i]);
        }
    }

    public static void addNewSeller() {
        int sellerNum;
        System.out.println("Nhập mới số lượng nhân viên: ");
        do {
            sellerNum = new Scanner(System.in).nextByte();
            if (sellerNum > 0)
                break;
            System.out.print("Số lượng nhân viên phải là số dương, mời nhập lại: ");
        } while (true);
        for (int i = 0; i < sellerNum; i++) {
            Seller seller = new Seller();
            seller.inputInfo();
            saveSeller(seller);
        }
    }

    private static void saveSeller(Seller seller) {
        for (int i = 0; i < MainRun.sellers.length; i++) {
            if (MainRun.sellers[i] == null) {
                MainRun.sellers[i] = seller;
                break;
            }

        }
    }
}

