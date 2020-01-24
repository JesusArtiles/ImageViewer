package implementation.view.ui;

import control.Command;
import view.ui.ImageDisplay;

import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.*;
import java.util.HashMap;


public class MainFrame extends JFrame {

    private Map<String, Command> commands = new HashMap<>();
    private ImageDisplay imageDisplay;

    public MainFrame() {
        this.setTitle("Image Viewer");
        this.setSize(900, 650);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(image());
        this.add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);

    }

    public void add(Command command){
        commands.put(command.name(), command);
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(button("previous"));
        panel.add(button("next"));
        return panel;
    }
    private Component button(String name) {
        JButton button = new JButton(name);
        button.addActionListener(execute(name));
        return button;
    }

    private Component image() {
        SwingImageDisplay display = new SwingImageDisplay();
        imageDisplay = display;
        return display;
    }

    private ActionListener execute(String name) {
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                commands.get(name).execute();
            }
        };
    }

}