package com.LKS.newgang;

import com.LKS.newgang.domain.*;
import com.LKS.newgang.repository.*;
import com.LKS.newgang.service.EnrolmentService;
import com.LKS.newgang.service.LoginService;
import com.LKS.newgang.service.SearchService;
import com.LKS.newgang.service.WishListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@Transactional
class NewgangApplicationTests {

    @Autowired
    private LoginService loginService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private WishListService wishListService;

    @Autowired
    private EnrolmentService enrolmentService;
    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private CampusRepository campusRepository;

    @Autowired
    private ColleagueRepository colleagueRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private MajorRepository majorRepository;

    @Autowired
    private EnrolmentRepository enrolmentRepository;
    @Test
    void 로그인_TC01() {
        assertThat(loginService.authStudent(201713883, "201713883")).isEqualTo(true);
    }

    @Test
    void 로그인_TC02() {
        assertThat(loginService.authStudent(201713883, "INVALID")).isEqualTo(false);
    }

    @Test
    void 로그인_TC03() {
        assertThat(loginService.authStudent(201813883, "201713883")).isEqualTo(false);
    }

    @Test
    void 학생정보채움_TC01() {

        String[] stdInfo = new String[4];
        stdInfo[0] = "수원주간";
        stdInfo[1] = "소프트웨어경영대학";
        stdInfo[2] = "컴퓨터공학부";
        stdInfo[3] = "";

        Optional<HashMap<String, String>> hashMap = searchService.stdBelonging("201713883");

        if (hashMap.isEmpty())
            fail("빈 해쉬맵");

        HashMap<String, String> result = hashMap.get();
        List<String> keySet = List.of("campus", "colleague", "department", "major");

        for (int i = 0; i < keySet.size(); i++) {
            assertThat(result.get(keySet.get(i))).isEqualTo(stdInfo[i]);
        }

    }

    @Test
    void 학생정보채움_TC02(){
        String[] stdInfo = new String[4];
        stdInfo[0] = "수원주간";
        stdInfo[1] = "인문대학";
        stdInfo[2] = "글로벌어문학부";
        stdInfo[3] = "독어독문전공";

        Optional<HashMap<String, String>> hashMap = searchService.stdBelonging("201710253");

        if (hashMap.isEmpty())
            fail("빈 해쉬맵");

        HashMap<String, String> result = hashMap.get();
        List<String> keySet = List.of("campus", "colleague", "department", "major");

        for (int i = 0; i < keySet.size(); i++) {
            assertThat(result.get(keySet.get(i))).isEqualTo(stdInfo[i]);
        }
    }

    @Test
    void 학생정보채움_TC03(){
        Optional<HashMap<String, String>> hashMap = searchService.stdBelonging("201713884");

        if(hashMap.isPresent())
            fail("비어있어야함");
    }

    @Test
    void 학생정보채움_TC04(){
        Optional<HashMap<String, String>> hashMap = searchService.stdBelonging("Not Integer Value");

        if(hashMap.isPresent())
            fail("비어있어야함");
    }

    @Test
    void 과목검색테스트() {
        assertThat(searchService.findByMajor(majorRepository.findById(24).orElseThrow()).size()).isEqualTo(1);
        assertThat(searchService.findByDepartment(departmentRepository.findById(1).orElseThrow()).size()).isEqualTo(3);
    }

    @Test
    void 소망가방담기(){
        wishlistApply_TC01();
        wishlistApply_TC02();
        wishlistApply_TC03();
        wishlistApply_TC04();
    }

    @Test
    void wishlistApply_TC01(){
        assertThat(wishListService.apply("201713883","2")).isEqualTo("신청이 완료되었습니다.");
    }

    @Test
    void wishlistApply_TC02(){
        assertThat(wishListService.apply("999999999","1")).isEqualTo("시스템 에러가 발생하였습니다. 에러 코드 : 1");
    }

