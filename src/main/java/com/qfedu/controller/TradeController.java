package com.qfedu.controller;

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
import java.util.List;

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
    public JsonResult listTradeInfo(HttpSession session,@DateTimeFormat(pattern = "yyyy-MM-dd") Date beginTime,@DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime){
        System.out.println("beginTime"+beginTime+",endTime"+endTime);
        User user =(User) session.getAttribute(StrUtils.LOGIN_USER);


        List<VTradeInfo> allTrades = tradeService.findAllTrades(user.getId(),beginTime,endTime);
        JsonResult jsonResult = new JsonResult(1, allTrades);



              return jsonResult;
    }

//    public List<VTradeInfo> findAll(HttpSession session) {


}
