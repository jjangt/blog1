package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.board.FreeBoardService;
import com.green.biz.board.FreeBoardVO;
import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;

@Controller
public class FreeBoardController {

	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping(value="/free_board_list", method=RequestMethod.GET)
	public String freeBoardListAll(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			List<FreeBoardVO> freeBoardList = freeBoardService.listAllFreeBoard();
			model.addAttribute("message", "등록된 게시글이 없습니다.");
			model.addAttribute("freeBoardList", freeBoardList);
			
			return "free_board/freeBoardList";
		}
	}
	
	@RequestMapping(value="/free_board_view")
	public String freeBoardView(@RequestParam(value="fseq") int fseq,
								HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			freeBoardService.plusFreeHit(fseq);
			FreeBoardVO freeBoardVO = freeBoardService.getFreeBoard(fseq);
			
			model.addAttribute("loginUser", loginUser);
			model.addAttribute("freeBoardVO", freeBoardVO);
			
			return "free_board/freeBoardView";
		}
	}
	
	@RequestMapping(value="free_board_write_form")
	public String freeBoardWriteView(HttpSession session) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			return "free_board/freeBoardWrite";
		}
	}
	
	@RequestMapping(value="free_board_write")
	public String freeBoardWrite(FreeBoardVO vo, HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setM_id(loginUser.getId());
			
			freeBoardService.insertFreeBoard(vo);
			System.out.println(vo);
			
			return "redirect:/free_board_list";
		}
	}
	
	@RequestMapping(value="/free_board_delete")
	public String freeBoardDelete(@RequestParam(value="fseq") int fseq,
								  HttpSession session) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			freeBoardService.deleteFreeBoard(fseq);
		
			return "redirect:/free_board_list";
		}
	}
	
	@RequestMapping(value="/free_board_update_form")
	public String freeBoardUpdateView(HttpSession session, FreeBoardVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			FreeBoardVO freeBoardVO = freeBoardService.getFreeBoard(vo.getFseq());
			
			model.addAttribute("freeBoardVO", freeBoardVO);
			
			return "free_board/freeBoardUpdate";
		}
	}
	
	@RequestMapping(value="/free_board_update")
	public String freeBoardUpdate(FreeBoardVO vo, HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setM_id(loginUser.getId());
			
			freeBoardService.updateFreeBoard(vo);
			
			return "redirect:/free_board_view?fseq="+vo.getFseq();
		}
	}
	
	@RequestMapping(value="/my_free_board")
	public String myFreeBoardList(FreeBoardVO vo, HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			List<FreeBoardVO> freeBoardList = freeBoardService.listFreeBoard(vo.getM_id());
			
			model.addAttribute("freeBoardList", freeBoardList);
			
			return "free_board/myFreeBoardList";
		}
	}
}
