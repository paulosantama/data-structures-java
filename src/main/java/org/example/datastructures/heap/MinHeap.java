package org.example.datastructures.heap;

import java.math.BigInteger;

public class MinHeap<T extends Scorable> extends AbstractHeap<T> {

	@Override
	protected boolean compareScore(BigInteger score1, BigInteger score2) {
		return score1.compareTo(score2) < 0;
	}

	public T getMinimum() {
		return this.getFirst();
	}

	public void deleteMinimum() {
		this.deleteFirst();
	}

}
