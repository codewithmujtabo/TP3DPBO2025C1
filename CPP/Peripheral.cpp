#pragma once
#include "Elektronik.cpp"

// Second branch of hierarchical inheritance
class Peripheral : public Elektronik {
protected:
    string tipePeripheral;
    string koneksi;

public:
    Peripheral() {}

    Peripheral(string merk, string nama, float harga, string tipePeripheral, string koneksi) 
        : Elektronik(merk, nama, harga) {
        this->tipePeripheral = tipePeripheral;
        this->koneksi = koneksi;
    }

    string getTipePeripheral() const {
        return tipePeripheral;
    }

    string getKoneksi() const {
        return koneksi;
    }

    void tampilkanInfo() {
        cout << tipePeripheral << ": " << merk << " " << nama
             << " (Koneksi: " << koneksi << ")" << endl
             << "    Harga: Rp" << harga << endl;
    }
};