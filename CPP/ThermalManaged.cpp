#pragma once

// Interface for components that require thermal management
class ThermalManaged {
protected:
    float suhuMaksimum;
    float suhuSaatIni;

public:
    ThermalManaged(float suhuMaksimum = 100.0, float suhuSaatIni = 30.0) {
        this->suhuMaksimum = suhuMaksimum;
        this->suhuSaatIni = suhuSaatIni;
    }

    virtual void coolDown() = 0;
    virtual float getSuhu() const {
        return suhuSaatIni;
    }
    virtual ~ThermalManaged() {}
};