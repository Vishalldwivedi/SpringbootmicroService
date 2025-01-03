package in.vishal.entity;

import javax.persistence.*;

@Entity
@Table(name="ELIG_DTLS")
public class EligEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer edgTraceId;

    private String planStatus;

    private Double benefitAmt;

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

    public Double getBenefitAmt() {
        return benefitAmt;
    }

    public void setBenefitAmt(Double benefitAmt) {
        this.benefitAmt = benefitAmt;
    }

    public Integer getEdgTraceId() {
        return edgTraceId;
    }

    public void setEdgTraceId(Integer edgTraceId) {
        this.edgTraceId = edgTraceId;
    }
}
