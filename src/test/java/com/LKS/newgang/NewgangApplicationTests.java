package com.LKS.newgang;

import com.LKS.newgang.service.LoginService;
import com.LKS.newgang.service.SearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
}