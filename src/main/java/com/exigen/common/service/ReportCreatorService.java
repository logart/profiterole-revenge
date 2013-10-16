package com.exigen.common.service;

import com.exigen.common.response.PrintDto;

import java.io.FileNotFoundException;
import java.io.OutputStream;

/**
 * Class {@code ReportCreatorService} used for creating reports.
 */
public interface ReportCreatorService {

    public void createReport(String templateName, Object dataTransferObject, OutputStream outputStream)
            throws FileNotFoundException;
}
