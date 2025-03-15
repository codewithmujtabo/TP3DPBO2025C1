// Harddrive.java
public class Harddrive extends Komponen {
    private int kapasitasGB;
    private String tipeDrive;
    private int readSpeed;
    private int writeSpeed;
    
    public Harddrive() {
        super();
        this.kapasitasGB = 0;
        this.tipeDrive = "";
        this.readSpeed = 0;
        this.writeSpeed = 0;
    }
    
    public Harddrive(int kapasitasGB, String tipeDrive, String merk, String nama, double harga,
                     int readSpeed, int writeSpeed) {
        super(merk, nama, harga, "Storage");
        this.kapasitasGB = kapasitasGB;
        this.tipeDrive = tipeDrive;
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
    }
    
    public int getKapasitasGB() {
        return kapasitasGB;
    }
    
    public void setKapasitasGB(int kapasitasGB) {
        this.kapasitasGB = kapasitasGB;
    }
    
    public String getTipeDrive() {
        return tipeDrive;
    }
    
    public void setTipeDrive(String tipeDrive) {
        this.tipeDrive = tipeDrive;
    }
    
    public int getReadSpeed() {
        return readSpeed;
    }
    
    public void setReadSpeed(int readSpeed) {
        this.readSpeed = readSpeed;
    }
    
    public int getWriteSpeed() {
        return writeSpeed;
    }
    
    public void setWriteSpeed(int writeSpeed) {
        this.writeSpeed = writeSpeed;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("Storage: " + merk + " " + nama + 
                           " (" + kapasitasGB + " GB, " + tipeDrive + ")");
        System.out.println("    Read: " + readSpeed + " MB/s, Write: " + writeSpeed + 
                           " MB/s, Harga: Rp" + harga);
    }
}