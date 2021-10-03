package com.leoncarraro.realmeetservice.mapper;

import com.leoncarraro.realmeetservice.domain.dto.RoomDTO;
import com.leoncarraro.realmeetservice.domain.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class RoomMapper {

    public static final RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    public abstract RoomDTO toDto(Room room);
}
