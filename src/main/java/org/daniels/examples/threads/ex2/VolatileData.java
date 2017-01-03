package org.daniels.examples.threads.ex2;

public class VolatileData {

	private  int counter = 0;

	public int getCounter() {
		return counter;
	}

	public void increaseCounter() {
		++counter;
	}
}