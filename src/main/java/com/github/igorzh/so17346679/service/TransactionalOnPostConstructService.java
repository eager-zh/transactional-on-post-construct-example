package com.github.igorzh.so17346679.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.annotation.PostConstruct;

@Service
@Lazy(false)
public class TransactionalOnPostConstructService {
	
	private final static Log logger = LogFactory.getLog(TransactionalOnPostConstructService.class);
	
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
