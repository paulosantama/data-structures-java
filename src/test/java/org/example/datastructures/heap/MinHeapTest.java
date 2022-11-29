package org.example.datastructures.heap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinHeapTest {

	@Test
	@DisplayName("Após a realização de inserçoes, a característica do min heap deve ser mantida")
	void testInsert() {
		MinHeap<BagOfAnything> minHeap = obtainMinHeapFilled();
		System.out.println(minHeap);

		assertEquals(3, minHeap.getMinimum().qtd);
	}

	@Test
	@DisplayName("Após a realização de remoçao do mínimo, a característica do min heap deve ser mantida")
	void testDeleteMinimum() {
		MinHeap<BagOfAnything> minHeap = obtainMinHeapFilled();
		System.out.println(minHeap);

		minHeap.deleteMinimum();
		System.out.println(minHeap);
		assertEquals(8, minHeap.getMinimum().qtd);

		minHeap.deleteMinimum();
		System.out.println(minHeap);
		assertEquals(9, minHeap.getMinimum().qtd);
	}

	@Test
	@DisplayName("Após a realização de remoçao, a característica do min heap deve ser mantida")
	void testDeleteElement() {
		MinHeap<BagOfAnything> minHeap = obtainMinHeapFilled();
		System.out.println(minHeap);

		minHeap.deleteElement(2);
		System.out.println(minHeap);
		assertEquals(3, minHeap.getMinimum().qtd);

		minHeap.deleteElement(0);
		System.out.println(minHeap);
		assertEquals(9, minHeap.getMinimum().qtd);

		minHeap.deleteElement(0);
		System.out.println(minHeap);
		assertEquals(10, minHeap.getMinimum().qtd);
	}

	private MinHeap<BagOfAnything> obtainMinHeapFilled() {
		MinHeap<BagOfAnything> minHeap = new MinHeap<>();

		minHeap.insert(new BagOfAnything(10));
		minHeap.insert(new BagOfAnything(9));
		minHeap.insert(new BagOfAnything(8));
		minHeap.insert(new BagOfAnything(20));
		minHeap.insert(new BagOfAnything(70));
		minHeap.insert(new BagOfAnything(3));
		minHeap.insert(new BagOfAnything(50));

		return minHeap;
	}

	public static class BagOfAnything implements Scorable {

		int qtd;

		public BagOfAnything(int qtd) {
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
