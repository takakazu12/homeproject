package jp.co.timepage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.co.timepage.mybatis.entity.Timepage;
import jp.co.timepage.mybatis.entity.TimepageKey;
import jp.co.timepage.mybatis.mapper.TimepageMapper;

@Repository
public class TimePageDao {

	@Autowired
	private TimepageMapper timeMapper;

	public List<Timepage> selectByPrimaryList(TimepageKey key) {

		List<Timepage> timeLine = timeMapper.selectByPrimaryList(key);
		return timeLine;


	}



}
