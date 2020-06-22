package com.green.biz.qna;

import java.util.Date;

import lombok.Data;

@Data
public class QnaVO {
	private int qseq;
	private String subject;
	private String content;
	private String m_id;
	private Date regdate;
	private String useyn;
}
