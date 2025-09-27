package Vanilla.llama31;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task120 {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("User Input Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create input field and button
        JTextField inputField = new JTextField(20);
        JButton button = new JButton("Show user input");

        // Create label to display the input
        JLabel resultLabel = new JLabel();

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText();
                resultLabel.setText("<html><b>" + userInput + "</b></html>");
            }
        });

        // Add components to the frame
        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Enter your name:"));
        frame.add(inputField);
        frame.add(button);
        frame.add(resultLabel);

        // Set size and visibility
        frame.pack();
        frame.setVisible(true);
    }
}