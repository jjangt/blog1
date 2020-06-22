package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.green.biz.admin.AdminVO;
import com.green.biz.board.FreeBoardService;
import com.green.biz.board.FreeBoardVO;
import com.green.biz.board.ImgBoardService;
import com.green.biz.board.ImgBoardVO;
import com.green.biz.qna.QnaService;
import com.green.biz.qna.QnaVO;

@Controller
@SessionAttributes("adminUser")
public class AdminBoardController {

	@Autowired
	private ImgBoardService imgBoardService;
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="admin_img_board_list")
	public String adminImgBoardListAll(HttpSession session, Model model) {
		
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			List<ImgBoardVO> imgBoardList = imgBoardService.listAllImgBoard();
			
			model.addAttribute("message", "등록된 게시글이 없습니다.");
			model.addAttribute("imgBoardList", imgBoardList);
			
			return "admin/img_board/imgBoardList";
		}
	}
	
	@RequestMapping(value="/admin_img_board_view")
	public String adminImgBoardView(@RequestParam(value="ibseq") int ibseq,
									HttpSession session, Model model) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			imgBoardService.plusImgHit(ibseq);
			ImgBoardVO imgBoardVO = imgBoardService.getImgBoard(ibseq);
			
			model.addAttribute("adminUser", adminUser);
			model.addAttribute("imgBoardVO", imgBoardVO);
			
			return "admin/img_board/imgBoardView";
		}
	}
	
	@RequestMapping(value="/admin_img_board_delete")
	public String deleteImgBoard(@RequestParam(value="ibseq") int ibseq,
								 HttpSession session) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			imgBoardService.deleteImgBoard(ibseq);
			
			return "redirect:/admin_img_board_list";
		}					
	}
	
	@RequestMapping(value="admin_free_board_list")
	public String adminFreeBoardListAll(HttpSession session, Model model) {
		
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			List<FreeBoardVO> freeBoardList = freeBoardService.listAllFreeBoard();
			
			model.addAttribute("message", "등록된 게시글이 없습니다.");
			model.addAttribute("freeBoardList", freeBoardList);
			
			return "admin/free_board/freeBoardList";
		}
	}
	
	@RequestMapping(value="/admin_free_board_view")
	public String adminFreeBoardView(@RequestParam(value="fseq") int fseq,
									HttpSession session, Model model) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			freeBoardService.plusFreeHit(fseq);
			FreeBoardVO freeBoardVO = freeBoardService.getFreeBoard(fseq);
			
			model.addAttribute("adminUser", adminUser);
			model.addAttribute("freeBoardVO", freeBoardVO);
			
			return "admin/free_board/freeBoardView";
		}
	}
	
	@RequestMapping(value="/admin_free_board_delete")
	public String deleteFreeBoard(@RequestParam(value="fseq") int fseq,
								  HttpSession session) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			freeBoardService.deleteFreeBoard(fseq);
			
			return "redirect:/admin_free_board_list";
		}					
	}
	
	@RequestMapping(value="/admin_qna_list")
	public String adminQnaListAll(HttpSession session, Model model) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			List<QnaVO> qnaList = qnaService.listAllQna();
			
			model.addAttribute("message", "등록된 게시글이 없습니다.");
			model.addAttribute("qnaList", qnaList);
			
			return "admin/qna/qnaList";
		}
	}
	
	@RequestMapping(value="/admin_qna_view")
	public String adminQnaView(@RequestParam(value="qseq") int qseq,
								  HttpSession session, Model model) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/admin_main";
		} else {
			QnaVO qnaVO = qnaService.getQna(qseq);
			
			model.addAttribute("adminUser", adminUser);
			model.addAttribute("qnaVO", qnaVO);
			
			return "admin/qna/qnaView";
		}
	}
	
	@RequestMapping(value="/admin_qna_delete")
	public String deleteQna(@RequestParam(value="qseq") int qseq,
								  HttpSession session) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			qnaService.deleteQna(qseq);
			
			return "redirect:/admin_qna_list";
		}					
	}
}
