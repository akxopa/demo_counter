package com.learnjavacore;

import java.util.Objects;

public class Counter {
    private int count = 0;

    public Counter() {
    }

    public Counter(int counter) {
        this.count = counter;
    }

    public void setCounter(int count) {
        this.count = count;
    }

    public int getCounter() {
        return count;
    }

    public void increment() {
        this.count++;
    }

    public void reset() {
        this.count = 0;
    }


    @Override
    public String toString() {
        String decoration = "-*-".repeat(10);
        return decoration + "\nТекущее значение счетчика '" + this.getCounter() + "'\n" + decoration;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
