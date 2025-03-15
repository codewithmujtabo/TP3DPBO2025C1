# komponen.py
from Elektronik import Elektronik

class Komponen(Elektronik):
    """First level of hierarchical inheritance - Computer components"""
    
    def __init__(self, merk="", nama="", harga=0, tipe_komponen=""):
        super().__init__(merk, nama, harga)
        self.tipe_komponen = tipe_komponen
    
    def get_tipe_komponen(self):
        return self.tipe_komponen
    
    def set_tipe_komponen(self, tipe_komponen):
        self.tipe_komponen = tipe_komponen
    
    def tampilkan_info(self):
        print(f"{self.tipe_komponen}: {self.merk} {self.nama}, Harga: Rp{self.harga}")