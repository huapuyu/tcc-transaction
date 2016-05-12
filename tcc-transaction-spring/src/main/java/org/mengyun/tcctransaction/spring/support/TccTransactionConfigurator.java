package org.mengyun.tcctransaction.spring.support;

import org.mengyun.tcctransaction.TransactionManager;
import org.mengyun.tcctransaction.TransactionRepository;
import org.mengyun.tcctransaction.support.TransactionConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

public class TccTransactionConfigurator implements TransactionConfigurator {

	@Autowired
	private TransactionRepository transactionRepository;

	private TransactionManager transactionManager = new TransactionManager(this);

	@Override
	public TransactionManager getTransactionManager() {
		return transactionManager;
	}

	@Override
	public TransactionRepository getTransactionRepository() {
		return transactionRepository;
	}
}
