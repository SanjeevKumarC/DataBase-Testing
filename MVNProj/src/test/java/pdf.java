import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class pdf{
	public static void main(String[] args) {
	 String pdfFilePath = "./TestData/Applitools.pdf";
	 try {
		// PDDocument document = PDDocument.load

	} catch (Exception e) {
		// TODO: handle exception
	}
	
     // Create a PDFTextStripper object to extract text from the PDF
     PDFTextStripper pdfTextStripper = new PDFTextStripper();

     // Get the text content from the PDF
    // String pdfText = pdfTextStripper.getText(document);

     // Print the extracted text
    // System.out.println("Extracted Text: \n" + pdfText);

     // Close the PDDocument
   //  document.close();
      
	}
}