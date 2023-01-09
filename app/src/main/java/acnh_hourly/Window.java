package acnh_hourly;

import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Taskbar;

import java.awt.FlowLayout;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {

    public Window (Player player) {
        JFrame frame = new JFrame("ACNH Hourly");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JPanel pausePanel = new JPanel();
        pausePanel.setLayout(new FlowLayout());


        JButton play = new JButton("Default");
        play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player.play(Weather.SUNNY);
            }
            
        });

        JButton rainy = new JButton("Rainy");
        rainy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.play(Weather.RAINY);
            }
        });

        JButton snowy = new JButton("Snowy");
        snowy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.play(Weather.SNOWY);
            }
        });

        JButton pause = new JButton("Pause");
        pause.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player.pause();
            }
            
        });

        buttonPanel.add(play);
        buttonPanel.add(rainy);
        buttonPanel.add(snowy);
        pausePanel.add(pause);

        panel.add(Box.createVerticalGlue());
        panel.add(buttonPanel);
        panel.add(pausePanel);

        frame.setSize(400, 200);

        Image image = (new ImageIcon("src/main/resources/icon.png")).getImage();
        frame.setIconImage(image);

        if (Taskbar.isTaskbarSupported()) {
            Taskbar taskbar = Taskbar.getTaskbar();
            taskbar.setIconImage(image);
        }

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
