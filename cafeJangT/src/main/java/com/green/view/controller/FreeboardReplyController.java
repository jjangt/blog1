package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.green.biz.member.MemberVO;
import com.green.biz.reply.FreeBoardReplyService;
import com.green.biz.reply.FreeBoardReplyVO;

@RestController
public class FreeboardReplyController {
	
	@Autowired
	private FreeBoardReplyService freeBoardReplyService;
	
	@RequestMapping(value="/save_comment", method=RequestMethod.POST)
	@ResponseBody
	public String saveFreeBoardReply(FreeBoardReplyVO fbrVO, HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "fail";
		} else {
			String userId = loginUser.getId();
			
			fbrVO.setM_id(userId);
			fbrVO.setA_id(userId);
			
			freeBoardReplyService.saveFreeBoardReply(fbrVO);
			
			System.out.println(fbrVO);
			
			return "success";
		}
	}
	
	@RequestMapping(value="/comment_list", method=RequestMethod.GET)
	public List<FreeBoardReplyVO> getFreeBoardReplyList(FreeBoardReplyVO fbrVO) {
		int fseq = fbrVO.getFseq();
		
		System.out.println("게시판번호= " + fseq);
		
		List<FreeBoardReplyVO> commentList = freeBoardReplyService.getFreeBoardReplyList(fseq);
		
		return commentList;
	}
}
