package org.mengyun.tcctransaction;

import org.mengyun.tcctransaction.api.TransactionXid;

import java.util.Collection;
import java.util.List;

public interface TransactionRepository {

	void create(Transaction transaction);

	void update(Transaction transaction);

	void delete(Transaction transaction);

	Transaction findByXid(TransactionXid xid);

	List<Transaction> findAll();

	void addErrorTransaction(Transaction transaction);

	void removeErrorTransaction(Transaction transaction);

	Collection<Transaction> findAllErrorTransactions();
}
