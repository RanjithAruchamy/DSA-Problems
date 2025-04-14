package data_structures.Arrays;

import java.util.Arrays;

public class MyArray {
    private int length;
    private int capacity;
    private Object[] data;

    MyArray() {
        this.length = 0;
        this.capacity = 1;
        data = new Object[1];
    }

    public int getLength() {
        return length;
    }


    public int getCapacity() {
        return capacity;
    }

    public Object[] getData() {
        return data;
    }

    public Object get(int index) {
        return data[index];
    }

    public void push(Object obj) {
        increaseCapacityIfFull();
        data[length] = obj;
        length++;
    }

    public Object pop() {
        Object itemTobeDeleted = data[length - 1];
        data[length - 1] = null;
        length--;
        return itemTobeDeleted;
    }

    public Object delete(int index) {
        Object itemTobeDeleted = data[index];
        shiftItemsLeft(index);
        return itemTobeDeleted;
    }

    public void add(int index, Object obj) {
        increaseCapacityIfFull();
        shiftItemsRight(index);
        data[index] = obj;
    }

    private void shiftItemsLeft(int index) {
        for (int i = index; i < length - 1 ; i++) {
            data[i] = data[i+1];
        }
        data[length-1] = null;
        this.length --;
    }

    private void shiftItemsRight(int index) {
        for (int i = length; i > index ; i--) {
            data[i] = data[i-1];
        }
        this.length ++;
    }

    private void increaseCapacityIfFull() {
        if(length == capacity) {
            data = Arrays.copyOf(data, capacity * 2);
            capacity *= 2;
        }
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray();

        myArray.push("Ranjith");
        myArray.push("Harshitha");
        myArray.push("Kumar");
        myArray.push("Rahul");
        myArray.push("Dravid");

        myArray.pop();

        myArray.delete(2);

        myArray.add(1, "Haasini");


        System.out.println("Data: " + Arrays.toString(myArray.getData()));
        System.out.println("Length: " + myArray.getLength());
    }
}
