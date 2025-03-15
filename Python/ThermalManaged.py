# thermal_managed.py
from abc import ABC, abstractmethod

class ThermalManaged(ABC):
    """Interface for components that require thermal management"""
    
    def __init__(self, suhu_maksimum=100.0, suhu_saat_ini=30.0):
        self.suhu_maksimum = suhu_maksimum
        self.suhu_saat_ini = suhu_saat_ini
    
    def get_suhu_maksimum(self):
        return self.suhu_maksimum
    
    def set_suhu_maksimum(self, suhu):
        self.suhu_maksimum = suhu
    
    def get_suhu(self):
        return self.suhu_saat_ini
    
    def set_suhu(self, suhu):
        self.suhu_saat_ini = suhu
    
    @abstractmethod
    def cool_down(self):
        pass