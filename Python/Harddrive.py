# harddrive.py
from Komponen import Komponen

class Harddrive(Komponen):
    """Hard Drive class"""
    
    def __init__(self, kapasitas_gb=0, tipe_drive="", merk="", nama="", harga=0, 
                 read_speed=500, write_speed=450, tipe_komponen="Storage"):
        super().__init__(merk, nama, harga, tipe_komponen)
        self.kapasitas_gb = kapasitas_gb
        self.tipe_drive = tipe_drive
        self.read_speed = read_speed
        self.write_speed = write_speed
    
    def get_kapasitas_gb(self):
        return self.kapasitas_gb
    
    def set_kapasitas_gb(self, kapasitas_gb):
        self.kapasitas_gb = kapasitas_gb
    
    def get_tipe_drive(self):
        return self.tipe_drive
    
    def set_tipe_drive(self, tipe_drive):
        self.tipe_drive = tipe_drive
    
    def get_read_speed(self):
        return self.read_speed
    
    def set_read_speed(self, read_speed):
        self.read_speed = read_speed
    
    def get_write_speed(self):
        return self.write_speed
    
    def set_write_speed(self, write_speed):
        self.write_speed = write_speed
    
    def tampilkan_info(self):
        print(f"Storage: {self.merk} {self.nama} ({self.kapasitas_gb} GB, {self.tipe_drive})")
        print(f"    Read: {self.read_speed} MB/s, Write: {self.write_speed} MB/s, Harga: Rp{self.harga}")