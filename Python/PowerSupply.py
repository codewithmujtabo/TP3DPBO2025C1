# power_supply.py
from Komponen import Komponen

class PowerSupply(Komponen):
    """Power Supply class"""
    
    def __init__(self, wattage=0, certification="", merk="", nama="", harga=0, tipe_komponen="Power Supply"):
        super().__init__(merk, nama, harga, tipe_komponen)
        self.wattage = wattage
        self.certification = certification
    
    def get_wattage(self):
        return self.wattage
    
    def set_wattage(self, wattage):
        self.wattage = wattage
    
    def get_certification(self):
        return self.certification
    
    def set_certification(self, certification):
        self.certification = certification
    
    def tampilkan_info(self):
        print(f"Power Supply: {self.merk} {self.nama} ({self.wattage}W, {self.certification})")
        print(f"    Harga: Rp{self.harga}")