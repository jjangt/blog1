package com.green.biz.qna;

import java.util.List;

import com.green.biz.qna.QnaVO;

public interface QnaService {

	// id가 조건이므로 매개변수 String id
	List<QnaVO> listQna(String m_id);

	QnaVO getQna(int seq);

	void insertQna(QnaVO qnaVO);

	List<QnaVO> listAllQna();

	void updateQna(QnaVO qnaVO);
	
	void deleteQna(int qseq);
	
	void updateQnaUseyn(String m_id);
	
	void resetQnaUseyn(String m_id);
}