package com.itbank.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate sst;
	
	public List<UserVO> selectAll() {
		return sst.selectList("userDAO.selectAll");
	}

	public int delete(List<String> usernum) {
		return sst.delete("userDAO.delete", usernum);
	}

	public int insert(UserVO vo) {
		return sst.insert("userDAO.insert", vo);
	}

	public int update(HashMap<String, String> map) {
		return sst.update("userDAO.updateStamp", map);
	}
	
	public int updateCancel (HashMap<String, String> map) {
		return sst.update("userDAO.updateCancel", map);
	}
}
