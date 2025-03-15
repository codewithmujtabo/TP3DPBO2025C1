#pragma once
#include "Komponen.cpp"
#include "Upgradeable.cpp"
#include "ThermalManaged.cpp"

// Multiple inheritance: Inherits from Komponen and implements two interfaces
class Cpu : public Komponen, public Upgradeable, public ThermalManaged {
private:
    int jumlahCore;
    float kecepatanGHz;
    string socket;

public:
    Cpu() : ThermalManaged(90.0, 35.0) {
        this->jumlahCore = 0;
        this->kecepatanGHz = 0.0;
        this->socket = "";
    }

    Cpu(int jumlahCore, float kecepatanGHz, string socket, string merk, string nama, float harga) 
        : Komponen(merk, nama, harga, "CPU"), ThermalManaged(90.0, 35.0) {
        this->jumlahCore = jumlahCore;
        this->kecepatanGHz = kecepatanGHz;
        this->socket = socket;
    }

    int getJumlahCore() const {
        return jumlahCore;
    }

    float getKecepatanGHz() const {
        return kecepatanGHz;
    }

    string getSocket() const {
        return socket;
    }

    void setJumlahCore(int jumlahCore) {
        this->jumlahCore = jumlahCore;
    }

    void setKecepatanGHz(float kecepatanGHz) {
        this->kecepatanGHz = kecepatanGHz;
    }

    void setSocket(string socket) {
        this->socket = socket;
    }

    void tampilkanInfo() {
        cout << "CPU: " << merk << " " << nama 
             << " (" << jumlahCore << " Core, " << kecepatanGHz << " GHz)" << endl
             << "    Socket: " << socket << ", Harga: Rp" << harga 
             << ", Suhu: " << suhuSaatIni << "°C" << endl;
    }

    // Implementation of Upgradeable interface
    bool canUpgrade() {
        return kecepatanGHz < 5.0;
    }

    void upgrade() {
        if (canUpgrade()) {
            kecepatanGHz += 0.2;
            harga += harga * 0.1;
            cout << "CPU berhasil di-upgrade menjadi " << kecepatanGHz << " GHz" << endl;
        } else {
            cout << "CPU tidak bisa di-upgrade lebih lanjut" << endl;
        }
    }

    // Implementation of ThermalManaged interface
    void coolDown() {
        suhuSaatIni -= 5.0;
        if (suhuSaatIni < 30.0) suhuSaatIni = 30.0;
        cout << "CPU didinginkan. Suhu sekarang: " << suhuSaatIni << "°C" << endl;
    }

    void overclock() {
        kecepatanGHz += 0.1;
        suhuSaatIni += 5.0;
        cout << "CPU di-overclock menjadi " << kecepatanGHz << " GHz. Suhu naik menjadi " 
             << suhuSaatIni << "°C" << endl;
    }
};