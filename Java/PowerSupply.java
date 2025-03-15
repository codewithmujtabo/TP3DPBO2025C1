public class PowerSupply extends Komponen {
    private int wattage;
    private String certification;
    
    public PowerSupply() {
        super();
        this.wattage = 0;
        this.certification = "";
    }
    
    public PowerSupply(int wattage, String certification, String merk, String nama, double harga) {
        super(merk, nama, harga, "Power Supply");
        this.wattage = wattage;
        this.certification = certification;
    }
    
    public int getWattage() {
        return wattage;
    }
    
    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
    
    public String getCertification() {
        return certification;
    }
    
    public void setCertification(String certification) {
        this.certification = certification;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Power Supply: " + merk + " " + nama + 
                           " (" + wattage + "W, " + certification + ")");
        System.out.println("    Harga: Rp" + harga);
    }
}
