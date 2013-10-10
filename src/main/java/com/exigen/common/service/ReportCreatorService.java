package com.exigen.common.service;

import com.exigen.common.response.PrintDto;

import java.io.FileNotFoundException;
import java.io.OutputStream;

/**
 * Class {@code ReportCreatorService} used for creating reports.
 */
public interface ReportCreatorService {

    /**
     * {@method createReport(String templateFile, PrintDto dataTransferObject)}
     * creates report from POJO using template.
     *
     * @param templateFile contains file path
     * @param dataTransferObject contains POJO with mapping data
     * @return OutputStream of report
     * @throws FileNotFoundException when template file not found
     */
    public OutputStream createReport(final String templateFile, final PrintDto dataTransferObject)
            throws FileNotFoundException;
}
