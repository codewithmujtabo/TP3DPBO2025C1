#pragma once
#include <iostream>
#include <string>

using namespace std;

// Base class for all electronic components
class Elektronik {
protected:
    string merk;
    string nama;
    float harga;

public:
    Elektronik() {}

    Elektronik(string merk, string nama, float harga) {
        this->merk = merk;
        this->nama = nama;
        this->harga = harga;
    }

    void setMerk(string merk) {
        this->merk = merk;
    }

    void setNama(string nama) {
        this->nama = nama;
    }

    void setHarga(float harga) {
        this->harga = harga;
    }

    string getMerk() const {
        return merk;
    }

    string getNama() const {
        return nama;
    }

    float getHarga() const {
        return harga;
    }

    virtual void tampilkanInfo() {
        cout << "Elektronik: " << merk << " " << nama << ", Harga: Rp" << harga << endl;
    }

    virtual ~Elektronik() {}
};