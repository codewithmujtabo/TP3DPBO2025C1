public class Motherboard extends Komponen {
    private String chipset;
    private String formFactor;
    private String socketType;
    
    public Motherboard() {
        super();
        this.chipset = "";
        this.formFactor = "";
        this.socketType = "";
    }
    
    public Motherboard(String chipset, String formFactor, String socketType, 
                      String merk, String nama, double harga) {
        super(merk, nama, harga, "Motherboard");
        this.chipset = chipset;
        this.formFactor = formFactor;
        this.socketType = socketType;
    }
    
    public String getChipset() {
        return chipset;
    }
    
    public void setChipset(String chipset) {
        this.chipset = chipset;
    }
    
    public String getFormFactor() {
        return formFactor;
    }
    
    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }
    
    public String getSocketType() {
        return socketType;
    }
    
    public void setSocketType(String socketType) {
        this.socketType = socketType;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Motherboard: " + merk + " " + nama + 
                           " (" + chipset + ", " + formFactor + ")");
        System.out.println("    Socket: " + socketType + ", Harga: Rp" + harga);
    }
}