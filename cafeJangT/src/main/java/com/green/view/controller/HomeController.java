package com.green.view.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.biz.board.ImgBoardService;
import com.green.biz.board.ImgBoardVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ImgBoardService imgBoardService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(Model model) {
		
		// 새 이미지 조회 서비스 호출
//		List<ImgBoardVO> imgBoardList = imgBoardService.listImgBoard();
//		
//		model.addAttribute("imgBoardList", imgBoardList);
		
		
		// model 저장소에 베스트 상품, 신상품 저장 
		return "index";
	}
	
}
