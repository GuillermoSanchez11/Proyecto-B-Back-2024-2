package com.codefactory.reserva_b.util.impl;

import com.codefactory.reserva_b.dto.impl.PlaneResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.IPlaneResponseDTO;
import com.codefactory.reserva_b.entity.interfaces.IPlaneEntity;
import com.codefactory.reserva_b.util.interfaces.IPlaneMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PlaneMapperImpl implements IPlaneMapper {
    @Override
    public PlaneResponseDTOImpl mapPlaneEntityToPlaneResponseDTO(IPlaneEntity planeEntity) {
        if (planeEntity == null) {
            return null;
        }
        Long idPlane = planeEntity.getIdPlane().longValue();
        String model = planeEntity.getModel();
        String manufacturer = planeEntity.getManufacturer();
        Integer capacityEconomy = planeEntity.getCapacityEconomy() != null ? planeEntity.getCapacityEconomy().intValue() : null;
        Integer capacityBusiness = planeEntity.getCapacityBusiness() != null ? planeEntity.getCapacityBusiness().intValue() : null;
        Integer capacityFirstClass = planeEntity.getCapacityFirstClass() != null ? planeEntity.getCapacityFirstClass().intValue() : null;
        LocalDate dateManufactured = planeEntity.getDateManufactured();
        LocalDate lastMaintenanceDate = planeEntity.getLastMaintenanceDate();
        String registrationNumber = planeEntity.getRegistrationNumber();
        Float fuelCapacity = planeEntity.getFuelCapacity() != null ? planeEntity.getFuelCapacity().floatValue() : null;

        return new PlaneResponseDTOImpl(
                idPlane,
                model,
                manufacturer,
                capacityEconomy,
                capacityBusiness,
                capacityFirstClass,
                dateManufactured,
                lastMaintenanceDate,
                registrationNumber,
                fuelCapacity
        );
    }
}
