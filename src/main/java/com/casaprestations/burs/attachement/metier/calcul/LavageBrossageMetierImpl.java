package com.casaprestations.burs.attachement.metier.calcul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casaprestations.burs.attachement.entity.db.calcul.LavageBrossage;
import com.casaprestations.burs.attachement.repository.calcul.BalayageRepository;
import com.casaprestations.burs.attachement.repository.calcul.LavageBrossageRepository;

@Service
public class LavageBrossageMetierImpl implements ILavageBrossageMetier{

	@Autowired
	private LavageBrossageRepository lavageBrossageRepository;

	@Override
	public List<LavageBrossage> findAll() {
		// TODO Auto-generated method stub
		return lavageBrossageRepository.findAll();
	}

}
