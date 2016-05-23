package com.casaprestations.burs.attachement.ui.controllers.calcul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.casaprestations.burs.attachement.metier.calcul.BalayageBean;
import com.casaprestations.burs.attachement.metier.calcul.IBalayageMecaniseMetier;
import com.casaprestations.burs.attachement.metier.calcul.SumBean;

@RestController
@RequestMapping("/balayage")
public class BalayageMecaniseSitaController {

	@Autowired
	private IBalayageMecaniseMetier balayageMecaniseMetier;

	@RequestMapping(value = "/balayagesSita", method = RequestMethod.GET)
	public List<BalayageBean> findBalayagesOfSitaByYearAndMonth2(String dateString) {
		return balayageMecaniseMetier.findBalayagesOfSitaByYearAndMonth(dateString);
	}

	@RequestMapping(value = "/sumBalayagesSita", method = RequestMethod.GET)
	public List<SumBean> findSumOfBalayagesBySita(String dateString) {
		
		return balayageMecaniseMetier.getSumOfBalayagesBySita(dateString);
	}

	@RequestMapping(value = "/tabDaysOfMonth", method = RequestMethod.GET)
	public List<Integer> tabDaysOfMonth(String dateString) {
		System.out.println("Tab du jours : "+balayageMecaniseMetier.getTabDaysMonth(dateString));
		return balayageMecaniseMetier.getTabDaysMonth(dateString);
	}
}