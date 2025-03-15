// Peripheral.java
public abstract class Peripheral extends Elektronik {
    protected String tipePeripheral;
    protected String koneksi;
    
    public Peripheral() {
        super();
        this.tipePeripheral = "";
        this.koneksi = "";
    }
    
    public Peripheral(String merk, String nama, double harga, String tipePeripheral, String koneksi) {
        super(merk, nama, harga);
        this.tipePeripheral = tipePeripheral;
        this.koneksi = koneksi;
    }
    
    public String getTipePeripheral() {
        return tipePeripheral;
    }
    
    public void setTipePeripheral(String tipePeripheral) {
        this.tipePeripheral = tipePeripheral;
    }
    
    public String getKoneksi() {
        return koneksi;
    }
    
    public void setKoneksi(String koneksi) {
        this.koneksi = koneksi;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println(tipePeripheral + ": " + merk + " " + nama + 
                           " (Koneksi: " + koneksi + ")");
        System.out.println("    Harga: Rp" + harga);
    }
}