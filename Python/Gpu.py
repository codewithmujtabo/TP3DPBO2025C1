# gpu.py
from Komponen import Komponen
from Upgradeable import Upgradeable
from ThermalManaged import ThermalManaged

class Gpu(Komponen, Upgradeable, ThermalManaged):
    """GPU class with multiple inheritance"""
    
    def __init__(self, vram_gb=0, tipe="", merk="", nama="", harga=0, power_consumption=150, tipe_komponen="GPU"):
        Komponen.__init__(self, merk, nama, harga, tipe_komponen)
        ThermalManaged.__init__(self, 85.0, 40.0)
        self.vram_gb = vram_gb
        self.tipe = tipe
        self.power_consumption = power_consumption
    
    def get_vram_gb(self):
        return self.vram_gb
    
    def set_vram_gb(self, vram_gb):
        self.vram_gb = vram_gb
    
    def get_tipe(self):
        return self.tipe
    
    def set_tipe(self, tipe):
        self.tipe = tipe
    
    def get_power_consumption(self):
        return self.power_consumption
    
    def set_power_consumption(self, power_consumption):
        self.power_consumption = power_consumption
    
    def tampilkan_info(self):
        print(f"GPU: {self.merk} {self.nama} ({self.vram_gb} GB, {self.tipe})")
        print(f"    Power: {self.power_consumption}W, Harga: Rp{self.harga}, Suhu: {self.suhu_saat_ini}°C")
    
    def can_upgrade(self):
        return self.vram_gb < 16
    
    def upgrade(self):
        if self.can_upgrade():
            self.vram_gb += 2
            self.power_consumption += 20
            self.harga += self.harga * 0.15
            print(f"GPU berhasil di-upgrade menjadi {self.vram_gb} GB VRAM")
        else:
            print("GPU tidak bisa di-upgrade lebih lanjut")
    
    def cool_down(self):
        self.suhu_saat_ini -= 8.0
        if self.suhu_saat_ini < 35.0:
            self.suhu_saat_ini = 35.0
        print(f"GPU didinginkan. Suhu sekarang: {self.suhu_saat_ini}°C")