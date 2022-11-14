package constant;

public enum CommodityConstant {
    //Điện tử, Điện lạnh, Máy tính, Thiết bị văn phòng
    Electronic("ĐIỆN TỬ"),
    Refrigeration("ĐIỆN LẠNH"),
    Computer("MÁY TÍNH"),
    Office("THIẾT BỊ VĂN PHÒNG");
    public String value;

    CommodityConstant(String value) {
        this.value = value;
    }


}
