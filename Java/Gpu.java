// Gpu.java
public class Gpu extends Komponen implements Upgradeable, ThermalManaged {
    private int vramGB;
    private String tipe;
    private int powerConsumption;
    private float suhuSaatIni;
    private float suhuMaksimum;
    
    public Gpu() {
        super();
        this.vramGB = 0;
        this.tipe = "";
        this.powerConsumption = 0;
        this.suhuSaatIni = 40.0f;
        this.suhuMaksimum = 85.0f;
    }
    
    public Gpu(int vramGB, String tipe, String merk, String nama, double harga, int powerConsumption) {
        super(merk, nama, harga, "GPU");
        this.vramGB = vramGB;
        this.tipe = tipe;
        this.powerConsumption = powerConsumption;
        this.suhuSaatIni = 40.0f;
        this.suhuMaksimum = 85.0f;
    }
    
    public int getVramGB() {
        return vramGB;
    }
    
    public void setVramGB(int vramGB) {
        this.vramGB = vramGB;
    }
    
    public String getTipe() {
        return tipe;
    }
    
    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
    
    public int getPowerConsumption() {
        return powerConsumption;
    }
    
    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
    
    public float getSuhuMaksimum() {
        return suhuMaksimum;
    }
    
    public void setSuhuMaksimum(float suhuMaksimum) {
        this.suhuMaksimum = suhuMaksimum;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("GPU: " + merk + " " + nama + 
                           " (" + vramGB + " GB, " + tipe + ")");
        System.out.println("    Power: " + powerConsumption + "W, Harga: Rp" + harga + 
                           ", Suhu: " + suhuSaatIni + "°C");
    }
    
    @Override
    public boolean canUpgrade() {
        return vramGB < 16;
    }
    
    @Override
    public void upgrade() {
        if (canUpgrade()) {
            vramGB += 2;
            powerConsumption += 20;
            harga += harga * 0.15;
            System.out.println("GPU berhasil di-upgrade menjadi " + vramGB + " GB VRAM");
        } else {
            System.out.println("GPU tidak bisa di-upgrade lebih lanjut");
        }
    }
    
    @Override
    public void coolDown() {
        suhuSaatIni -= 8.0f;
        if (suhuSaatIni < 35.0f) suhuSaatIni = 35.0f;
        System.out.println("GPU didinginkan. Suhu sekarang: " + suhuSaatIni + "°C");
    }
    
    @Override
    public float getSuhu() {
        return suhuSaatIni;
    }
}