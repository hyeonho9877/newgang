package com.LKS.newgang.service;

import com.LKS.newgang.domain.*;
import com.LKS.newgang.repository.EnrolmentRepository;
import com.LKS.newgang.repository.LectureRepository;
import com.LKS.newgang.repository.StudentRepository;
import com.LKS.newgang.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Transactional
@Service
@RequiredArgsConstructor
public class EnrolmentService {

    private final EnrolmentRepository enrolmentRepository;
    private final LectureRepository lectureRepository;
    private final StudentRepository studentRepository;
    private final WishListRepository wishListRepository;
    /**
     * 사용자가 특정 강의에 대한 소망가방 담기를 희망할 때 실행되는 메소드
     *
     * @param stdID     현재 로그인하여 작업을 진행하고 있는 학생의 학생번호
     * @param lectureNo 수강신청에 담고자 하는 강의의 강의번호.
     * @return 신청 결과 성공여부에 따른 적절한 안내 메시지
     */
    public String apply(String stdID, String lectureNo) {
        List<WishList> wishList = wishListRepository.findAll();
        List<Enrolment> enrolmentList = this.getList(stdID);

        if (currentStatus != statusOK)
            return "시스템 에러가 발생하였습니다. 에러 코드 : " + currentStatus;

        try {
            Lecture wantToApply = lectureRepository.findById(Integer.parseInt(lectureNo)).orElseThrow(NoSuchLectureException::new);// 현재 신청하기를 원하는 강의의 강의 시간
            Student student = studentRepository.findById(Integer.parseInt(stdID)).orElseThrow(NoSuchStudentException::new); // 현재 신청을 원하는 학생

            for (WishList ws : wishList) {//소망가방 자동추가

                if (student.isTransfer()) { // 편입생일 경우
                    if (ws.getLecNo().getMax_transfer() > ws.getLecNo().getCurr_transfer()) {
                        ws.getLecNo().setCurr_transfer(ws.getLecNo().getCurr_transfer()+1);
                        enrolmentRepository.save(new Enrolment(student, lectureRepository.findById(ws.getLecNo().getNo()).orElseThrow()));
                        continue;
                    }
                }
                else if (student.getGrade() == ws.getLecNo().getGrade()) {// 현재 학년이랑 과목 학년이랑 같은 경우
                    if (ws.getLecNo().getCurr_grade() < ws.getLecNo().getMax_grade()) {
                        ws.getLecNo().setCurr_grade(ws.getLecNo().getCurr_grade()+1);
                        enrolmentRepository.save(new Enrolment(student, lectureRepository.findById(ws.getLecNo().getNo()).orElseThrow()));
                        continue;
                    }
                }
                else if (student.getGrade() != ws.getLecNo().getGrade()) {// 현재 학년이랑 과목 학년이랑 다른 경우
                    if (ws.getLecNo().getCurr_other_grade() < ws.getLecNo().getMax_other_grade()) {
                        ws.getLecNo().setCurr_other_grade(ws.getLecNo().getCurr_other_grade()+1);
                        enrolmentRepository.save(new Enrolment(student, lectureRepository.findById(ws.getLecNo().getNo()).orElseThrow()));
                        continue;
                    }
                }
            }

            for (Enrolment registration : enrolmentList) {
                // 기존에 신청한 강의의 강의 시간
                String alreadyApplied = lectureRepository.findById(registration.getLec_no().getNo()).map(Lecture::getTime).orElseThrow();
                // 신청하려는 강의와 기존에 신청한 강의의 강의 시간을 비교
                if (wantToApply.getTime().equals(alreadyApplied))
                    return "기존에 신청한 강의와 강의 시간이 중복됩니다.";
            }


            // 겹치지 않는 경우 수강신청 완료
            enrolmentRepository.save(new Enrolment(student, wantToApply));
            return "신청이 완료되었습니다.";
        } catch (NoSuchLectureException e) { // 강의 조회 실패
            currentStatus = noSuchLecture;
            return "시스템 에러가 발생하였습니다. 에러 코드 : " + currentStatus;
        } catch (NoSuchStudentException e) { // 학생 조회 실패
            currentStatus = noSuchStudent;
            return "시스템 에러가 발생하였습니다. 에러 코드 : " + currentStatus;
        }
    }

    /**
     * 특정 학생의 수강신청 리스트 조회 메소드
     *
     * @param stdID 조회할 학생의 학생번호
     * @return 조회 결과에 따른 현재 상태 변화와 학생의 수강신청 내역이 담긴 새로운 List 객체
     */
    public List<Enrolment> getList(String stdID) {
        try {
            // 학생 번호로 수강신청 내역 조회
            List<Enrolment> result = enrolmentRepository.findByStdNoEquals(new Student(Integer.parseInt(stdID)));
            currentStatus = statusOK;
            return result;
        } catch (NoSuchElementException e) { // 학생번호로 소망가방 내역 조회 실패
            currentStatus = noSuchStudent;
            return new ArrayList<>();
        } catch (NumberFormatException e) { // stdID 변수의 Integer 형 변환 실패
            currentStatus = integerParsing;
            return new ArrayList<>();
        }
    }

    private int currentStatus = 0;

    private final int statusOK = 0;
    private final int noSuchStudent = 1;
    private final int noSuchLecture = 2;
    private final int integerParsing = 3;

    private class NoSuchLectureException extends Throwable {

    }

    private class NoSuchStudentException extends Throwable {

    }
}
