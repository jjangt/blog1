package com.green.biz.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.member.MemberService;
import com.green.biz.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public MemberVO getMember(String id) {

		return memberDao.getMember(id);
	}

	@Override
	public MemberVO loginMember(MemberVO vo) {

		return memberDao.loginMember(vo);
	}

	@Override
	public MemberVO getMemberByNameAndEmail(MemberVO vo) {

		return memberDao.getMemberByNameAndEmail(vo);
	}

	@Override
	public MemberVO getMemberByIdAndNameAndEmail(MemberVO vo) {

		return memberDao.getMemberByIdAndNameAndEmail(vo);
	}

	@Override
	public void insertMember(MemberVO vo) {

		memberDao.insertMember(vo);
	}
	
	@Override
	public List<MemberVO> listMember(String name) {

		return memberDao.listMember(name);
	}

	@Override
	public void updateMember(MemberVO vo) {

		memberDao.updateMember(vo);
	}

	@Override
	public List<MemberVO> getMemberAllList() {

		return memberDao.getMemberAllList();
	}

	@Override
	public void adminDeleteMember(String id) {

		memberDao.adminDeleteMember(id);
	}

	// 테스트 1
	@Override
	public void updateMemberUseyn(String id) {

		memberDao.updateMemberUseyn(id);
	}

	@Override
	public void resetMemberUseyn(String id) {

		memberDao.resetMemberUseyn(id);
	}
}
