package com.green.biz.admin.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.admin.AdminVO;

@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
		
	public AdminVO getAdmin(String id) {
		System.out.println("==> Mybatis로 getAdmin() 기능 처리");
		
		return mybatis.selectOne("AdminDAO.getAdmin", id);
	}
	
	public AdminVO loginAdmin(AdminVO vo) {
		System.out.println("==> Mybatis로 loginAdmin() 기능 처리");

		return mybatis.selectOne("AdminDAO.loginAdmin", vo);
	}
	
	public void updateAdmin(AdminVO vo) {
		System.out.println("==> Mybatis로 updateAdmin() 기능 처리");

		mybatis.update("AdminDAO.updateAdmin", vo);
	}
}
