package com.choa.member;

public interface MemberDAO {
	
	
	//join	
	public int memberJoin(MemberDTO memberDTO) throws Exception;
	
	//Login
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception;

	//Mypage
	public MemberDTO memberPage(String id) throws Exception;

}
