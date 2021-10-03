package com.leoncarraro.realmeetservice.service;

import com.leoncarraro.realmeetservice.domain.dto.RoomDTO;
import com.leoncarraro.realmeetservice.domain.entity.Room;
import com.leoncarraro.realmeetservice.exception.RoomNotFoundException;
import com.leoncarraro.realmeetservice.mapper.RoomMapper;
import com.leoncarraro.realmeetservice.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomDTO findById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException("ID " + id + " not found!"));
        return RoomMapper.INSTANCE.toDto(room);
    }
}
