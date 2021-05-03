package com.msl.rule.advice;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.msl.rule.life.dto.Response;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
	
	// 日志记录器
	private static Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);
	
	@ExceptionHandler(value = Exception.class)
	public @ResponseBody Response exceptionHandler(Exception e) {
		Response response = new Response();
		
//		e.printStackTrace();
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw, true));
		String exceptionMsg = sw.toString();
		String exceptionSimpleName = e.getClass().getSimpleName();
		logger.error(exceptionMsg);
		
		response.setStatusCode(Response.STATUS_CODE_ERROR);
		response.setErrMsg(e.getMessage());
		response.setErrorCode(exceptionSimpleName);
		
		return response;
	}
}
