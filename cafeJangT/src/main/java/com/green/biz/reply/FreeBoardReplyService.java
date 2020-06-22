package com.green.biz.reply;

import java.util.List;

import com.green.biz.reply.FreeBoardReplyVO;


public interface FreeBoardReplyService {
	
	List<FreeBoardReplyVO> getFreeBoardReplyList(int fseq);
	
	public void saveFreeBoardReply(FreeBoardReplyVO fbrVO);

	public void updateFreeBoardReply(FreeBoardReplyVO fbrVO);
	
	public void deleteFreeBoardReply(int fbrseq);
	
	public void saveAdminFreeBoardReply(FreeBoardReplyVO fbrVO);
	
	public void updateFbrUseyn(String m_id);
	
	public void resetFbrUseyn(String m_id);
}
