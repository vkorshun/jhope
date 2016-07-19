package com.gmail.vkorshun.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by vkorshun on 16.07.2016.
 */
@ApiModel
public class OperationResponse {

  @ApiModelProperty(value = "Код ответа")
  private ResponseResultCode resultCode;

  @ApiModelProperty(value = "Описание ошибки")
  private String errorMessage;

  public OperationResponse() {
  }

  public OperationResponse(ResponseResultCode responseResultCode, String errorMessage) {
    this.resultCode = responseResultCode;
    this.errorMessage = errorMessage;
  }

  public ResponseResultCode getResultCode() {
    return resultCode;
  }

  public void setResultCode(ResponseResultCode resultCode) {
    this.resultCode = resultCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("OperationResponse{");
    sb.append("resultCode=").append(resultCode);
    sb.append(", errorMessage='").append(errorMessage).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
