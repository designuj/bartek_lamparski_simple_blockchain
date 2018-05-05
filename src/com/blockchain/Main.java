package com.blockchain;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Block> blockchain = new ArrayList<>();

    public static void main(String[] args) {
        blockchain.add(new Block("lorem ipsum", "0"));
        blockchain.add(new Block("lorem ipsum", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("lorem ipsum", blockchain.get(blockchain.size()-1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }
}
