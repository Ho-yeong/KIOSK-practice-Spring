package com.itbank.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ProductDAO {

	@Autowired
	private SqlSessionTemplate sst;
	
	public List<ProductVO> selectAll() {
		return sst.selectList("productDAO.selectAll");
	}

	public int insert(ProductVO vo) {
		return sst.insert("productDAO.insert", vo);
	}

	public int delete(List<String> name) {
		return sst.delete("productDAO.delete", name);
	}

	public ProductVO selectOne(String name) {
		return sst.selectOne("productDAO.selectOne", name);
	}

	public int update(ProductVO vo) {
		return sst.update("productDAO.update", vo);
	}

	public int update(HashMap<String, String> map) {
		
		return sst.update("productDAO.updateWithSales", map);
		
	}
	
	public int updateCancel (HashMap<String, String> map) {
		return sst.update("productDAO.updateCancel", map);
	}

}
