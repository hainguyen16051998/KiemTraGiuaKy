package logichandle;

import entity.Commodity;
import run.MainRun;


import java.util.Scanner;

public class CommodityLogic {

    public static void showCommodityInfo() {
        for (int i = 0; i < MainRun.commoditys.length; i++) {
            if (MainRun.commoditys[i] != null)
                System.out.println(MainRun.commoditys[i]);
        }
    }

    public static void addNewCommodity() {
        int commodityNum;
        System.out.println("Nhập mới số lượng mặt hàng: ");
        do {
            commodityNum = new Scanner(System.in).nextByte();
            if (commodityNum > 0)
                break;
            System.out.print("Số lượng mặt hàng phải là số dương, mời nhập lại: ");
        } while (true);
        for (int i = 0; i < commodityNum; i++) {
            Commodity commodity = new Commodity();
            commodity.inputInfo();
            saveCommodity(commodity);
        }
    }

    private static void saveCommodity(Commodity commodity) {
        for (int i = 0; i < MainRun.commoditys.length; i++) {
            if (MainRun.commoditys[i] == null) {
                MainRun.commoditys[i] = commodity;
                break;
            }

        }
    }
}
