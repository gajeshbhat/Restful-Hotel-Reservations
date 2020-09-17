package com.gajesh.lil.web;

import com.gajesh.lil.business.domain.RoomReservation;
import com.gajesh.lil.business.service.ReservationService;
import com.gajesh.lil.data.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationWebController {

    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservations(@RequestParam(value ="date",required = false)String dateStr, Model model){
        Date date = DateUtils.getDateFromDateString(dateStr);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationForDate(date);
        model.addAttribute("roomReservations",roomReservations);
        return "reservations";
    }
}
