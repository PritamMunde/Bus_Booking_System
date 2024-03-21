package com.example.busbookingsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.busbookingsystem.entity.BusDetails;
import com.example.busbookingsystem.entity.Ticket;
import com.example.busbookingsystem.exceptionhandling.ResourceNotFoundException;
import com.example.busbookingsystem.repository.BusDetailsRepository;
import com.example.busbookingsystem.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
    private BusDetailsRepository busDetailsRepository;


	@Override
	public Ticket saveTicket(Ticket ticket) {

		return ticketRepository.save(ticket);
	} 
	
	

	@Override
	public List<Ticket> getAllTickets() {

		return ticketRepository.findAll();
	}

	@Override
	public Ticket getTicketById(int ticketId) throws ResourceNotFoundException {

		return ticketRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Ticket id not found"));
	}

	@Override
	public void deleteTicketById(int ticketId) throws ResourceNotFoundException {
		if (ticketRepository.existsById(ticketId)) {
			ticketRepository.deleteById(ticketId);
		} else {
			throw new ResourceNotFoundException("Ticket Id not found: " + ticketId);

		}

	}
	 public List<Ticket> findTicketsByBusNumber(int busNumber) {
	        return ticketRepository.findByBusDetails_BusNumber(busNumber);
	    }



	 @Override
	    public int getTotalTicketsBookedForBus(int busNumber) {
	        return ticketRepository.countTicketsByBusNumber(busNumber);
	    }


	

}
