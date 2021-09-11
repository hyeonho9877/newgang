package com.LKS.newgang.service;

import com.LKS.newgang.domain.Student;
import com.LKS.newgang.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public boolean authStudent(int studentID, String studentPassword){
        Optional<Student> result = loginRepository.findById(studentID);
        return result.map(student -> student.getPassword().equals(studentPassword)).orElse(Boolean.FALSE);
    }
}
