package com.green.biz.board;

import java.util.List;

import com.green.biz.board.ImgBoardVO;

public interface ImgBoardService {

	ImgBoardVO getImgBoard(int ibseq);

	List<ImgBoardVO> listImgBoard(String m_id);
	
	List<ImgBoardVO> listAllImgBoard();

	void insertImgBoard(ImgBoardVO vo);

	void updateImgBoard(ImgBoardVO vo);
	
	void deleteImgBoard(int ibseq);

	void plusImgHit(int ibseq);
	
	void deleteImgBoardReply(int ibseq);
	
	void updateIbUseyn(String m_id);

	void resetIbUseyn(String m_id);
}