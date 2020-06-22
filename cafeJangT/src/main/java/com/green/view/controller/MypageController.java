package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.board.FreeBoardService;
import com.green.biz.board.FreeBoardVO;
import com.green.biz.board.ImgBoardService;
import com.green.biz.board.ImgBoardVO;
import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;
import com.green.biz.qna.QnaService;
import com.green.biz.reply.FreeBoardReplyService;
import com.green.biz.reply.ImgBoardReplyService;
import com.green.biz.reply.QnaReplyService;

@Controller
public class MypageController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@Autowired
	private FreeBoardReplyService freeBoardReplyService;
	
	@Autowired
	private ImgBoardService imgBoardService;
	
	@Autowired
	private ImgBoardReplyService imgBoardReplyService;
	
	@Autowired
	private QnaService qnaService;
	
	@Autowired
	private QnaReplyService qnaReplyService;
	
	@RequestMapping(value="/mypage_view")
	public String mypageView(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			model.addAttribute("id", loginUser.getId());
			
			return "member/mypageMain";
		}
	}
	
	@RequestMapping(value="/mypage_update_form")
	public String mypageUpdateView(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			model.addAttribute("memberVO", loginUser);
		
			return "member/mypageUpdate";
		}
	}
	
	@RequestMapping(value="/mypage_update")
	public String mypageUpdate(@RequestParam(value="mail_addr", defaultValue="") String email,
							   HttpSession session, MemberVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setEmail(email);
			System.out.println(vo);
			
			memberService.updateMember(vo);
			
			return "redirect:/mypage_view";
		}
	}
	
	@RequestMapping(value="/my_free_board_list")
	public String myFreeBoardList(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			List<FreeBoardVO> myFreeBoardList = freeBoardService.listFreeBoard(loginUser.getId());
			
			model.addAttribute("message", "등록된 게시글이 없습니다.");
			model.addAttribute("myFreeBoardList", myFreeBoardList);
			
			return "member/myFreeBoard";
		}
	}
	
	@RequestMapping(value="/my_free_board_view")
	public String myFreeBoardView(@RequestParam(value="fseq") int fseq,
								  HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			freeBoardService.plusFreeHit(fseq);
			FreeBoardVO freeBoardVO = freeBoardService.getFreeBoard(fseq);
			
			model.addAttribute("loginUser", loginUser);
			model.addAttribute("freeBoardVO", freeBoardVO);
			
			return "member/myFreeBoardView";
		}
	}
	
	@RequestMapping(value="/my_free_board_delete")
	public String myFreeBoardDelete(@RequestParam(value="fseq") int fseq,
									HttpSession session) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			freeBoardService.deleteFreeBoard(fseq);
			
			return "redirect:/my_free_board_list";
		}
	}
	
	@RequestMapping(value="/my_free_board_update_form")
	public String myFreeBoardUpdateView(HttpSession session, FreeBoardVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			FreeBoardVO freeBoardVO = freeBoardService.getFreeBoard(vo.getFseq());
			
			model.addAttribute("freeBoardVO", freeBoardVO);
			
			return "mypage/myFreeBoardUpdate";
		}
				
	}
	
	@RequestMapping(value="/my_free_board_update")
	public String myFreeBoardUpdate(FreeBoardVO vo, HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setM_id(loginUser.getId());
			
			freeBoardService.updateFreeBoard(vo);
			
			return "redirect:/my_free_board_view";
		}
	}
	
	@RequestMapping(value="/my_img_board_list")
	public String myImgBOardList(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			List<ImgBoardVO> myImgBoardList = imgBoardService.listImgBoard(loginUser.getId());
			
			model.addAttribute("message", "등록된 게시글이 없습니다.");
			model.addAttribute("myImgBoardList", myImgBoardList);
			
			return "member/myImgBoard";
		}
	}	
	
	@RequestMapping(value="/member_delete_form")
	public String memberDeleteView(MemberVO vo, HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			model.addAttribute("loginUserId", loginUser.getId());
			
			vo = memberService.getMember(loginUser.getId());
			System.out.println("사용자비밀번호:" + vo.getPwd());
			System.out.println("사용자아이디:" + vo.getId());
			
			model.addAttribute("loginUserPwd", vo.getPwd());

			return "member/deleteMember";
		}
	}
	
	@RequestMapping(value="/member_delete")
	public String memberDelete(@RequestParam(value="pwd") String pwd, 
							   MemberVO loginUser, MemberVO member, HttpSession session, Model model) {

		System.out.println(loginUser);
		memberService.getMember(loginUser.getId());
		memberService.getMember(member.getId());
		
		memberService.updateMemberUseyn(loginUser.getId());
		freeBoardService.updateFbUseyn(member.getId());
		freeBoardReplyService.updateFbrUseyn(member.getId());
		imgBoardService.updateIbUseyn(member.getId());
		imgBoardReplyService.updateIbrUseyn(member.getId());
		qnaService.updateQnaUseyn(member.getId());
		qnaReplyService.updateQnarUseyn(member.getId());
		
		System.out.println("loginUser:"+loginUser);
		System.out.println("member"+member);
		
//		memberService.deleteMember(loginUser);
		session.invalidate();
		
		return "redirect:/index";
	}
}
