package com.github.igorzh.so17346679.service;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@Lazy(false)
public class TransactionalOnPostConstructService {
	
	private static Log logger = LogFactory.getLog(TransactionalOnPostConstructService.class);
	
	@Autowired
	private TransactionalOnPostConstructService self;
	
	private boolean executedInsideTransaction;
	
	@Transactional
	public void executeInsideTransaction(){
		executedInsideTransaction = TransactionSynchronizationManager.isActualTransactionActive();
		logger.info("Executed inside of transaction? " + executedInsideTransaction);
	}
	
	@PostConstruct
	private void init(){
		self.executeInsideTransaction();
	}

	public boolean isExecutedInsideTransaction() {
		return executedInsideTransaction;
	}
	
}
