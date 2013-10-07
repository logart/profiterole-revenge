package com.exigen.common.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
@Service
public class PdfCreatorService {

    public OutputStream createReport(String templateName, Object dataTransferObject)
            throws FileNotFoundException, JRException {
        ArrayList<Object> objects = new ArrayList<Object>();
        objects.add(dataTransferObject);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(objects);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(templateName);
        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), dataSource);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

        return outputStream;
    }
}
