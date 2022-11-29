package org.example.datastructures.heap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxHeapTest {

  @Test
  @DisplayName("Após a realização de inserçoes, a característica do max heap deve ser mantida")
  void testInsert() {
    MaxHeap<BagOfAnything> maxHeap = obtainMaxHeapFilled();
    System.out.println(maxHeap);

    assertEquals(70, maxHeap.getMaximum().qtd);
  }

  @Test
  @DisplayName(
          "Após a realização de remoçao do máximo, a característica do max heap deve ser mantida"
  )
  void testDeleteMaximum() {
    MaxHeap<BagOfAnything> maxHeap = obtainMaxHeapFilled();
    System.out.println(maxHeap);

    maxHeap.deleteMaximum();
    System.out.println(maxHeap);
    assertEquals(50, maxHeap.getMaximum().qtd);

    maxHeap.deleteMaximum();
    System.out.println(maxHeap);
    assertEquals(20, maxHeap.getMaximum().qtd);
  }

  @Test
  @DisplayName("Após a realização de remoçao, a característica do max heap deve ser mantida")
  void testDeleteElement() {
    MaxHeap<BagOfAnything> maxHeap = obtainMaxHeapFilled();
    System.out.println(maxHeap);
    assertEquals(70, maxHeap.getMaximum().qtd);

    maxHeap.deleteElement(2);
    System.out.println(maxHeap);
    assertEquals(70, maxHeap.getMaximum().qtd);

    maxHeap.deleteElement(0);
    System.out.println(maxHeap);
    assertEquals(20, maxHeap.getMaximum().qtd);

    maxHeap.deleteElement(0);
    System.out.println(maxHeap);
    assertEquals(10, maxHeap.getMaximum().qtd);
  }

  private MaxHeap<BagOfAnything> obtainMaxHeapFilled() {
    MaxHeap<BagOfAnything> maxHeap = new MaxHeap<>();

    maxHeap.insert(new BagOfAnything(10));
    maxHeap.insert(new BagOfAnything(9));
    maxHeap.insert(new BagOfAnything(8));
    maxHeap.insert(new BagOfAnything(20));
    maxHeap.insert(new BagOfAnything(70));
    maxHeap.insert(new BagOfAnything(3));
    maxHeap.insert(new BagOfAnything(50));

    return maxHeap;
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
