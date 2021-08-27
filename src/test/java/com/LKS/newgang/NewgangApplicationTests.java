package com.LKS.newgang;

import com.LKS.newgang.domain.Department;
import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.domain.Major;
import com.LKS.newgang.domain.WishList;
import com.LKS.newgang.repository.SearchRepository;
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
    private SearchRepository searchRepository;
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
        Lecture lecture = new Lecture();
        Department department = new Department();
        Major major = new Major();

        department.setDepartmentName("컴퓨터공학부");
        major.setMajorName("컴퓨터공학");
        lecture.setLectureName("컴퓨터과학개론");

        lecture.setDepartment(department);
        lecture.setMajor(major);
        searchRepository.save(lecture);
        List<Lecture> lectureList = new ArrayList<>();
        lectureList.add(lecture);
        assertThat(lectureList.equals(searchService.findByDepartment(department.getDepartmentName())));
        assertThat(lectureList.equals(searchService.findByMajor(major.getMajorName())));
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
    void 캠퍼스정보_TC01(){
        List<HashMap<String, ArrayList<String>>> campusInfo = searchService.getCampusInfo();
        for (HashMap<String, ArrayList<String>> target : campusInfo) {
            for(String key : target.keySet()){
                System.out.println("current key : "+key);
                for(String source : target.get(key)){
                    System.out.print(source);
                }
                System.out.println();
            }
        }
    }

}