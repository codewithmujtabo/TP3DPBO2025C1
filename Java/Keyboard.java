public class Keyboard extends Peripheral {
    private String layoutType;
    private boolean mechanical;
    
    public Keyboard() {
        super();
        this.layoutType = "";
        this.mechanical = false;
    }
    
    public Keyboard(String layoutType, boolean mechanical, String merk, String nama, double harga,
                   String tipePeripheral, String koneksi) {
        super(merk, nama, harga, tipePeripheral, koneksi);
        this.layoutType = layoutType;
        this.mechanical = mechanical;
    }
    
    public Keyboard(String layoutType, boolean mechanical, String merk, String nama, double harga) {
        this(layoutType, mechanical, merk, nama, harga, "Keyboard", "USB");
    }
    
    public String getLayoutType() {
        return layoutType;
    }
    
    public void setLayoutType(String layoutType) {
        this.layoutType = layoutType;
    }
    
    public boolean isMechanical() {
        return mechanical;
    }
    
    public void setMechanical(boolean mechanical) {
        this.mechanical = mechanical;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println(tipePeripheral + ": " + merk + " " + nama + 
                           " (" + layoutType + ", " + (mechanical ? "Mechanical" : "Membrane") + ")");
        System.out.println("    Koneksi: " + koneksi + ", Harga: Rp" + harga);
    }
}
