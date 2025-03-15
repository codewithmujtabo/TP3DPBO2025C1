# motherboard.py
from Komponen import Komponen

class Motherboard(Komponen):
    """Motherboard class"""
    
    def __init__(self, chipset="", form_factor="", socket_type="", merk="", nama="", harga=0, tipe_komponen="Motherboard"):
        super().__init__(merk, nama, harga, tipe_komponen)
        self.chipset = chipset
        self.form_factor = form_factor
        self.socket_type = socket_type
    
    def get_chipset(self):
        return self.chipset
    
    def set_chipset(self, chipset):
        self.chipset = chipset
    
    def get_form_factor(self):
        return self.form_factor
    
    def set_form_factor(self, form_factor):
        self.form_factor = form_factor
    
    def get_socket_type(self):
        return self.socket_type
    
    def set_socket_type(self, socket_type):
        self.socket_type = socket_type
    
    def tampilkan_info(self):
        print(f"Motherboard: {self.merk} {self.nama} ({self.chipset}, {self.form_factor})")
        print(f"    Socket: {self.socket_type}, Harga: Rp{self.harga}")