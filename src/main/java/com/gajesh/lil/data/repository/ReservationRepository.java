package com.gajesh.lil.data.repository;

import com.gajesh.lil.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    Iterable<Reservation> findReservationsByResDate(Date date);
}
