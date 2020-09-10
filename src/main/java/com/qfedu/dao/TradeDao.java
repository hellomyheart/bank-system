package com.qfedu.dao;

import com.qfedu.vo.VTradeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @description
 * @className: TradeDao
 * @package: com.qfedu.dao
 * @author: Stephen Shen
 * @date: 2020/9/9 下午3:38
 */
public interface TradeDao {
    public List<VTradeInfo> findAll(@Param("uid") Integer id, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}
