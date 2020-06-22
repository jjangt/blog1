package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.green.biz.admin.AdminVO;
import com.green.biz.reply.FreeBoardReplyService;
import com.green.biz.reply.FreeBoardReplyVO;
import com.green.biz.reply.ImgBoardReplyService;
import com.green.biz.reply.ImgBoardReplyVO;
import com.green.biz.reply.QnaReplyService;
import com.green.biz.reply.QnaReplyVO;

@RestController
public class AdminReplyController {

	@Autowired
	private ImgBoardReplyService imgBoardReplyService;
	
	@Autowired
	private FreeBoardReplyService freeBoardReplyService;
	
	@Autowired
	private QnaReplyService qnaReplyService;
	
	@RequestMapping(value="/admin_img_save_comment", method=RequestMethod.POST)
	@ResponseBody
	public String saveAdminImgBoardReply(ImgBoardReplyVO ibrVO, HttpSession session) {
		
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "fail";
		} else {
			String userId = adminUser.getId();
			
			ibrVO.setA_id(userId);
			ibrVO.setM_id(userId);
			
			System.out.println(ibrVO);
			imgBoardReplyService.saveAdminImgBoardReply(ibrVO);
			
			return "success";
		}
	}
	
	@RequestMapping(value="/admin_img_comment_list", method=RequestMethod.GET)
	public List<ImgBoardReplyVO> getAdminImgBoardReplyList(ImgBoardReplyVO ibrVO) {
		int ibseq = ibrVO.getIbseq();
		
		System.out.println("게시판번호= " + ibseq);
		
		List<ImgBoardReplyVO> commentList = imgBoardReplyService.getImgBoardReplyList(ibseq);
		System.out.println(commentList);
		
		return commentList;
	}
	
	@RequestMapping(value="/admin_save_comment", method=RequestMethod.POST)
	@ResponseBody
	public String saveAdminFreeBoardReply(FreeBoardReplyVO fbrVO, HttpSession session) {
		
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "fail";
		} else {
			String userId = adminUser.getId();
			
			fbrVO.setA_id(userId);
			fbrVO.setM_id(userId);
			
			System.out.println(fbrVO);
			freeBoardReplyService.saveAdminFreeBoardReply(fbrVO);
			
			return "success";
		}
	}
	
	@RequestMapping(value="/admin_comment_list", method=RequestMethod.GET)
	public List<FreeBoardReplyVO> getAdminFreeBoardReplyList(FreeBoardReplyVO fbrVO) {
		int fseq = fbrVO.getFseq();
		
		System.out.println("게시판번호= " + fseq);
		
		List<FreeBoardReplyVO> commentList = freeBoardReplyService.getFreeBoardReplyList(fseq);
		System.out.println(commentList);
		
		return commentList;
	}
	
	@RequestMapping(value="/admin_qna_save_comment", method=RequestMethod.POST)
	@ResponseBody
	public String saveAdminQnaReply(QnaReplyVO qrVO, HttpSession session) {
		
		AdminVO adminUser = (AdminVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "fail";
		} else {
			String userId = adminUser.getId();
			
			qrVO.setA_id(userId);
			qrVO.setM_id(userId);
			
			qnaReplyService.saveAdminQnaReply(qrVO);
			
			return "success";
		}
	}
	
	@RequestMapping(value="/admin_qna_comment_list", method=RequestMethod.GET)
	public List<QnaReplyVO> getAdminQnaReplyList(QnaReplyVO qrVO) {
		int qseq = qrVO.getQseq();
		
		System.out.println("게시판번호= " + qseq);
		
		List<QnaReplyVO> commentList = qnaReplyService.getQnaReplyList(qseq);
		System.out.println(commentList);
		
		return commentList;
	}
}
