package com.cynapsys.Views.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

@ManagedBean(name = "constantController")
@SessionScoped
public class ConstantController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String SESSION_CONNECTED_USER = "currentUser";
	public static String SESSION_SELECT_FLASH_PROJET = "flashProjet";
	public static String SESSION_DETAIL_PROJET = "detailProjet";
	public static String SESSION_MODIFIER_PROJET = "modifierProjet";
	public static String MODIFICATION_FLASH_PROJET = "modifFlashProjet";

	public ConstantController() {
		Locale locale = Locale.getDefault();
		DateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy", locale);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", locale);
		date = dateFormat.format(new Date());
		setDateCur(new Date());
		dateCurS = format.format(dateCur);
		try {
			String l = date.substring(0, 1).toUpperCase();
			date = l + date.substring(1, date.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String date;
	private Date dateCur;
	private String dateCurS;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Date getDateCur() {
		return dateCur;
	}

	public void setDateCur(Date dateCur) {
		this.dateCur = dateCur;
	}

	public String getDateCurS() {
		return dateCurS;
	}

	public void setDateCurS(String dateCurS) {
		this.dateCurS = dateCurS;
	}

	public Integer getRecordNomber(String totalRecords) {
		if ("".equals(totalRecords))
			return null;
		return Integer.valueOf(totalRecords);
	}

	public static String loadPropretiesValue(String key) {

		String value = "";
		try {
			ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			Properties fileProperties = new Properties();
			// load file properties
			fileProperties.load(sc.getResourceAsStream("/WEB-INF/conf.properties"));
			value = fileProperties.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
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

		filePath = Long.toHexString(Double.doubleToLongBits(Math.random())).toUpperCase() + "." + extension;
		File file = new File(filePath);

		while (file.exists()) {
			filePath = Long.toHexString(Double.doubleToLongBits(Math.random())).toUpperCase() + "." + extension;
			file = new File(filePath);
		}
		return filePath;
	}

	public static String getFilesLogo() {
		String report = "";
		report = getPath() + loadPropretiesValue("file.Reference.Icon");
		return report;
	}

	public static String getFilesVideo() {
		String report = "";
		report = getPath() + loadPropretiesValue("file.Reference.Video");
		return report;
	}

	public static String getFilesPresentation() {
		String report = "";
		report = getPath() + loadPropretiesValue("file.Reference.Presentation");
		return report;
	}

	public static String getFilesPalaning() {
		String report = "";
		report = getPath() + loadPropretiesValue("file.FlashProjet.Planing");
		return report;
	}

	public static String getFilesFigure() {
		String report = "";
		report = getPath() + loadPropretiesValue("file.Reference.Figure");
		return report;
	}

	public static String getPath() {
		String path = "";
		path = loadPropretiesValue("url.base");
		return path;
	}

}
