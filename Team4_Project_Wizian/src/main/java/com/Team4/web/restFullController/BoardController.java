package com.Team4.web.restFullController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Team4.web.entity.Inquiry;
import com.Team4.web.model.BoardModel;
import com.Team4.web.service.BoardService;
import com.Team4.web.service.InquiryService;
import com.Team4.web.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

@RestController
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Autowired Util util;
	
	@GetMapping("/inquiryhistory")
	@ResponseBody
	public String inquiryHistory(HttpSession httpSession) {
	    Object session = util.getSession().getAttribute("userNo");
	    System.out.println(session);
	    List<BoardModel> boardList = boardService.boardList(session);

	    // ObjectMapper를 사용하여 List<BoardModel>을 JSON 문자열로 변환
	    ObjectMapper objectMapper = new ObjectMapper();
	    String jsonBoardList = "";
	    try {
	        jsonBoardList = objectMapper.writeValueAsString(boardList);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        // JSON 변환 중 예외가 발생한 경우 빈 문자열 반환
	    }

	    System.out.println("확인" + jsonBoardList);
	    return jsonBoardList;
	}

}