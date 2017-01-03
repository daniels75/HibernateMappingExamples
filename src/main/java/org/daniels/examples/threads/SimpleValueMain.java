package org.daniels.examples.threads;

public class SimpleValueMain {

	public static void main(String[] args) throws Exception {
		final SimpleValue simpleValue = new SimpleValue();
		final Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				printValues("Thread 1 - Before", simpleValue);
				simpleValue.setExecuted(true);
				//simpleValue.setAtomicExecuted(true);
				printValues("Thread 1 - After", simpleValue);
			}
		}, "Thread1");
		
		final Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				printValues("Thread 2 - Before", simpleValue);
				simpleValue.setExecuted(true);
				//simpleValue.setAtomicExecuted(true);
				printValues("Thread 2 - After", simpleValue);
			}
		}, "Thread2");

		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		printValues("MainThread - After", simpleValue);
	}


	
	private static void printValues(final String treadName, final SimpleValue simpleValue) {
		//System.out.println(treadName + " executed: " + simpleValue.isExecuted() + "    [" + simpleValue.hashCode() + "]");
		System.out.println(treadName + " atomicExecuted: " + simpleValue.isAtomicExecuted()+ "    [" + simpleValue.hashCode() + "]");
	}
	/* Result without volatile
	 	Thread 2 - Before executed: true
		Thread 2 - After executed: false
		Thread 1 - Before executed: true
		Thread 1 - After executed: false
		Main Thread executed: false
		
		with volatile
		Thread 1 - Before executed: true
		Thread 1 - After executed: false
		Thread 2 - Before executed: true
		Thread 2 - After executed: false
		Main Thread executed: false
	 * 
	 * 
	 */
}
