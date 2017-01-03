package org.daniels.examples.threads.ex2;

import java.util.ArrayList;
import java.util.List;

public class VolatileMain {

	private final static int TOTAL_THREADS = 2;

	public static void main(String[] args) throws InterruptedException {
		final VolatileData volatileData = new VolatileData();

		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < TOTAL_THREADS; ++i) {
			threads.add(new VolatileThread(volatileData));
		}
		// Start all reader threads.
		for (int i = 0; i < TOTAL_THREADS; ++i) {
			threads.get(i).start();
		}

		// Wait for all threads to terminate.
		for (int i = 0; i < TOTAL_THREADS; ++i) {
			threads.get(i).join();
		}
	}
}