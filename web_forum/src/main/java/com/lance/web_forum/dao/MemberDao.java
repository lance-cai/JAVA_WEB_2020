package com.lance.web_forum.dao;

import com.lance.web_forum.bean.*;

public interface MemberDao extends GenericBackendDao<Member> {
	public int changeUserName(String memberId, String new_name);
	public int changePwd(String memberId, String new_pwd);
	public int deleteAccount(String memberId);
}
