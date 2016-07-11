package com.hummingbird.account.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.account.entity.ConfirmDifference;
import com.hummingbird.account.entity.ConfirmResult;
import com.hummingbird.account.mapper.ConfirmDifferenceMapper;
import com.hummingbird.account.mapper.ConfirmResultMapper;
import com.hummingbird.account.mapper.TradeRecordMapper;
import com.hummingbird.account.services.ConfirmAccountService;
import com.hummingbird.common.exception.BusinessException;
@Service
public class ConfirmAccountServiceImpl implements ConfirmAccountService{
	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	@Autowired
	TradeRecordMapper tradeRecordDao;	
	@Autowired
	ConfirmResultMapper confirmResultDao;	
	@Autowired
	ConfirmDifferenceMapper confirmDifferenceDao;
	
	@Override	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void confirmAccount() throws BusinessException {
		log.debug("开始对账：");
	     //验证数商户号是否一致
		
		
		 //获取上游对账文件中第一条的交易流水号和最后一条的交易流水号
		
		
		 //根据上一步获取的2个交易流水号,查询我方的所有交易记录
		
		
		 //根据上一次对账的最后一条的交易流水号和本次对账的第一条交易流水号,进行查询,并得到我方多出来的交易记录
		
		
		 //遍历对账文件和我方的交易记录(双方),根据交易流水号,账号,金额和交易时间找到对应的记录
		
		 /**
		  * a)	如果对账文件存在,而我方交易记录不存在,则是我方缺少,以上游为准,调整我方内容(按需要)
		  * b)	如果对账记录存在,但金额不同,则以上游为准,调整我方内容(按需要)
		  * c)	如果我方存在记录,而对账文件不存在,则需要进行冲正等操作.(按需要)
		  */
		
		ConfirmResult confirmResult = new ConfirmResult();
		//confirmResult.setAccountno(accountno);
		//confirmResult.setAmount(amount);
		 //把对账的结果进行保存到数据库
		saveConfirmResult(confirmResult);
		log.debug("结束对账。");
	}

	@Override	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveConfirmResult(ConfirmResult confirmResult) throws BusinessException {
		try{
			confirmResultDao.insert(confirmResult);
		}catch(DataAccessException e){
			e.printStackTrace();
			throw new BusinessException("保存对账结果失败。");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveConfirmDifference(ConfirmDifference confirmDifference) throws BusinessException {
		try{
			confirmDifferenceDao.insert(confirmDifference);
		}catch(DataAccessException e){
			e.printStackTrace();
			throw new BusinessException("保存对账差异失败。");
		}
	}
	
	
	
}
