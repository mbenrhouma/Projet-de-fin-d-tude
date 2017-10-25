package com.cynapsys.Views.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.cynapsys.Views.ClientAcquereurBean;
import com.cynapsys.Views.ClientLocataireBean;
import com.cynapsys.Views.DecompteBean;
import com.cynapsys.Views.NoteDebitBean;
import com.cynapsys.Views.RechercheDesClientsAcquereursBean;
import com.cynapsys.Views.ReclamationBean;
import com.cynapsys.Views.TableauAmortissementBean;
import com.cynapsys.Views.Converter.ClientAcquereurConverterBean;


@ManagedBean(name = "menuController")
@SessionScoped
public class MenuController implements Serializable {
	
	ReclamationBean reclamationBean = (ReclamationBean) FacesContext
            .getCurrentInstance()
            .getApplication()
            .evaluateExpressionGet(FacesContext.getCurrentInstance(),
                         "#{reclamationBean}",
                         ReclamationBean.class);
	@SuppressWarnings("unused")
	private String headerValue = "Acceuil";
	private static final long serialVersionUID = -542260296902930917L;
	FacesContext context = FacesContext.getCurrentInstance();
	ExternalContext extContext = context.getExternalContext();
	HttpSession session = (HttpSession) context.getExternalContext()
			.getSession(false);

	// accueil  
	public String goToPageAccueil() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url = extContext.encodeActionURL(context.getApplication()
				.getViewHandler()
				.getActionURL(context, "/views/pageAccueil/pageAccueil.xhtml"));
		extContext.redirect(url);
		headerValue = "Accueil";
		return "/views/pageAccueil/pageAccueil.xhtml";
	}

	// Groupe
	public String goToPageGroupe() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url = extContext.encodeActionURL(context.getApplication()
				.getViewHandler()
				.getActionURL(context, "/views/groupe/gestionGroupe.xhtml"));
		extContext.redirect(url);
		headerValue = "Accueil";
		return "/views/groupe/gestionGroupe.xhtml";
	}
	
	

	// Utilisateur
	public String goToPageUtilisateur() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url = extContext.encodeActionURL(context
				.getApplication()
				.getViewHandler()
				.getActionURL(context,
						"/views/utilisateur/gestionUtilisateur.xhtml"));
		extContext.redirect(url);
		headerValue = "Accueil";
		return "/views/utilisateur/gestionUtilisateur.xhtml";
	}

	public String goToPageChangerMotPasse() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url = extContext.encodeActionURL(context
				.getApplication()
				.getViewHandler()
				.getActionURL(context,
						"/views/utilisateur/changerMotPasse.xhtml"));
		extContext.redirect(url);
		headerValue = "Accueil";
		return "/views/utilisateur/changerMotPasse.xhtml";
	}

	public String goToPagePremierLogin() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url = extContext.encodeActionURL(context.getApplication()
				.getViewHandler().getActionURL(context, "/premierLogin.xhtml"));
		extContext.redirect(url);
		headerValue = "Accueil";
		return "/premierLogin.xhtml";
	}

	// PageLogin
	public String goToPageLogin() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url = extContext.encodeActionURL(context.getApplication()
				.getViewHandler().getActionURL(context, "/pageLogin.xhtml"));
		extContext.redirect(url);
		headerValue = "Accueil";
		return "/pageLogin.xhtml";
	}


				
				/**********************************Debut Souhail *******************************************/
			
	public String goToPageTableauxAmortissement() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		
		TableauAmortissementBean tableauAmortissementBean = (TableauAmortissementBean) FacesContext.getCurrentInstance()
				.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
						"#{tableauAmortissementBean}", TableauAmortissementBean.class);
		tableauAmortissementBean.initialisation();
		
		String url = extContext.encodeActionURL(context
				.getApplication()
				.getViewHandler()
				.getActionURL(context,
						"/views/gestionTableauxAmortissement/gestionTableauxAmortissement.xhtml"));
		extContext.redirect(url);
		 
		headerValue = "Tableaux d'amortissements";
		return "/views/gestionTableauxAmortissement/gestionTableauxAmortissement.xhtml";
	}
	
	
	public String goToPageTableauxAmortissementByCA(String codeClient) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		
		TableauAmortissementBean tableauAmortissementBean = (TableauAmortissementBean) FacesContext.getCurrentInstance()
				.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
						"#{tableauAmortissementBean}", TableauAmortissementBean.class);
		tableauAmortissementBean.initialisation();
		tableauAmortissementBean.setConsulterTAClientAcquereur(1);
		tableauAmortissementBean.setCodeclient(codeClient);
		String url = extContext.encodeActionURL(context
				.getApplication()
				.getViewHandler()
				.getActionURL(context,
						"/views/gestionTableauxAmortissement/gestionTableauxAmortissement.xhtml"));
		extContext.redirect(url);
		 
		headerValue = "Tableaux d'amortissements";
		return "/views/gestionTableauxAmortissement/gestionTableauxAmortissement.xhtml";
	}
	
	public String goToPageDetailTA() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url = extContext.encodeActionURL(context
				.getApplication()
				.getViewHandler()
				.getActionURL(context,
						"/views/gestionTableauxAmortissement/detailTA.xhtml"));
		extContext.redirect(url);
		 
		headerValue = "Détail Tableaux d'amortissements";
		return "/views/gestionTableauxAmortissement/detailTA.xhtml";
	}
	
				/**********************************fin Souhail *******************************************/

	
				/**********************************Debut Mohamed *******************************************/
