#pragma once

// Interface for components that can be upgraded
class Upgradeable {
public:
    virtual bool canUpgrade() = 0;
    virtual void upgrade() = 0;
    virtual ~Upgradeable() {}
};