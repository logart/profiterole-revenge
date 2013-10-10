package com.exigen.common.service;

import com.exigen.common.response.PrintDto;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * {@inheritDoc}
 * Creates *.prf file.
 */
@Service
public class PdfCreatorService implements ReportCreatorService {

    protected static final Logger LOG = Logger.getLogger(PdfCreatorService.class.getName());

    /**
     * {@inheritDoc}
     *
     * @param templateFile contains file path
     * @param dataTransferObject contains POJO with mapping data
     * @return OutputStream with pdf format
     * @throws FileNotFoundException
     */
    @Override
    public OutputStream createReport(final String templateFile, final PrintDto dataTransferObject)
            throws FileNotFoundException {
        ArrayList<Object> objects = new ArrayList<Object>();
        objects.add(dataTransferObject);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(objects);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(templateFile);
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, new HashMap(), dataSource);
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        } catch (JRException e) {
            LOG.log(Level.WARNING, "JRException in JasperReports API", e);
        }

        return outputStream;
    }
}
