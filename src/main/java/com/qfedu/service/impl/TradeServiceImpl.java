package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.TradeDao;
import com.qfedu.dao.UserDao;
import com.qfedu.entity.Trade;
import com.qfedu.entity.User;
import com.qfedu.service.TradeService;
import com.qfedu.vo.VTradeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public static final String CONSUM_TYPE_IN = "收入";
    public static final String CONSUM_TYPE_OUT = "支出";
    @Autowired
    private TradeDao tradeDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<VTradeInfo> findAllTrades(Integer id, Date beginTime, Date endTime,Integer page,Integer limit) {

        //设置页码和每页显示的记录数，该语句紧跟数据库查询的相关语句
        PageHelper.startPage(page,limit);
        List<VTradeInfo> trades = tradeDao.findAll(id, beginTime, endTime);
        return trades;
    }

    /**
     * 转账业务
     * @param code
     * @param otherCode
     * @param money
     */
    @Override
    public void transfer(String code, String otherCode, Double money) {


        //转账金额检查
        if (money < 0) {
            throw new RuntimeException("转账金额不能为负");
        }

        //要被扣钱的人
        User loginUser = userDao.findByCode(code);

        //要被加钱的人
        User otherUser = userDao.findByCode(otherCode);

        //转账前置检查d340a2501bc6
        checkAccount(loginUser, otherUser, money);

        //原账户减钱
        changeUserAndTrade(loginUser, otherUser.getId(), money, "转出", CONSUM_TYPE_OUT);

        //另一个账户加钱
        changeUserAndTrade(otherUser, loginUser.getId(),  -money, "转入", CONSUM_TYPE_IN);


    }

    /**
     * 转账前置检查
     *
     * @param loginUser
     * @param otherUser
     */
    public void checkAccount(User loginUser, User otherUser, Double money) {
        if (otherUser == null) {
            throw new RuntimeException("用户不存在");
        }
        if (loginUser.getBankCode().equals(otherUser.getBankCode())) {
            throw new RuntimeException("不能给自己转钱");
        }

        if (loginUser.getBalance() < money) {
            throw new RuntimeException("余额不足");
        }
    }


    /**
     * 更新账户与添加转账记录
     * @param user
     * @param otherUid
     * @param money
     * @param comment
     * @param consumType
     */
    public void changeUserAndTrade(User  user, Integer otherUid, Double money, String comment, String consumType) {

        //更新账户余额
        //money>0是转出
        //money<0是转入
        user.setBalance(user.getBalance() - money);
        userDao.update(user);

        //添加转账记录
        Trade trade = new Trade();
        trade.setUid(user.getId());
        trade.setOtherUid(otherUid);
        trade.setMoney(money);
        trade.setCreateTime(new Date());
        trade.setBalance(user.getBalance());
        trade.setComment(comment);
        trade.setConsumType(consumType);

        tradeDao.add(trade);

    }


}
