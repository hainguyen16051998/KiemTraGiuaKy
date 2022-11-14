package entity;

public class CommodityDetail {
    private Commodity commodity;
    private int quatity;

    public CommodityDetail(Commodity commodity, int quatity) {
        this.commodity = commodity;
        this.quatity = quatity;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    @Override
    public String toString() {
        return "CommodityDetail{" +
                "commodity=" + commodity +
                ", quatity=" + quatity +
                '}';
    }
}
