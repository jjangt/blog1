package com.green.biz.reply.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.reply.FreeBoardReplyVO;

@Repository
public class FreeBoardReplyDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<FreeBoardReplyVO> getFreeBoardReplyList(int fseq) {
		System.out.println("==> Mybatis로 getFreeBoardReplyList() 기능 처리");
	
		return mybatis.selectList("FreeBoardReplyDAO.getFreeBoardReplyList", fseq);
	}
	
	public void saveFreeBoardReply(FreeBoardReplyVO fbrVO) {
		System.out.println("==> Mybatis로 saveFreeBoardReply() 기능 처리");
		
		mybatis.insert("FreeBoardReplyDAO.saveFreeBoardReply", fbrVO);
	}
	
	public void updateFreeBoardReply(FreeBoardReplyVO fbrVO) {
		System.out.println("==> Mybatis로 updateFreeBoardReply() 기능 처리");
		
		mybatis.update("FreeBoardReplyDAO.updateFreeBoardReply", fbrVO);
	}
	
	public void deleteFreeBoardReply(int fbrseq) {
		System.out.println("==> Mybatis로 deleteFreeBoardReply() 기능 처리");
		
		mybatis.delete("FreeBoardReplyDAO.deleteFreeBoardReply", fbrseq);
	}
	
	public void saveAdminFreeBoardReply(FreeBoardReplyVO fbrVO) {
		System.out.println("==> Mybatis로 saveAdminFreeBoardReply() 기능 처리");
		
		mybatis.insert("FreeBoardReplyDAO.saveAdminFreeBoardReply", fbrVO);
	}
	
	public void updateFbrUseyn(String m_id) {
		System.out.println("==> Mybatis로 updateFbrUseyn() 기능 처리");
		
		mybatis.update("FreeBoardReplyDAO.updateFbrUseyn", m_id);
	}
	
	public void resetFbrUseyn(String m_id) {
		System.out.println("==> Mybatis로 resetFbrUseyn() 기능 처리");
		
		mybatis.update("FreeBoardReplyDAO.resetFbrUseyn", m_id);
	}
}
