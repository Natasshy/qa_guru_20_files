package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class FilesTest {
    @Test
    @DisplayName("PDF - тест чтения и проверки содержимого файла из архива")
    void pdfFileCheck() throws Exception {
        try (ZipFile zip = new ZipFile(new File("src/test/resources/Archive 2.zip"))) {
            ZipEntry entry = zip.getEntry("Новый пдф.pdf");
            InputStream inputStream = zip.getInputStream(entry);
            {
                PDF pdf = new PDF(inputStream);
                Assertions.assertEquals("A Simple PDF File\n", pdf.text);
            }
        }
    }

    @Test
    @DisplayName("CSV - тест чтения и проверки содержимого файла из архива")
    void csvFileCheck() throws Exception {
        try (ZipFile zip = new ZipFile(new File("src/test/resources/Archive 2.zip"))) {
            ZipEntry entry = zip.getEntry("Новая таблица.csv");
            InputStream inputStream = zip.getInputStream(entry);
            Reader reader = new InputStreamReader(inputStream);
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> values = csvReader.readAll();

            final String[] firstRow = values.get(0);

            Assertions.assertArrayEquals(new String[]{"\uFEFFПродукты", "Количество"}, firstRow);

        }
    }

    @Test
    @DisplayName("XLS - тест чтения и проверки содержимого файла из архива")
    void XlsFileCheck() throws Exception {
        try (ZipFile zip = new ZipFile(new File("src/test/resources/Archive 2.zip"))) {
            ZipEntry entry = zip.getEntry("Новая таблица.xlsx");
            InputStream inputStream = zip.getInputStream(entry);
            XLS xls = new XLS(inputStream);

            Assertions.assertEquals("Молоко",
                    xls.excel.getSheetAt(0).getRow(3).getCell(0).getStringCellValue());

        }
    }
}
