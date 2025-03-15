// Ram.java
public class Ram extends Komponen implements Upgradeable {
    private int kapasitasGB;
    private String ddr;
    private int clockSpeed;
    
    public Ram() {
        super();
        this.kapasitasGB = 0;
        this.ddr = "";
        this.clockSpeed = 0;
    }
    
    public Ram(int kapasitasGB, String ddr, String merk, String nama, double harga, int clockSpeed) {
        super(merk, nama, harga, "RAM");
        this.kapasitasGB = kapasitasGB;
        this.ddr = ddr;
        this.clockSpeed = clockSpeed;
    }
    
    public int getKapasitasGB() {
        return kapasitasGB;
    }
    
    public void setKapasitasGB(int kapasitasGB) {
        this.kapasitasGB = kapasitasGB;
    }
    
    public String getDdr() {
        return ddr;
    }
    
    public void setDdr(String ddr) {
        this.ddr = ddr;
    }
    
    public int getClockSpeed() {
        return clockSpeed;
    }
    
    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("RAM: " + merk + " " + nama + 
                           " (" + kapasitasGB + " GB, " + ddr + ", " + clockSpeed + " MHz)");
        System.out.println("    Harga: Rp" + harga);
    }
    
    @Override
    public boolean canUpgrade() {
        return clockSpeed < 5000;
    }
    
    @Override
    public void upgrade() {
        if (canUpgrade()) {
            clockSpeed += 400;
            harga += harga * 0.08;
            System.out.println("RAM berhasil di-upgrade menjadi " + clockSpeed + " MHz");
        } else {
            System.out.println("RAM tidak bisa di-upgrade lebih lanjut");
        }
    }
}