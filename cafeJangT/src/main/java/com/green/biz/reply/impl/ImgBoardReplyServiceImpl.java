package com.green.biz.reply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.reply.ImgBoardReplyService;
import com.green.biz.reply.ImgBoardReplyVO;

@Service("imgBoardReplyService")
public class ImgBoardReplyServiceImpl implements ImgBoardReplyService {

	@Autowired
	private ImgBoardReplyDAO imgBoardReplyDao;
	
	@Override
	public List<ImgBoardReplyVO> getImgBoardReplyList(int ibseq) {

		return imgBoardReplyDao.getImgBoardReplyList(ibseq);
	}

	@Override
	public void saveImgBoardReply(ImgBoardReplyVO ibrVO) {

		imgBoardReplyDao.saveImgBoardReply(ibrVO);
	}

	@Override
	public void updateImgBoardReply(ImgBoardReplyVO ibrVO) {

		imgBoardReplyDao.updateImgBoardReply(ibrVO);
	}

	@Override
	public void deleteImgBoardReply(int ibrseq) {

		imgBoardReplyDao.deleteImgBoardReply(ibrseq);
	}

	@Override
	public void saveAdminImgBoardReply(ImgBoardReplyVO ibrVO) {

		imgBoardReplyDao.saveAdminImgBoardReply(ibrVO);
	}

	@Override
	public void updateIbrUseyn(String m_id) {

		imgBoardReplyDao.updateIbrUseyn(m_id);
	}

	@Override
	public void resetIbrUseyn(String m_id) {

		imgBoardReplyDao.resetIbrUseyn(m_id);
	}

}
