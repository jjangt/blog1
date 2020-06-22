package com.green.biz.reply;

import java.util.List;

public interface QnaReplyService {

	List<QnaReplyVO> getQnaReplyList(int qseq);
	
	void saveQnaReply(QnaReplyVO qrVO);
	
	void updateQnaReply(QnaReplyVO qrVO);
	
	void deleteQnaReply(int qrseq);
	
	void saveAdminQnaReply(QnaReplyVO qrVO);
	
	void updateQnarUseyn(String m_id);

	void resetQnarUseyn(String m_id);
}
