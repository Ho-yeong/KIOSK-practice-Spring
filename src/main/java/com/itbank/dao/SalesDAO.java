package com.itbank.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SalesDAO {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	public List<SalesVO> selectAll() {
		return sst.selectList("salesDAO.selectAll");
	}

	public int insert(SalesVO vo) {
		return sst.insert("salesDAO.insert", vo);
	}

}