//Menu : aller à la page gestion des employeurs
	public String goToPageEmployeur() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url = extContext.encodeActionURL(context.getApplication()
				.getViewHandler().getActionURL(context, "/views/employeur/employeur.xhtml"));
		extContext.redirect(url);
     
		return "/views/employeur/employeur.xhtml";
	}
	
	//Menu : aller à la page cession sur salaire
		public String goToPageCession() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context.getApplication()
					.getViewHandler().getActionURL(context, "/views/employeur/cession.xhtml"));
			extContext.redirect(url);
	     
			return "/views/employeur/cession.xhtml";
		}
		
		//Menu : aller à la page Modifier cession sur salaire
			
		public String goToPageModifierCession() throws IOException {
					FacesContext context = FacesContext.getCurrentInstance();
					ExternalContext extContext = context.getExternalContext();
					String url = extContext.encodeActionURL(context.getApplication()
							.getViewHandler().getActionURL(context, "/views/employeur/modifCession.xhtml"));
					extContext.redirect(url);
			     
					return "/views/employeur/modifCession.xhtml";
				}
		
		//Menu : aller à la page Ajouter un client acquereur
		public String goToPageClientacquereur() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context.getApplication()
					.getViewHandler().getActionURL(context, "/views/gestionClientAcquereur/clientAcquereur.xhtml"));
			extContext.redirect(url);
	     
			return "/views/gestionClientAcquereur/clientAcquereur.xhtml";
		}
		
		//Menu : aller à la page Modifierun client acquereur
		public String goToPageModifClientacquereur() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context.getApplication()
					.getViewHandler().getActionURL(context, "/views/gestionClientAcquereur/modifclient.xhtml"));
			extContext.redirect(url);
	     
			return "/views/gestionClientAcquereur/modifclient.xhtml";
		}
		
		
		public String goToPageModifClientacquereurByTA() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			
			ClientAcquereurBean clientAcquereurBean = (ClientAcquereurBean) FacesContext.getCurrentInstance()
			.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
				"#{clientAcquereurBean}", ClientAcquereurBean.class);
			clientAcquereurBean.updateListMensualite();
			String url = extContext.encodeActionURL(context.getApplication()
					.getViewHandler().getActionURL(context, "/views/gestionClientAcquereur/modifclient.xhtml"));
			extContext.redirect(url);
	     
			return "/views/gestionClientAcquereur/modifclient.xhtml";
		}
		
		//Menu : aller à la page regulements des employeurs
		
		public String goToPageQuittanceEmployeur() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context.getApplication()
					.getViewHandler().getActionURL(context, "/views/employeur/recetteEmp.xhtml"));
			extContext.redirect(url);
	     
			return "/views/employeur/recetteEmp.xhtml";
		}
		
		//Menu : aller à la page gestion des Quittance
		public String goToPageQuittance() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context.getApplication()
					.getViewHandler().getActionURL(context, "/views/employeur/quitance.xhtml"));
			extContext.redirect(url);
	     
			return "/views/employeur/quitance.xhtml";
		}

	
				/**********************************fin Mohamed *******************************************/
	
				
				/**********************************Debut Rami *******************************************/
