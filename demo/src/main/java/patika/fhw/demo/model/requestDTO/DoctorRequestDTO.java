package patika.fhw.demo.model.requestDTO;
import java.util.List;

import patika.fhw.demo.util.dbutil.BaseDTO;

public class DoctorRequestDTO extends BaseDTO{
    
    private String firstName;
    private String lastName;
    private String specialty;
    private List<String> languages;
    private String email;
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
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public List<String> getLanguages() {
        return languages;
    }
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}

