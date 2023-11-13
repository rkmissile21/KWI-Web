package com.kwi.base;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFUtil {

    /**
     * Read text content from a PDF file.
     *
     * @param pdfFile PDF file to read.
     * @return Text content of the PDF.
     * @throws IOException If an I/O error occurs.
     */
    public static String readPDF(File pdfFile) throws IOException {
        try (PDDocument document = PDDocument.load(pdfFile)) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }

    /**
     * Write text content to a PDF file.
     *
     * @param pdfFile PDF file to write.
     * @param content Text content to write to the PDF.
     * @throws IOException If an I/O error occurs.
     */
    public static void writePDF(File pdfFile, String content) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(100, 700); // Adjust as needed
                contentStream.showText(content);
                contentStream.endText();
            }

            document.save(pdfFile);
        }
    }

    /**
     * Validate if a PDF file exists.
     *
     * @param pdfFile PDF file to validate.
     * @return True if the file exists, false otherwise.
     */
    public static boolean isPDFFileExists(File pdfFile) {
        return pdfFile.exists() && pdfFile.isFile();
    }

    /**
     * Validate if a PDF file is downloaded successfully.
     *
     * @param pdfFile PDF file to validate.
     * @return True if the file is downloaded, false otherwise.
     */
    public static boolean isPDFDownloaded(File pdfFile) {
        return isPDFFileExists(pdfFile) && pdfFile.length() > 0;
    }

    public static void main(String[] args) throws IOException {
        // Example usage:
        File samplePDF = new File("path/to/sample.pdf");

        // Read PDF
        String pdfContent = readPDF(samplePDF);
        System.out.println("PDF Content:\n" + pdfContent);

        // Write PDF (Note: This will overwrite the existing file)
        String newTextContent = "This is a new content.";
        writePDF(samplePDF, newTextContent);

        // Validate if PDF is downloaded
        if (isPDFDownloaded(samplePDF)) {
            System.out.println("PDF is downloaded successfully.");
        } else {
            System.out.println("PDF download failed.");
        }
    }
}
