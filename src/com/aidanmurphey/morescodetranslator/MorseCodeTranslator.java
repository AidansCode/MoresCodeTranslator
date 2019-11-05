package com.aidanmurphey.morescodetranslator;

import java.util.Scanner;
import com.aidanmurphey.jsjf.LinkedBinaryTree;

public class MorseCodeTranslator {
    
    static LinkedBinaryTree<Character> alphabet;

    public static void main(String[] args) {
        alphabet = initAlphabet();

        System.out.println("Preorder list:");
        alphabet.iteratorPreOrder().forEachRemaining(System.out::print);
        System.out.println();
        
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("All valid Morse code must end with a #");
        do {
            System.out.print("Enter Morse code to be translated (-1 to terminate): ");
            input = scanner.nextLine();
            
            if (!input.equals("-1")) {
                
                if (input.length() > 240) {
                    System.out.println("Max character limit of 240! Try again");
                } else {
                    String english = Translator.translateLine(alphabet, input);
                    System.out.println(english);
                }
            }
        } while (!input.equals("-1"));
        
        System.out.println("End of program");
    }
    
    private static LinkedBinaryTree<Character> initAlphabet() {
        LinkedBinaryTree<Character> h = new LinkedBinaryTree('H');
        LinkedBinaryTree<Character> v = new LinkedBinaryTree('V');
        LinkedBinaryTree<Character> s = new LinkedBinaryTree('S', v, h);
        
        LinkedBinaryTree<Character> f = new LinkedBinaryTree('F');
        LinkedBinaryTree<Character> u = new LinkedBinaryTree('U', f);
        
        LinkedBinaryTree<Character> i = new LinkedBinaryTree('I', u, s);
        
        LinkedBinaryTree<Character> l = new LinkedBinaryTree('L');
        LinkedBinaryTree<Character> r = new LinkedBinaryTree('R', l);
        
        LinkedBinaryTree<Character> p = new LinkedBinaryTree('P');
        LinkedBinaryTree<Character> j = new LinkedBinaryTree('J');
        LinkedBinaryTree<Character> w = new LinkedBinaryTree('W', j, p);
        
        LinkedBinaryTree<Character> a = new LinkedBinaryTree('A', w, r);
        
        LinkedBinaryTree<Character> b = new LinkedBinaryTree('B');
        LinkedBinaryTree<Character> x = new LinkedBinaryTree('X');
        LinkedBinaryTree<Character> d = new LinkedBinaryTree('D', x, b);
        
        LinkedBinaryTree<Character> c = new LinkedBinaryTree('C');
        LinkedBinaryTree<Character> y = new LinkedBinaryTree('Y');
        LinkedBinaryTree<Character> k = new LinkedBinaryTree('K', y, c);
        
        LinkedBinaryTree<Character> n = new LinkedBinaryTree('N', k, d);
        
        LinkedBinaryTree<Character> z = new LinkedBinaryTree('Z');
        LinkedBinaryTree<Character> q = new LinkedBinaryTree('Q');
        LinkedBinaryTree<Character> g = new LinkedBinaryTree('G', q, z);
        
        LinkedBinaryTree<Character> o = new LinkedBinaryTree('O');
        
        LinkedBinaryTree<Character> m = new LinkedBinaryTree('M', o, g);
        
        LinkedBinaryTree<Character> e = new LinkedBinaryTree('E', a, i);
        LinkedBinaryTree<Character> t = new LinkedBinaryTree('T', m, n);
        
        LinkedBinaryTree<Character> alphabet = new LinkedBinaryTree(' ', t, e);
        
        return alphabet;
        
    }
    
}
