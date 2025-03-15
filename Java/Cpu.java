// Cpu.java
public class Cpu extends Komponen implements Upgradeable, ThermalManaged {
    private int jumlahCore;
    private float kecepatanGHz;
    private String socket;
    private float suhuSaatIni;
    private float suhuMaksimum;
    
    public Cpu() {
        super();
        this.jumlahCore = 0;
        this.kecepatanGHz = 0.0f;
        this.socket = "";
        this.suhuSaatIni = 30.0f;
        this.suhuMaksimum = 90.0f;
    }
    
    public Cpu(int jumlahCore, float kecepatanGHz, String socket, 
               String merk, String nama, double harga) {
        super(merk, nama, harga, "CPU");
        this.jumlahCore = jumlahCore;
        this.kecepatanGHz = kecepatanGHz;
        this.socket = socket;
        this.suhuSaatIni = 35.0f;
        this.suhuMaksimum = 90.0f;
    }
    
    public int getJumlahCore() {
        return jumlahCore;
    }
    
    public void setJumlahCore(int jumlahCore) {
        this.jumlahCore = jumlahCore;
    }
    
    public float getKecepatanGHz() {
        return kecepatanGHz;
    }
    
    public void setKecepatanGHz(float kecepatanGHz) {
        this.kecepatanGHz = kecepatanGHz;
    }
    
    public String getSocket() {
        return socket;
    }
    
    public void setSocket(String socket) {
        this.socket = socket;
    }
    
    public float getSuhuMaksimum() {
        return suhuMaksimum;
    }
    
    public void setSuhuMaksimum(float suhuMaksimum) {
        this.suhuMaksimum = suhuMaksimum;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.println("CPU: " + merk + " " + nama + 
                           " (" + jumlahCore + " Core, " + kecepatanGHz + " GHz)");
        System.out.println("    Socket: " + socket + ", Harga: Rp" + harga + 
                           ", Suhu: " + suhuSaatIni + "°C");
    }
    
    @Override
    public boolean canUpgrade() {
        return kecepatanGHz < 5.0f;
    }
    
    @Override
    public void upgrade() {
        if (canUpgrade()) {
            kecepatanGHz += 0.2f;
            harga += harga * 0.1;
            System.out.println("CPU berhasil di-upgrade menjadi " + kecepatanGHz + " GHz");
        } else {
            System.out.println("CPU tidak bisa di-upgrade lebih lanjut");
        }
    }
    
    @Override
    public void coolDown() {
        suhuSaatIni -= 5.0f;
        if (suhuSaatIni < 30.0f) suhuSaatIni = 30.0f;
        System.out.println("CPU didinginkan. Suhu sekarang: " + suhuSaatIni + "°C");
    }
    
    @Override
    public float getSuhu() {
        return suhuSaatIni;
    }
    
    public void overclock() {
        kecepatanGHz += 0.1f;
        suhuSaatIni += 5.0f;
        System.out.println("CPU di-overclock menjadi " + kecepatanGHz + " GHz. Suhu naik menjadi " 
                           + suhuSaatIni + "°C");
    }
}