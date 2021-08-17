package com.LKS.newgang.service;

import com.LKS.newgang.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public boolean authStudent(int studentID, String studentPassword){
        return loginRepository.findById(studentID).map(student -> student.getPassword().equals(studentPassword)).orElse(Boolean.FALSE);
    }
}
