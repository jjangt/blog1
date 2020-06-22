package com.green.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.board.FreeBoardVO;

@Repository
public class FreeBoardDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public FreeBoardVO getFreeBoard(int fseq) {
		System.out.println("==> Mybatis로 getFreeBoard() 기능 처리");
		
		return mybatis.selectOne("FreeBoardDAO.getFreeBoard", fseq);
	}
	
	public List<FreeBoardVO> listFreeBoard(String m_id) {
		System.out.println("==> Mybatis로 listFreeBoard() 기능 처리");
		
		return mybatis.selectList("FreeBoardDAO.listFreeBoard", m_id);
	}
	
	public void insertFreeBoard(FreeBoardVO vo) {
		System.out.println("==> Mybatis로 insertFreeBoard() 기능 처리");
		
		mybatis.insert("FreeBoardDAO.insertFreeBoard", vo);
	}
	
	public void updateFreeBoard(FreeBoardVO vo) {
		System.out.println("==> Mybatis로 updateFreeBoard() 기능 처리");
		
		mybatis.update("FreeBoardDAO.updateFreeBoard", vo);
	}
	
	public List<FreeBoardVO> listAllFreeBoard() {
		System.out.println("==> Mybatis로 listAllFreeBoard() 기능 처리");
		
		return mybatis.selectList("FreeBoardDAO.listAllFreeBoard");
	}
	
	public void deleteFreeBoard(int fseq) {
		System.out.println("==> Mybatis로 deleteFreeBoard() 기능 처리");
		
		mybatis.delete("FreeBoardDAO.deleteFreeBoard", fseq);
	}
	
	public void plusFreeHit(int fseq) {
		System.out.println("==> Mybatis로 plusFreeHit() 기능 처리");
		
		mybatis.update("FreeBoardDAO.plusFreeHit", fseq);
	}
	
	public void deleteFreeBoardReply(int fseq) {
		System.out.println("==> Mybatis로 deleteFreeBoardReply() 기능 처리");
		
		mybatis.delete("FreeBoardReplyDAO.deleteFreeBoardReply", fseq);
	}
	
	public void updateFbUseyn(String m_id) {
		System.out.println("==> Mybatis로 updateFbUseyn() 기능 처리");
		
		mybatis.update("FreeBoardDAO.updateFbUseyn", m_id);
	}
	
	public void resetFbUseyn(String m_id) {
		System.out.println("==> Mybatis로 resetFbUseyn() 기능 처리");
		
		mybatis.update("FreeBoardDAO.resetFbUseyn", m_id);
	}
}
