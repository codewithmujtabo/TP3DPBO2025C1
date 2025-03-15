#pragma once
#include "Komponen.cpp"

class Motherboard : public Komponen {
private:
    string chipset;
    string formFactor;
    string socketType;

public:
    Motherboard() {
        this->chipset = "";
        this->formFactor = "";
        this->socketType = "";
    }

    Motherboard(string chipset, string formFactor, string socketType, 
                string merk, string nama, float harga) 
        : Komponen(merk, nama, harga, "Motherboard") {
        this->chipset = chipset;
        this->formFactor = formFactor;
        this->socketType = socketType;
    }

    string getChipset() const {
        return chipset;
    }

    string getFormFactor() const {
        return formFactor;
    }

    string getSocketType() const {
        return socketType;
    }

    void tampilkanInfo() {
        cout << "Motherboard: " << merk << " " << nama
             << " (" << chipset << ", " << formFactor << ")" << endl
             << "    Socket: " << socketType << ", Harga: Rp" << harga << endl;
    }
};