    @Test
    void wishlistApply_TC03(){
        assertThat(wishListService.apply("201713883","4")).isEqualTo("시스템 에러가 발생하였습니다. 에러 코드 : 2");
    }

    @Test
    void wishlistApply_TC04(){
        assertThat(wishListService.apply("STRING","1")).isEqualTo("시스템 에러가 발생하였습니다. 에러 코드 : 3");
    }

    @Test
    void 소망가방조회(){
        wishlistInquiry_TC01();
        wishlistInquiry_TC02();
        wishlistInquiry_TC03();
    }

    @Test
    void wishlistInquiry_TC01(){
        List<WishList> result = wishListService.getList("201713883");
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    void wishlistInquiry_TC02(){
        List<WishList> result = wishListService.getList("999999999");
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void wishlistInquiry_TC03(){
        List<WishList> result = wishListService.getList("STRING");
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void 수강신청() {
        enrolmentListApply_TC01();
        enrolmentListApply_TC02();
        enrolmentListApply_TC03();
        enrolmentListApply_TC04();
    }
    void 수강신청조회() {

    }
    @Test
    void 소망가방자동수강신청() {
        wishListService.apply("201713883","2");
        enrolmentService.applyAuto("201713883");
        assertThat(wishListService.getList("201713883").size()).isEqualTo(enrolmentService.getList("201713883"));
    }
    @Test
    void enrolmentListInquiry_TC01(){
        List<Enrolment> result = enrolmentService.getList("201713739");
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    void enrolmentListInquiry_TC02(){
        List<Enrolment> result = enrolmentService.getList("999999999");
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    void enrolmentListInquiry_TC03(){
        List<Enrolment> result = enrolmentService.getList("STRING");
        assertThat(result.size()).isEqualTo(0);
    }
    @Test
    void enrolmentListApply_TC01(){
        assertThat(enrolmentService.apply("201713123","2")).isEqualTo("신청이 완료되었습니다.");
    }

    @Test
    void enrolmentListApply_TC02(){
        assertThat(enrolmentService.apply("999999999","1")).isEqualTo("시스템 에러가 발생하였습니다. 에러 코드 : 1");
    }

    @Test
    void enrolmentListApply_TC03(){
        assertThat(enrolmentService.apply("201713123","4")).isEqualTo("시스템 에러가 발생하였습니다. 에러 코드 : 2");
    }

    @Test
    void enrolmentListApply_TC04(){
        assertThat(enrolmentService.apply("STRING","1")).isEqualTo("시스템 에러가 발생하였습니다. 에러 코드 : 3");
    }
    /*@Test
    void 교내캠퍼스구분(){
        HashMap<Campus, HashMap<Colleague, HashMap<Department, ArrayList<Major>>>> campusInfo = searchService.getCampusInfo();
        for(Campus campus:campusInfo.keySet()){
            System.out.println("campus : "+campus.getCampusName());
            for (Colleague colleague : campusInfo.get(campus).keySet()) {
                System.out.println("colleague : " + colleague.getColleagueName());
                for (Department department : campusInfo.get(campus).get(colleague).keySet()) {
                    System.out.println(department.getDepartmentName());
                    for (Major major : campusInfo.get(campus).get(colleague).get(department)) {
                        System.out.println("major : "+major.getMajorName());
                    }
                }
            }
        }
    }*/

    @Test
    void 캠퍼스구분출력(){
        campus();
        colleague();
        department();
        major();
    }

    @Test
    void campus(){
        for (Campus campus : campusRepository.findAll()) {
            System.out.println(campus.getCampusName());
        }
    }

    @Test
    void colleague(){
        for (Colleague colleague : colleagueRepository.findAll()) {
            System.out.println(colleague.getColleagueName());
        }
    }

    @Test
    void department(){
        for (Department department : departmentRepository.findAll()) {
            System.out.println(department.getDepartmentName());
        }
    }

    @Test
    void major(){
        for (Major major : majorRepository.findAll()) {
            System.out.println(major.getMajorName());
        }
    }

}