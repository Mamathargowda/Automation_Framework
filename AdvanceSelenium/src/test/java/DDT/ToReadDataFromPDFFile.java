package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ToReadDataFromPDFFile {

	public static void main(String[] args) throws Throwable {
		File fis = new File("C:\\Users\\Harsha\\Downloads\\Selenium32.pdf");
		PDDocument doc= PDDocument.load(fis);
		int pages = doc.getNumberOfPages();
		System.out.println(pages);
		
		PDFTextStripper pdfData = new PDFTextStripper();
		String readData = pdfData.getText(doc);
		System.out.println(readData);

	}

}
