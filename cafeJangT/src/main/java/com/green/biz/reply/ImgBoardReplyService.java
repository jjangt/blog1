package com.green.biz.reply;

import java.util.List;

public interface ImgBoardReplyService {
	List<ImgBoardReplyVO> getImgBoardReplyList(int ibseq);
	
	void saveImgBoardReply(ImgBoardReplyVO ibrVO);
	
	void updateImgBoardReply(ImgBoardReplyVO ibrVO);
	
	void deleteImgBoardReply(int ibrseq);
	
	void saveAdminImgBoardReply(ImgBoardReplyVO ibrVO);
	
	void updateIbrUseyn(String m_id);
	
	void resetIbrUseyn(String m_id);
}
