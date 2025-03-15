#pragma once
#include "Komponen.cpp"
#include "Upgradeable.cpp"
#include "ThermalManaged.cpp"

// Multiple inheritance similar to CPU
class Gpu : public Komponen, public Upgradeable, public ThermalManaged {
private:
    int vramGB;
    string tipe;
    int powerConsumption;

public:
    Gpu() : ThermalManaged(85.0, 40.0) {
        this->vramGB = 0;
        this->tipe = "";
        this->powerConsumption = 0;
    }

    Gpu(int vramGB, string tipe, string merk, string nama, float harga, int powerConsumption = 150) 
        : Komponen(merk, nama, harga, "GPU"), ThermalManaged(85.0, 40.0) {
        this->vramGB = vramGB;
        this->tipe = tipe;
        this->powerConsumption = powerConsumption;
    }

    int getVramGB() const {
        return vramGB;
    }

    string getTipe() const {
        return tipe;
    }

    int getPowerConsumption() const {
        return powerConsumption;
    }

    void tampilkanInfo() {
        cout << "GPU: " << merk << " " << nama 
             << " (" << vramGB << " GB, " << tipe << ")" << endl
             << "    Power: " << powerConsumption << "W, Harga: Rp" << harga 
             << ", Suhu: " << suhuSaatIni << "°C" << endl;
    }

    // Implementation of Upgradeable interface
    bool canUpgrade() {
        return vramGB < 16;
    }

    void upgrade() {
        if (canUpgrade()) {
            vramGB += 2;
            powerConsumption += 20;
            harga += harga * 0.15;
            cout << "GPU berhasil di-upgrade menjadi " << vramGB << " GB VRAM" << endl;
        } else {
            cout << "GPU tidak bisa di-upgrade lebih lanjut" << endl;
        }
    }

    // Implementation of ThermalManaged interface
    void coolDown() {
        suhuSaatIni -= 8.0;
        if (suhuSaatIni < 35.0) suhuSaatIni = 35.0;
        cout << "GPU didinginkan. Suhu sekarang: " << suhuSaatIni << "°C" << endl;
    }
};