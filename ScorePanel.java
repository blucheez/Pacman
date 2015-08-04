
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nathan
 */
public class ScorePanel extends JPanel {

    public static JFrame frame;

    public void open() {
        frame = new JFrame("High Scores");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ScorePanel());
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
    }

    public ScorePanel() {
        setLayout(new BorderLayout());
        setOpaque(true);
        setBackground(Color.blue);
        setForeground(Color.yellow);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1, 3));
        JLabel name = new JLabel("Name", SwingConstants.CENTER);
        name.setForeground(Color.yellow);
        titlePanel.add(name);
        JLabel score = new JLabel("Score", SwingConstants.CENTER);
        score.setForeground(Color.yellow);
        titlePanel.add(score);
        JLabel numghost = new JLabel("Number of Ghosts", SwingConstants.CENTER);
        numghost.setForeground(Color.yellow);
        titlePanel.add(numghost);
        titlePanel.setBackground(Color.blue);
        add(titlePanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 10, 10));

        Scanner infile = null;
        try {
            infile = new Scanner(new File("scores.txt"));
            while (infile.hasNext()) {
                addPerson(mainPanel, infile.nextLine(), Integer.parseInt(infile.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File NOt Found");
        }

        mainPanel.setBackground(Color.blue);
        add(mainPanel, BorderLayout.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new Back());
        back.setBackground(Color.blue);
        back.setForeground(Color.yellow);
        back.setFocusPainted(false);
        add(back, BorderLayout.SOUTH);
        
    }

    private void addPerson(JPanel p, String s, int score) {
        JLabel newName = new JLabel(s, SwingConstants.RIGHT);
        newName.setForeground(Color.YELLOW);
        p.add(newName);
        JLabel newScore = new JLabel("" + score, SwingConstants.LEFT);
        newScore.setForeground(Color.YELLOW);
        p.add(newScore);
        
    }

    private class Back implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            Start.menuFrame.setVisible(true);
        }

    }
}
