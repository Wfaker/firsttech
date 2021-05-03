package com.msl.rule.lt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msl.rule.life.dto.Response;
import com.msl.rule.lt.service.LtLifeUwService;

@RestController
@RequestMapping("rule/life/lt")
public class LtLifeUWController {

	@Autowired
	LtLifeUwService ltLifeUwService;

//	/**
//	 * 长险核保请求
//	 * 
//	 * @param policy
//	 * @return
//	 */
//	@RequestMapping(value = "/uw", method = { RequestMethod.POST })
//	public Response getUnderWriteResult(@RequestBody Policy policy) {
//		return ltLifeUwService.getUnderWriteFlow(policy);
//	}
	
	/**
	 * 长险核保请求
	 * 
	 * @param policy
	 * @return
	 */
	@RequestMapping(value = "/uw", method = { RequestMethod.POST })
	public Response getUnderWriteResult(@RequestBody String policyJsonString) {
		return ltLifeUwService.getUnderWriteFlow(policyJsonString);
	}
}
