package com.example.cm.demo.observer.pattern;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * Created by 410063005 on 2018/5/25.
 */

public class JavaObserver {

    public static void main(String[] args) throws InterruptedException {

        MyObservable mo = new MyObservable();
        mo.addObserver(new MyObserver("MyObserver-a"));
        mo.addObserver(new MyObserver("MyObserver-b"));

        mo.setValue("1");

        Thread thread = new Thread(new DataProducer(mo));
        thread.start();
        thread.join();
    }

    static class DataProducer implements Runnable {

        final Random random;
        final MyObservable myObservable;

        DataProducer(MyObservable myObservable) {
            this.random = new Random();
            this.myObservable = myObservable;
        }

        @Override
        public void run() {
            //noinspection InfiniteLoopStatement
            while (true) {
                myObservable.setValue(random.nextInt());
                try {
                    Thread.sleep(random.nextInt(10) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyObserver implements Observer {

        private final String name;

        MyObserver(String name) {
            this.name = name;
        }

        @Override
        public void update(Observable observable, Object o) {
            System.out.println(name + " get new value " + o);
        }
    }

    static class MyObservable extends Observable {

        void setValue(Object value) {
            setChanged();
            notifyObservers(value);
        }
    }
}
