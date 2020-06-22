package com.green.biz.reply;

import java.util.Date;

import lombok.Data;

@Data
public class QnaReplyVO {
	private int qrseq;
	private String m_id;
	private String a_id;
	private int qseq;
	private String content;
	private Date regdate;
	private Date modifydate;
	private String useyn;
}
