package com.green.biz.reply;

import java.util.Date;

import lombok.Data;

@Data
public class FreeBoardReplyVO {
	private int fbrseq;
	private String m_id;
	private String a_id;
	private int fseq;
	private String content;
	private Date regdate;
	private Date modifydate;
	private String useyn;
}
