package com.gmail.vkorshun.controllers;

import com.gmail.vkorshun.config.ApiVersion;
import com.gmail.vkorshun.model.OperationResponse;
import com.gmail.vkorshun.model.ResponseResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by vkorshun on 16.07.2016.
 */
@RestController
@Api(value = "iSign API crypto service", description = "iSign API Криптографические методы. Версия " + ApiVersion.version)
@RequestMapping({"/api/v" + ApiVersion.version + "/hopej"})
public class HopejController {

  @ApiOperation(value = "test", notes = "test", httpMethod = "POST")
  @RequestMapping(value = "/testConnect", method = RequestMethod.POST, produces = "application/json")
  public OperationResponse testConnect(
       @RequestParam @ApiParam(value = "Логин пользователя", required = true) String login
      , @RequestParam @ApiParam(value = "Пароль пользователя", required = true) String password
      , @RequestParam(required = false) @ApiParam(value = "Id запроса") BigDecimal requestId
  ) {
    return new OperationResponse(ResponseResultCode.OK, "All right "+login+" "+ password+ (requestId == null ? "0" : requestId.toString()));
  }


}
