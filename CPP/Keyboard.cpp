#pragma once
#include "Peripheral.cpp"

class Keyboard : public Peripheral {
private:
    string layoutType;
    bool mechanical;

public:
    Keyboard() {
        this->layoutType = "";
        this->mechanical = false;
    }

    Keyboard(string layoutType, bool mechanical, string merk, string nama, float harga,
             string tipePeripheral = "Keyboard", string koneksi = "USB") 
        : Peripheral(merk, nama, harga, tipePeripheral, koneksi) {
        this->layoutType = layoutType;
        this->mechanical = mechanical;
    }

    string getLayoutType() const {
        return layoutType;
    }

    bool isMechanical() const {
        return mechanical;
    }

    void tampilkanInfo() {
        cout << tipePeripheral << ": " << merk << " " << nama
             << " (" << layoutType << ", " << (mechanical ? "Mechanical" : "Membrane") << ")" << endl
             << "    Koneksi: " << koneksi << ", Harga: Rp" << harga << endl;
    }
};