# monitor.py
from Peripheral import Peripheral

class Monitor(Peripheral):
    """Monitor peripheral class"""
    
    def __init__(self, ukuran_inch=0.0, refresh_rate=0, resolution="", merk="", nama="", harga=0,
                 tipe_peripheral="Monitor", koneksi="HDMI"):
        super().__init__(merk, nama, harga, tipe_peripheral, koneksi)
        self.ukuran_inch = ukuran_inch
        self.refresh_rate = refresh_rate
        self.resolution = resolution
    
    def get_ukuran_inch(self):
        return self.ukuran_inch
    
    def set_ukuran_inch(self, ukuran_inch):
        self.ukuran_inch = ukuran_inch
    
    def get_refresh_rate(self):
        return self.refresh_rate
    
    def set_refresh_rate(self, refresh_rate):
        self.refresh_rate = refresh_rate
    
    def get_resolution(self):
        return self.resolution
    
    def set_resolution(self, resolution):
        self.resolution = resolution
    
    def tampilkan_info(self):
        print(f"{self.tipe_peripheral}: {self.merk} {self.nama} ({self.ukuran_inch}', {self.resolution}, {self.refresh_rate} Hz)")
        print(f"    Koneksi: {self.koneksi}, Harga: Rp{self.harga}")