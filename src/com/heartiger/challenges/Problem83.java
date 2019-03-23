package com.heartiger.challenges;

/*
This problem was asked by Microsoft.

Implement the singleton pattern with a twist.
First, instead of storing one instance, store two instances.
And in every even call of getInstance(),
return the first instance and in every odd call of getInstance(), return the second instance.

*/
public class Problem83 {

    static class DoubleSingleton {

        static DoubleSingleton doubleSingletonInstanceOdd = new DoubleSingleton();
        static DoubleSingleton doubleSingletonInstanceEven = new DoubleSingleton();

        static boolean doReturn = true;

        private DoubleSingleton(){}

        DoubleSingleton getInstance(){
            if(doReturn){
                doReturn = false;
                return doubleSingletonInstanceEven;
            } else {
                doReturn = true;
                return doubleSingletonInstanceOdd;
            }
        }
    }

    public static void main(String[] args) {
        DoubleSingleton doubleSingleton = new DoubleSingleton();
        assert doubleSingleton.getInstance() != doubleSingleton.getInstance(): "Test 1 Failed";
    }
}
