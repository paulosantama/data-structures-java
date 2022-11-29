package org.example.datastructures.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Scorable> {

	private final List<T> arr;
	private final int capacity;

	public MinHeap(int capacity) {
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

	public T getMin() {
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

	public void deleteMinimum() {
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

		this.deleteMinimum();
	}

	private void heapify(int index) {
		if (this.getSize() <= 1) {
			return;
		}

		int left = leftChild(index);
		int right = rightChild(index);

		int smallest = index;

		if (left < this.getSize() && this.arr.get(left).getScore().compareTo(arr.get(smallest).getScore()) < 0) {
			smallest = left;
		}

		if (right < this.getSize() && this.arr.get(right).getScore().compareTo(arr.get(smallest).getScore()) < 0) {
			smallest = right;
		}

		if (smallest != index) {
			T temp = this.arr.get(index);
			this.arr.set(index, this.arr.get(smallest));
			this.arr.set(smallest, temp);
			heapify(smallest);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Min Heap:\n");
		for (int i = 0; i < (this.getSize() - 1); i++) {
			sb.append(this.arr.get(i)).append(" -> ");
		}
		sb.append(this.arr.get(this.getSize() - 1));
		sb.append("\n");
		return sb.toString();
	}

	private void rearrangeFromCurrent(int current) {
		while (current > 0 && this.arr.get(parent(current)).getScore().compareTo(this.arr.get(current).getScore()) > 0) {
			T temp = this.arr.get(parent(current));
			this.arr.set(parent(current), this.arr.get(current));
			this.arr.set(current, temp);
			current = parent(current);
		}
	}

}
