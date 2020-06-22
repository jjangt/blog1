package com.green.biz.board;

import java.util.Date;

import lombok.Data;

@Data
public class FreeBoardVO {
	private int fseq;
	private String m_id;
	private String subject;
	private String content;
	private int hit;
	private Date regdate;
	private String useyn;
}
