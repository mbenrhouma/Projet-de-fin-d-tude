package com.cynapsys.dao;

import java.util.List;

import com.cynapsys.entities.Utilisateur;

public interface UtilisateurDAO extends AbstractDAO<Utilisateur>{
	Utilisateur	findByUtilisateur(String id,String password);
	
	List<String> findValideurs(Integer codeGestion);

	Utilisateur findById(Integer identifiant);
	
	Utilisateur findByemail(String email);
	
	Utilisateur findByLogin(String login) ;
}

