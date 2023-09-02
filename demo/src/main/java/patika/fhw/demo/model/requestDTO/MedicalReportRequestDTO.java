package patika.fhw.demo.model.requestDTO;

import patika.fhw.demo.util.dbutil.BaseDTO;

public class MedicalReportRequestDTO extends BaseDTO {
    
    private String description;
    private String diagnosis;
    private String treatmentPlan;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    
    
}
