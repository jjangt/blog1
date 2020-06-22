package com.green.biz.admin;

public interface AdminService {
	
	public AdminVO getAdmin(String id);
	
	public AdminVO loginAdmin(AdminVO vo);
	
	public void updateAdmin(AdminVO vo);
}
