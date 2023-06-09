
package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int countIn = 0;
    int countOut = 0;

    public T poll() {
        if (countIn == 0 && countOut == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        while (countIn != countOut) {
            out.push(in.pop());
            countOut++;
            countIn--;
        }
        return out.pop();
    }
     public void push(T value) {
    countIn++;
    countOut--;
    in.push(value);
    }
}
