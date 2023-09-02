package patika.fhw.demo.model.requestDTO;

import java.util.Date;

import patika.fhw.demo.util.dbutil.BaseDTO;

public class PatientRequestDTO extends BaseDTO {
    
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String nationality;
    private String phoneNumber;
    private String email;
    private String medicalHistory;
    private String password;
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMedicalHistory() {
        return medicalHistory;
    }
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
