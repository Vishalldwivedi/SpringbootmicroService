package in.vishal.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
public class citizenPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer citizenId;//autoincrement
    private String citizenName;
    private String gender;
    private String planName;
    private String planStatus;
    private LocalDate planStartDate;
    private LocalDate planEndDate;
    private Double benefitAmt;
    private String deniedReason;
    private LocalDate terminatedDate;
    private String terminatedRsn;


}
