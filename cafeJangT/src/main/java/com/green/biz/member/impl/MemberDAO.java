package com.green.biz.member.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.member.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 아이디가 존재하는지 확인하는 메소드
	public MemberVO getMember(String id) {
		System.out.println("--> Mybatis로 getMember() 기능 처리");
		
		return mybatis.selectOne("MemberDAO.getMember", id);
	}
	
	// 아이디와 비밀번호를 동시에 확인하는 메소드
	public MemberVO loginMember(MemberVO vo) {
		System.out.println("==> Mybatis로 loginMember() 기능 처리");
		
		return mybatis.selectOne("MemberDAO.loginMember", vo);
	}
		
	// 회원 등록
	public void insertMember(MemberVO vo) {
		System.out.println("==> Mybatis로 insertMember() 기능 처리");
		
		mybatis.insert("MemberDAO.insertMember", vo);
	}
	
	public MemberVO getMemberByNameAndEmail(MemberVO vo) {
		System.out.println("==> Mybatis로 getMemberByNameAndEmail() 기능 처리");
		
		return mybatis.selectOne("MemberDAO.getMemberByNameAndEmail", vo);
	}

	public MemberVO getMemberByIdAndNameAndEmail(MemberVO vo) {
		System.out.println("==> Mybatis로 getMemberByIdAndNameAndEmail() 기능 처리");
		
		return mybatis.selectOne("MemberDAO.getMemberByIdAndNameAndEmail", vo);
	}
	
	/*
	 *  회원관리(사용자)
	 */
	public List<MemberVO> listMember(String name) {
		System.out.println("==> Mybatis로 listMember() 기능 처리");
		
		return mybatis.selectList("MemberDAO.listMember", name);
	}
	
	public void updateMember(MemberVO vo) {
		System.out.println("==> Mybatis로 updateMember() 기능 처리");
		
		mybatis.update("MemberDAO.updateMember", vo);
	}
	
	// 테스트 해보자
	public void updateMemberUseyn(String id) {
		System.out.println("==> Mybatis로 updateMemberUseyn() 기능 처리");
		
		mybatis.update("MemberDAO.updateMemberUseyn", id);
	}
	
	public void resetMemberUseyn(String id) {
		System.out.println("==> Mybatis로 resetMemberUseyn() 기능 처리");
		
		mybatis.update("MemberDAO.resetMemberUseyn", id);
	}
	
	/*
	 * 회원리스트(관리자)
	 */
	public List<MemberVO> getMemberAllList() {
		System.out.println("==> Mybatis로 getMemberAllList() 기능 처리");
		
		return mybatis.selectList("MemberDAO.getMemberAllList");
	}
	
	public void adminDeleteMember(String id) {
		System.out.println("==> Mybatis로 adminDeleteMember() 기능 처리");
		
		mybatis.delete("MemberDAO.adminDeleteMember", id);
	}
}
