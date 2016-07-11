package com.hummingbird.account.services;

import com.hummingbird.account.entity.ConfirmDifference;
import com.hummingbird.account.entity.ConfirmResult;
import com.hummingbird.common.exception.BusinessException;

public interface ConfirmAccountService {

	/**
	 * 对账管理
	 * @throws BusinessException
	 */
	public void confirmAccount() throws BusinessException;
	

	/**
	 * 保存对账结果
	 * @param confirmResult
	 * @throws BusinessException
	 */
	public void saveConfirmResult(ConfirmResult confirmResult) throws BusinessException;
	
	/**
	 * 保存对账差异
	 * @param confirmDifference
	 * @throws BusinessException
	 */
	public void saveConfirmDifference(ConfirmDifference confirmDifference) throws BusinessException;
	

	
	
}
