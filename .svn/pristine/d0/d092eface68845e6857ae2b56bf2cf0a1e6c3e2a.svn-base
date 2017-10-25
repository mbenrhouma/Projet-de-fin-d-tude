package com.cynapsys.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.cynapsys.entities.Assurance;

public interface AssuranceService extends AbstractService<Assurance> {
	Assurance findById(String id);

	List<Assurance> findAssuranceByCodeClient(Assurance assurance);

	List<Assurance> findAllDta();
	List<Assurance> findAllAssureur();
	List<Assurance> findAssuranceByClient(String id);


	Assurance findAssuranceByCodeConjoint(Assurance assurance);

	Assurance findAssuranceInCodeClient(BigDecimal id);

	Assurance findAssuranceInCodeConjoint(BigInteger id);

}
