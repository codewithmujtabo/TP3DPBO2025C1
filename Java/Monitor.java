public class Monitor extends Peripheral {
    private float ukuranInch;
    private int refreshRate;
    private String resolution;
    
    public Monitor() {
        super();
        this.ukuranInch = 0.0f;
        this.refreshRate = 0;
        this.resolution = "";
    }
    
    public Monitor(float ukuranInch, int refreshRate, String resolution, 
                  String merk, String nama, double harga, 
                  String tipePeripheral, String koneksi) {
        super(merk, nama, harga, tipePeripheral, koneksi);
        this.ukuranInch = ukuranInch;
        this.refreshRate = refreshRate;
        this.resolution = resolution;
    }
    
    public Monitor(float ukuranInch, int refreshRate, String resolution, 
                  String merk, String nama, double harga) {
        this(ukuranInch, refreshRate, resolution, merk, nama, harga, "Monitor", "HDMI");
    }
    
    public float getUkuranInch() {
        return ukuranInch;
    }
    
    public void setUkuranInch(float ukuranInch) {
        this.ukuranInch = ukuranInch;
    }
    
    public int getRefreshRate() {
        return refreshRate;
    }
    
    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }
    
    public String getResolution() {
        return resolution;
    }
    
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println(tipePeripheral + ": " + merk + " " + nama + 
                           " (" + ukuranInch + "', " + resolution + ", " + refreshRate + " Hz)");
        System.out.println("    Koneksi: " + koneksi + ", Harga: Rp" + harga);
    }
}