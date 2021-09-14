package com.LKS.newgang.auth;

import com.LKS.newgang.domain.Student;
import com.LKS.newgang.exceptions.NoSuchStudentException;
import com.LKS.newgang.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.LKS.newgang.security.ApplicationUserRole.ADMIN;
import static com.LKS.newgang.security.ApplicationUserRole.STUDENT;

@Repository("MariaDB")
@RequiredArgsConstructor
public class ApplicationUserDaoService implements ApplicationUserDao {

    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        try {
            Student student = loginRepository.findById(Integer.parseInt(username)).orElseThrow(NoSuchStudentException::new);
            return Optional.of(
                    new ApplicationUser(
                            String.valueOf(student.getNo()),
                            student.getPassword(),
                            student.getIsAdmin().equals('Y') ? ADMIN.getGrantedAuthorities() : STUDENT.getGrantedAuthorities(),
                            true,
                            true,
                            true,
                            true));
        } catch (NoSuchStudentException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
