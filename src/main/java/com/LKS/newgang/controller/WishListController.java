package com.LKS.newgang.controller;

import com.LKS.newgang.domain.WishList;
import com.LKS.newgang.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 소망가방에 대한 유저의 요청을 담당하는 컨트롤러
 */
@RestController
@RequiredArgsConstructor
public class WishListController {

    private final WishListService wishListService;

    @PostMapping("/wishlist")
    public List<WishList> wishlistPage(HttpSession session){
        String stdID = String.valueOf(session.getAttribute("stdID"));
        return wishListService.getList(stdID);
    }

    /**
     * 소망가방 담기 신청
     * @param lectureNo 신청하려는 강의의 강의번호
     * @param session 유저와 서버간의 세션
     * @return 성공적으로 신청이 완료되면 ResponseEntity.ok(), 실패 시에는 badRequest 리턴
     */
    @GetMapping("/wishlist/apply")
    public ResponseEntity<?> apply(@RequestParam(name = "lectureNo") String lectureNo, HttpSession session){
        String stdID = String.valueOf(session.getAttribute("stdID"));
        String result = wishListService.apply(stdID, lectureNo);
        if(result.equals("신청이 완료되었습니다."))
            return ResponseEntity.ok(result);
        else return ResponseEntity.badRequest().body(result);
    }
}
