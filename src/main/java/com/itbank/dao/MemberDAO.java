package com.itbank.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sst;
	
	public MemberVO login (HashMap<String, String> map) {
		return sst.selectOne("userDAO.login",map);
	}
}
