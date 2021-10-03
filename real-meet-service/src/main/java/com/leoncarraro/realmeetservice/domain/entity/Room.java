package com.leoncarraro.realmeetservice.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import java.util.Objects;

import static java.util.Objects.isNull;

@Entity
@Table(name = "TB_ROOM")
public class Room extends AbstractEntity<Long> {
    private static final long serialVersionUID = -7878691168265284107L;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SEATS", nullable = false)
    private Integer seats;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;

    public Room() {}

    private Room(Long id, String name, Integer seats, Boolean status) {
        super(id);
        this.name = name;
        this.seats = seats;
        this.status = status;
    }

    @PrePersist
    public void prePersist() {
        if (isNull(status)) {
            status = Boolean.TRUE;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getSeats() {
        return seats;
    }

    public Boolean getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return (Objects.equals(super.getId(), room.getId()) &&
                Objects.equals(name, room.name) &&
                Objects.equals(seats, room.seats) &&
                Objects.equals(status, room.status));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, seats, status);
    }

    public static RoomBuilder builder() {
        return new RoomBuilder();
    }

    public static final class RoomBuilder {
        private Long id;
        private String name;
        private Integer seats;
        private Boolean status;

        private RoomBuilder() {}

        public RoomBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RoomBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RoomBuilder seats(Integer seats) {
            this.seats = seats;
            return this;
        }

        public RoomBuilder status(Boolean status) {
            this.status = status;
            return this;
        }

        public Room build() {
            return new Room(id, name, seats, status);
        }
    }
}
