package jp.co.timepage.mybatis.mapper;

import java.util.List;

import jp.co.timepage.mybatis.entity.Fruit;
import jp.co.timepage.mybatis.entity.Timepage;

public interface TimepageMapper2 {

    List<Fruit> selectAll();

    List<Timepage> selectAll2();
}