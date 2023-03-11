package de.hsos.shipping.utils.dto;

import de.hsos.shipping.entity.Ship;

public class ShipDTO {
    public Integer id;
    public String name;
    public boolean hasOrder;

    public ShipDTO(Integer id, String name, boolean hasOrder) {
        this.id = id;
        this.name = name;
        this.hasOrder = hasOrder;
    }

    public static ShipDTO toDTO(Ship ship) {
        return new ShipDTO(ship.getId(), ship.getName(), ship.isHasOrder());
    }
}
