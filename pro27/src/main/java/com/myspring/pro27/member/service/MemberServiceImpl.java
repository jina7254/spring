package com.myspring.pro27.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.pro27.member.dao.MemberDAO;
import com.myspring.pro27.member.vo.MemberVO;

@Service("memberService") //MemberServiceImpl클래스를 이용해 id가 memberService인 빈을 자동 생성합니다.
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;  //id가 MemberDAO인 빈을 자동 주입합니다.
	
	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMemberList();
		return membersList;
	}

	@Override
	public int addMember(MemberVO member) throws DataAccessException {
		return memberDAO.insertMember(member);
	}

	@Override
	public int removeMember(String id) throws DataAccessException {
		return memberDAO.deleteMember(id);
	}
	

}
