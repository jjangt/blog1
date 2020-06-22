package com.green.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.board.FreeBoardService;
import com.green.biz.board.FreeBoardVO;

@Service("freeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardDAO freeBoardDao;
	
	@Override
	public FreeBoardVO getFreeBoard(int fseq) {

		return freeBoardDao.getFreeBoard(fseq);
	}

	@Override
	public List<FreeBoardVO> listFreeBoard(String m_id) {

		return freeBoardDao.listFreeBoard(m_id);
	}

	@Override
	public List<FreeBoardVO> listAllFreeBoard() {

		return freeBoardDao.listAllFreeBoard();
	}

	@Override
	public void insertFreeBoard(FreeBoardVO vo) {

		freeBoardDao.insertFreeBoard(vo);
	}

	@Override
	public void updateFreeBoard(FreeBoardVO vo) {

		freeBoardDao.updateFreeBoard(vo);
	}

	@Override
	public void deleteFreeBoard(int fseq) {

		freeBoardDao.deleteFreeBoard(fseq);
	}

	@Override
	public void plusFreeHit(int fseq) {

		freeBoardDao.plusFreeHit(fseq);
	}

	@Override
	public void deleteFreeBoardReply(int fseq) {

		freeBoardDao.deleteFreeBoardReply(fseq);
	}

	@Override
	public void updateFbUseyn(String m_id) {

		freeBoardDao.updateFbUseyn(m_id);
	}

	@Override
	public void resetFbUseyn(String m_id) {

		freeBoardDao.resetFbUseyn(m_id);
	}

}
