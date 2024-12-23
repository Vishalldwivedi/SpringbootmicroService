package in.vishal.response;

import lombok.Data;

@Data// to get getter and setter
public class Ticket {

	private Integer ticketId;
	private String from;
	private String to;
	private String ticketStatus;
	private String tktCost;
	private String trainNum;
}
