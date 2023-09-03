package allianz.healthtourism.entity;

import allianz.healthtourism.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseEntity {

    private String username;

    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    private boolean isEnable;

    @JsonCreator
    public User(@JsonProperty("username") String username, @JsonProperty("firstName")String firstName,
                @JsonProperty("lastName")String lastName, @JsonProperty("password")String password, @JsonProperty("email")String email,
                @JsonProperty("isEnable")boolean isEnable, @JsonProperty( "roles")Set<Role> roles) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.isEnable = isEnable;
        this.roles = roles;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {

    }
    {


    }
}

  /*@JoinTable(name = "user_group",joinColumns = @JoinColumn(name="user_id"))
    @JoinColumn(name = "group_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Group> group;*/