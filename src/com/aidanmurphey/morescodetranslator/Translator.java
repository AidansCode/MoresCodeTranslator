package com.aidanmurphey.morescodetranslator;

import com.aidanmurphey.jsjf.LinkedBinaryTree;

public class Translator {

    private LinkedBinaryTree<Character> alphabet;

    public Translator(LinkedBinaryTree<Character> alphabet) {
        this.alphabet = alphabet;
    }
    
    public String translateLine(String line) {
        StringBuilder output = new StringBuilder();
        String curLetter = "";

        for(char x : line.toCharArray()) {
            if (x == '|') {
                curLetter = "";
                output.append(" ");
            } else if (x == '-' || x == '.') {
                curLetter += x;
            } else if (!curLetter.equals("") && !curLetter.equals(" ")) {
                output.append(getLetter(curLetter));
                curLetter = "";
            }
            
        }
        
        return output.toString();
    }
    
    private char getLetter(String morseCodeWord) {
        return getLetter(alphabet, morseCodeWord, 0).getRootElement();
    }
    
    private LinkedBinaryTree<Character> getLetter(LinkedBinaryTree<Character> tree, String match, int level) {
        LinkedBinaryTree<Character> next;
        
        try {
            if (match.charAt(level) == '-')
                next = tree.getLeft();
            else
                next = tree.getRight();
        } catch(Exception e) {
            return new LinkedBinaryTree<>(' ');
        }
        
        if (level + 1 == match.length()) {
            return next;
        } else {
            return getLetter(next, match, level+1);
        }
    }
    
}
