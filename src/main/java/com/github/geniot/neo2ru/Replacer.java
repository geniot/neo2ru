package com.github.geniot.neo2ru;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Vitaly Sazanovich
 * Date: 6/7/18
 * Time: 12:12 AM
 */
public class Replacer {

    /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
//Create and set up the window.
        JFrame frame = new JFrame("Replacer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Add the ubiquitous "Hello World" label.
        final JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        JButton convert = new JButton("en2ru");
        convert.addActionListener(e -> {
            String s = textArea.getText();
            textArea.setText(convertText(s, CONV_MAP));
        });

        JButton unconvert = new JButton("ru2en");
        unconvert.addActionListener(e -> {
            String s = textArea.getText();
            textArea.setText(convertText(s, UNCONV_MAP));
        });

        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.getContentPane().add(convert, BorderLayout.SOUTH);
        frame.getContentPane().add(unconvert, BorderLayout.NORTH);

        frame.setMinimumSize(new Dimension(600, 800));
//Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private static final Map<Character, Character> CONV_MAP = new HashMap<>();
    private static final Map<Character, Character> UNCONV_MAP = new HashMap<>();
//    private static final Map<Character, Character> REP_MAP = new HashMap<>();

    static {
        CONV_MAP.put('f', 'а');
        CONV_MAP.put('F', 'А');
        CONV_MAP.put(',', 'б');
        CONV_MAP.put('<', 'Б');
        CONV_MAP.put('d', 'в');
        CONV_MAP.put('D', 'В');
        CONV_MAP.put('u', 'г');
        CONV_MAP.put('U', 'Г');
        CONV_MAP.put('l', 'д');
        CONV_MAP.put('L', 'Д');
        CONV_MAP.put('t', 'е');
        CONV_MAP.put('T', 'Е');
        CONV_MAP.put('`', 'ё');
        CONV_MAP.put('~', 'Ё');
        CONV_MAP.put(';', 'ж');
        CONV_MAP.put(':', 'Ж');
        CONV_MAP.put('p', 'з');
        CONV_MAP.put('P', 'З');
        CONV_MAP.put('b', 'и');
        CONV_MAP.put('B', 'И');
        CONV_MAP.put('q', 'й');
        CONV_MAP.put('Q', 'Й');
        CONV_MAP.put('r', 'к');
        CONV_MAP.put('R', 'К');
        CONV_MAP.put('k', 'л');
        CONV_MAP.put('K', 'Л');
        CONV_MAP.put('v', 'м');
        CONV_MAP.put('V', 'М');
        CONV_MAP.put('y', 'н');
        CONV_MAP.put('Y', 'Н');
        CONV_MAP.put('j', 'о');
        CONV_MAP.put('J', 'О');
        CONV_MAP.put('g', 'п');
        CONV_MAP.put('G', 'П');
        CONV_MAP.put('h', 'р');
        CONV_MAP.put('H', 'Р');
        CONV_MAP.put('c', 'с');
        CONV_MAP.put('C', 'С');
        CONV_MAP.put('n', 'т');
        CONV_MAP.put('N', 'Т');
        CONV_MAP.put('e', 'у');
        CONV_MAP.put('E', 'У');
        CONV_MAP.put('a', 'ф');
        CONV_MAP.put('A', 'Ф');
        CONV_MAP.put('[', 'х');
        CONV_MAP.put('{', 'Х');
        CONV_MAP.put('w', 'ц');
        CONV_MAP.put('W', 'Ц');
        CONV_MAP.put('x', 'ч');
        CONV_MAP.put('X', 'Ч');
        CONV_MAP.put('i', 'ш');
        CONV_MAP.put('I', 'Ш');
        CONV_MAP.put('o', 'щ');
        CONV_MAP.put('O', 'Щ');
        CONV_MAP.put(']', 'ъ');
        CONV_MAP.put('}', 'Ъ');
        CONV_MAP.put('s', 'ы');
        CONV_MAP.put('S', 'Ы');
        CONV_MAP.put('m', 'ь');
        CONV_MAP.put('M', 'Ь');
        CONV_MAP.put('\'', 'э');
        CONV_MAP.put('"', 'Э');
        CONV_MAP.put('.', 'ю');
        CONV_MAP.put('>', 'Ю');
        CONV_MAP.put('z', 'я');
        CONV_MAP.put('Z', 'Я');

        CONV_MAP.put('?', ',');
        CONV_MAP.put('/', '.');
        CONV_MAP.put('|', '/');
        CONV_MAP.put('@', '"');
        CONV_MAP.put('#', '№');
        CONV_MAP.put('$', ';');
        CONV_MAP.put('^', ':');
        CONV_MAP.put('&', '?');
    }

    static {
        for (char c : CONV_MAP.keySet()) {
            UNCONV_MAP.put(CONV_MAP.get(c), c);
        }
    }

    private static String convertText(String s, Map<Character, Character> map) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            boolean isUpper = Character.isUpperCase(c);
            Character res = map.get(c);
            if (res == null) {
                res = map.get(Character.toLowerCase(c));
            }


            if (res != null) {
                if (isUpper) {
                    sb.append(Character.toUpperCase(res));
                } else {
                    sb.append(res);
                }
            } else {
                sb.append(c);
            }

        }
        return sb.toString();
    }


    public static void main(String[] args) {
//Schedule a job for the event-dispatching thread:
//creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(Replacer::createAndShowGUI);
    }
}
