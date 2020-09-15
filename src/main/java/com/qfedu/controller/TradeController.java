package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.User;
import com.qfedu.service.TradeService;
import com.qfedu.utils.StrUtils;
import com.qfedu.vo.VTradeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @className: TradeController
 * @package: com.qfedu.controller
 * @author: Stephen Shen
 * @date: 2020/9/9 下午4:58
 */
@Controller
@RequestMapping("/trade")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @RequestMapping("/list.do")
    @ResponseBody
    //public JsonResult listTradeInfo(HttpSession session, @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginTime, @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
    //public JsonResult listTradeInfo(HttpSession session, Date beginTime, Date endTime,Integer page,Integer limit) {
    public Map<String ,Object> listTradeInfo(HttpSession session, Date beginTime, Date endTime, Integer page, Integer limit) {
        User user = (User) session.getAttribute(StrUtils.LOGIN_USER);

        List<VTradeInfo> list = tradeService.findAllTrades(user.getId(), beginTime, endTime, page, limit);

        //与总条数有关
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);//获取总条数
        map.put("data", list);//获取分页数据

        return map;
    }

    @RequestMapping("/transfer.do")
    @ResponseBody
    public JsonResult transfer(String otherCode,double money,HttpSession session){
        User u = (User)session.getAttribute(StrUtils.LOGIN_USER);
        tradeService.transfer(u.getBankCode(),otherCode,money);
        return new JsonResult(1,"转账成功");

    }

}
