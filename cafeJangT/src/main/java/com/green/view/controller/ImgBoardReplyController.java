package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.green.biz.member.MemberVO;
import com.green.biz.reply.ImgBoardReplyService;
import com.green.biz.reply.ImgBoardReplyVO;

@RestController
public class ImgBoardReplyController {

	@Autowired
	private ImgBoardReplyService imgBoardReplyService;
	
	@RequestMapping(value="/img_save_comment", method=RequestMethod.POST)
	@ResponseBody
	public String saveImgBoardReply(ImgBoardReplyVO ibrVO, HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "fail";
		} else {
			String userId = loginUser.getId();
			
			ibrVO.setM_id(userId);
			ibrVO.setA_id(userId);
			
			imgBoardReplyService.saveImgBoardReply(ibrVO);
			
			return "success";
		}
	}
	
	@RequestMapping(value="/img_comment_list", method=RequestMethod.GET)
	public List<ImgBoardReplyVO> getImgBoardReplyList(ImgBoardReplyVO ibrVO) {
		int ibseq = ibrVO.getIbseq();
		
		System.out.println("게시판번호= " + ibseq);
		
		List<ImgBoardReplyVO> commentList = imgBoardReplyService.getImgBoardReplyList(ibseq);
		
		return commentList;
	}
}
