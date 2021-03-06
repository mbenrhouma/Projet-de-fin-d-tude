package com.cynapsys.schedule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

import com.cynapsys.entities.ClientLocataire;
import com.cynapsys.service.ClientLocataireService;
import com.cynapsys.utils.Constants;

public class Jobs implements ServletContextAware {

	private ServletContext servletContext;

	@ManagedProperty(value = "#{clientLocataireService}")
	private ClientLocataireService clientLocataireService;

	private List<ClientLocataire> listClientLocataire;

	// methode qui augmente le prix de location suivant le taux d'augmentation

	public void clientLocataire() {
		Date sysDate = new Date();
		listClientLocataire = new ArrayList<ClientLocataire>();
		listClientLocataire = clientLocataireService.findDTA();
		for (ClientLocataire client : listClientLocataire) {
			if ((client.getDateFin().equals(sysDate)) || (client.getDateFin().after(sysDate))) {
				if (client.getTauxAugmetation() != null && client.getTauxAugmetation() != 0) {
					
					//  commentaire a voir
//					Double augmentation;
//					augmentation = (client.getLoyerMensuel() * client.getTauxAugmetation()) / Constants.centpourCent;
//					client.setLoyerMensuel(client.getLoyerMensuel() + augmentation);
//					client.setLoyerAnnuel(client.getLoyerMensuel() * Constants.nbreMoins);
//					augmentation=null;
					Double augmentation;
					augmentation = (double) ((client.getLoyerAnnuel() * client.getTauxAugmetation()) / Constants.centpourCent);
					client.setLoyerMensuel(client.getLoyerMensuel() + augmentation.intValue());
					client.setLoyerAnnuel(client.getLoyerMensuel() * Constants.nbreMoins);
					augmentation=null;
				}
				
				// il manque de garder l'historique

				// modification du date debut date fin renouvellement
				// automatique
				Calendar c = Calendar.getInstance();
				Calendar c2 = Calendar.getInstance();
				client.setDateDebut(sysDate);
				client.setDateDebut(new Date(client.getDateDebut().getYear(), client.getDateDebut().getMonth(), 1));
				c.setTime(client.getDateDebut());
				c.add(Calendar.YEAR, client.getDuree());
				c.add(Calendar.MONTH, 1);
				c.add(Calendar.DAY_OF_MONTH, -1);

				client.setDateFin(c.getTime());
				clientLocataireService.update(client);
			}

		}
	}

	public ClientLocataireService getClientLocataireService() {
		return clientLocataireService;
	}

	public void setClientLocataireService(ClientLocataireService clientLocataireService) {
		this.clientLocataireService = clientLocataireService;
	}

	public List<ClientLocataire> getListClientLocataire() {
		return listClientLocataire;
	}

	public void setListClientLocataire(List<ClientLocataire> listClientLocataire) {
		this.listClientLocataire = listClientLocataire;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

	public ServletContext getServletContext() {
		return servletContext;
	}

}
