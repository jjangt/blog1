package com.green.biz.board;

import java.util.List;

import com.green.biz.board.FreeBoardVO;

public interface FreeBoardService {
	
	FreeBoardVO getFreeBoard(int fseq);
	
	List<FreeBoardVO> listFreeBoard(String m_id);
	
	List<FreeBoardVO> listAllFreeBoard();
	
	void insertFreeBoard(FreeBoardVO vo);

	void updateFreeBoard(FreeBoardVO vo);
	
	void deleteFreeBoard(int fseq);
	
	void plusFreeHit(int fseq);
	
	void deleteFreeBoardReply(int fseq);
	
	void updateFbUseyn(String m_id);
	
	void resetFbUseyn(String m_id);
}
