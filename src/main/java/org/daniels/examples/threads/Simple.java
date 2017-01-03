package org.daniels.examples.threads;

import java.util.concurrent.atomic.AtomicBoolean;

public class Simple {
	private boolean isEditable = true;
	private AtomicBoolean isEditableAtomic = new AtomicBoolean(true);

	public boolean isEditable() {
		return isEditable;
	}

	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}

	public AtomicBoolean isEditableAtomic() {
		return isEditableAtomic;
	}

	public void setIsEditableAtomic(boolean isEditableAtomic) {
		this.isEditableAtomic.set(isEditableAtomic);
	}

}
