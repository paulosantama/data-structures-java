package org.example.datastructures.heap;

public class MinHeap {

    private final int[] arr;
    private int size;
    private final int capacity;

    public MinHeap(int capacity) {
        this.arr = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left_child(int i) {
        return (i * 2) + 1;
    }

    private int right_child(int i) {
        return (i * 2) + 2;
    }

    public int get_min() {
        return this.arr[0];
    }

    public void insert(int element) {
        if (this.size >= this.capacity)  {
            System.out.println("Não é possível inserir " + element + ". O Heap está cheio!");
            return;
        }
        int current = this.size++;
        this.arr[current] = element;

        while(current > 0 && this.arr[parent(current)] > this.arr[current]) {
            int temp = this.arr[parent(current)];
            this.arr[parent(current)] = this.arr[current];
            this.arr[current] = temp;
            current = parent(current);
        }
    }

    public void deleteMinimum() {
        if (this.size == 0)  {
            return;
        }

        int size = this.size;
        int lastElement = this.arr[size - 1];
        arr[0] = lastElement;
        this.size--;

        this.heapify(0);
    }

    private void heapify(int index) {
        if (this.size <= 1) {
            return;
        }

        int left = left_child(index);
        int right = right_child(index);

        int smallest = index;

        if (left < this.size && this.arr[left] < arr[smallest]) {
            smallest = left;
        }

        if (right < this.size && this.arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            int temp = this.arr[index];
            this.arr[index] = this.arr[smallest];
            this.arr[smallest] = temp;
            heapify(smallest);
        }
    }

}