//	Assureur
	public String goToPageAssureurs() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url = extContext.encodeActionURL(context
				.getApplication()
				.getViewHandler()
				.getActionURL(context, 
						  "/views/assurance/assureur.xhtml"));
		extContext.redirect(url);
		headerValue = "Gestion des Assureurs";
		return "/assureur.xhtml";
	}

//	Assurance
	public String goToPageAssurance() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url = extContext.encodeActionURL(context
				.getApplication()
				.getViewHandler()
				.getActionURL(context,
						"/views/assurance/assurances.xhtml"));
		extContext.redirect(url);
		headerValue = "Gestion des Assurances";
		return "/views/assurance/assurances.xhtml";
	}
//	Reclamation
	public String goToPageReclamation() throws IOException {
		
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url = extContext.encodeActionURL(context
				.getApplication()
				.getViewHandler()
				.getActionURL(context,
						"/views/assurance/reclamation.xhtml"));
		extContext.redirect(url);
		headerValue = "Gestion des Prise en charge des  réclamations";
		return "/views/assurance/reclamation.xhtml";
	}
//	Deces
	public String goToPageDeces() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url = extContext.encodeActionURL(context
				.getApplication()
				.getViewHandler()
				.getActionURL(context,
						"/views/assurance/deces.xhtml"));
		extContext.redirect(url);
		headerValue = "Gestion des décès";
		return "/views/assurance/deces.xhtml";
	}
