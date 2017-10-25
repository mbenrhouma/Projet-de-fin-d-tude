package com.cynapsys.service;



import java.util.Date;
import java.util.List;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.DetailMensualite;
import com.cynapsys.entities.Mensualite;
import com.cynapsys.pojo.CalculInteretDeRetardPojo;

public interface DetailMensualiteService extends AbstractService<DetailMensualite>{
	DetailMensualite	findById(Integer id);
	List<DetailMensualite> findbyMensualite(Mensualite mens);
	List<DetailMensualite>findbymensDateAu(Mensualite mens,Date date);
	List<DetailMensualite> findbymensDateDe(Mensualite mens, Date date);
	List<CalculInteretDeRetardPojo> findMensualiteByClient(ClientAcquereur client);
	List<DetailMensualite> findAllMensualiteByClient(ClientAcquereur client);

}
