package org.example.datastructures.heap;

import java.math.BigInteger;

public class MaxHeap<T extends Scorable> extends AbstractHeap<T> {

	@Override
	protected boolean compareScore(BigInteger score1, BigInteger score2) {
		return score1.compareTo(score2) > 0;
	}

	public T getMaximum() {
		return this.getFirst();
	}

	public void deleteMaximum() {
		this.deleteFirst();
	}

}
