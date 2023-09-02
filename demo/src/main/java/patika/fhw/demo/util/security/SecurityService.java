package patika.fhw.demo.util.security;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import patika.fhw.demo.database.entity.AdminEntity;
import patika.fhw.demo.database.entity.Doctor;
import patika.fhw.demo.database.entity.Patient;
import patika.fhw.demo.database.entity.UserEntity;
import patika.fhw.demo.database.repository.AdminRepository;
import patika.fhw.demo.database.repository.DoctorRepository;
import patika.fhw.demo.database.repository.PatientRepository;
import patika.fhw.demo.database.repository.UserRepository;

@Service
public class SecurityService implements UserDetailsService {


    @Autowired
    UserRepository userEntityRepository;
    @Autowired
    AdminRepository adminEntityRepository;
    @Autowired 
    DoctorRepository doctorEntityRepository;
    @Autowired 
    PatientRepository patientEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = userEntityRepository.findByEmail(email);
        Optional<AdminEntity> admin = adminEntityRepository.findByEmail(email);
        Optional<Doctor> doctor = doctorEntityRepository.findByEmail(email);
        Optional<Patient> patient = patientEntityRepository.findByEmail(email);

        if (user.isEmpty() && admin.isEmpty() && doctor.isEmpty() && patient.isEmpty()) {
            throw new UsernameNotFoundException("Could not findUser with email =" + email);
        }

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        if (user.isPresent()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(email, user.get().getPassword(), authorities);
        }

        if (patient.isPresent()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_PATIENT"));
            return new User(email, patient.get().getPassword(), authorities);
        }

        if (admin.isPresent()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User(email, admin.get().getPassword(), authorities);
        } 
        
        if (doctor.isPresent()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_DOCTOR"));
            return new User(email, doctor.get().getPassword(), authorities);
        } 
        

        throw new UsernameNotFoundException("Could not find user with email: " + email);
                

    }
}
