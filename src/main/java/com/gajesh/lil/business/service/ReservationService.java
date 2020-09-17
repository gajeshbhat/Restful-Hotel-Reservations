package com.gajesh.lil.business.service;

import com.gajesh.lil.business.domain.RoomReservation;
import com.gajesh.lil.data.entity.Guest;
import com.gajesh.lil.data.entity.Reservation;
import com.gajesh.lil.data.entity.Room;
import com.gajesh.lil.data.repository.GuestRepository;
import com.gajesh.lil.data.repository.ReservationRepository;
import com.gajesh.lil.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationForDate(Date date){
        Iterable<Room> rooms = this.roomRepository.findAll();
        HashMap<Long,RoomReservation> roomReservationHashMap = new HashMap<>();
        rooms.forEach(room -> {
          RoomReservation roomReservation=new RoomReservation();
          roomReservation.setRoomId(room.getRoomId());
          roomReservation.setRoomName(room.getRoomName());
          roomReservation.setRoomNumber(room.getRoomNum());

          // Add to Map
            roomReservationHashMap.put(room.getRoomId(),roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.findReservationsByResDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationHashMap.get(reservation.getRoomID());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestID()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName((guest.getLastName()));
            roomReservation.setGuestId(guest.getGuestID());
        });
        List<RoomReservation> roomReservationsList = new ArrayList<>();
        for (Long key: roomReservationHashMap.keySet()) {
            roomReservationsList.add(roomReservationHashMap.get(key));
        }
        return roomReservationsList;
    }
    public List<Guest> getHotelGuests(){
        Iterable<Guest> guests = this.guestRepository.findAll();
        List<Guest> guestList = new ArrayList<>();
        guests.forEach(guest->{guestList.add(guest);});
        guestList.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                if (o1.getLastName() == o2.getLastName()){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        return guestList;
    }
}
