package com.codefactory.reserva_b.util.impl;

import com.codefactory.reserva_b.dto.impl.PilotResponseDTOImpl;
import com.codefactory.reserva_b.dto.interfaces.IPilotResponseDTO;
import com.codefactory.reserva_b.entity.interfaces.IPilotEntity;
import com.codefactory.reserva_b.util.interfaces.IPilotMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PilotMapperImpl implements IPilotMapper {
    @Override
    public PilotResponseDTOImpl mapPilotEntityToPilotResponseDTO(IPilotEntity pilotEntity) {
        if (pilotEntity == null) {
            return null;
        }

        Long idPilot = pilotEntity.getIdPilot().longValue();
        String firstName = pilotEntity.getFirstName();
        String lastName = pilotEntity.getLastName();
        String licenseNumber = pilotEntity.getLicenseNumber();
        LocalDate dateOfBirth = pilotEntity.getDateOfBirth();
        String nationality = pilotEntity.getNationality();
        String rank = pilotEntity.getRank();
        Float hoursFlown = pilotEntity.getHoursFlown() != null ? pilotEntity.getHoursFlown().floatValue() : null;
        LocalDate employeeDate = pilotEntity.getEmployeeDate();
        String status = pilotEntity.getStatus();
        String homeBase = pilotEntity.getHomeBase();
        LocalDate lastMedicalCheck = pilotEntity.getLastMedicalCheck();

        return new PilotResponseDTOImpl(
                idPilot,
                firstName,
                lastName,
                licenseNumber,
                dateOfBirth,
                nationality,
                rank,
                hoursFlown,
                employeeDate,
                status,
                homeBase,
                lastMedicalCheck
        );
    }
}
