package com.inventory.mobile.model;

import java.util.UUID;

public class EquipmentUnit {
    private Long equipmentUnitId;
    private String inventoryNumber;
    private Equipment equipment;
    private Location location;
    private boolean onState;
    private UUID guidCode;

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isOnState() {
        return onState;
    }

    public UUID getGuidCode() {
        return guidCode;
    }
}

