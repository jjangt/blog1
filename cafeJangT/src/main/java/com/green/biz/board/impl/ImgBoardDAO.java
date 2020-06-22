package com.green.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.board.ImgBoardVO;

@Repository
public class ImgBoardDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public ImgBoardVO getImgBoard(int ibseq) {
		System.out.println("==> Mybatis로 getImgBoard() 기능 처리");
		
		return mybatis.selectOne("ImgBoardDAO.getImgBoard", ibseq);
	}
	
	public List<ImgBoardVO> listImgBoard(String m_id) {
		System.out.println("==> Mybatis로 listImgBoard() 기능 처리");
		
		return mybatis.selectList("ImgBoardDAO.listImgBoard", m_id);
	}
	
	public void insertImgBoard(ImgBoardVO vo) {
		System.out.println("==> Mybatis로 insertImgBoard() 기능 처리");
		
		mybatis.insert("ImgBoardDAO.insertImgBoard", vo);
	}
	
	public void updateImgBoard(ImgBoardVO vo) {
		System.out.println("==> Mybatis로 updateImgBoard() 기능 처리");

		mybatis.update("ImgBoardDAO.updateImgBoard", vo);
	}
	
	public List<ImgBoardVO> listAllImgBoard() {
		System.out.println("==> Mybatis로 listAllImgBoard() 기능 처리");

		return mybatis.selectList("ImgBoardDAO.listAllImgBoard");
	}
	
	public void deleteImgBoard(int ibseq) {
		System.out.println("==> Mybatis로 deleteImgBoard() 기능 처리");
		
		mybatis.delete("ImgBoardDAO.deleteImgBoard", ibseq);
	}
	
	public void plusImgHit(int ibseq) {
		System.out.println("==> Mybatis로 plustImgHit() 기능 처리");
		
		mybatis.update("ImgBoardDAO.plusImgHit", ibseq);
	}
	
	public void deleteImgBoardReply(int ibseq) {
		System.out.println("==>Mybytis로 deleteImgBoardReply() 기능 처리");
		
		mybatis.delete("ImgBoardDAO.deleteImgBoardReply", ibseq);
	}
	
	public void updateIbUseyn(String m_id) {
		System.out.println("==>Mybytis로 updateIbUseyn() 기능 처리");
		
		mybatis.update("ImgBoardDAO.updateIbUseyn", m_id);
	}
	
	public void resetIbUseyn(String m_id) {
		System.out.println("==>Mybytis로 resetIbUseyn() 기능 처리");
		
		mybatis.update("ImgBoardDAO.resetIbUseyn", m_id);
	}
}
