package com.leoncarraro.realmeetservice.controller;

import com.leoncarraro.realmeetservice.domain.dto.RoomDTO;
import com.leoncarraro.realmeetservice.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;
    private final Executor executor;

    public RoomController(RoomService roomService, Executor executor) {
        this.roomService = roomService;
        this.executor = executor;
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<RoomDTO>> findById(@PathVariable Long id) {
        return CompletableFuture
                .supplyAsync(() -> roomService.findById(id), executor)
                .thenApply(ResponseEntity::ok);
    }
}
