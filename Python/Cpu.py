# cpu.py
from Komponen import Komponen
from Upgradeable import Upgradeable
from ThermalManaged import ThermalManaged

class Cpu(Komponen, Upgradeable, ThermalManaged):
    """CPU class with multiple inheritance"""
    
    def __init__(self, jumlah_core=0, kecepatan_ghz=0.0, socket="", 
                 merk="", nama="", harga=0, tipe_komponen="CPU"):
        Komponen.__init__(self, merk, nama, harga, tipe_komponen)
        ThermalManaged.__init__(self, 90.0, 35.0)
        self.jumlah_core = jumlah_core
        self.kecepatan_ghz = kecepatan_ghz
        self.socket = socket
    
    def get_jumlah_core(self):
        return self.jumlah_core
    
    def set_jumlah_core(self, jumlah_core):
        self.jumlah_core = jumlah_core
    
    def get_kecepatan_ghz(self):
        return self.kecepatan_ghz
    
    def set_kecepatan_ghz(self, kecepatan_ghz):
        self.kecepatan_ghz = kecepatan_ghz
    
    def get_socket(self):
        return self.socket
    
    def set_socket(self, socket):
        self.socket = socket
    
    def tampilkan_info(self):
        print(f"CPU: {self.merk} {self.nama} ({self.jumlah_core} Core, {self.kecepatan_ghz} GHz)")
        print(f"    Socket: {self.socket}, Harga: Rp{self.harga}, Suhu: {self.suhu_saat_ini}°C")
    
    def can_upgrade(self):
        return self.kecepatan_ghz < 5.0
    
    def upgrade(self):
        if self.can_upgrade():
            self.kecepatan_ghz += 0.2
            self.harga += self.harga * 0.1
            print(f"CPU berhasil di-upgrade menjadi {self.kecepatan_ghz} GHz")
        else:
            print("CPU tidak bisa di-upgrade lebih lanjut")
    
    def cool_down(self):
        self.suhu_saat_ini -= 5.0
        if self.suhu_saat_ini < 30.0:
            self.suhu_saat_ini = 30.0
        print(f"CPU didinginkan. Suhu sekarang: {self.suhu_saat_ini}°C")
    
    def overclock(self):
        self.kecepatan_ghz += 0.1
        self.suhu_saat_ini += 5.0
        print(f"CPU di-overclock menjadi {self.kecepatan_ghz} GHz. Suhu naik menjadi {self.suhu_saat_ini}°C")