package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.green.biz.admin.AdminService;
import com.green.biz.admin.AdminVO;
import com.green.biz.board.FreeBoardService;
import com.green.biz.board.ImgBoardService;
import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;
import com.green.biz.qna.QnaService;
import com.green.biz.reply.FreeBoardReplyService;
import com.green.biz.reply.ImgBoardReplyService;
import com.green.biz.reply.QnaReplyService;

@Controller
@SessionAttributes("adminUser")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
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
	
	@RequestMapping(value="/admin_main")
	public String adminMain() {
		return "admin/admin_main";
	}
	
	@RequestMapping(value="/userPage")
	public String userPage(SessionStatus status) {
		status.setComplete();
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="adminPage_view")
	public String adminPageView(HttpSession session, Model model) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			model.addAttribute("id", adminUser.getId());
			
			return "admin/member/adminPageMain";
		}
	}
	
	@RequestMapping(value="/adminPage_update_form")
	public String mypageUpdateView(HttpSession session, Model model) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			model.addAttribute("adminVO", adminUser);
		
			return "admin/member/adminPageUpdate";
		}
	}
	
	@RequestMapping(value="/adminPage_update")
	public String mypageUpdate(HttpSession session, AdminVO admin, Model model) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			System.out.println(admin);
			
			adminService.updateAdmin(admin);
			
			return "redirect:/adminPage_view";
		}
	}
	
	@RequestMapping(value="/admin_login_form")
	public String adminLoginView() {
		
		return "admin/member/admin_login";
	}

	@RequestMapping(value="/admin_login")
	public String adminLoginView(AdminVO vo, Model model) {
		
		AdminVO adminUser = adminService.loginAdmin(vo);
		
		if(adminUser != null) {
			model.addAttribute("adminUser", adminUser);
			
			return "admin/admin_main";
		} else {
			return "admin/member/login_fail";
		}
	}
	
	@RequestMapping(value="/admin_logout")
	public String adminLogout(SessionStatus status) {
		
		status.setComplete();
		
		return "redirect:/admin_main";
	}

	@RequestMapping(value="/admin_member_list")
	public String adminMemberListView(HttpSession session, Model model) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			List<MemberVO> memberList = memberService.getMemberAllList();
			
			model.addAttribute("message", "가입한 회원이 없습니다.");
			model.addAttribute("memberList", memberList);
			
			return "admin/member/memberList";
		}
	}
	
	@RequestMapping(value="/admin_member_delete")
	public String adminMemberDelete(MemberVO member, HttpSession session, Model model) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		memberService.getMember(member.getId());
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			memberService.updateMemberUseyn(member.getId());
			freeBoardService.updateFbUseyn(member.getId());
			freeBoardReplyService.updateFbrUseyn(member.getId());
			imgBoardService.updateIbUseyn(member.getId());
			imgBoardReplyService.updateIbrUseyn(member.getId());
			qnaService.updateQnaUseyn(member.getId());
			qnaReplyService.updateQnarUseyn(member.getId());
			
			return "redirect:/admin_member_list";
		}
	}
	
	@RequestMapping(value="/admin_member_reset")
	public String adminMemberReset(MemberVO member, HttpSession session, Model model) {
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		memberService.getMember(member.getId());
		
		if(adminUser == null) {
			return "admin/member/admin_login";
		} else {
			memberService.resetMemberUseyn(member.getId());
			freeBoardService.resetFbUseyn(member.getId());
			freeBoardReplyService.resetFbrUseyn(member.getId());
			imgBoardService.resetIbUseyn(member.getId());
			imgBoardReplyService.resetIbrUseyn(member.getId());
			qnaService.resetQnaUseyn(member.getId());
			qnaReplyService.resetQnarUseyn(member.getId());
			
			return "redirect:/admin_member_list";
		}
	}
}
