package com.green.biz.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.admin.AdminService;
import com.green.biz.admin.AdminVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDao;

	@Override
	public AdminVO getAdmin(String id) {

		return adminDao.getAdmin(id);
	}

	@Override
	public AdminVO loginAdmin(AdminVO vo) {

		return adminDao.loginAdmin(vo);
	}

	@Override
	public void updateAdmin(AdminVO vo) {

		adminDao.updateAdmin(vo);
	}
}
