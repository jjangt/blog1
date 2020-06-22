package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.member.MemberVO;
import com.green.biz.qna.QnaService;
import com.green.biz.qna.QnaVO;

@Controller
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	// get, post 둘 다 있을 때 제외하고는 method 따로 추가할 필요 없음
	@RequestMapping(value="/qna_list")
	public String qnaList(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";	// 로그인 페이지 호출
		} else {
			List<QnaVO> qnaList = qnaService.listQna(loginUser.getId());
			
			model.addAttribute("message", "등록된 Q&A가 없습니다.");
			model.addAttribute("qnaList", qnaList);
			System.out.println(qnaList);
			
			return "qna/qnaList";	// 게시글 조회
		}
	}
	
	// qna 상세보기
	// qnaList.jsp에 보면 qna_view?qseq가 있으므로 매개변수에 @RequestParam(value="qseq") int qseq로 해줌
	@RequestMapping(value="/qna_view")
	public String qnaView(@RequestParam(value="qseq") int qseq,
						  HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";	// 로그인 페이지 호출
		} else {
			QnaVO qnaVO = qnaService.getQna(qseq);
			
			// jsp 파일에 있는 ${qnaVO.뭐뭐뭐}를 보고 설정하면 된다.
			model.addAttribute("qnaVO",qnaVO);
			
			return "qna/qnaView";
		}
	}
	
	// qna 작성하기
	@RequestMapping(value="/qna_write_form")
	public String qanWriteView(HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";	// 로그인 페이지 호출
		} else {
			return "qna/qnaWrite";
		}
	}
	
	// 게시글 등록 모듈
	@RequestMapping(value="/qna_write")
	public String qnaWrite(QnaVO qnaVO, HttpSession session, Model model) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";	// 로그인 페이지 호출
		} else {
			// id만 넣어주면 된다.
			qnaVO.setM_id(loginUser.getId());
			
			qnaService.insertQna(qnaVO);
			
			return "redirect:/qna_list";
		}
		
	}
	
	// qna 게시글 수정 작성하기
	@RequestMapping(value="/qna_update_form")
	public String qnaUpdateView(@RequestParam(value="qseq") int qseq,
						  HttpSession session, Model model) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";	// 로그인 페이지 호출
		} else {
			QnaVO qnaVO = qnaService.getQna(qseq);
			
			// jsp 파일에 있는 ${qnaVO.뭐뭐뭐}를 보고 설정하면 된다.
			model.addAttribute("qnaVO",qnaVO);
			
			return "qna/qnaUpdate";
		}
	}
	
	@RequestMapping(value="/qna_update")
	public String qnaUpdate(QnaVO vo, HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");


		if(loginUser == null) {
			return "member/login";	// 로그인 페이지 호출
		} else {
			qnaService.updateQna(vo);
			
			return "redirect:/qna_list";
		}
	}
	
	@RequestMapping(value="/qna_delete")
	public String deleteQna(@RequestParam(value="qseq") int qseq,
							HttpSession session) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
		
			qnaService.deleteQna(qseq);
		
			return "redirect:/qna_list";
		}
	}
}
