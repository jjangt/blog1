package com.green.biz.reply.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.reply.ImgBoardReplyVO;


@Repository
public class ImgBoardReplyDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<ImgBoardReplyVO> getImgBoardReplyList(int ibseq) {
		System.out.println("==> Mybatis로 getImgBoardReplyList() 기능 처리");
	
		return mybatis.selectList("ImgBoardReplyDAO.getImgBoardReplyList", ibseq);
	}
	
	public void saveImgBoardReply(ImgBoardReplyVO ibrVO) {
		System.out.println("==> Mybatis로 saveImgBoardReply() 기능 처리");
		
		mybatis.insert("ImgBoardReplyDAO.saveImgBoardReply", ibrVO);
	}
	
	public void updateImgBoardReply(ImgBoardReplyVO ibrVO) {
		System.out.println("==> Mybatis로 updateImgBoardReply() 기능 처리");
		
		mybatis.update("ImgBoardReplyDAO.updateImgBoardReply", ibrVO);
	}
	
	public void deleteImgBoardReply(int ibrseq) {
		System.out.println("==> Mybatis로 deleteImgBoardReply() 기능 처리");
		
		mybatis.delete("ImgBoardReplyDAO.deleteImgBoardReply", ibrseq);
	}
	
	public void saveAdminImgBoardReply(ImgBoardReplyVO ibrVO) {
		System.out.println("==> Mybatis로 saveImgBoardReply() 기능 처리");

		mybatis.insert("ImgBoardReplyDAO.saveAdminImgBoardReply", ibrVO);
	}
	
	public void updateIbrUseyn(String m_id) {
		System.out.println("==> Mybatis로 updateIbrUseyn() 기능 처리");
		
		mybatis.update("ImgBoardReplyDAO.updateIbrUseyn", m_id);
	}

	public void resetIbrUseyn(String m_id) {
		System.out.println("==> Mybatis로 resetIbrUseyn() 기능 처리");
		
		mybatis.update("ImgBoardReplyDAO.resetIbrUseyn", m_id);
	}
}
