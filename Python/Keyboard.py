# keyboard.py
from Peripheral import Peripheral

class Keyboard(Peripheral):
    """Keyboard peripheral class"""
    
    def __init__(self, layout_type="", mechanical=False, merk="", nama="", harga=0,
                 tipe_peripheral="Keyboard", koneksi="USB"):
        super().__init__(merk, nama, harga, tipe_peripheral, koneksi)
        self.layout_type = layout_type
        self.mechanical = mechanical
    
    def get_layout_type(self):
        return self.layout_type
    
    def set_layout_type(self, layout_type):
        self.layout_type = layout_type
    
    def is_mechanical(self):
        return self.mechanical
    
    def set_mechanical(self, mechanical):
        self.mechanical = mechanical
    
    def tampilkan_info(self):
        print(f"{self.tipe_peripheral}: {self.merk} {self.nama} ({self.layout_type}, {'Mechanical' if self.mechanical else 'Membrane'})")
        print(f"    Koneksi: {self.koneksi}, Harga: Rp{self.harga}")