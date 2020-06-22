package com.green.biz.reply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.board.impl.FreeBoardDAO;
import com.green.biz.reply.FreeBoardReplyService;
import com.green.biz.reply.FreeBoardReplyVO;

@Service("freeBoardReplyService")
public class FreeBoardReplyServiceImpl implements FreeBoardReplyService {
	
	@Autowired
	private FreeBoardReplyDAO freeBoardReplyDao;

	@Override
	public List<FreeBoardReplyVO> getFreeBoardReplyList(int fseq) {

		return freeBoardReplyDao.getFreeBoardReplyList(fseq);
	}

	@Override
	public void saveFreeBoardReply(FreeBoardReplyVO fbrVO) {

		freeBoardReplyDao.saveFreeBoardReply(fbrVO);
	}

	@Override
	public void updateFreeBoardReply(FreeBoardReplyVO fbrVO) {

		freeBoardReplyDao.updateFreeBoardReply(fbrVO);
	}

	@Override
	public void deleteFreeBoardReply(int fbrseq) {

		freeBoardReplyDao.deleteFreeBoardReply(fbrseq);
	}

	@Override
	public void saveAdminFreeBoardReply(FreeBoardReplyVO fbrVO) {

		freeBoardReplyDao.saveAdminFreeBoardReply(fbrVO);
	}

	@Override
	public void updateFbrUseyn(String m_id) {

		freeBoardReplyDao.updateFbrUseyn(m_id);
	}

	@Override
	public void resetFbrUseyn(String m_id) {

		freeBoardReplyDao.resetFbrUseyn(m_id);
	}

}
