package in.vishal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import in.vishal.reports.IReport;

@Service("reportService")
public class ReportService {// report service is dependent on the ireport


	@Autowired //here it is a field there for field it will become field injection by using reflection api field injection works
	// now ioc container will inject the dependent object to this excelreport variable byname will not work as there
	// is no bean named excelreport so it will do with byType but for datatype iReport two implementaion
	// r available so it will fail sol is to use -> primary or qualifier @
	@Qualifier("excel")
	private IReport excelreport;


	public void generate() {
		System.out.println("Injected :: " + excelreport.getClass().getName());
		excelreport.generateReport();
	}
}