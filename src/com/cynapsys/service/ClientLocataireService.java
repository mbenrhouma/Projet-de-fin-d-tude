package com.cynapsys.service;



import java.util.List;

import com.cynapsys.entities.ClientLocataire;

public interface ClientLocataireService extends AbstractService<ClientLocataire>{
	ClientLocataire	findById(String id);
	 List<ClientLocataire> findDTA() ;
}
