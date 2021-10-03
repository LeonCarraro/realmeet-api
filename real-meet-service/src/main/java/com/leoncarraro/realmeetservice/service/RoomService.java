package com.leoncarraro.realmeetservice.service;

import com.leoncarraro.realmeetservice.domain.entity.Room;
import com.leoncarraro.realmeetservice.exception.RoomNotFoundException;
import com.leoncarraro.realmeetservice.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room findById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException("ID " + id + " not found!"));
    }
}
