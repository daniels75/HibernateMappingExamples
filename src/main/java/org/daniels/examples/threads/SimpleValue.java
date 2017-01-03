package org.daniels.examples.threads;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleValue implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean executed;
	private AtomicBoolean atomicExecuted = new AtomicBoolean(false);
	
	public boolean isExecuted() {
		return executed;
	}
	public void setExecuted(boolean executed) {
		this.executed = executed;
	}
	public boolean isAtomicExecuted() {
		return atomicExecuted.get();
	}
	public void setAtomicExecuted(boolean executed) {
		this.atomicExecuted.set(executed);
	}
	
}
