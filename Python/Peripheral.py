# peripheral.py
from Elektronik import Elektronik

class Peripheral(Elektronik):
    """Second branch of hierarchical inheritance - Peripherals"""
    
    def __init__(self, merk="", nama="", harga=0, tipe_peripheral="", koneksi=""):
        super().__init__(merk, nama, harga)
        self.tipe_peripheral = tipe_peripheral
        self.koneksi = koneksi
    
    def get_tipe_peripheral(self):
        return self.tipe_peripheral
    
    def set_tipe_peripheral(self, tipe_peripheral):
        self.tipe_peripheral = tipe_peripheral
    
    def get_koneksi(self):
        return self.koneksi
    
    def set_koneksi(self, koneksi):
        self.koneksi = koneksi
    
    def tampilkan_info(self):
        print(f"{self.tipe_peripheral}: {self.merk} {self.nama} (Koneksi: {self.koneksi})")
        print(f"    Harga: Rp{self.harga}")