package com.msl.rule.life.dto;

import java.io.Serializable;

/**
 * 
 * 返回结果
 * 
 * @author zhou
 *
 */
public class Response implements Serializable {

	/**
	 * 序列版本号
	 */
	private static final long serialVersionUID = 4701512637335379918L;
	
	// 属性
	private String statusCode = STATUS_CODE_SUCCESS; // 统一响应码，SUCCESS成功，ERROR失败。默认SUCCESS
	private String errorCode = "";  // 如果statusCode是ERROR，可以通过该errCode判断是哪种类型的错误，比如401代表没权限等。当前返回异常名称
	private String errMsg = ""; // 如果statusCode是ERROR，errMsg里描述具体的错误信息
	private Result data = new Result(); // 返回的具体的业务数据，输出结果
	
	// 常量值
	public static String STATUS_CODE_SUCCESS = "SUCCESS";
	public static String STATUS_CODE_ERROR = "ERROR";
	
	// Getter && Setter
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public Result getData() {
		return data;
	}
	public void setData(Result data) {
		this.data = data;
	}

}
