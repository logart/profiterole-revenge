package com.exigen.common.service;

import com.exigen.common.response.PrintDto;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This test describes how JasperReports works.
 */
public class PdfCreatorServiceTest {

    @Test
    public void testCreateReport() throws Exception {

        TestDto dataMock = mock(TestDto.class);
        when(dataMock.getTestField()).thenReturn("testText");

        OutputStream outputStream = new ByteArrayOutputStream();
        new PdfCreatorService().createReport("test.jasper", dataMock, outputStream);
        Assert.assertNotNull(outputStream);

    }

    public class TestDto implements PrintDto {
        private String testField;

        public String getTestField() {
            return testField;
        }

        public void setTestField(String testField) {
            this.testField = testField;
        }
    }
}
