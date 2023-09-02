package patika.fhw.demo.model.dto;

import java.util.Date;

import patika.fhw.demo.util.dbutil.BaseDTO;

public class MedicalReportDTO extends BaseDTO {
    private Long id;
    private String patientId;
    private String doctorId;
    private String diagnosis;
    private String treatmentPlan;
    private Date reportDate;
    private String notes;
    
    @Override
    public Long getId() {
        return id; 
    }
    @Override
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public String getTreatmentPlan() {
        return treatmentPlan;
    }
    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }
    public Date getReportDate() {
        return reportDate;
    }
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    

    
}
