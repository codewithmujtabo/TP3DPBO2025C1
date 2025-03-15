// Elektronik.java
public abstract class Elektronik {
    protected String merk;
    protected String nama;
    protected double harga;
    
    public Elektronik() {
        this.merk = "";
        this.nama = "";
        this.harga = 0.0;
    }
    
    public Elektronik(String merk, String nama, double harga) {
        this.merk = merk;
        this.nama = nama;
        this.harga = harga;
    }
    
    public void setMerk(String merk) {
        this.merk = merk;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    public String getMerk() {
        return merk;
    }
    
    public String getNama() {
        return nama;
    }
    
    public double getHarga() {
        return harga;
    }
    
    public abstract void tampilkanInfo();
}