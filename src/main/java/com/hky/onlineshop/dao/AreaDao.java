package java.com.hky.onlineshop.dao;

import java.com.hky.onlineshop.entity.Area;
import java.util.List;

public interface AreaDao {
    /**
     * 列出区域列表
     * @return
     */
    List<Area> queryArea();
}