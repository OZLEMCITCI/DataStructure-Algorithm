package com.ds.algorithm.datastructureandalgorithm.datastructure;

import java.util.NoSuchElementException;

public class LinkedList {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    int size=0;

    public Node head;

    public void addFront(int data) {

        Node newNode=new Node(data);
        if(head==null){
           head=newNode;
           size++;
           return;
        }
        newNode.next=head;
        head=newNode;
        size++;

    }

    public int getFirst() {
        return head.data;
    }

    public int getLast() {
        if(head==null){
            throw new NoSuchElementException("Empty List");
        }

        Node traverser=head;

        while(traverser.next!=null){
            traverser=traverser.next;
        }

        return traverser.data;

    }

    public void addBack(int data) {
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            size++;
            return;
        }

        Node traverser=head;
        while(traverser.next!=null){
            traverser=traverser.next;
        }

        traverser.next=newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
   head=null;
   size=0;
    }

    public void deleteValue(int data) {
        // if head
        if (head == null) {
            size--;
            return;
        }
        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }

        // else walk the list
        Node previous = head;

        while (previous.next != null) {
            if (previous.next.data == data) {
                previous.next = previous.next.next;
                size--;
                return;
            }
            previous = previous.next;
        }
        size--;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("");
    }

}
