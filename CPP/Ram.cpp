#pragma once
#include "Komponen.cpp"
#include "Upgradeable.cpp"

// Multiple inheritance: Ram inherits from Komponen and implements Upgradeable
class Ram : public Komponen, public Upgradeable {
private:
    int kapasitasGB;
    string ddr;
    int clockSpeed;

public:
    Ram() {
        this->kapasitasGB = 0;
        this->ddr = "";
        this->clockSpeed = 0;
    }

    Ram(int kapasitasGB, string ddr, string merk, string nama, float harga, int clockSpeed = 3200) 
        : Komponen(merk, nama, harga, "RAM") {
        this->kapasitasGB = kapasitasGB;
        this->ddr = ddr;
        this->clockSpeed = clockSpeed;
    }

    int getKapasitasGB() const {
        return kapasitasGB;
    }

    string getDdr() const {
        return ddr;
    }

    int getClockSpeed() const {
        return clockSpeed;
    }

    void tampilkanInfo() {
        cout << "RAM: " << merk << " " << nama
             << " (" << kapasitasGB << " GB, " << ddr << ", " << clockSpeed << " MHz)" << endl
             << "    Harga: Rp" << harga << endl;
    }

    // Implementation of Upgradeable interface
    bool canUpgrade() {
        return clockSpeed < 5000;
    }

    void upgrade() {
        if (canUpgrade()) {
            clockSpeed += 400;
            harga += harga * 0.08;
            cout << "RAM berhasil di-upgrade menjadi " << clockSpeed << " MHz" << endl;
        } else {
            cout << "RAM tidak bisa di-upgrade lebih lanjut" << endl;
        }
    }
};