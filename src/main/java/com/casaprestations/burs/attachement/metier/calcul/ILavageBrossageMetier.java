package com.casaprestations.burs.attachement.metier.calcul;

import java.util.List;

import com.casaprestations.burs.attachement.entity.db.calcul.LavageBalayage;
import com.casaprestations.burs.attachement.entity.db.calcul.LavageBrossage;

public interface ILavageBrossageMetier {

	public List<LavageBrossage> findAll();

}
