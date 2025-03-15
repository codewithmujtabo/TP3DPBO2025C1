#pragma once
#include "Elektronik.cpp"

// First level of hierarchical inheritance
class Komponen : public Elektronik {
protected:
    string tipeKomponen;

public:
    Komponen() {}

    Komponen(string merk, string nama, float harga, string tipeKomponen) 
        : Elektronik(merk, nama, harga) {
        this->tipeKomponen = tipeKomponen;
    }

    string getTipeKomponen() const {
        return tipeKomponen;
    }

    void setTipeKomponen(string tipeKomponen) {
        this->tipeKomponen = tipeKomponen;
    }

    void tampilkanInfo() {
        cout << tipeKomponen << ": " << merk << " " << nama << ", Harga: Rp" << harga << endl;
    }
};
