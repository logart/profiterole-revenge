package com.exigen.common.service;

import com.exigen.common.response.Dto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.InputStream;
import java.io.OutputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 */
public class PdfCreatorServiceTest {

    @Test
    public void testCreateReport() throws Exception {

        TestDto dataMock = mock(TestDto.class);
        when(dataMock.getTestField()).thenReturn("testText");

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("test.pdf");
        OutputStream outputStream = new PdfCreatorService().createReport("test.jrxml", dataMock);

        Assert.assertNotNull(outputStream);
    }

    public class TestDto implements Dto {
        private String testField;

        public String getTestField() {
            return testField;
        }

        public void setTestField(String testField) {
            this.testField = testField;
        }
    }
}
