package org.example.datastructures.heap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinHeapTest {

    @Test
    @DisplayName("Após a realização de inserçoes, a característica do min heap deve ser mantida")
    void testInsert() {
        MinHeap<BagOfApples> minHeap = obtainMinHeapFilled();

        System.out.println(minHeap);
        assertEquals(3, minHeap.getMin().qtd);
    }

    @Test
    @DisplayName("Após a realização de remoçao do mínimo, a característica do min heap deve ser mantida")
    void testDeleteMinimum() {
        MinHeap<BagOfApples> minHeap = obtainMinHeapFilled();
        System.out.println(minHeap);

        minHeap.deleteMinimum();
        System.out.println(minHeap);
        assertEquals(8, minHeap.getMin().qtd);

        minHeap.deleteMinimum();
        System.out.println(minHeap);
        assertEquals(9, minHeap.getMin().qtd);
    }

    @Test
    @DisplayName("Após a realização de remoçao, a característica do min heap deve ser mantida")
    void testDeleteElement() {
        MinHeap<BagOfApples> minHeap = obtainMinHeapFilled();

        System.out.println(minHeap);
        minHeap.deleteElement(2);
        System.out.println(minHeap);
        assertEquals(3, minHeap.getMin().qtd);

        minHeap.deleteElement(0);
        System.out.println(minHeap);
        assertEquals(9, minHeap.getMin().qtd);

        minHeap.deleteElement(0);
        System.out.println(minHeap);
        assertEquals(10, minHeap.getMin().qtd);
    }

    private MinHeap<BagOfApples> obtainMinHeapFilled() {
        MinHeap<BagOfApples> minHeap = new MinHeap<>(10);

        minHeap.insert(new BagOfApples(10));
        minHeap.insert(new BagOfApples(9));
        minHeap.insert(new BagOfApples(8));
        minHeap.insert(new BagOfApples(20));
        minHeap.insert(new BagOfApples(70));
        minHeap.insert(new BagOfApples(3));
        minHeap.insert(new BagOfApples(50));

        return minHeap;
    }

    public static class BagOfApples implements Scorable {

        int qtd;

        int daysRemaining;

        public BagOfApples(int qtd) {
            this.qtd = qtd;
        }

        @Override
        public BigInteger getScore() {
            return BigInteger.valueOf(this.qtd);
        }

        @Override
        public String toString() {
            return getScore().toString();
        }
    }

}
