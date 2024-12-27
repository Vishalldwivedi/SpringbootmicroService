package in.vishal.Util;

import in.vishal.entity.citizenPlan;
import in.vishal.repo.citizenPlanRepo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Component
public class ExcelGenerator {
    @Autowired// we are injecting
    private citizenPlanRepo planRepo;
    public void generate(HttpServletResponse response,List<citizenPlan> records) throws Exception{

        Workbook workbook = new HSSFWorkbook();
        //Workbook is a interface and HSSFworkbook is a imp class for that
        Sheet sheet =workbook.createSheet("plans-data");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("citizenName");
        headerRow.createCell(2).setCellValue("plan name");
        headerRow.createCell(3).setCellValue("plan status");
        headerRow.createCell(4).setCellValue("plan start date");
        headerRow.createCell(5).setCellValue("plan end date");
        headerRow.createCell(6).setCellValue("benefit amount");
        int dataRowIndex =1;
        for(citizenPlan plan : records){
            Row dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(plan.getCitizenId());
            dataRow.createCell(1).setCellValue(plan.getCitizenName());
            dataRow.createCell(2).setCellValue(plan.getPlanName());
            dataRow.createCell(3).setCellValue(plan.getPlanStatus());
            dataRow.createCell(4).setCellValue(plan.getPlanStartDate());
            dataRow.createCell(5).setCellValue(plan.getPlanEndDate());
            if(null!=plan.getBenefitAmt()){
                dataRow.createCell(6).setCellValue(plan.getBenefitAmt());
            }else{
                dataRow.createCell(6).setCellValue("N/A");
            }

            dataRowIndex++;
        }
        //now write this data to file
//        FileOutputStream fos = new FileOutputStream(new File("plans.xls"));
//        workbook.write(fos);
//        workbook.close();

//what ever the workbook i have created i need to write that data in my outputStream obj
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
    }
}
