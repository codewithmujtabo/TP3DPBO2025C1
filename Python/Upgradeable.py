# upgradeable.py
from abc import ABC, abstractmethod

class Upgradeable(ABC):
    """Interface for components that can be upgraded"""
    
    @abstractmethod
    def can_upgrade(self):
        pass
    
    @abstractmethod
    def upgrade(self):
        pass