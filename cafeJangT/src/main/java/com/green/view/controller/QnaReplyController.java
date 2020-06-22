package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.green.biz.member.MemberVO;
import com.green.biz.reply.QnaReplyService;
import com.green.biz.reply.QnaReplyVO;

@RestController
public class QnaReplyController {

	@Autowired
	private QnaReplyService qnaReplyService;
	
	@RequestMapping(value="/qna_save_comment", method=RequestMethod.POST)
	@ResponseBody
	public String saveQnaReply(QnaReplyVO qrVO, HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "fail";
		} else {
			String userId = loginUser.getId();
			
			qrVO.setM_id(userId);
			qrVO.setA_id(userId);
			
			qnaReplyService.saveQnaReply(qrVO);
			
			return "success";
		}
	}
	
	@RequestMapping(value="/qna_comment_list", method=RequestMethod.GET)
	public List<QnaReplyVO> getQnaReplyList(QnaReplyVO qrVO) {
		int qseq = qrVO.getQseq();
		
		System.out.println("게시판번호= " + qseq);
		
		List<QnaReplyVO> commentList = qnaReplyService.getQnaReplyList(qseq);
		
		System.out.println(commentList);
		
		return commentList;
	}
}
