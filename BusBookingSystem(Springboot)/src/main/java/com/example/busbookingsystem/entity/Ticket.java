package com.example.busbookingsystem.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "Ticket_Info", sequenceName = "seq3", initialValue = 300)
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Ticket_Info")
	private int ticketId;
	 
	private String passName;
	
	private int passCount;



	private double ticketPrice;
	
	private String source;
	
	private String destination;
	
	private LocalDate journeyDate;

	private LocalTime journeyTime;
	
	 @ManyToOne
		@JoinColumn(name = "busNumber", referencedColumnName = "busNumber")
	    private BusDetails busDetails;
	 
	 private String passengerEmail;

	public Ticket() {
		super();
	}

	public Ticket(int ticketId, String passName, int passCount, double ticketPrice, String source, String destination,
			LocalDate journeyDate, LocalTime journeyTime, BusDetails busDetails, String passengerEmail) {
		super();
		this.ticketId = ticketId;
		this.passName = passName;
		this.passCount = passCount;
		this.ticketPrice = ticketPrice;
		this.source = source;
		this.destination = destination;
		this.journeyDate = journeyDate;
		this.journeyTime = journeyTime;
		this.busDetails = busDetails;
		this.passengerEmail = passengerEmail;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassName() {
		return passName;
	}

	public void setPassName(String passName) {
		this.passName = passName;
	}

	public int getPassCount() {
		return passCount;
	}

	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public LocalTime getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime(LocalTime journeyTime) {
		this.journeyTime = journeyTime;
	}

	public BusDetails getBusDetails() {
		return busDetails;
	}

	public void setBusDetails(BusDetails busDetails) {
		this.busDetails = busDetails;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passName=" + passName + ", passCount=" + passCount + ", ticketPrice="
				+ ticketPrice + ", source=" + source + ", destination=" + destination + ", journeyDate=" + journeyDate
				+ ", journeyTime=" + journeyTime + ", busDetails=" + busDetails + ", passengerEmail=" + passengerEmail
				+ "]";
	}

	

	}