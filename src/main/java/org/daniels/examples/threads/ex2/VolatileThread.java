package org.daniels.examples.threads.ex2;

public class VolatileThread extends Thread {
	private final VolatileData data;

	public VolatileThread(VolatileData data) {
		this.data = data;
	}

	@Override
	public void run() {
		System.out.println("[Thread " + Thread.currentThread().getId() + "]: Old value = " + data.getCounter());
		data.increaseCounter();
		System.out.println("[Thread " + Thread.currentThread().getId() + "]: New value = " + data.getCounter());
	}
}