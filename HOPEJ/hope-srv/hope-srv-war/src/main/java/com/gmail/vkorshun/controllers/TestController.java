package com.gmail.vkorshun.controllers;

import com.gmail.vkorshun.DAO.BaseDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

/**
 * Created by vkorshun on 29.06.2016.
 */

@Controller
public class TestController {

  @RequestMapping("/test")
  public String test(){
    BaseDAO dao = new BaseDAO();
    String s = BaseDAO.getObjectName(BigDecimal.ONE);
    return s;
  }
}
