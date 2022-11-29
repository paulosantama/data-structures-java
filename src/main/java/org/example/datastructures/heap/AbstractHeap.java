package org.example.datastructures.heap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHeap<T extends Scorable> {

	private final List<T> arr;
	private final int capacity;

	public AbstractHeap(int capacity) {
		this.arr = new ArrayList<>(capacity);
		this.capacity = capacity;
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int leftChild(int i) {
		return (i * 2) + 1;
	}

	private int rightChild(int i) {
		return (i * 2) + 2;
	}

	private int getSize() {
		return this.arr.size();
	}

	protected T getFirst() {
		return this.arr.get(0);
	}

	public void insert(T element) {
		if (this.getSize() >= this.capacity) {
			System.out.println("Não é possível inserir " + element + ". O Heap está cheio!");
			return;
		}
		int current = this.getSize();
		this.arr.add(current, element);
		this.rearrangeFromCurrent(current);
	}

	protected void deleteFirst() {
		if (this.getSize() == 0) {
			return;
		}
		this.arr.remove(0);
		this.heapify(0);
	}

	public void deleteElement(int index) {
		if (index >= this.getSize()) {
			System.out.println("Índice '" + index + "' inexistente!");
			return;
		}

		T temp = this.arr.get(index);
		this.arr.set(index, this.arr.get(0));
		this.arr.set(0, temp);

		this.deleteFirst();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Heap:\n");
		for (int i = 0; i < (this.getSize() - 1); i++) {
			sb.append(this.arr.get(i)).append(" -> ");
		}
		sb.append(this.arr.get(this.getSize() - 1));
		sb.append("\n");
		return sb.toString();
	}

	private void heapify(int index) {
		if (this.getSize() <= 1) {
			return;
		}

		int left = leftChild(index);
		int right = rightChild(index);

		int smallest = index;

		if (left < this.getSize() && this.compareScore(this.arr.get(left).getScore(), arr.get(smallest).getScore())) {
			smallest = left;
		}

		if (right < this.getSize() && this.compareScore(this.arr.get(right).getScore(), arr.get(smallest).getScore())) {
			smallest = right;
		}

		if (smallest != index) {
			T temp = this.arr.get(index);
			this.arr.set(index, this.arr.get(smallest));
			this.arr.set(smallest, temp);
			heapify(smallest);
		}
	}

	private void rearrangeFromCurrent(int current) {
		while (current > 0 && this.compareScore(this.arr.get(current).getScore(), this.arr.get(parent(current)).getScore())) {
			T temp = this.arr.get(parent(current));
			this.arr.set(parent(current), this.arr.get(current));
			this.arr.set(current, temp);
			current = parent(current);
		}
	}

	protected abstract boolean compareScore(BigInteger score1, BigInteger score2);

}
