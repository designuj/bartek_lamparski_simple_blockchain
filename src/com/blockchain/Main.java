package com.blockchain;

import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static int difficulty = 2;

    public static void main(String[] args) {
        blockchain.add(new Block("lorem ipsum", "0"));
        System.out.println("Try to mine block 1...");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("lorem ipsum", blockchain.get(blockchain.size()-1).hash));
        System.out.println("Try to mine block 2...");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("lorem ipsum", blockchain.get(blockchain.size()-1).hash));
        System.out.println("Try to mine block 3...");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("Is blockchain valid: " + isChainValid());
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("Blockchain:");
        System.out.println(blockchainJson);
    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes are not equal");
                return false;
            }

            if (!previousBlock.hash.equals(previousBlock.calculateHash())) {
                System.out.println("Previous Hashes are not equal");
                return false;
            }

            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("Block has not been mined");
                return false;
            }
        }
        return true;
    }
}
