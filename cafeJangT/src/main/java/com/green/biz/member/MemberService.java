package com.green.biz.member;

import java.util.List;

import com.green.biz.member.MemberVO;

public interface MemberService {

	// 아이디가 존재하는지 확인하는 메소드
	MemberVO getMember(String id);

	// 아이디와 비밀번호를 동시에 확인하는 메소드
	MemberVO loginMember(MemberVO vo);

	// 회원 등록
	void insertMember(MemberVO vo);

	MemberVO getMemberByNameAndEmail(MemberVO vo);

	MemberVO getMemberByIdAndNameAndEmail(MemberVO vo);

	/*
	 *  회원관리(사용자)
	 */
	List<MemberVO> listMember(String name);

	void updateMember(MemberVO vo);
	
	// 테스트1
	void updateMemberUseyn(String id);

	void resetMemberUseyn(String id);
	
	/*
	 * 회원리스트(관리자)
	 */
	List<MemberVO> getMemberAllList();
	
	void adminDeleteMember(String id);
}