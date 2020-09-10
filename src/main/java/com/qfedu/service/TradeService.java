package com.qfedu.service;

import com.qfedu.vo.VTradeInfo;

import java.util.Date;
import java.util.List;

/**
 * @description
 * @className: TradeService
 * @package: com.qfedu.service
 * @author: Stephen Shen
 * @date: 2020/9/9 下午5:09
 */
public interface TradeService {
    public List<VTradeInfo> findAllTrades(Integer id, Date beginTime, Date endTime);
}
