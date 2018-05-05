package com.blockchain;

public class Main {

    public static void main(String[] args) {
        Block firstBlock = new Block("lorem ipsum", "0");
        System.out.println("Hash for 1 block: " + firstBlock.hash);

        Block secondBlock = new Block("lorem ipsum", firstBlock.hash);
        System.out.println("Hash for 2 block: " + secondBlock.hash);

        Block thirdBlock = new Block("lorem ipsum", secondBlock.hash);
        System.out.println("Hash for 3 block: " + thirdBlock.hash);
    }
}
