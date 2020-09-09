package com.qfedu.service.impl;

import com.qfedu.dao.TradeDao;
import com.qfedu.service.TradeService;
import com.qfedu.vo.VTradeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @className: TradeServiceImpl
 * @package: com.qfedu.service.impl
 * @author: Stephen Shen
 * @date: 2020/9/9 下午5:09
 */
@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeDao tradeDao;

    @Override
    public List<VTradeInfo> findAllTrades() {
        List<VTradeInfo> trades = tradeDao.findAll();
        return trades;
    }
}
