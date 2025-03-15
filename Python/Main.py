# main.py
from Komputer import Komputer
from Cpu import Cpu
from Gpu import Gpu
from Ram import Ram
from Harddrive import Harddrive
from PowerSupply import PowerSupply
from Motherboard import Motherboard
from Keyboard import Keyboard
from Monitor import Monitor


def main():
    print("=== SISTEM KOMPUTER DENGAN OOP ===")
    print("Demonstrasi Hierarchical, Multiple, & Hybrid Inheritance\n")
    
    # Membuat komponen CPU dengan multiple inheritance (Komponen, Upgradeable, ThermalManaged)
    cpu = Cpu(8, 3.6, "LGA1700", "Intel", "Core i7-12700K", 4500000)
    cpu.overclock()  # Demonstrasi method dari ThermalManaged
    
    # Membuat GPU dengan multiple inheritance (Komponen, Upgradeable, ThermalManaged)
    gpu = Gpu(12, "RTX 4070", "NVIDIA", "GeForce", 8000000, 220)
    
    # Membuat RAM dengan multiple inheritance (Komponen, Upgradeable)
    ram_list = [
        Ram(16, "DDR5", "Corsair", "Vengeance", 1200000, 5200),
        Ram(16, "DDR5", "Kingston", "Fury Beast", 1150000, 5000)
    ]
    
    # Membuat storage devices dengan hierarchical inheritance (Elektronik -> Komponen -> Harddrive)
    storage_list = [
        Harddrive(1000, "SSD NVMe", "Samsung", "980 Pro", 1800000, 7000, 5000),
        Harddrive(2000, "HDD", "Seagate", "Barracuda", 800000, 190, 180)
    ]
    
    # Membuat motherboard dan power supply dengan hierarchical inheritance
    mobo = Motherboard("Z690", "ATX", "LGA1700", "ASUS", "ROG Maximus", 5500000)
    psu = PowerSupply(850, "80+ Gold", "Corsair", "RM850x", 1900000)
    
    # Komputer dengan komposisi (composition) berbagai komponen
    gaming_pc = Komputer("Gaming PC Deluxe", cpu, ram_list, storage_list, gpu, psu, mobo)
    
    # Menambahkan peripheral (hierarchical inheritance: Elektronik -> Peripheral -> Keyboard/Monitor)
    keyboard = Keyboard("US QWERTY", True, "Logitech", "G Pro X", 1500000)
    monitor = Monitor(27.0, 165, "2560x1440", "LG", "UltraGear", 4500000)
    
    gaming_pc.add_peripheral(keyboard)
    gaming_pc.add_peripheral(monitor)
    
    # Menampilkan spesifikasi komputer
    gaming_pc.tampilkan_info()
    
    # Memeriksa kompatibilitas komponen
    gaming_pc.check_compatibility()
    
    # Menampilkan harga total sebelum upgrade
    print(f"\nTotal harga sebelum upgrade: Rp{gaming_pc.get_total_harga()}")
    
    # Upgrade komponen yang mendukung interface Upgradeable
    gaming_pc.upgrade_komponen()
    
    # Menampilkan harga setelah upgrade
    print(f"Total harga setelah upgrade: Rp{gaming_pc.get_total_harga()}")
    
    # Tampilkan informasi akhir
    gaming_pc.tampilkan_info()


if __name__ == "__main__":
    main()