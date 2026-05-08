package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {

    private JTextField num1Field;
    private JTextField num2Field;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;

    // Placeholder for an icon. You need to place a file named 'calculator_icon.png'
    // in the same directory as the compiled class files for this to display.
    private ImageIcon calculatorIcon;
    private JLabel iconLabel;

    // Field for the image to be placed below buttons
    private ImageIcon backgroundImageIcon;
    private JLabel imageLabel;

    public SimpleCalculator() {
        // --- Frame Setup ---
        setTitle("Enhanced Simple Calculator");
        setSize(500, 550); // Increased size to accommodate new elements
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Use BorderLayout for better structure
        getContentPane().setBackground(Color.GREEN); // Set screen background to Lime

        // --- Set Window Icon ---
        try {
            // Load the image for the window icon.
            // IMPORTANT: Ensure '206.png' is accessible from the program's execution context.
            Image windowIcon = Toolkit.getDefaultToolkit().getImage("206.png");
            setIconImage(windowIcon);
        } catch (Exception e) {
            System.err.println("Warning: Could not set window icon from '206.png'. Please ensure the file exists and is accessible.");
        }

        // --- Top Panel for Icon and Title ---
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        topPanel.setBackground(new Color(176, 196, 222)); // Light Steel Blue background for top panel

        // Load the icon for the screen display. IMPORTANT: You need to provide 'calculator_icon.png'
        // in the same directory where the compiled .class file resides,
        // or provide a full path.
        try {
            calculatorIcon = new ImageIcon("calculator_icon.png"); // Path to your icon file for screen display
            // Scale the icon if needed, or ensure it's a suitable size.
            Image img = calculatorIcon.getImage();
            Image scaledImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            calculatorIcon = new ImageIcon(scaledImg);
            iconLabel = new JLabel(calculatorIcon);
            topPanel.add(iconLabel);
        } catch (Exception e) {
            System.err.println("Warning: Could not load calculator_icon.png for screen display. Please ensure the file exists.");
            iconLabel = new JLabel("Calculator"); // Fallback text
            topPanel.add(iconLabel);
        }

        JLabel titleLabel = new JLabel("Simple Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(70, 130, 180)); // Steel Blue for title
        topPanel.add(titleLabel);

        add(topPanel, BorderLayout.NORTH);

        // --- Center Panel for Inputs, Buttons, and Image ---
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.setBackground(Color.GREEN); // Match screen background

        // Input fields panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBackground(Color.GREEN); // Match background

        JLabel num1Label = new JLabel("First Number:");
        num1Label.setHorizontalAlignment(JLabel.RIGHT);
        num1Label.setFont(new Font("Arial", Font.PLAIN, 16));
        num1Field = new JTextField();
        num1Field.setPreferredSize(new Dimension(150, 30));

        JLabel num2Label = new JLabel("Second Number:");
        num2Label.setHorizontalAlignment(JLabel.RIGHT);
        num2Label.setFont(new Font("Arial", Font.PLAIN, 16));
        num2Field = new JTextField();
        num2Field.setPreferredSize(new Dimension(150, 30));

        inputPanel.add(num1Label);
        inputPanel.add(num1Field);
        inputPanel.add(num2Label);
        inputPanel.add(num2Field);

        centerPanel.add(inputPanel, BorderLayout.NORTH);

        // Operation buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(Color.GREEN); // Match background

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");

        Dimension buttonSize = new Dimension(70, 45);
        addButton.setPreferredSize(buttonSize);
        addButton.setBackground(new Color(144, 238, 144)); // Light Green
        addButton.setFont(new Font("Arial", Font.BOLD, 25));
        addButton.setForeground(Color.BLACK);

        subtractButton.setPreferredSize(buttonSize);
        subtractButton.setBackground(new Color(255, 182, 193)); // Light Pink
        subtractButton.setFont(new Font("Arial", Font.BOLD, 25));
        subtractButton.setForeground(Color.BLACK);

        multiplyButton.setPreferredSize(buttonSize);
        multiplyButton.setBackground(new Color(255, 218, 185)); // Peach Puff
        multiplyButton.setFont(new Font("Arial", Font.BOLD, 25));
        multiplyButton.setForeground(Color.BLACK);

        divideButton.setPreferredSize(buttonSize);
        divideButton.setBackground(new Color(173, 216, 230)); // Light Blue
        divideButton.setFont(new Font("Arial", Font.BOLD, 25));
        divideButton.setForeground(Color.BLACK);

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        centerPanel.add(buttonPanel, BorderLayout.CENTER); // Buttons are in the center of the centerPanel

        // --- Image Panel Below Buttons ---
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Panel for the image
        imagePanel.setBackground(Color.GREEN); // Match background

        try {
            // Load the image from the @ai-java folder (project root)
            // IMPORTANT: Ensure 'img.png' exists in the project root directory.
            backgroundImageIcon = new ImageIcon("img.png");
            // Scale the image to double its original size (width: 150*2=300, height: 100*2=200)
            Image img = backgroundImageIcon.getImage();
            Image scaledImg = img.getScaledInstance(300, 200, Image.SCALE_SMOOTH); // Scaled to double size
            backgroundImageIcon = new ImageIcon(scaledImg);
            imageLabel = new JLabel(backgroundImageIcon);
            imagePanel.add(imageLabel);
        } catch (Exception e) {
            System.err.println("Warning: Could not load img.png. Please ensure the file exists in the project root directory.");
            // Optionally add a placeholder label if image fails to load
            imagePanel.add(new JLabel("Image not found"));
        }

        // Add the image panel to the south of the center panel, so it appears below the buttons (which are in CENTER)
        centerPanel.add(imagePanel, BorderLayout.SOUTH);

        // Add the entire center panel to the main frame
        add(centerPanel, BorderLayout.CENTER);

        // --- Add Action Listeners ---
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        // Make the frame visible
        setVisible(true);
    }

    // Action Performed method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;
            String operation = "";
            String resultMessage = "";

            if (e.getSource() == addButton) {
                operation = "+";
                result = num1 + num2;
                resultMessage = String.format("%.2f %s %.2f = %.2f", num1, operation, num2, result);
            } else if (e.getSource() == subtractButton) {
                operation = "-";
                result = num1 - num2;
                resultMessage = String.format("%.2f %s %.2f = %.2f", num1, operation, num2, result);
            } else if (e.getSource() == multiplyButton) {
                operation = "*";
                result = num1 * num2;
                resultMessage = String.format("%.2f %s %.2f = %.2f", num1, operation, num2, result);
            } else if (e.getSource() == divideButton) {
                operation = "/";
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Error: Division by zero is not allowed.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
                    return; // Stop processing if division by zero
                }
                result = num1 / num2;
                resultMessage = String.format("%.2f %s %.2f = %.2f", num1, operation, num2, result);
            }

            // Display the result in a new dialog window
            JOptionPane.showMessageDialog(this, resultMessage, "Calculation Result", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            // Handle invalid input by showing a message dialog
            JOptionPane.showMessageDialog(this, "Error: Invalid input. Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            // Handle other potential errors
            JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(); // For debugging purposes
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread (EDT) for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleCalculator();
            }
        });
    }
}
