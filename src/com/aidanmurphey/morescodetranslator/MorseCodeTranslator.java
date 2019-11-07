package com.aidanmurphey.morescodetranslator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.aidanmurphey.jsjf.LinkedBinaryTree;

public class MorseCodeTranslator {

    private static Scanner keyboardReader;
    private static Translator translator;

    public static void main(String[] args) {
        keyboardReader = new Scanner(System.in);
        LinkedBinaryTree<Character> alphabet = initAlphabet();
        translator = new Translator(alphabet);

        displayPreOrder(alphabet);

        while (processInput());

        keyboardReader.close();
        System.out.println("End of program");
    }

    public static boolean processInput() {
        String inputType = getInputType();
        if (inputType.equals("-1")) return false;

        ArrayList<String> input = inputType.equals("file") ? getFileInput() : getKeyboardInput();

        input.forEach((morseCode) -> {
            System.out.println("\"" + morseCode + "\" translates to: ");
            System.out.println(translator.translateLine(morseCode));
            System.out.println();
        });

        return true;
    }

    public static ArrayList<String> getFileInput() {
        ArrayList<String> result = new ArrayList<>();

        boolean exists;
        String fileName = null;

        do {
            if (fileName != null)
                System.out.println("File could not be found! Try again");

            System.out.print("Enter the file to be read: ");
            fileName = keyboardReader.nextLine();

            File file = new File(fileName);
            exists = file.exists();
        } while(!exists);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch(Exception e) {}

        return result;
    }

    public static ArrayList<String> getKeyboardInput() {
        ArrayList<String> result = new ArrayList<>();

        String input;
        do {
            System.out.println("All valid Morse code must end with a '#' and be 240 characters or less");
            System.out.print("Enter Morse code to be translated: ");
            input = keyboardReader.nextLine();
        } while (input.length() > 240 || input.charAt(input.length() - 1) != '#');

        result.add(input);

        return result;
    }

    public static String getInputType() {
        String input;

        do {
            System.out.print("Select an input method (file/keyboard or -1 to terminate): ");
            input = keyboardReader.nextLine().toLowerCase();
        } while(!input.equals("file") && !input.equals("keyboard") && !input.equals("-1"));

        return input;
    }

    public static void displayPreOrder(LinkedBinaryTree<Character> alphabet) {
        System.out.println("Preorder list:");
        alphabet.iteratorPreOrder().forEachRemaining(System.out::print);
        System.out.println();
    }

    private static LinkedBinaryTree<Character> initAlphabet() {
        LinkedBinaryTree<Character> h = new LinkedBinaryTree<>('H');
        LinkedBinaryTree<Character> v = new LinkedBinaryTree<>('V');
        LinkedBinaryTree<Character> s = new LinkedBinaryTree<>('S', v, h);
        
        LinkedBinaryTree<Character> f = new LinkedBinaryTree<>('F');
        LinkedBinaryTree<Character> u = new LinkedBinaryTree<>('U', f);
        
        LinkedBinaryTree<Character> i = new LinkedBinaryTree<>('I', u, s);
        
        LinkedBinaryTree<Character> l = new LinkedBinaryTree<>('L');
        LinkedBinaryTree<Character> r = new LinkedBinaryTree<>('R', l);
        
        LinkedBinaryTree<Character> p = new LinkedBinaryTree<>('P');
        LinkedBinaryTree<Character> j = new LinkedBinaryTree<>('J');
        LinkedBinaryTree<Character> w = new LinkedBinaryTree<>('W', j, p);
        
        LinkedBinaryTree<Character> a = new LinkedBinaryTree<>('A', w, r);
        
        LinkedBinaryTree<Character> b = new LinkedBinaryTree<>('B');
        LinkedBinaryTree<Character> x = new LinkedBinaryTree<>('X');
        LinkedBinaryTree<Character> d = new LinkedBinaryTree<>('D', x, b);
        
        LinkedBinaryTree<Character> c = new LinkedBinaryTree<>('C');
        LinkedBinaryTree<Character> y = new LinkedBinaryTree<>('Y');
        LinkedBinaryTree<Character> k = new LinkedBinaryTree<>('K', y, c);
        
        LinkedBinaryTree<Character> n = new LinkedBinaryTree<>('N', k, d);
        
        LinkedBinaryTree<Character> z = new LinkedBinaryTree<>('Z');
        LinkedBinaryTree<Character> q = new LinkedBinaryTree<>('Q');
        LinkedBinaryTree<Character> g = new LinkedBinaryTree<>('G', q, z);
        
        LinkedBinaryTree<Character> o = new LinkedBinaryTree<>('O');
        
        LinkedBinaryTree<Character> m = new LinkedBinaryTree<>('M', o, g);
        
        LinkedBinaryTree<Character> e = new LinkedBinaryTree<>('E', a, i);
        LinkedBinaryTree<Character> t = new LinkedBinaryTree<>('T', m, n);
        
        return new LinkedBinaryTree<>(' ', t, e);
    }
    
}
