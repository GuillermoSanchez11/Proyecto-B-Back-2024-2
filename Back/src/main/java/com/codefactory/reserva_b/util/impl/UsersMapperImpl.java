package com.codefactory.reserva_b.util.impl;

import com.codefactory.reserva_b.dto.impl.UsersResponseDTOImpl;
import com.codefactory.reserva_b.entity.interfaces.IUsersEntity;
import com.codefactory.reserva_b.util.interfaces.IUsersMapper;
import org.springframework.stereotype.Component;

@Component
public class UsersMapperImpl implements IUsersMapper {
    @Override
    public UsersResponseDTOImpl mapUsersEntityToUsersResponseDTO(IUsersEntity usersEntity) {
        if (usersEntity == null) {
            return null;
        }
        Long idUser = usersEntity.getIdUser().longValue();
        String firstName = usersEntity.getFirstName();
        String lastName = usersEntity.getLastName();
        String phoneNumber = usersEntity.getPhoneNumber();
        String email = usersEntity.getEmail();
        String nationality = usersEntity.getNationality();
        String documentId = usersEntity.getDocumentId();
        String passportNumber = usersEntity.getPassportNumber();
        String dateOfBirth = usersEntity.getDateOfBirth().toString();
        String registrationDate = usersEntity.getRegistrationDate().toString();
        Integer flyerNumber = usersEntity.getFlyerNumber().intValue();
        String address = usersEntity.getAddress();
        String userType = usersEntity.getUserType();
        return new UsersResponseDTOImpl(
                idUser,
                firstName,
                lastName,
                phoneNumber,
                email,
                nationality,
                documentId,
                passportNumber,
                dateOfBirth,
                registrationDate,
                flyerNumber,
                address,
                userType
        );
    }

}
