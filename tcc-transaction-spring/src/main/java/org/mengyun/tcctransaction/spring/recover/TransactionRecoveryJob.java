package org.mengyun.tcctransaction.spring.recover;

import org.mengyun.tcctransaction.recover.TransactionRecovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("transactionRecoveryJob")
public class TransactionRecoveryJob {

	@Autowired
	private TransactionRecovery transactionRecovery;

	@Scheduled(cron = "0 */1 * * * ?")
	public void recover() {
		transactionRecovery.startRecover();
	}
}
