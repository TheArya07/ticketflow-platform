package com.ticketflow.ticket_service.repository;

import com.ticketflow.ticket_service.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}