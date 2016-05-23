package com.casaprestations.burs.attachement.ui.controllers.calcul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.casaprestations.burs.attachement.entity.db.calcul.LavageBrossage;
import com.casaprestations.burs.attachement.metier.calcul.ILavageBrossageMetier;

@RestController
@RequestMapping("/lavageBrossage")
public class LavageBrossageController {
	

	@Autowired
	private ILavageBrossageMetier lavageBrossageMetier;
	
	@RequestMapping(value = "/attachements", method = RequestMethod.GET)
	public List<LavageBrossage> findAll() {
		return lavageBrossageMetier.findAll();
	}
	
	
}
