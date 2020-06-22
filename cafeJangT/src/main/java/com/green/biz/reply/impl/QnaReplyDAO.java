package com.green.biz.reply.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.reply.QnaReplyVO;

@Repository
public class QnaReplyDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<QnaReplyVO> getQnaReplyList(int qseq) {
		System.out.println("==> Mybatis로 getQnaReplyList() 기능 처리");
		
		return mybatis.selectList("QnaReplyDAO.getQnaReplyList", qseq);
	}
	
	public void saveQnaReply(QnaReplyVO qrVO) {
		System.out.println("==> Mybatis로 saveQnaReply() 기능 처리");
		
		mybatis.insert("QnaReplyDAO.saveQnaReply", qrVO);
	}
	
	public void updateQnaReply(QnaReplyVO qrVO) {
		System.out.println("==> Mybatis로 updateQnaReply() 기능 처리");
		
		mybatis.update("QnaReplyDAO.updateQnaReply", qrVO);
	}
	
	public void deleteQnaReply(int qrseq) {
		System.out.println("==> Mybatis로 deleteQnaReply() 기능 처리");
		
		mybatis.delete("QnaReplyDAO.deleteQnaReply", qrseq);
	}
	
	public void saveAdminQnaReply(QnaReplyVO qrVO) {
		System.out.println("==> Mybatis로 saveAdminQnaReply() 기능 처리");
		
		mybatis.insert("QnaReplyDAO.saveAdminQnaReply", qrVO);
	}

	public void updateQnarUseyn(String m_id) {
		System.out.println("==> Mybatis로 updateQnarUseyn() 기능 처리");
		
		mybatis.update("QnaReplyDAO.updateQnarUseyn", m_id);
	}
	
	public void resetQnarUseyn(String m_id) {
		System.out.println("==> Mybatis로 resetQnarUseyn() 기능 처리");
		
		mybatis.update("QnaReplyDAO.resetQnarUseyn", m_id);
	}
}
