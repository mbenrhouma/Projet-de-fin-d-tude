package com.cynapsys.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.cynapsys.entities.Assurance;

public interface AssuranceDAO  extends AbstractDAO<Assurance>{
	Assurance findById(String id);

	List<Assurance> findAllDta();
	List<Assurance> findAssuranceByCodeClient(Assurance assurance);

	Assurance findAssuranceByCodeConjoint(Assurance assurance);

	Assurance findAssuranceInCodeClient(BigDecimal id);

	Assurance findAssuranceInCodeConjoint(BigInteger id);

	List<Assurance> findAllAssureur();

	List<Assurance> findAssuranceByClient(String id);
}
