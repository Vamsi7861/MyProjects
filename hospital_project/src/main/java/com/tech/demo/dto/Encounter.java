package com.tech.demo.dto;

import java.time.LocalDate;

import java.util.List;



import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Encounter {
	@OneToMany(mappedBy = "encounter")
	private List<MedOrder> orders;

	public List<MedOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<MedOrder> orders) {
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateOfAdmit() {
		return dateOfAdmit;
	}

	public void setDateOfAdmit(LocalDate dateOfAdmit) {
		this.dateOfAdmit = dateOfAdmit;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@JsonIgnore
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@JsonIgnore
	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@CreationTimestamp
	private LocalDate dateOfAdmit;
	private String reason;
	@ManyToOne
	@JoinColumn
	private Person person;
	@ManyToOne
	@JoinColumn
	private Branch branch;
}
