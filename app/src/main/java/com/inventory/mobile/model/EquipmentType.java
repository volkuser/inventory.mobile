package com.inventory.mobile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentType {
    private Long equipmentTypeId;
    private String equipmentTypeName;
}