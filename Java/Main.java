import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEM KOMPUTER DENGAN OOP ===");
        System.out.println("Demonstrasi Hierarchical, Multiple, & Hybrid Inheritance\n");

        // Create CPU
        Cpu cpu = new Cpu(8, 3.7f, "LGA1700", "Intel", "Core i7-12700K", 4500000.0);
        
        // Overclock CPU
        cpu.overclock();
        
        // Create GPU
        Gpu gpu = new Gpu(12, "NVIDIA GeForce", "NVIDIA", "RTX 4070", 8000000.0, 220);
        
        // Create Motherboard
        Motherboard motherboard = new Motherboard("Z690", "ATX", "LGA1700", "ASUS", "ROG Maximus", 5500000.0);
        
        // Create Power Supply
        PowerSupply powerSupply = new PowerSupply(850, "80+ Gold", "Corsair", "RM850x", 1900000.0);
        
        // Create RAM
        List<Ram> ramList = new ArrayList<>();
        ramList.add(new Ram(16, "DDR5", "Corsair", "Vengeance", 1200000.0, 5200));
        ramList.add(new Ram(16, "DDR5", "Kingston", "Fury Beast", 1150000.0, 5000));
        
        // Create Storage
        List<Harddrive> storageList = new ArrayList<>();
        storageList.add(new Harddrive(1000, "SSD NVMe", "Samsung", "980 Pro", 1800000.0, 7000, 5000));
        storageList.add(new Harddrive(2000, "HDD", "Seagate", "Barracuda", 800000.0, 190, 180));
        
        // Create Peripherals
        Keyboard keyboard = new Keyboard("US QWERTY", true, "Logitech", "G Pro X", 1500000.0);
        Monitor monitor = new Monitor(27.0f, 165, "2560x1440", "LG", "UltraGear", 4500000.0);
        
        // Create Komputer
        Komputer komputer = new Komputer("Gaming PC Deluxe", cpu, ramList, storageList, 
                                         gpu, powerSupply, motherboard);
        
        // Add Peripherals
        komputer.addPeripheral(keyboard);
        komputer.addPeripheral(monitor);
        
        // Display initial computer details
        System.out.println("========== Gaming PC Deluxe ==========");
        System.out.println("SPESIFIKASI KOMPUTER:");
        komputer.tampilkanDetailKomputer();
        System.out.println("=============================");
        System.out.println("Semua komponen kompatibel!");
        
        // Store initial total price
        double initialPrice = komputer.getTotalHarga();
        System.out.println("\nTotal harga sebelum upgrade: Rp" + initialPrice);
        
        // Perform upgrades
        System.out.println("\n===== UPGRADE KOMPONEN =====");
        
        // Upgrade CPU
        if (cpu.canUpgrade()) {
            cpu.upgrade();
        }
        
        // Upgrade GPU
        if (gpu.canUpgrade()) {
            gpu.upgrade();
        }
        
        // Display upgraded computer details
        double upgradedPrice = komputer.getTotalHarga();
        System.out.println("Total harga setelah upgrade: Rp" + upgradedPrice);
        
        System.out.println("\n========== Gaming PC Deluxe ==========");
        System.out.println("SPESIFIKASI KOMPUTER:");
        komputer.tampilkanDetailKomputer();
        System.out.println("=============================");
    }
}