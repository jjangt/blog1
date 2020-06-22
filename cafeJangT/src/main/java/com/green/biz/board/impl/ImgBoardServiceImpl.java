package com.green.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.board.ImgBoardService;
import com.green.biz.board.ImgBoardVO;

@Service("imgBoardService")
public class ImgBoardServiceImpl implements ImgBoardService {
	
	@Autowired
	private ImgBoardDAO imgBoardDao;
	
	@Override
	public ImgBoardVO getImgBoard(int ibseq) {

		return imgBoardDao.getImgBoard(ibseq);
	}

	@Override
	public List<ImgBoardVO> listImgBoard(String m_id) {

		return imgBoardDao.listImgBoard(m_id);
	}

	@Override
	public void insertImgBoard(ImgBoardVO vo) {

		imgBoardDao.insertImgBoard(vo);
	}

	@Override
	public void updateImgBoard(ImgBoardVO vo) {

		imgBoardDao.updateImgBoard(vo);
	}

	@Override
	public List<ImgBoardVO> listAllImgBoard() {

		return imgBoardDao.listAllImgBoard();
	}

	@Override
	public void deleteImgBoard(int ibseq) {

		imgBoardDao.deleteImgBoard(ibseq);
	}

	@Override
	public void plusImgHit(int ibseq) {

		imgBoardDao.plusImgHit(ibseq);
	}

	@Override
	public void deleteImgBoardReply(int ibseq) {

		imgBoardDao.deleteImgBoardReply(ibseq);
	}

	@Override
	public void updateIbUseyn(String m_id) {

		imgBoardDao.updateIbUseyn(m_id);
	}

	@Override
	public void resetIbUseyn(String m_id) {

		imgBoardDao.resetIbUseyn(m_id);
	}

}
