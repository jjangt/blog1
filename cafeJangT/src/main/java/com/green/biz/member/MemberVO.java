package com.green.biz.member;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private Date regdate;
	private String useyn;
}
