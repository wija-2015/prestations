package com.casaprestations.burs.attachement.repository.calcul;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casaprestations.burs.attachement.entity.db.calcul.LavageBrossage;

public interface LavageBrossageRepository extends JpaRepository<LavageBrossage, Integer> {

	// Averda (A32) : Résultat du prestation Lavage/Brossage
	//@Query("select bross from LavageBrossage bross where nomVehicule LIKE 'A32%' order by dateJour")
	//List<LavageBrossage> findBrossagesByAverda();

	// Sita (S32, S36) : Résultat du prestation Lavage/Brossage
	//@Query("select bross from LavageBrossage bross where (nomVehicule LIKE 'S32%' or nomVehicule LIKE 'S36%') order by dateJour")
	//List<LavageBrossage> findBrossagesBySita();
}
