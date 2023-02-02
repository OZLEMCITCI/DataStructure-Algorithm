package com.ds.algorithm.datastructureandalgorithm.algorithms.datastructure;
import com.ds.algorithm.datastructureandalgorithm.datastructure.HashTable;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Test_HashTable {
    private HashTable hashTable;

    @BeforeEach
    public void SetUp() {
        hashTable = new HashTable();
    }

    @Test
    public void PutAndGet() {
        hashTable.put("John Smith", "521-1234");
        hashTable.put("Lisa Smith", "521-8976");
        hashTable.put("Sam Doe", "521-5030");
        hashTable.put("Sandra Dee", "521-9655");
        hashTable.put("Ted Baker", "418-4165");
        hashTable.toString();

        assertEquals("521-1234", hashTable.get("John Smith"));
        assertEquals("521-8976", hashTable.get("Lisa Smith"));
        assertEquals("521-5030", hashTable.get("Sam Doe"));
        assertEquals("521-9655", hashTable.get("Sandra Dee"));
        assertEquals("418-4165", hashTable.get("Ted Baker"));
        assertEquals(null, hashTable.get("Tim Lee"));


    }

    @Test
    public void Empty() {
        assertEquals(null, hashTable.get("Ted Baker"));
        assertEquals(null, hashTable.get("Tim Lee"));
        hashTable.toString();
    }

    @Test
    public void Collision() {
        // these keys will collide
        hashTable.put("John Smith", "521-1234");
        hashTable.put("Sandra Dee", "521-9655");

        assertEquals("521-1234", hashTable.get("John Smith"));
        assertEquals("521-9655", hashTable.get("Sandra Dee"));
        assertEquals(null, hashTable.get("Tim Lee"));
    }
}
