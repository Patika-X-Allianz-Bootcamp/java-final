package patika.fhw.demo.model.dto;

import java.util.Date;

import patika.fhw.demo.util.dbutil.BaseDTO;

public class AppointmentDTO extends BaseDTO{
    private Long id;
    private String patientId;
    private String doctorId;
    private String hospitalId;
    private Date appointmentDate;
    private String status;
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
    public String getHospitalId() {
        return hospitalId;
    }
    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }
    public Date getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    

    
}
