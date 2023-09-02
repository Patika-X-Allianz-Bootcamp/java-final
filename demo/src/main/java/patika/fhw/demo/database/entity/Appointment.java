package patika.fhw.demo.database.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import patika.fhw.demo.util.dbutil.BaseEntity;

@Entity
public class Appointment extends BaseEntity {
    private Date appointmentDate;
    
    @ManyToOne
    private Patient patient;
    
    @ManyToOne
    private Doctor doctor;

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getCreationTimestamp() {
        return null;
    }

    public void setValid(boolean b) {
    }

    
}
