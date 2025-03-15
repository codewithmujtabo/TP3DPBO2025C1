#pragma once
#include "Peripheral.cpp"

class Monitor : public Peripheral {
private:
    float ukuranInch;
    int refreshRate;
    string resolution;

public:
    Monitor() {
        this->ukuranInch = 0.0;
        this->refreshRate = 0;
        this->resolution = "";
    }

    Monitor(float ukuranInch, int refreshRate, string resolution,
            string merk, string nama, float harga,
            string tipePeripheral = "Monitor", string koneksi = "HDMI") 
        : Peripheral(merk, nama, harga, tipePeripheral, koneksi) {
        this->ukuranInch = ukuranInch;
        this->refreshRate = refreshRate;
        this->resolution = resolution;
    }

    float getUkuranInch() const {
        return ukuranInch;
    }

    int getRefreshRate() const {
        return refreshRate;
    }

    string getResolution() const {
        return resolution;
    }

    void tampilkanInfo() {
        cout << tipePeripheral << ": " << merk << " " << nama
             << " (" << ukuranInch << "', " << resolution << ", " << refreshRate << " Hz)" << endl
             << "    Koneksi: " << koneksi << ", Harga: Rp" << harga << endl;
    }
};