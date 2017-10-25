package com.cynapsys.dao;

import com.cynapsys.entities.AnneeBudgetaire;

public interface AnneeBudgetaireDAO extends AbstractDAO<AnneeBudgetaire>{
	
	AnneeBudgetaire findById(String id);
}
