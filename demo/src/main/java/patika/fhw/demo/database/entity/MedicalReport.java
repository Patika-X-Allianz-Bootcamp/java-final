package patika.fhw.demo.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import patika.fhw.demo.util.dbutil.BaseEntity;

@Entity
public class MedicalReport extends BaseEntity {
    private String reportTitle;
    
    @Lob
    private String reportDetails;
    
    @ManyToOne
    private Patient patient;

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    
}
