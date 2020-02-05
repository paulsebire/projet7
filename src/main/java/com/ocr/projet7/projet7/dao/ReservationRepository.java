package com.ocr.projet7.projet7.dao;


import com.ocr.projet7.projet7.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    List<Reservation> findReservationByUtilisateurIdUserOrderByDateEmpruntAsc(Long idUser);

}
