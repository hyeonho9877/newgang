package com.LKS.newgang.service;

import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.domain.Student;
import com.LKS.newgang.domain.WishList;
import com.LKS.newgang.repository.LectureRepository;
import com.LKS.newgang.repository.StudentRepository;
import com.LKS.newgang.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 소망가방 기능과 관련된 사용자의 요구에 대한 기능적인 작업처리를 담당하는 클래스
 */
@Service
@Transactional
@RequiredArgsConstructor
public class WishListService {

    private final WishListRepository wishListRepository;
    private final LectureRepository lectureRepository;
    private final StudentRepository studentRepository;

    /**
     * 사용자가 특정 강의에 대한 소망가방 담기를 희망할 때 실행되는 메소드
     *
     * @param stdID     현재 로그인하여 작업을 진행하고 있는 학생의 학생번호
     * @param lectureNo 소망가방에 담고자 하는 강의의 강의번호.
     * @return 신청 결과 성공여부에 따른 적절한 안내 메시지
     */
    public String apply(String stdID, String lectureNo) {

        List<WishList> wishlist = this.getList(stdID);

        if(currentStatus != statusOK)
            return "시스템 에러가 발생하였습니다. 에러 코드 : "+currentStatus;

        try {
            Lecture wantToApply = lectureRepository.findById(Integer.parseInt(lectureNo)).orElseThrow(NoSuchLectureException::new);// 현재 신청하기를 원하는 강의의 강의 시간
            Student student = studentRepository.findById(Integer.parseInt(stdID)).orElseThrow(NoSuchStudentException::new); // 현재 신청을 원하는 학생

            for (WishList registration : wishlist) {
                // 기존에 신청한 강의의 강의 시간
                Lecture target = lectureRepository.findById(registration.getLecNo().getNo()).orElseThrow();
                if(wantToApply.getLectureName().equals(target.getLectureName()))
                    return "이미 신청한 강의입니다.";
                // 신청하려는 강의와 기존에 신청한 강의의 강의 시간을 비교
                if (wantToApply.getTime().equals(target.getTime()))
                    return "기존에 신청한 강의와 강의 시간이 중복됩니다.";
            }

            // 겹치지 않는 경우 소망가방 신청 완료
            wishListRepository.save(new WishList(student, wantToApply));
            return "신청이 완료되었습니다.";
        } catch (NoSuchLectureException e) { // 강의 조회 실패
            currentStatus = noSuchLecture;
            return "시스템 에러가 발생하였습니다. 에러 코드 : "+currentStatus;
        } catch (NoSuchStudentException e){ // 학생 조회 실패
            currentStatus = noSuchStudent;
            return "시스템 에러가 발생하였습니다. 에러 코드 : "+currentStatus;
        }
    }

    /**
     * 특정 학생의 소망가방 리스트 조회 메소드
     * @param stdID 조회할 학생의 학생번호
     * @return 조회 결과에 따른 현재 상태 변화와 학생의 소망가방 내역이 담긴 새로운 List 객체
     */
    public List<WishList> getList(String stdID) {
        try {
            // 학생 번호로 소망가방 내역 조회
            List<WishList> result = wishListRepository.findByStdNoEquals(new Student(Integer.parseInt(stdID)));
            currentStatus = statusOK;
            return result;
        } catch (NoSuchElementException e) { // 학생번호로 소망가방 내역 조회 실패
            currentStatus = noSuchStudent;
            return new ArrayList<>();
        } catch (NumberFormatException e){ // stdID 변수의 Integer 형 변환 실패
            currentStatus = integerParsing;
            return new ArrayList<>();
        }
    }

    private int currentStatus = 0;

    private final int statusOK = 0;
    private final int noSuchStudent = 1;
    private final int noSuchLecture = 2;
    private final int integerParsing = 3;

    private class NoSuchLectureException extends Throwable{

    }

    private class NoSuchStudentException extends Throwable{

    }
}