//	Recherche reclamation
	public String goToPageRechercheReclamation() throws IOException {
      if (reclamationBean.getRechReclamations() !=null ){
			
			reclamationBean.initialisation();
		}
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		String url = extContext.encodeActionURL(context
				.getApplication()
				.getViewHandler()
				.getActionURL(context,
						"/views/assurance/rechercheReclamation.xhtml"));
		extContext.redirect(url);
		headerValue = "Gestion des Prise en charge des  réclamations";
		return "/views/assurance/rechercheReclamation.xhtml";
	}
				/**********************************fin Rami *******************************************/

		
				/*************************************debut zied *************************************/
	// Utilisateur
		public String goToPageParametrageTypeFrais() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/parametrage/parametrageDesTypesDeFrais.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Parametrage Type Frais";
			return "/views/parametrage/parametrageDesTypesDeFrais.xhtml";
		}
			public String goToPageParametrageAnneeBudgetaire() throws IOException {
				FacesContext context = FacesContext.getCurrentInstance();
				ExternalContext extContext = context.getExternalContext();
				String url = extContext.encodeActionURL(context
						.getApplication()
						.getViewHandler()
						.getActionURL(context,
								"/views/parametrage/parametrageAnneeBudgetaire.xhtml"));
				extContext.redirect(url);
				 
				headerValue = "Parametrage Type Frais";
				return "/views/parametrage/parametrageAnneeBudgetaire.xhtml";
			
		}
	
		
		public String goToPageParametrageTypeReclamation() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/parametrage/parametrageDesObjetsReclamation.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Parametrage Objet réclamation";
			return "/views/parametrage/parametrageDesObjetsReclamation.xhtml";
		}
		public String goToPageParametrageContentieux() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/parametrage/parametrageContentieux.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Parametrage Contentieux";
			return "/views/parametrage/parametrageContentieux.xhtml";
		}
		public String goToPageParametrageGouvernerat() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/parametrage/parametrageGouvernorats.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Parametrage Gouvernorats";
			return "/views/parametrage/parametrageGouvernorats.xhtml";
		}
		public String goToPageParametrageHuissierNotaire() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/parametrage/parametrageHuissiersNotaires.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Parametrage Huissiers Notaires";
			return "/views/parametrage/parametrageHuissiersNotaires.xhtml";
		}
		public String goToPageParametrageTypeLogement() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/parametrage/parametrageTypeLogement.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "parametrage Logement";
			return "/views/parametrage/parametrageTypeLogement.xhtml";
		}
		public String goToPageParametrageTypeMainlevée() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/parametrage/parametrageTypeMainlevée.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Parametrage Mainlevée";
			return "/views/parametrage/parametrageTypeMainlevée.xhtml";
		}
		public String goToPageParametrageVilles() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/parametrage/parametrageVilles.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Parametrage Villes";
			return "/views/parametrage/parametrageVilles.xhtml";
		}
		public String goToPageParametrageMainlevee() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/parametrage/parametrageMainlevee.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Parametrage Mainlevee";
			return "/views/parametrage/parametrageMainlevee.xhtml";
		}
		
		public String goToPageGestionNoteDebit() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/recette/gestionNoteDebit/consulterNoteDebit.xhtml"));
			extContext.redirect(url);
			NoteDebitBean noteDebitBean = ( NoteDebitBean) FacesContext
		                .getCurrentInstance()
		                .getApplication()
		                .evaluateExpressionGet(FacesContext.getCurrentInstance(),
		                             "#{noteDebitBean}",
		                             NoteDebitBean.class);
				  
			noteDebitBean.createNoteDebit();
			
			headerValue = "Consulter Note Debit";
			return "/views/recette/gestionNoteDebit/consulterNoteDebit.xhtml";
		}
		
		public String goToPageAjouterDebitNotaire() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/recette/gestionNoteDebit/ajouterNoteDebit.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Consulter Note Debit";
			return "/views/recette/gestionNoteDebit/ajouterNoteDebit.xhtml";
		}
	
		public String goToPageModifierNoteDebit() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/recette/gestionNoteDebit/modifierNoteDebit.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Consulter Note Debit";
			return "/views/recette/gestionNoteDebit/modifierNoteDebit.xhtml";
		}
		public String goToPageConsulterLogement() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/identification/gestionLogement/consulterLogement.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Consulter Logements";
			return "/views/identification/gestionLogement/consulterLogement.xhtml";
		}
		public String goToPageGestionClientLocataire() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			ClientLocataireBean clientLocataireBean = ( ClientLocataireBean) FacesContext
	                .getCurrentInstance()
	                .getApplication()
	                .evaluateExpressionGet(FacesContext.getCurrentInstance(),
	                             "#{clientLocataireBean}",
	                             ClientLocataireBean.class);
			  
			clientLocataireBean.setEtatClienLocataireFRAR();
		
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/identification/gestionClientLocataire/gestionClientLocataire.xhtml"));
			extContext.redirect(url);
			
			return "/views/identification/gestionClientLocataire/gestionClientLocataire.xhtml";
		}
		
		public String goToPageAjouterClientLocataire() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			ClientLocataireBean clientLocataireBean = ( ClientLocataireBean) FacesContext
	                .getCurrentInstance()
	                .getApplication()
	                .evaluateExpressionGet(FacesContext.getCurrentInstance(),
	                             "#{clientLocataireBean}",
	                             ClientLocataireBean.class);
			  
			clientLocataireBean.initialisation();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/identification/gestionClientLocataire/ajouterClientLocataire.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Gestion Client Locataire";
			return "/views/identification/gestionClientLocataire/ajouterClientLocataire.xhtml";
		}
		
		
		
		public String goToPageModifierClientLocataire() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/identification/gestionClientLocataire/modifierClientLocataire.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Modifier Client Locataire";
			return "/views/identification/gestionClientLocataire/modifierClientLocataire.xhtml";
		}

		public String goToParametrageLotissement() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/parametrage/parametrageLotissement.xhtml"));
			extContext.redirect(url);
			headerValue = "Gestion Lotissement";
			return "/views/gestionClientAcquereur/parametrageLotissement.xhtml";
		}
		
		public String goToPageGestionDecompte() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			
			DecompteBean decompteBean = (DecompteBean) FacesContext.getCurrentInstance()
					.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
							"#{decompteBean}", DecompteBean.class);
			decompteBean.initialisation();
			
			
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/recette/gestionDecompteMainlevee/gestionDecompte.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Gestion Decompte";
			return "/views/recette/gestionDecompteMainlevee/gestionDecompte.xhtml";
		}
		public String goToPageimprimerMainLevee() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/recette/imprimerMainlevee/imprimerMainLevee.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Imprimer mailevee";
			return "/views/recette/imprimerMainlevee/gimprimerMainLevee.xhtml";
		}

		public String goToPageimprimerNoteAlaDOF() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/recette/imprimerNoteAlaDof/noteAlaDOF.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Imprimer note a la DOF";
			return "/views/recette/imprimerNoteAlaDof/noteAlaDOF.xhtml";
		}
		public String goToPageimprimerActeDePrecision() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/recette/imprimerActePrecision/actePrecision.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Imprimer acte de precision ";
			return "/views/recette/imprimerActePrecision/actePrecision.xhtml";
		}
		public void goToPageApurement() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/apurement/rechercheCompteAttente.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Apurement";
			
		}
		public void goToPageDeclasse() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/apurement/declasserQuittance.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Déclasser Quittance";
			
		}
		public void goToPageGestionQuittance() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/apurement/gestionQuittance.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Gestion Quittance";
			
		}
		public void goToPageArchivageClient() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/recette/Archive/archivageClient.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Gestion Quittance";
			
		}
		
		public void goToPageEditionTableauSoldeClient() throws IOException{
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/edition/edition.xhtml"));
			extContext.redirect(url);
			 
			headerValue = "Edition";
			
		}


				
			/*************************************fin zied****************************************/
		
		
		/*************************************debut hejaiej****************************************/
		
		
		public String goToPageSuiviDesRecouvrements() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/gestionDesRecettes/suiviDesRecouvrements.xhtml"));
			extContext.redirect(url);
			headerValue = "Accueil";
			return "/views/gestionDesRecettes/suiviDesRecouvrements.xhtml";
		}
		
		public String goToPageGestionPrecontentieux() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/gestionDesRecettes/suiviPrecontentieux.xhtml"));
			extContext.redirect(url);
			headerValue = "Accueil";
			return "/views/gestionDesRecettes/suiviPrecontentieux.xhtml";
		}
		
		public String goToPageSuiviPrecontentieux() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/gestionDesRecettes/precontentieux.xhtml"));
			extContext.redirect(url);
			headerValue = "Accueil";
			return "/views/gestionDesRecettes/precontentieux.xhtml";
		}
		
		
		public String goToPageDossierContentieux() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/contentieux/dossierAenvoyerAuContentieux.xhtml"));
			extContext.redirect(url);
			headerValue = "Accueil";
			return "/views/contentieux/dossierAenvoyerAuContentieux.xhtml";
		}
		
		public String goToPageContentieux() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/contentieux/contentieux.xhtml"));
			extContext.redirect(url);
			headerValue = "Accueil";
			return "/views/contentieux/contentieux.xhtml";
		}
		
		
		public String goToPageGestionArrangement() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/gestionDesRecettes/gestionArrangement.xhtml"));
			extContext.redirect(url);
			headerValue = "Accueil";
			
			return "/views/gestionDesRecettes/gestionArrangement.jsf";
		}
		
		public String goToPagerechercheClientAcquereur() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/gestionClientAcquereur/rechercheDesClientsAcquereurs.xhtml"));
			ClientAcquereurBean clientAcquereurBean = ( ClientAcquereurBean) FacesContext
	                .getCurrentInstance()
	                .getApplication()
	                .evaluateExpressionGet(FacesContext.getCurrentInstance(),
	                             "#{clientAcquereurBean}",
	                             ClientAcquereurBean.class);
			RechercheDesClientsAcquereursBean rechercheDesClientsAcquereursBean = ( RechercheDesClientsAcquereursBean) FacesContext
	                .getCurrentInstance()
	                .getApplication()
	                .evaluateExpressionGet(FacesContext.getCurrentInstance(),
	                             "#{rechercheDesClientsAcquereursBean}",
	                             RechercheDesClientsAcquereursBean.class);
			
			rechercheDesClientsAcquereursBean.initialisation();
			clientAcquereurBean.initSelect();
		
			extContext.redirect(url); 
			headerValue = "Recherche clients acquereur";
			return "/views/gestionClientAcquereur/rechercheDesClientsAcquereurs.jsf";
		}
		
		
		public String goToPagerechercheArrangement() throws IOException {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			String url = extContext.encodeActionURL(context
					.getApplication()
					.getViewHandler()
					.getActionURL(context,
							"/views/gestionDesRecettes/rechercheArrangement.xhtml"));
			extContext.redirect(url);
			headerValue = "Accueil";
			return "/views/gestionDesRecettes/rechercheArrangement.jsf";
		}
		
		
		
		
		
		
		
		
		/*************************************fin hejaiej****************************************/

}