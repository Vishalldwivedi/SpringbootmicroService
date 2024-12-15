package in.vishal.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer passportId;

	private String passportNum;

	private LocalDate issuedDate;

	private LocalDate expiryDate;

	@OneToOne
	@JoinColumn(name = "person_id")// foregin key personID
	private Person person;

	public Integer getPassportId() {
		return passportId;
	}

	public void setPassportId(Integer passportId) {
		this.passportId = passportId;
	}

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}

	public LocalDate getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Person getPerson() {
		return person;
	}

	@Override
	public String toString() {
		return "Passport{" +
				"passportId=" + passportId +
				", passportNum='" + passportNum + '\'' +
				", issuedDate=" + issuedDate +
				", expiryDate=" + expiryDate +
				", person=" + person +
				'}';
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
