package zi2018.zad4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextStatFrame extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JButton statsBtn = new JButton("Statistics");
    private JButton freqBtn = new JButton("Show frequencies");
    private JTextArea resultArea = new JTextArea();

    public TextStatFrame(String title) {
        super(title);
        setLayout(new BorderLayout());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        resultArea.setEditable(false);

        JScrollPane scroller1 = new JScrollPane(textArea);
        JScrollPane scroller2 = new JScrollPane(resultArea);
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane1.setResizeWeight(0.5);
        splitPane1.setLeftComponent(scroller1);
        splitPane1.setRightComponent(scroller2);
        splitPane1.setPreferredSize(new Dimension(400, 200));
        add(splitPane1, BorderLayout.CENTER);
        JPanel btnPanel = new JPanel();
        //btnPanel.setLayout(new FlowLayout());
        btnPanel.add(statsBtn);
        btnPanel.add(freqBtn);
        add(btnPanel, BorderLayout.SOUTH);

        statsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resultArea.setText("");
                String[] words = getWords(textArea.getText());
                resultArea.setText(String.format(("No of words: %d\n"), words.length));
                for (String word : getFilteredWords(words, 6)) {
                    resultArea.append("\n"+ word);
                }
            }
        });

        freqBtn.addActionListener(actionEvent -> {
                resultArea.setText("");
                String[] words = getWords(textArea.getText());
                Runnable heavyTask = () -> {
                    Map<String, Integer> freq = getFrequencies(words);
                    for (String key : freq.keySet()) {
                        String value = freq.get(key).toString();
                        SwingUtilities.invokeLater(() -> resultArea.append(key + " " + value + "\n"));
                    }
            };
                new Thread(heavyTask).start();
        });

    }

    private String [] getWords(String text){
        return text.split("[^a-zA-Z]+");
    }

    private LinkedList<String> getFilteredWords(String[] words, int noOfCharacters) {
        LinkedList<String> filterd = new LinkedList<>();
        Stream.of(words)
                .filter(s -> s.length() >= noOfCharacters)
                .sorted((s1, s2)->(Integer.compare(s1.length(), s2.length())))
                .forEach(a -> filterd.add(a));
        return filterd;
    }
    Map<String, Integer> getFrequencies(String[] words){
        Map<String, Integer> frequencies = new TreeMap<>();
        for (String w : words) {
            w = w.toLowerCase();
            Integer n = frequencies.get(w);
            n = (n == null) ? 1 : ++n;
            frequencies.put(w, n);
        }
        return frequencies;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new TextStatFrame("Text Stat");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }


}
