package in.vishal.Util;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import in.vishal.entity.citizenPlan;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class PdfGenerator {
    public void generate(HttpServletResponse response, List<citizenPlan> records)throws Exception{
        // Create a document with A4 size
        Document document = new Document(PageSize.A4);

        // Initialize PDF writer
        PdfWriter.getInstance(document, response.getOutputStream());

        // Open the document
        document.open();// to write the data that doc should be open

        // Add Title
        document.add(new Paragraph("Citizen Plans Report"));
        document.add(new Paragraph("\n"));

        // Create a table with 6 columns
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);

        // Add table headers
        table.addCell("ID");
        table.addCell("Citizen Name");
        table.addCell("Plan Name");
        table.addCell("Plan Status");
        table.addCell("Plan Start Date");
        table.addCell("Plan End Date");

        // Fetch data from the database

        for (citizenPlan plan : records) {
            table.addCell(String.valueOf(plan.getCitizenId()));
            table.addCell(plan.getCitizenName());
            table.addCell(plan.getPlanName());
            table.addCell(plan.getPlanStatus());
            table.addCell(plan.getPlanStartDate().toString());
            table.addCell(plan.getPlanEndDate().toString());
        }

        // Add table to document
        document.add(table);

        // Close the document
        document.close();
    }
}
