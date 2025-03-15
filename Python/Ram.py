# ram.py
from Komponen import Komponen
from Upgradeable import Upgradeable

class Ram(Komponen, Upgradeable):
    """RAM class with multiple inheritance"""
    
    def __init__(self, kapasitas_gb=0, ddr="", merk="", nama="", harga=0, clock_speed=3200, tipe_komponen="RAM"):
        super().__init__(merk, nama, harga, tipe_komponen)
        self.kapasitas_gb = kapasitas_gb
        self.ddr = ddr
        self.clock_speed = clock_speed
    
    def get_kapasitas_gb(self):
        return self.kapasitas_gb
    
    def set_kapasitas_gb(self, kapasitas_gb):
        self.kapasitas_gb = kapasitas_gb
    
    def get_ddr(self):
        return self.ddr
    
    def set_ddr(self, ddr):
        self.ddr = ddr
    
    def get_clock_speed(self):
        return self.clock_speed
    
    def set_clock_speed(self, clock_speed):
        self.clock_speed = clock_speed
    
    def tampilkan_info(self):
        print(f"RAM: {self.merk} {self.nama} ({self.kapasitas_gb} GB, {self.ddr}, {self.clock_speed} MHz)")
        print(f"    Harga: Rp{self.harga}")
    
    def can_upgrade(self):
        return self.clock_speed < 5000
    
    def upgrade(self):
        if self.can_upgrade():
            self.clock_speed += 400
            self.harga += self.harga * 0.08
            print(f"RAM berhasil di-upgrade menjadi {self.clock_speed} MHz")
        else:
            print("RAM tidak bisa di-upgrade lebih lanjut")