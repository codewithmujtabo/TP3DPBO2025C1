#include <iostream>
#include <iomanip>
#include <vector>
#include "Komputer.cpp"

using namespace std;

int main() {
    cout << fixed << setprecision(2);
    
    cout << "=== SISTEM KOMPUTER DENGAN OOP ===" << endl;
    cout << "Demonstrasi Hierarchical, Multiple, & Hybrid Inheritance" << endl << endl;
    
    // Membuat komponen CPU dengan multiple inheritance (Komponen, Upgradeable, ThermalManaged)
    Cpu cpu(8, 3.6, "LGA1700", "Intel", "Core i7-12700K", 4500000);
    cpu.overclock(); // Demonstrasi method dari ThermalManaged
    
    // Membuat GPU dengan multiple inheritance (Komponen, Upgradeable, ThermalManaged)
    Gpu gpu(12, "RTX 4070", "NVIDIA", "GeForce", 8000000, 220);
    
    // Membuat RAM dengan multiple inheritance (Komponen, Upgradeable)
    vector<Ram> ramList;
    ramList.push_back(Ram(16, "DDR5", "Corsair", "Vengeance", 1200000, 5200));
    ramList.push_back(Ram(16, "DDR5", "Kingston", "Fury Beast", 1150000, 5000));
    
    // Membuat storage devices dengan hierarchical inheritance (Elektronik -> Komponen -> Harddrive)
    vector<Harddrive> storageList;
    storageList.push_back(Harddrive(1000, "SSD NVMe", "Samsung", "980 Pro", 1800000, 7000, 5000));
    storageList.push_back(Harddrive(2000, "HDD", "Seagate", "Barracuda", 800000, 190, 180));
    
    // Membuat motherboard dan power supply dengan hierarchical inheritance
    Motherboard mobo("Z690", "ATX", "LGA1700", "ASUS", "ROG Maximus", 5500000);
    PowerSupply psu(850, "80+ Gold", "Corsair", "RM850x", 1900000);
    
    // Komputer dengan komposisi (composition) berbagai komponen
    Komputer gamingPC("Gaming PC Deluxe", cpu, ramList, storageList, gpu, psu, mobo);
    
    // Menambahkan peripheral (hierarchical inheritance: Elektronik -> Peripheral -> Keyboard/Monitor)
    Keyboard* keyboard = new Keyboard("US QWERTY", true, "Logitech", "G Pro X", 1500000);
    Monitor* monitor = new Monitor(27.0, 165, "2560x1440", "LG", "UltraGear", 4500000);
    
    gamingPC.addPeripheral(keyboard);
    gamingPC.addPeripheral(monitor);
    
    // Menampilkan spesifikasi komputer
    gamingPC.tampilkanInfo();
    
    // Memeriksa kompatibilitas komponen
    gamingPC.checkCompatibility();
    
    // Menampilkan harga total sebelum upgrade
    cout << "\nTotal harga sebelum upgrade: Rp" << gamingPC.getTotalHarga() << endl;
    
    // Upgrade komponen yang mendukung interface Upgradeable
    gamingPC.upgradeKomponen();
    
    // Menampilkan harga setelah upgrade
    cout << "Total harga setelah upgrade: Rp" << gamingPC.getTotalHarga() << endl;
    
    // Tampilkan informasi akhir
    gamingPC.tampilkanInfo();
    
    return 0;
}