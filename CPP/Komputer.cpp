#pragma once
#include <iostream>
#include <string>
#include <vector>
#include "Cpu.cpp"
#include "Gpu.cpp"
#include "Ram.cpp"
#include "Harddrive.cpp"
#include "PowerSupply.cpp"
#include "Motherboard.cpp"
#include "Peripheral.cpp"
#include "Keyboard.cpp"
#include "Monitor.cpp"

using namespace std;

// Class that demonstrates composition of multiple component types
class Komputer {
private:
    string nama;
    Cpu cpu;
    vector<Ram> ramList;
    vector<Harddrive> storageList;
    Gpu gpu;
    PowerSupply powerSupply;
    Motherboard motherboard;
    vector<Peripheral*> peripheralList;
    float totalHarga;

public:
    Komputer() {
        this->nama = "";
        this->totalHarga = 0.0;
    }

    Komputer(string nama, Cpu cpu, vector<Ram> ramList, vector<Harddrive> storageList,
             Gpu gpu, PowerSupply powerSupply, Motherboard motherboard) {
        this->nama = nama;
        this->cpu = cpu;
        this->ramList = ramList;
        this->storageList = storageList;
        this->gpu = gpu;
        this->powerSupply = powerSupply;
        this->motherboard = motherboard;
        this->hitungTotalHarga();
    }

    string getNama() const {
        return nama;
    }

    Cpu getCpu() const {
        return cpu;
    }

    vector<Ram> getRamList() const {
        return ramList;
    }

    vector<Harddrive> getStorageList() const {
        return storageList;
    }

    Gpu getGpu() const {
        return gpu;
    }

    PowerSupply getPowerSupply() const {
        return powerSupply;
    }

    Motherboard getMotherboard() const {
        return motherboard;
    }

    void addRam(Ram ram) {
        ramList.push_back(ram);
        this->hitungTotalHarga();
    }

    void addStorage(Harddrive storage) {
        storageList.push_back(storage);
        this->hitungTotalHarga();
    }

    void addPeripheral(Peripheral* peripheral) {
        peripheralList.push_back(peripheral);
        this->hitungTotalHarga();
    }

    void hitungTotalHarga() {
        totalHarga = cpu.getHarga() + gpu.getHarga() + 
                     powerSupply.getHarga() + motherboard.getHarga();
        
        // Use traditional loop instead of range-based for loop
        for (size_t i = 0; i < ramList.size(); i++) {
            totalHarga += ramList[i].getHarga();
        }
        
        for (size_t i = 0; i < storageList.size(); i++) {
            totalHarga += storageList[i].getHarga();
        }
        
        for (size_t i = 0; i < peripheralList.size(); i++) {
            totalHarga += peripheralList[i]->getHarga();
        }
    }

    float getTotalHarga() const {
        return totalHarga;
    }

    void checkCompatibility() {
        bool compatible = true;
        string issues = "";

        // Check CPU and motherboard socket compatibility
        if (cpu.getSocket() != motherboard.getSocketType()) {
            compatible = false;
            issues += "- CPU socket (" + cpu.getSocket() + ") tidak kompatibel dengan motherboard socket (" 
                    + motherboard.getSocketType() + ")\n";
        }

        // Check power supply wattage vs GPU requirements
        if (powerSupply.getWattage() < gpu.getPowerConsumption() + 200) {
            compatible = false;
            issues += "- Power supply wattage (" + to_string(powerSupply.getWattage()) 
                    + "W) mungkin tidak cukup untuk GPU (" + to_string(gpu.getPowerConsumption()) + "W)\n";
        }

        if (compatible) {
            cout << "Semua komponen kompatibel!" << endl;
        } else {
            cout << "Ditemukan masalah kompatibilitas:\n" << issues;
        }
    }

    void upgradeKomponen() {
        cout << "\n===== UPGRADE KOMPONEN =====" << endl;
        
        // Upgrade CPU if possible
        if (cpu.canUpgrade()) {
            cpu.upgrade();
        } else {
            cout << "CPU tidak dapat di-upgrade" << endl;
        }
        
        // Upgrade GPU if possible
        if (gpu.canUpgrade()) {
            gpu.upgrade();
        } else {
            cout << "GPU tidak dapat di-upgrade" << endl;
        }
        
        // Upgrade all RAM modules if possible
        for (size_t i = 0; i < ramList.size(); i++) {
            Ram& ram = ramList[i];
            if (ram.canUpgrade()) {
                ram.upgrade();
            }
        }
        
        // Recalculate total price after upgrades
        this->hitungTotalHarga();
    }

    void tampilkanInfo() {
        cout << "\n========== " << nama << " ==========" << endl;
        cout << "SPESIFIKASI KOMPUTER:" << endl;
        
        // Show components
        cpu.tampilkanInfo();
        gpu.tampilkanInfo();
        motherboard.tampilkanInfo();
        powerSupply.tampilkanInfo();
        
        cout << "\nRAM Modules:" << endl;
        for (size_t i = 0; i < ramList.size(); i++) {
            cout << "[" << i+1 << "] ";
            ramList[i].tampilkanInfo();
        }
        
        cout << "\nStorage Devices:" << endl;
        for (size_t i = 0; i < storageList.size(); i++) {
            cout << "[" << i+1 << "] ";
            storageList[i].tampilkanInfo();
        }
        
        if (!peripheralList.empty()) {
            cout << "\nPeripherals:" << endl;
            for (size_t i = 0; i < peripheralList.size(); i++) {
                cout << "[" << i+1 << "] ";
                peripheralList[i]->tampilkanInfo();
            }
        }
        
        cout << "\nTotal Harga: Rp" << totalHarga << endl;
        cout << "=============================" << endl;
    }

    ~Komputer() {
        // Free memory for peripherals
        for (size_t i = 0; i < peripheralList.size(); i++) {
            delete peripheralList[i];
        }
        peripheralList.clear();
    }
};