package patika.fhw.demo.database.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import patika.fhw.demo.util.dbutil.BaseEntity;

@Entity
public class UserEntity extends BaseEntity {

    
    private String username;
    
    private String firstName;
    
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    
    private String photoLink;
    
    private boolean isEnable;



    @ManyToMany(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "role_id", nullable = false)
    private Set<RoleEntity> roles;



    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



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



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getPhotoLink() {
        return photoLink;
    }



    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }



    public boolean isEnable() {
        return isEnable;
    }



    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }



    public Set<RoleEntity> getRoles() {
        return roles;
    }



    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    


    }
