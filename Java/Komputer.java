// Komputer.java
import java.util.ArrayList;
import java.util.List;

public class Komputer {
    private String nama;
    private Cpu cpu;
    private List<Ram> ramList;
    private List<Harddrive> storageList;
    private Gpu gpu;
    private PowerSupply powerSupply;
    private Motherboard motherboard;
    private List<Peripheral> peripheralList;
    private double totalHarga;
    
    public Komputer() {
        this.nama = "";
        this.cpu = new Cpu();
        this.ramList = new ArrayList<>();
        this.storageList = new ArrayList<>();
        this.gpu = new Gpu();
        this.powerSupply = new PowerSupply();
        this.motherboard = new Motherboard();
        this.peripheralList = new ArrayList<>();
        this.totalHarga = 0.0;
    }
    
    public Komputer(String nama, Cpu cpu, List<Ram> ramList, List<Harddrive> storageList,
                   Gpu gpu, PowerSupply powerSupply, Motherboard motherboard) {
        this.nama = nama;
        this.cpu = cpu;
        this.ramList = ramList;
        this.storageList = storageList;
        this.gpu = gpu;
        this.powerSupply = powerSupply;
        this.motherboard = motherboard;
        this.peripheralList = new ArrayList<>();
        hitungTotalHarga();
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public Cpu getCpu() {
        return cpu;
    }
    
    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
        hitungTotalHarga();
    }
    
    public List<Ram> getRamList() {
        return ramList;
    }
    
    public void setRamList(List<Ram> ramList) {
        this.ramList = ramList;
        hitungTotalHarga();
    }
    
    public List<Harddrive> getStorageList() {
        return storageList;
    }
    
    public void setStorageList(List<Harddrive> storageList) {
        this.storageList = storageList;
        hitungTotalHarga();
    }
    
    public Gpu getGpu() {
        return gpu;
    }
    
    public void setGpu(Gpu gpu) {
        this.gpu = gpu;
        hitungTotalHarga();
    }
    
    public PowerSupply getPowerSupply() {
        return powerSupply;
    }
    
    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
        hitungTotalHarga();
    }
    
    public Motherboard getMotherboard() {
        return motherboard;
    }
    
    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
        hitungTotalHarga();
    }
    
    public List<Peripheral> getPeripheralList() {
        return peripheralList;
    }
    
    public double getTotalHarga() {
        return totalHarga;
    }
    
    public void addRam(Ram ram) {
        ramList.add(ram);
        hitungTotalHarga();
    }
    
    public void removeRam(Ram ram) {
        ramList.remove(ram);
        hitungTotalHarga();
    }
    
    public void addStorage(Harddrive storage) {
        storageList.add(storage);
        hitungTotalHarga();
    }
    
    public void removeStorage(Harddrive storage) {
        storageList.remove(storage);
        hitungTotalHarga();
    }
    
    public void addPeripheral(Peripheral peripheral) {
        peripheralList.add(peripheral);
        hitungTotalHarga();
    }
    
    public void removePeripheral(Peripheral peripheral) {
        peripheralList.remove(peripheral);
        hitungTotalHarga();
    }
    
    private void hitungTotalHarga() {
        // Reset total price
        totalHarga = 0.0;
        
        // Add component prices
        totalHarga += cpu.getHarga();
        
        // Add RAM prices
        for (Ram ram : ramList) {
            totalHarga += ram.getHarga();
        }
        
        // Add storage prices
        for (Harddrive storage : storageList) {
            totalHarga += storage.getHarga();
        }
        
        // Add GPU price
        totalHarga += gpu.getHarga();
        
        // Add Power Supply price
        totalHarga += powerSupply.getHarga();
        
        // Add Motherboard price
        totalHarga += motherboard.getHarga();
        
        // Add Peripheral prices
        for (Peripheral peripheral : peripheralList) {
            totalHarga += peripheral.getHarga();
        }
    }
    
    public void tampilkanDetailKomputer() {
        System.out.println("Komputer: " + nama);
        System.out.println("Total Harga: Rp" + String.format("%.2f", totalHarga));
        
        System.out.println("\nKomponen Utama:");
        cpu.tampilkanInfo();
        motherboard.tampilkanInfo();
        gpu.tampilkanInfo();
        powerSupply.tampilkanInfo();
        
        System.out.println("\nRAM:");
        for (Ram ram : ramList) {
            ram.tampilkanInfo();
        }
        
        System.out.println("\nPenyimpanan:");
        for (Harddrive storage : storageList) {
            storage.tampilkanInfo();
        }
        
        System.out.println("\nPeriferal:");
        for (Peripheral peripheral : peripheralList) {
            peripheral.tampilkanInfo();
        }
    }
} 