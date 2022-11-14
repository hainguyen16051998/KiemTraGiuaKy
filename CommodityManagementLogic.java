package logichandle;

import entity.Commodity;
import entity.CommodityDetail;
import entity.CommodityManagement;
import entity.Seller;
import run.MainRun;

import java.util.Scanner;

public class CommodityManagementLogic {
    public static void addNewCommodityManagements() {
        if (!check()) {
            System.out.println("chưa có dữ liệu");
            return;
        }
        int sellerNum;
        System.out.print("Bảng danh sách bán hàng cho bao nhiêu nhân viên: ");
        do {
            sellerNum = new Scanner(System.in).nextByte();
            if (sellerNum > 0)
                break;
            System.out.print("Số lượng nhân viên phải là số dương, mời nhập lại: ");
        } while (true);
        for (int i = 0; i < sellerNum; i++) {
            System.out.println("Nhập thông tin cho nhân viên thứ " + (i + 1));
            System.out.println("Mã ID nhân viên cần nhập thông tin: ");
            Seller seller = null;
            int sellersID = -1;
            do {
                sellersID = new Scanner(System.in).nextInt();
                for (int k = 0; k < MainRun.sellers.length; k++) {
                    if (MainRun.sellers[k].getId() == sellersID) {
                        seller = MainRun.sellers[k];
                        break;
                    }
                }
                if (seller != null)
                    break;
                System.out.println("k có phóng viên nào mang mã " + sellersID + " trong hệ thống, vui lòng nhập lại: ");
            } while (true);
            System.out.print("Nhập số lượng mặt hàng đã bán: ");
            int commodityNum;
            do {
                commodityNum = new Scanner(System.in).nextByte();
                if (commodityNum > 0 && commodityNum <= 5)
                    break;
                System.out.print("Số lượng mặt hàng phải là số dương và bé hơn hoặc bằng 5, mời nhập lại: ");
            } while (true);
            CommodityDetail[] commodityDetail = new CommodityDetail[commodityNum];
            int count = 0;
            for (int j = 0; j < commodityNum; j++) {
                System.out.println("Nhập thông tin tên mặt hàng thứ " + (j + 1) + " mà nhân viên " + seller.getName() + " đã bán");
                System.out.print("Nhập id của loại mặt hàng thứ " + (j + 1) + ": ");
                Commodity commodity = null;
                int commodityID = -1;
                do {
                    commodityID = new Scanner(System.in).nextInt();
                    for (int k = 0; k < MainRun.commoditys.length; k++) {
                        if (MainRun.commoditys[k].getId() == commodityID) {
                            commodity = MainRun.commoditys[k];
                            break;
                        }
                    }
                    if (commodity == null) {
                        System.out.println("k có mặt hàng nào mang mã " + commodityID + " trong danh sách, vui lòng nhập lại: ");
                        continue;
                    }

                    boolean xemdanhapchua = false;
                    for (int k = 0; k < count; k++) {
                        if (commodityDetail[k].getCommodity().getId() == commodityID) {
                            xemdanhapchua = true;
                            break;
                        }
                    }
                    if (!xemdanhapchua)
                        break;
                    System.out.println("loại này mới nhập, nhập loại khác: ");
                } while (true);

                System.out.print("Nhập số lượng hàng của loại mặt hàng này đã bán: ");
                int quantity = new Scanner(System.in).nextInt();
                commodityDetail[count] = new CommodityDetail(commodity, quantity);
                count++;
            }
            CommodityManagement commodityManagement = new CommodityManagement(seller, commodityDetail);
            saveCommodityManagement(commodityManagement);
        }
    }

    private static void saveCommodityManagement(CommodityManagement commodityManagement) {
        for (int i = 0; i < MainRun.commodityManagements.length; i++) {
            if (MainRun.commodityManagements[i] == null)
                MainRun.commodityManagements[i] = commodityManagement;
            break;
        }
    }

    public static void showCommodityManagementInfo() {
        for (int i = 0; i < MainRun.commodityManagements.length; i++) {
            if (MainRun.commodityManagements[i] != null)
                System.out.println(MainRun.commodityManagements[i]);
            break;
        }
    }

    private static boolean check() {
        boolean ValidCommodity = false;
        for (int i = 0; i < MainRun.commoditys.length; i++) {
            if (MainRun.commoditys[i] != null) {
                ValidCommodity = true;
                break;
            }
        }
        boolean ValidSeller = false;
        for (int i = 0; i < MainRun.sellers.length; i++) {
            if (MainRun.sellers[i] != null) {
                ValidSeller = true;
                break;
            }
        }
        return ValidCommodity && ValidSeller;
    }

    public static void sortWriterByName() {
        for (int i = 0; i < MainRun.commodityManagements.length; i++) {
            for (int j = i + 1; j < MainRun.commodityManagements.length; j++) {
                CommodityManagement commodity1 = MainRun.commodityManagements[i];
                CommodityManagement commodity2 = MainRun.commodityManagements[j];
                if (commodity1.getSeller().getName().compareTo(commodity2.getSeller().getName()) > 1) {
                    CommodityManagement temp = commodity1;
                    commodity1 = commodity2;
                    commodity1 = temp;
                }
            }
        }
    }

    public static void calculateSalarry() {
        for (int i = 0; i < MainRun.commodityManagements.length; i++) {
            double salary = 0;
            Seller seller = MainRun.commodityManagements[i].getSeller();
            CommodityDetail[] commodityDetails = MainRun.commodityManagements[i].getCommodityDetails();
            for (int j = 0; j < commodityDetails.length; j++) {
                salary += commodityDetails[j].getCommodity().getPrice() * commodityDetails[j].getQuatity();
            }
            System.out.println("doanh thu của " + seller.getName() + " là: " + salary);
        }
    }
}
