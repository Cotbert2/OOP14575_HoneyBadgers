package ec.edu.espe.viveresgabysoftwarekit.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfConverter {
    public void convert(String filePath) {
        String pdfFilePath = changeExtension(filePath);

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));
            document.open();

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                document.add(new Paragraph(line));
            }
            reader.close();

            document.close();

            System.out.println("[+] PDF report was generated successfully: " + pdfFilePath);

        } catch (IOException e) {
            System.out.println("[-] Error while pdf conversion: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[-] Error while pdf conversion: " + e.getMessage());
        }
    }

    private String changeExtension(String filePath) {
        return (filePath.split("\\.")[0] + ".pdf");
    }
}
