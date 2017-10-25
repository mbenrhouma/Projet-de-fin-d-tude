package com.cynapsys.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class ConfigUtils {
	private static ConfigUtils instance;

	public static ConfigUtils getInstance() {
		if (instance != null)
			return instance;
		else
			return new ConfigUtils();
	}

	public static ServletContext getServletContext() {
		return (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();
	}

	public static String loadPropretiesValue(String file, String key) {

		String value = "";
		try {

			Properties fileProperties = new Properties();
			// load file properties
			fileProperties.load(getServletContext().getResourceAsStream(file));
			value = fileProperties.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	public static String loadPropretiesValue(String key) {

		String value = "";
		try {

			Properties fileProperties = new Properties();
			// load file properties
			fileProperties.load(getServletContext().getResourceAsStream(
					"/conf/conf.properties"));

			value = fileProperties.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String loadPropretiesConfigValue(String key) {
		return loadPropretiesValue("/conf/conf.properties", key);
	}

	public static String loadPropretiesConfigMailValue(String key) {
		return loadPropretiesValue("/conf/mail.properties", key);
	}
	
	public static String loadPropretiesConfigMailDetailValue(String key) {
		return loadPropretiesValue("/conf/mail_demande_detail.properties", key);
	}
	
	public static String loadPropretiesConfigMailTempFactureValue(String key) {
		return loadPropretiesValue("/conf/mail_facture_temp.properties", key);
	}
	
	public static String loadPropretiesConfigMailOPValue(String key) {
		return loadPropretiesValue("/conf/mail_ordre_paiement.properties", key);
	}
	public static String loadPropretiesHibernateConnexion(String key) {
		return loadPropretiesValue("/WEB-INF/hibernate.properties", key);
	}
	public static String loadPropretiesQuartz(String key) {
		return loadPropretiesValue("/WEB-INF/quartz.properties", key);
	}
	public static String loadPropretiesConfigValueMailRecptionTT(String key) {
		return loadPropretiesValue("/conf/mail_reception_tt.properties", key);
	}

	public static String getUrlBase() {
		return Constants.getUrlPath();
	}


	public static String getMailFacturesTTUrl() {
		return  loadPropretiesConfigValueMailRecptionTT("dossier.mail.tt");
	}
	
	public static String getPath() {
		String path = "";
		path = loadPropretiesValue("url_base");
		return path;
	}
	public static String getPathRacine() {
		String path = "";
		path = loadPropretiesValue("url_base")+ loadPropretiesValue("dossier_racine");
		return path;
	}
	
	public static String getFilesPhotosLocalePath() {
		String report = "";
		report = getPathRacine()
				+ loadPropretiesValue("file.photo.local.path");
		return report;
	}
	public static String getFilesContratPath() {
		String report = "";
		report = getPathRacine()
				+ loadPropretiesValue("file.contrat.local.path");
		return report;
	}
	public static String getFilesContratToPrintPath() {
		String report = "";
		report = getPathRacine()
				+ loadPropretiesValue("file.contrat.to.print.local.path");
		return report;
	}
	
	public static void createDirectory(String outputDirectory) {
		File rep = new File(outputDirectory);
		if (!rep.exists()) {
			rep.mkdirs();
		}
	}
	
	public static String renameFile(String filePath) {

		int indexExtension = filePath.lastIndexOf(".");
		String extension = filePath.substring(indexExtension + 1);

		String fileName = filePath.substring(0, indexExtension);

		int i = 2;
		filePath = fileName + " (" + i + ")." + extension;
		File file = new File(filePath);

		while (file.exists()) {
			i++;
			filePath = fileName + " (" + i + ")." + extension;
			file = new File(filePath);
		}
		return filePath;
	}

}
