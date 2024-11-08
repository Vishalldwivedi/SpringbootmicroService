package in.vishal.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import in.vishal.dao.IReportDao;
import in.vishal.dao.ReportDaoImpl;

@Service
public class ReportService {
	
	@Value("${report.type}")
	private String type;
	
	private IReportDao reportDao;

	public ReportService( IReportDao dao ) {// we need to injection object into this repoprtDAo variable .
		// we need to perform DI here this is constructor DI .
		this.reportDao = dao;
	}

	public void printName(Integer userId) {
		System.out.println("Report Type :: "+ type);
		String nameById = reportDao.getNameById(userId);
		System.out.println(nameById);
	}
}
