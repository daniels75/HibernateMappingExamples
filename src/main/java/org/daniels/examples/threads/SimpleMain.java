package org.daniels.examples.threads;

public class SimpleMain extends Thread {
	Simple simple = new Simple();

	public void run() {
		System.out.println("Thread started");
		long count = 0;
//		while (simple.isEditableAtomic().get()) {
//			count++;
//		}
		while (simple.isEditable()) {
			count++;
		}
		
		System.out.println("Thread terminated with count: " + count);
	}

	public static void main(String[] args) throws InterruptedException {
		final SimpleMain thread = new SimpleMain();
		thread.start();
		Thread.sleep(50);
		//thread.simple.setIsEditableAtomic(false);
		thread.simple.setEditable(false);

		System.out.println("main thread set value to false");
	}
}