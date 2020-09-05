package com.qfedu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.common.JsonResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description
 * @className: JsonUtils
 * @package: com.qfedu.utils
 * @author: Stephen Shen
 * @date: 2020/9/3 下午2:18
 */
public class JsonUtils {
    public static void writeJsonInfo(int code, Object info, HttpServletResponse response) {
        JsonResult jsonResult = new JsonResult(code, info);
        ObjectMapper objectMapper = new ObjectMapper();

        response.setContentType("text/json;charset=utf-8");
//        try//
        String s= null;
        try {
            s = objectMapper.writeValueAsString(jsonResult);
            PrintWriter writer = response.getWriter();

            writer.write(s);
            writer.flush();
            writer.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
