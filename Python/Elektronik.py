from abc import ABC, abstractmethod

class Elektronik(ABC):
    """Base class for all electronic components"""
    
    def __init__(self, merk="", nama="", harga=0):
        self.merk = merk
        self.nama = nama
        self.harga = harga
    
    def set_merk(self, merk):
        self.merk = merk
    
    def set_nama(self, nama):
        self.nama = nama
    
    def set_harga(self, harga):
        self.harga = harga
    
    def get_merk(self):
        return self.merk
    
    def get_nama(self):
        return self.nama
    
    def get_harga(self):
        return self.harga
    
    def tampilkan_info(self):
        print(f"Elektronik: {self.merk} {self.nama}, Harga: Rp{self.harga}")


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


class Upgradeable(ABC):
    """Interface for components that can be upgraded"""
    
    @abstractmethod
    def can_upgrade(self):
        pass
    
    @abstractmethod
    def upgrade(self):
        pass


class ThermalManaged(ABC):
    """Interface for components that require thermal management"""
    
    def __init__(self, suhu_maksimum=100.0, suhu_saat_ini=30.0):
        self.suhu_maksimum = suhu_maksimum
        self.suhu_saat_ini = suhu_saat_ini
    
    @abstractmethod
    def cool_down(self):
        pass
    
    def get_suhu(self):
        return self.suhu_saat_ini