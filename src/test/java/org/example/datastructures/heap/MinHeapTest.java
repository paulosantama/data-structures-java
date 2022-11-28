package org.example.datastructures.heap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinHeapTest {

    @Test
    @DisplayName("Após a realização de inserçoes, a característica do min heap deve ser mantida")
    void testInsert() {
        MinHeap minHeap = obtainMinHeapFilled();

        assertEquals(3, minHeap.getMin());
    }

    @Test
    @DisplayName("Após a realização de remoçao do mínimo, a característica do min heap deve ser mantida")
    void testDeleteMinimum() {
        MinHeap minHeap = obtainMinHeapFilled();

        minHeap.deleteMinimum();
        assertEquals(8, minHeap.getMin());

        minHeap.deleteMinimum();
        assertEquals(9, minHeap.getMin());
    }

    @Test
    @DisplayName("Após a realização de remoçao, a característica do min heap deve ser mantida")
    void testDeleteElement() {
        MinHeap minHeap = obtainMinHeapFilled();

        System.out.println(minHeap);
        minHeap.deleteElement(2);
        System.out.println(minHeap);
        assertEquals(3, minHeap.getMin());
    }

    private MinHeap obtainMinHeapFilled() {
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(10);
        minHeap.insert(9);
        minHeap.insert(8);
        minHeap.insert(20);
        minHeap.insert(70);
        minHeap.insert(3);
        minHeap.insert(50);

        return minHeap;
    }

}
