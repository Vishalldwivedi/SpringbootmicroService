package in.vishal.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ReportDaoImpl implements IReportDao{

	public String getNameById(Integer userId) {
		if (userId == 100) {
			return "Vishal";
		} else if (userId == 101) {
			return "Rjt";
		} else {
			return "Name Not Found";
		}
	}
}
