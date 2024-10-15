package com.codefactory.reserva_b.util.interfaces;

import com.codefactory.reserva_b.dto.impl.UsersResponseDTOImpl;
import com.codefactory.reserva_b.entity.interfaces.IUsersEntity;

public interface IUsersMapper {
    UsersResponseDTOImpl mapUsersEntityToUsersResponseDTO(IUsersEntity usersEntity);
}
