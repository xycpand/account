package com.hummingbird.account.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.account.services.ConfirmAccountService;
import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.vo.ResultModel;
/**
 * @author panda
 * 2016年7月11日 上午10:59:01
 * 对账管理
 */
@Controller
@RequestMapping(value="/confirm")
public class ConfirmAccountController extends BaseController  {
	@Autowired
	ConfirmAccountService confirmAccountService;
	
		/**
		 * 对账
		 * @param request
		 * @param response
		 * @return
		 */
		@RequestMapping(value = "/confirmAccount", method = RequestMethod.POST)
		//@AccessRequered(methodName = "保存文章信息", isJson = true, codebase = 245900, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.account.vo.SaveArticleVO", appLog = true)
		public @ResponseBody ResultModel confirmAccount(HttpServletRequest request,
				HttpServletResponse response) {
		ResultModel rm = super.getResultModel();
	   // BaseTransVO<SaveArticleVO> transorder = (BaseTransVO<SaveArticleVO>) super.getParameterObject();
		String messagebase = "对账";
		try {
			confirmAccountService.confirmAccount();
			rm.setErrmsg(messagebase+"成功");
		} catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
		} 
		return rm;
	}
}
