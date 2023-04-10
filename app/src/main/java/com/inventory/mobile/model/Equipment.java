package com.inventory.mobile.model;

public class Equipment {
    private Long equipmentId;
    private String modelName;
    private EquipmentType equipmentType;
    private String manufacturer;

    public String getModelName() {
        return modelName;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
