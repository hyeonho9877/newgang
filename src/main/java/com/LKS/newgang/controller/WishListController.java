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

    @PostMapping("/wishlist")
    @PreAuthorize(value = "hasAuthority('student:read')")
    public List<Lecture> wishlistPage(Authentication authentication){
        String name = authentication.getName();
        return wishListService.getList(name);
    }


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
