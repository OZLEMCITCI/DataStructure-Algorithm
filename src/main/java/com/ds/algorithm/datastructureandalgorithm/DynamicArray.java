package com.ds.algorithm.datastructureandalgorithm;

public class DynamicArray <String>{
     private Object[] data;
     private int initialCapacity;
     private int size=0;
    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data=new Object[initialCapacity];
    }

    public String get(int index){
       return (String)data[index];
    }

    public void set(int index,String value){
      data[index]=value;
    }

    public void insert(int index,String value){
        if(initialCapacity==size){
            resize();
        }
        for(int i=index;i<size+1;i++){
           data[i+1]=data[i];
        }
        data[index]=value;
        size++;
    }
    public void delete (int index){
        for(int i=index;i<size-1;i++){
           data[i]=data[i+1];
        }
        data[size-1]=null;
        size++;
    }
    private void resize(){
        Object[] newData=new Object[2*initialCapacity];

        for(int i=0;i<data.length;i++){
            newData[i]=data[i];
        }

        data=newData;initialCapacity*=2;
    }
    public int size(){
      return size;
    }

    public void print(){
        for(int i=0;i<size;i++){
            System.out.println("data["+i+"]="+data[i]);
        }

    }

    public void add(String value){
       if(size==initialCapacity){
           resize();
       }
    }
}
