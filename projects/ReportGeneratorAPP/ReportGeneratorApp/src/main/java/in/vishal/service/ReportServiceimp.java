package in.vishal.service;

import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;
import in.vishal.Util.ExcelGenerator;
import in.vishal.Util.PdfGenerator;
import in.vishal.entity.citizenPlan;
import in.vishal.repo.citizenPlanRepo;
import in.vishal.request.SeachRequest;
import org.apache.catalina.filters.ExpiresFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfWriter;
import in.vishal.entity.citizenPlan;
import in.vishal.repo.citizenPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;



@Service //service wil talk to repository therefor we meed to perform DI
// to represent this as spring bean we need Service .
public class ReportServiceimp implements ReportService{
    @Autowired// we are injecting
    private citizenPlanRepo planRepo;
    @Autowired
    private ExcelGenerator excelGenerator;
    @Autowired
    private PdfGenerator pdfGenerator;

    @Override
    public List<String> getPlanNames() {//my service method is calling my
        //repo method
        return  planRepo.getPlanName();

    }

    @Override
    public List<String> getPlanStatus() {
        return planRepo.getStatusName();
    }

    @Override//controller should call the method and send data to the UI
    public List<citizenPlan> search(SeachRequest request) {

        // i need to apply filter of data based on by searchRequest
        citizenPlan entity =new citizenPlan();
//                //copy the data from source (req) to target(cp)
//        BeanUtils.copyProperties(request,entity);

        // if the plan name is not null and plan name is not empty
        if(null!=request.getPlanName() && !"".equals(request.getPlanName())){
            entity.setPlanName(request.getPlanName());
        }
        if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())){
            entity.setPlanStatus(request.getPlanStatus());
        }
        if(null!=request.getGender() && !"".equals(request.getGender())){
            entity.setGender(request.getGender());
        }


        return planRepo.findAll(Example.of(entity));
        //using example we are generating query dynamically
    }

    @Override
    public boolean exportExcel(HttpServletResponse response) throws Exception {
      List<citizenPlan> plans= planRepo.findAll();
      excelGenerator.generate(response, plans);
      return true;
    }

    @Override
    public boolean exportPdf(HttpServletResponse response) throws Exception {
        List<citizenPlan> plans = planRepo.findAll();
        pdfGenerator.generate(response,plans);
        return true;
    }
}

//how who wil call service controller there for make it.