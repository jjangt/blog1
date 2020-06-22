package com.green.biz.reply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.reply.QnaReplyService;
import com.green.biz.reply.QnaReplyVO;

@Service("qnaReplyService")
public class QnaReplyServiceImpl implements QnaReplyService {

	@Autowired
	private QnaReplyDAO qnaReplyDao;
	
	@Override
	public List<QnaReplyVO> getQnaReplyList(int qseq) {

		return qnaReplyDao.getQnaReplyList(qseq);
	}

	@Override
	public void saveQnaReply(QnaReplyVO qrVO) {

		qnaReplyDao.saveQnaReply(qrVO);
	}

	@Override
	public void updateQnaReply(QnaReplyVO qrVO) {

		qnaReplyDao.updateQnaReply(qrVO);
	}

	@Override
	public void deleteQnaReply(int qrseq) {

		qnaReplyDao.deleteQnaReply(qrseq);
	}

	@Override
	public void saveAdminQnaReply(QnaReplyVO qrVO) {

		qnaReplyDao.saveAdminQnaReply(qrVO);
	}

	@Override
	public void updateQnarUseyn(String m_id) {

		qnaReplyDao.updateQnarUseyn(m_id);
	}

	@Override
	public void resetQnarUseyn(String m_id) {

		qnaReplyDao.resetQnarUseyn(m_id);
	}

}
