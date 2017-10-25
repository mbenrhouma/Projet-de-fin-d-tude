package com.cynapsys.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRProperties;
import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateException;
import net.sf.jooreports.templates.DocumentTemplateFactory;

public class GenerateRapport {

	public static String urlJasper = Parametre.getProjetRealPath(GenerateRapport.class) + "/Jasper/";
	public static String urlJrxml = Parametre.getProjetRealPath(GenerateRapport.class) + "/Jasper/source/";
	public static String urlodt = Parametre.getProjetRealPath(GenerateRapport.class) + "/Jasper/source/doc/";
	public static String urlPDF = Parametre.getProjetRealPath(GenerateRapport.class) + "/rapport/";
	public static String urlImages = Parametre.getProjetRealPath(GenerateRapport.class) + "/images/";// get
																										// chemin
																										// relatif
	public static String urlFont = Parametre.getProjetRealPath(GenerateRapport.class) + "/font/";
	public static String nameFont = "arial.ttf";

	// Cette m�thode permet de g�n�rer un document PDF
	// le document g�n�r� sera renvoy� sous la forme d'un byte[]
	public static <T> byte[] viewPDFWithDataSource(String inPutfileJasper, Map<String, Object> params,
			List<T> dataSource) {

		String urlFile = urlJasper + inPutfileJasper;
		try {
			InputStream is = new FileInputStream(urlFile);
			JasperPrint jasperPrint = JasperFillManager.fillReport(is, params,
					new JRBeanCollectionDataSource(dataSource));
			return JasperExportManager.exportReportToPdf(jasperPrint);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static <T> byte[] viewPDFWithDataSource(String inPutfileJasper, Map<String, Object> params) {

		String urlFile = urlJasper + inPutfileJasper;
		try {
			InputStream is = new FileInputStream(urlFile);
			JRProperties.setProperty("net.sf.jasperreports.default.pdf.font.name", urlFont + nameFont);

			JasperPrint jasperPrint = JasperFillManager.fillReport(is, params, new JREmptyDataSource());

			return JasperExportManager.exportReportToPdf(jasperPrint);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	public static <T> void exportPDFWithDataSource(String inPutfileJasper, Map<String, Object> params,
			List<T> dataSource, String fileName) {

		String urlFile = urlJasper + inPutfileJasper;
		System.out.println("Runtime japser font" + urlFont + nameFont);
		try {
			InputStream is = new FileInputStream(urlFile);
			JRProperties.setProperty("net.sf.jasperreports.default.pdf.font.name", urlFont + nameFont);
			JasperPrint jasperPrint = JasperFillManager.fillReport(is, params,
					new JRBeanCollectionDataSource(dataSource));

			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition", "attachment; filename=" + fileName);
			ServletOutputStream stream = response.getOutputStream();

			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	public static <T> void exportPDFWithDataSource(String inputFileMasterJasper, String inputFileSubJasper,
			Map<String, Object> params, List<T> dataSource, String listName, String fileName) {

		String urlMasterFile = urlJasper + inputFileMasterJasper;
		String urlSubFile = urlJasper + inputFileSubJasper;

		System.out.println("Runtime japser font" + urlFont + nameFont);
		try {
			InputStream is = new FileInputStream(urlMasterFile);
			JasperReport jasperSubReport = (JasperReport) JRLoader.loadObject(new FileInputStream(urlSubFile));

			params.put(listName, jasperSubReport);
			params.put("SUBREPORT_DIR", urlJasper);

			JRProperties.setProperty("net.sf.jasperreports.default.pdf.font.name", urlFont + nameFont);

			JasperPrint jasperPrint = JasperFillManager.fillReport(is, params,
					new JRBeanCollectionDataSource(dataSource));

			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition", "attachment; filename=" + fileName);
			ServletOutputStream stream = response.getOutputStream();

			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	public static <T> void exportPDFWithDataSource(String inPutfileJasper, Map<String, Object> params,
			String fileName) {
		String urlFile = urlJasper + inPutfileJasper;
		try {
			InputStream is = new FileInputStream(urlFile);

			JRProperties.setProperty("net.sf.jasperreports.default.pdf.font.name", urlFont + nameFont);
		
			JasperPrint jasperPrint = JasperFillManager.fillReport(is, params, new JREmptyDataSource());

			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition", "attachment; filename=" + fileName);
			ServletOutputStream stream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T> void exportPDFWithDataSourceSubReport(String subReportFileName, String masterReportFileName,
			List<T> dataList, Map<String, Object> params, String fileName, String listParamNam) {
		String urlFilesubReport = urlJasper + subReportFileName;
		String urlFileMaster = urlJasper + masterReportFileName;
		try {
			JRBeanCollectionDataSource dataSourceMasterReport = new JRBeanCollectionDataSource(dataList);

			JasperReport jasperMasterReport = (JasperReport) JRLoader.loadObject(new FileInputStream(urlFileMaster));

			JasperReport jasperSubReport = (JasperReport) JRLoader.loadObject(new FileInputStream(urlFilesubReport));

			params.put(listParamNam, jasperSubReport);
			params.put("SUBREPORT_DIR", urlJasper);

			JRProperties.setProperty("net.sf.jasperreports.default.pdf.font.name", urlFont + nameFont);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, params, dataSourceMasterReport);

			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition", "attachment; filename=" + fileName);
			ServletOutputStream stream = response.getOutputStream();

			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//	debut zied
	public static <T> void exportWordWithDataSource(String inPutfileJasper, Map<String, Object> params,
			String fileName) {
		String urlFile=urlodt+inPutfileJasper;
		
		DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
        DocumentTemplate document;
		try {
			document = documentTemplateFactory.getTemplate(new File(urlFile));
			document.createDocument(params, new FileOutputStream("D://"+fileName));
		} catch (IOException e) {
			System.out.print("exception1");
			e.printStackTrace();
		} catch (DocumentTemplateException e) {
			System.out.print("exception2");
			e.printStackTrace();
		}
		
	}

	
	
}
