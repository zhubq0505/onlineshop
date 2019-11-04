package com.hky.onlineshop.dao;

import static org.junit.Assert.*;
import com.hky.onlineshop.entity.Area;

import java.util.Date;
import java.util.List;

import com.hky.onlineshop.BaseTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class AreaDaoTest extends BaseTest {
    @Autowired
    @Qualifier("areaDao")
    private AreaDao areaDao;

    @Test
    @Ignore
    public void testQueryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(4, areaList.size());
    }

    @Test
    public void testInsertArea() {
        String[] names = new String[]{"滨江", "西湖", "拱墅", "萧山"};
        for (int i = 0; i < names.length; i++) {
            Area area = new Area();
            area.setAreaName(names[i]);
            area.setWeight(i);
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            areaDao.insertArea(area);
        }
    }

}
