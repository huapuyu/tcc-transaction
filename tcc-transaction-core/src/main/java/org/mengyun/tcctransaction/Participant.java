package org.mengyun.tcctransaction;

import org.mengyun.tcctransaction.api.TransactionXid;

import java.io.Serializable;

public class Participant implements Serializable {

	private static final long serialVersionUID = 4127729421281425247L;

	private TransactionXid xid;
	private Terminator terminator;

	public Participant(TransactionXid xid, Terminator terminator) {
		this.xid = xid;
		this.terminator = terminator;
	}

	public void rollback() {
		terminator.rollback();
	}

	public void commit() {
		terminator.commit();
	}
}
