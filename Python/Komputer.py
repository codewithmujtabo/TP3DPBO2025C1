# komputer.py
from Cpu import Cpu
from Gpu import Gpu
from Ram import Ram
from Harddrive import Harddrive
from PowerSupply import PowerSupply
from Motherboard import Motherboard
from Peripheral import Peripheral

class Komputer:
    """Computer class demonstrating composition of multiple component types"""
    
    def __init__(self, nama="", cpu=None, ram_list=None, storage_list=None, 
                 gpu=None, power_supply=None, motherboard=None):
        self.nama = nama
        self.cpu = cpu if cpu else Cpu()
        self.ram_list = ram_list if ram_list else []
        self.storage_list = storage_list if storage_list else []
        self.gpu = gpu if gpu else Gpu()
        self.power_supply = power_supply if power_supply else PowerSupply()
        self.motherboard = motherboard if motherboard else Motherboard()
        self.peripheral_list = []
        self.total_harga = 0
        self.hitung_total_harga()
    
    def get_nama(self):
        return self.nama
    
    def set_nama(self, nama):
        self.nama = nama
    
    def get_cpu(self):
        return self.cpu
    
    def set_cpu(self, cpu):
        self.cpu = cpu
        self.hitung_total_harga()
    
    def get_gpu(self):
        return self.gpu
    
    def set_gpu(self, gpu):
        self.gpu = gpu
        self.hitung_total_harga()
    
    def get_ram_list(self):
        return self.ram_list
    
    def set_ram_list(self, ram_list):
        self.ram_list = ram_list
        self.hitung_total_harga()
    
    def get_storage_list(self):
        return self.storage_list
    
    def set_storage_list(self, storage_list):
        self.storage_list = storage_list
        self.hitung_total_harga()
    
    def get_power_supply(self):
        return self.power_supply
    
    def set_power_supply(self, power_supply):
        self.power_supply = power_supply
        self.hitung_total_harga()
    
    def get_motherboard(self):
        return self.motherboard
    
    def set_motherboard(self, motherboard):
        self.motherboard = motherboard
        self.hitung_total_harga()
    
    def get_peripheral_list(self):
        return self.peripheral_list
    
    def get_total_harga(self):
        return self.total_harga
    
    def add_ram(self, ram):
        self.ram_list.append(ram)
        self.hitung_total_harga()
    
    def add_storage(self, storage):
        self.storage_list.append(storage)
        self.hitung_total_harga()
    
    def add_peripheral(self, peripheral):
        self.peripheral_list.append(peripheral)
        self.hitung_total_harga()
    
    def hitung_total_harga(self):
        self.total_harga = self.cpu.get_harga() + self.gpu.get_harga() + \
                          self.power_supply.get_harga() + self.motherboard.get_harga()
        
        for ram in self.ram_list:
            self.total_harga += ram.get_harga()
        
        for storage in self.storage_list:
            self.total_harga += storage.get_harga()
        
        for peripheral in self.peripheral_list:
            self.total_harga += peripheral.get_harga()
    
    def check_compatibility(self):
        compatible = True
        issues = ""
        
        # Check CPU and motherboard socket compatibility
        if self.cpu.get_socket() != self.motherboard.get_socket_type():
            compatible = False
            issues += f"- CPU socket ({self.cpu.get_socket()}) tidak kompatibel dengan motherboard socket ({self.motherboard.get_socket_type()})\n"
        
        # Check power supply wattage vs GPU requirements
        if self.power_supply.get_wattage() < self.gpu.get_power_consumption() + 200:
            compatible = False
            issues += f"- Power supply wattage ({self.power_supply.get_wattage()}W) mungkin tidak cukup untuk GPU ({self.gpu.get_power_consumption()}W)\n"
        
        if compatible:
            print("Semua komponen kompatibel!")
        else:
            print(f"Ditemukan masalah kompatibilitas:\n{issues}")
    
    def upgrade_komponen(self):
        print("\n===== UPGRADE KOMPONEN =====")
        
        # Upgrade CPU if possible
        if self.cpu.can_upgrade():
            self.cpu.upgrade()
        else:
            print("CPU tidak dapat di-upgrade")
        
        # Upgrade GPU if possible
        if self.gpu.can_upgrade():
            self.gpu.upgrade()
        else:
            print("GPU tidak dapat di-upgrade")
        
        # Upgrade all RAM modules if possible
        for ram in self.ram_list:
            if ram.can_upgrade():
                ram.upgrade()
        
        # Recalculate total price after upgrades
        self.hitung_total_harga()
    
    def tampilkan_info(self):
        print(f"\n========== {self.nama} ==========")
        print("SPESIFIKASI KOMPUTER:")
        
        # Show components
        self.cpu.tampilkan_info()
        self.gpu.tampilkan_info()
        self.motherboard.tampilkan_info()
        self.power_supply.tampilkan_info()
        
        print("\nRAM Modules:")
        for i, ram in enumerate(self.ram_list, 1):
            print(f"[{i}] ", end="")
            ram.tampilkan_info()
        
        print("\nStorage Devices:")
        for i, storage in enumerate(self.storage_list, 1):
            print(f"[{i}] ", end="")
            storage.tampilkan_info()
        
        if self.peripheral_list:
            print("\nPeripherals:")
            for i, peripheral in enumerate(self.peripheral_list, 1):
                print(f"[{i}] ", end="")
                peripheral.tampilkan_info()
        
        print(f"\nTotal Harga: Rp{self.total_harga}")
        print("=============================")