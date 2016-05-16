package org.mengyun.tcctransaction.support;

import org.mengyun.tcctransaction.TransactionManager;
import org.mengyun.tcctransaction.TransactionRepository;

public interface TransactionConfigurator {

	public TransactionManager getTransactionManager();

	public TransactionRepository getTransactionRepository();

}
