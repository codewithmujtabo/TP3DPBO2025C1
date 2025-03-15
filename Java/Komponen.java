// Komponen.java
public abstract class Komponen extends Elektronik {
    protected String tipeKomponen;
    
    public Komponen() {
        super();
        this.tipeKomponen = "";
    }
    
    public Komponen(String merk, String nama, double harga, String tipeKomponen) {
        super(merk, nama, harga);
        this.tipeKomponen = tipeKomponen;
    }
    
    public String getTipeKomponen() {
        return tipeKomponen;
    }
    
    public void setTipeKomponen(String tipeKomponen) {
        this.tipeKomponen = tipeKomponen;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println(tipeKomponen + ": " + merk + " " + nama + ", Harga: Rp" + harga);
    }
}