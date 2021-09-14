package com.LKS.newgang.controller;

import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 소망가방에 대한 유저의 요청을 담당하는 컨트롤러
 */
@RestController
@RequiredArgsConstructor
public class WishListController {

    private final WishListService wishListService;

    /**
     * 로그인한 학생의 소망가방 리스트 전송
     * @param authentication 로그인한 학생의 정보
     * @return 소망가방 리스트
     */
    @PostMapping("/wishlist")
    @PreAuthorize(value = "hasAuthority('student:read')")
    public List<Lecture> wishlistPage(Authentication authentication){
        String name = authentication.getName();
        return wishListService.getList(name);
    }

    /**
     * 로그인한 학생이 신청한 과목을 소망가방 리스트에 추가
     * @param lectureNo 신청하려는 강의 번호
     * @param authentication 로그인한 학생의 정보
     * @return 처리 결과에 따른 HttpResponse
     */
    @GetMapping("/wishlist/apply")
    @PreAuthorize(value = "hasAuthority('student:read')")
    public ResponseEntity<?> apply(@RequestParam(name = "lectureNo") String lectureNo, Authentication authentication){
        String stdID = authentication.getName();
        String result = wishListService.apply(stdID, lectureNo);
        if(result.equals("신청이 완료되었습니다."))
            return ResponseEntity.ok(result);
        else return ResponseEntity.badRequest().body(result);
    }
}
