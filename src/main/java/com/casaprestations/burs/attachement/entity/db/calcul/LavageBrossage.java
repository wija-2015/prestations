package com.casaprestations.burs.attachement.entity.db.calcul;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LavageBrossage implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomVehicule;
	private Date dateJour;
	private Double duree;
	private Integer idPlace;
	
	public LavageBrossage() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateJour() {
		return dateJour;
	}

	public void setDateJour(Date dateJour) {
		this.dateJour = dateJour;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	public Integer getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(Integer idPlace) {
		this.idPlace = idPlace;
	}

	public void setDuree(Double duree) {
		this.duree = duree;
	}

	public String getNomVehicule() {
		return nomVehicule;
	}

	public void setNomVehicule(String nomVehicule) {
		this.nomVehicule = nomVehicule;
	}
}
