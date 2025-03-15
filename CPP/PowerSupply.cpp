#pragma once
#include "Komponen.cpp"

class PowerSupply : public Komponen {
private:
    int wattage;
    string certification;

public:
    PowerSupply() {
        this->wattage = 0;
        this->certification = "";
    }

    PowerSupply(int wattage, string certification, string merk, string nama, float harga) 
        : Komponen(merk, nama, harga, "Power Supply") {
        this->wattage = wattage;
        this->certification = certification;
    }

    int getWattage() const {
        return wattage;
    }

    string getCertification() const {
        return certification;
    }

    void tampilkanInfo() {
        cout << "Power Supply: " << merk << " " << nama
             << " (" << wattage << "W, " << certification << ")" << endl
             << "    Harga: Rp" << harga << endl;
    }
};