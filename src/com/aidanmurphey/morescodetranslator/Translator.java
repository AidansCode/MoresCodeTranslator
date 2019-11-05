package com.aidanmurphey.morescodetranslator;

import com.aidanmurphey.jsjf.LinkedBinaryTree;

public class Translator {
    
    public static String translateLine(LinkedBinaryTree<Character> alphabet, String line) {
        String output = "", curLetter = "";
        
        for(char x : line.toCharArray()) {
            if (x == '|') {
                curLetter = "";
                output += " ";
            } else if (x == '-' || x == '.') {
                curLetter += x;
            } else if (!curLetter.equals("") && !curLetter.equals(" ")) {
                output += getLetter(alphabet, curLetter);
                curLetter = "";
            }
            
        }
        
        return output;
    }
    
    public static char getLetter(LinkedBinaryTree<Character> alphabet, String morseCodeWord) {
        return getLetter(alphabet, morseCodeWord, 0).getRootElement();
    }
    
    public static LinkedBinaryTree<Character> getLetter(LinkedBinaryTree<Character> tree, String match, int level) {
        LinkedBinaryTree<Character> next = null;
        
        try {
            if (match.charAt(level) == '-')
                next = tree.getLeft();
            else
                next = tree.getRight();
        } catch(Exception e) {
            return new LinkedBinaryTree(' ');
        }
        
        if (level + 1 == match.length()) {
            return next;
        } else {
            return getLetter(next, match, level+1);
        }
    }
    
}
