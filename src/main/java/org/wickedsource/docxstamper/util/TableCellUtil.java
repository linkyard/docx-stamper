package org.wickedsource.docxstamper.util;

import jakarta.xml.bind.JAXBElement;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Tc;


public class TableCellUtil {

    private static ObjectFactory objectFactory = new ObjectFactory();

    public static boolean hasAtLeastOneParagraphOrTable(Tc cell) {
        for (Object contentElement : cell.getContent()) {
            if (contentElement instanceof P ||
                    (contentElement instanceof JAXBElement && ((JAXBElement) contentElement).getValue() instanceof Tbl)) {
                return true;
            }
        }
        return false;
    }

    public static void addEmptyParagraph(Tc cell) {
        P paragraph = objectFactory.createP();
        paragraph.getContent().add(objectFactory.createR());
        cell.getContent().add(paragraph);
    }
}
