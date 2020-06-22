package com.green.biz.qna.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.qna.QnaVO;

@Repository
public class QnaDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// id가 조건이므로 매개변수 String id
	public List<QnaVO> listQna(String m_id) {
		System.out.println("==> Mybatis로 listQna() 기능 처리");
		
		return mybatis.selectList("QnaDAO.listQna", m_id);
	}
	
	public QnaVO getQna(int seq) {
		System.out.println("==> Mybatis로 getQna() 기능 처리");
		
		return mybatis.selectOne("QnaDAO.getQna", seq);
	}
	
	public void insertQna(QnaVO qnaVO) {
		System.out.println("==> Mybatis로 insertQna() 기능 처리");

		mybatis.insert("QnaDAO.insertQna", qnaVO);
	}
	
	public List<QnaVO> listAllQna(){
		System.out.println("==> Mybatis로 listAllQna() 기능 처리");

		return mybatis.selectList("QnaDAO.listAllQna");
	}
	
	
	public void updateQna(QnaVO qnaVO) {
		System.out.println("==> Mybatis로 updateQna() 기능 처리");

		mybatis.update("QnaDAO.updateQna", qnaVO);
	}
	
	public void deleteQna(int qseq) {
		System.out.println("==> Mybatis로 deleteQna() 기능 처리");

		mybatis.delete("QnaDAO.deleteQna", qseq);
	}
	
	public void updateQnaUseyn(String m_id) {
		System.out.println("==> Mybatis로 updateQnaUseyn() 기능 처리");
		
		mybatis.update("QnaDAO.updateQnaUseyn", m_id);
	}
	
	public void resetQnaUseyn(String m_id) {
		System.out.println("==> Mybatis로 resetQnaUseyn() 기능 처리");
		
		mybatis.update("QnaDAO.resetQnaUseyn", m_id);
	}
}
