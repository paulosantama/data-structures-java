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

}
