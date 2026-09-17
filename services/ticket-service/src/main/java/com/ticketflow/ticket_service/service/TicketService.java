package com.ticketflow.ticket_service.service;

import com.ticketflow.ticket_service.entity.Ticket;
import com.ticketflow.ticket_service.exception.TicketNotFoundException;
import com.ticketflow.ticket_service.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() ->
                        new TicketNotFoundException(
                                "Ticket not found with id: " + id
                        ));
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        Ticket existingTicket = getTicketById(id);

        existingTicket.setTitle(updatedTicket.getTitle());
        existingTicket.setDescription(updatedTicket.getDescription());
        existingTicket.setStatus(updatedTicket.getStatus());
        existingTicket.setPriority(updatedTicket.getPriority());

        return ticketRepository.save(existingTicket);
    }

    public void deleteTicket(Long id) {
        Ticket ticket = getTicketById(id);
        ticketRepository.delete(ticket);
    }
}