package entity;

import java.util.Arrays;

public class CommodityManagement {
    private Seller seller;
    private CommodityDetail[] commodityDetails;
    private int totalCommodity;

    public int getTotalCommodity() {
        return totalCommodity;
    }

    public void setTotalCommodity(int totalCommodity) {
        this.totalCommodity = totalCommodity;
    }

    public CommodityManagement(Seller seller, CommodityDetail[] commodityDetails) {
        this.seller = seller;
        this.commodityDetails = commodityDetails;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public CommodityDetail[] getCommodityDetails() {
        return commodityDetails;
    }

    public void setCommodityDetails(CommodityDetail[] commodityDetails) {
        this.commodityDetails = commodityDetails;
    }

    @Override
    public String toString() {
        return "CommodityManagement{" +
                "seller=" + seller +
                ", commodityDetails=" + Arrays.toString(commodityDetails) +
                '}';
    }
}
