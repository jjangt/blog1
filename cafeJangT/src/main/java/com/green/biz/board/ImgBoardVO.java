package com.green.biz.board;

import java.util.Date;

import lombok.Data;

@Data
public class ImgBoardVO {
	private int ibseq;
	private String m_id;
	private String subject;
	private String content;
	private String thum_img;
	private String image1;
	private String image1_name;
	private String image1_brand;
	private int image1_price;
	private String image2;
	private String image2_name;
	private String image2_brand;
	private int image2_price;
	private String image3;
	private String image3_name;
	private String image3_brand;
	private int image3_price;
	private int hit;
	private Date regdate;
	private String useyn;
}
