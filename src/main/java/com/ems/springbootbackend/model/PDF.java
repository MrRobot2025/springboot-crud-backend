package com.ems.springbootbackend.model;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PDF {


    private Logger logger = LoggerFactory.getLogger(PDF.class);

    public ByteArrayInputStream createPDF() {
        logger.info("Create PDF started");

        String title = "Welcome";
        String content = " WE prove Quality Work";

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document();
        PdfWriter.getInstance(document,out);

        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
        Paragraph titleparagraph=new Paragraph(title,titleFont);
        document.add(titleparagraph);

        Font paraFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);
        Paragraph paragraph=new Paragraph(content,paraFont);
        document.add(paragraph);

        document.close();

        return new ByteArrayInputStream(out.toByteArray());

    }

}
