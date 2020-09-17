package com.gajesh.lil;

import com.gajesh.lil.data.entity.Guest;
import com.gajesh.lil.data.entity.Reservation;
import com.gajesh.lil.data.entity.Room;
import com.gajesh.lil.data.repository.GuestRepository;
import com.gajesh.lil.data.repository.ReservationRepository;
import com.gajesh.lil.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LilApplication {

	public static void main(String[] args) {
		SpringApplication.run(LilApplication.class, args);
	}

	/*
	// Create a rest endpoint for Rooms
	@RestController
	@RequestMapping("/rooms")
	class RoomController{
		@Autowired
		private RoomRepository roomRepository;

		@GetMapping
		public Iterable<Room> getRooms(){
			return this.roomRepository.findAll();
		}

	}

	@RestController
	@RequestMapping("/guests")
	class GuestController{
		@Autowired
		private GuestRepository guestRepository;

		@GetMapping
		public Iterable<Guest> getGuests(){
			return this.guestRepository.findAll();
		}

	}
	@RestController
	@RequestMapping("/reservations")
	class ReservationController{
		@Autowired
		private ReservationRepository reservationRepository;

		@GetMapping
		public Iterable<Reservation> getReservations(){
			return this.reservationRepository.findAll();
		}

	}
	*/
}
