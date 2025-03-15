#pragma once
#include "Komponen.cpp"

class Harddrive : public Komponen {
private:
    int kapasitasGB;
    string tipeDrive;
    int readSpeed;
    int writeSpeed;

public:
    Harddrive() {
        this->kapasitasGB = 0;
        this->tipeDrive = "";
        this->readSpeed = 0;
        this->writeSpeed = 0;
    }

    Harddrive(int kapasitasGB, string tipeDrive, string merk, string nama, float harga,
              int readSpeed = 500, int writeSpeed = 450) 
        : Komponen(merk, nama, harga, "Storage") {
        this->kapasitasGB = kapasitasGB;
        this->tipeDrive = tipeDrive;
        this->readSpeed = readSpeed;
        this->writeSpeed = writeSpeed;
    }

    int getKapasitasGB() const {
        return kapasitasGB;
    }

    string getTipeDrive() const {
        return tipeDrive;
    }

    int getReadSpeed() const {
        return readSpeed;
    }

    int getWriteSpeed() const {
        return writeSpeed;
    }

    void tampilkanInfo() {
        cout << "Storage: " << merk << " " << nama
             << " (" << kapasitasGB << " GB, " << tipeDrive << ")" << endl
             << "    Read: " << readSpeed << " MB/s, Write: " << writeSpeed << " MB/s, Harga: Rp" << harga << endl;
    }
};