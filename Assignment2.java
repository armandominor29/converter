/**
 * @author Armando Minor
 * Assignment2.java set to produce GUI
 * and convert a binary input to a decimal output.
 * Incorrect input will result in error message displayed on GUI.
 */

/**Import classes needed for program to execute.*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**Class to create GUI*/
public class Assignment2 extends JFrame
{
    // Initialize labels for GUI.
    // @param binaryLabel label for binary input
    // @param decimalLabel label for decimal output
    private JLabel binaryLabel, decimalLabel;

    // Initialize text fields for GUI.
    // @param binaryStringTextField text field for binary input
    // @param decimalStringTextField text field for decimal output
    private JTextField binaryStringTextField, decimalStringTextField;

    // Initialize button for GUI
    // @param convertButton button to be pressed for conversion
    private JButton convertButton;
    private CalculateButtonHandler convertHandler;

    // Initialize parameters for GUI.
    // @param WIDTH width of window
    // @param HEIGHT height of window
    private static final int WIDTH = 600;
    private static final int HEIGHT = 100;

    /**Constructor for Assignment2*/
    public Assignment2()
    {
        // Assign values to labels.
        binaryLabel = new JLabel("Binary String: ", SwingConstants.RIGHT);
        decimalLabel = new JLabel("Decimal String: ", SwingConstants.RIGHT);

        // Set number of columns for both text fields to 15.
        binaryStringTextField = new JTextField(15);
        decimalStringTextField = new JTextField(15);

        // Set label, handler, and action listener for conversion.
        convertButton = new JButton("Convert To Decimal");
        convertHandler = new CalculateButtonHandler();
        convertButton.addActionListener(convertHandler);

        // Set title for window and configure grid layout.
        setTitle("Convert Binary to Decimal");
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(3,1));

        // Align components.
        pane.add(binaryLabel);
        pane.add(binaryStringTextField);
        pane.add(decimalLabel);
        pane.add(decimalStringTextField);
        pane.add(convertButton);

        // Set window size, make window visible, maintain default close operation.
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



    /**Import classes needed for program to execute.*/
    private class CalculateButtonHandler implements ActionListener
    {
        /**Method for binary to decimal conversion.*/
        public static int parseBinary(String bString) throws NumberFormatException{

            // Initialize variable varC for conversion
            int varC=Integer.parseInt(bString,2);
            return varC;
        }


        /** Action preformed method */
        public void actionPerformed(ActionEvent event)
        {
            // Initialize variables for input and output.
            // @param binaryInput user input(binary)
            // @param decimalOutput converted output(decimal)
            double binaryInput, decimalOutput;

            // try block
            try{
                binaryInput=parseBinary(binaryStringTextField.getText());
                decimalOutput = binaryInput;
                decimalStringTextField.setText("" + decimalOutput);

            }

            // catch block
            catch (NumberFormatException n){
                decimalStringTextField.setText("Illegal: input is not a binary number");
            }
        }
    }

    // Main method
    public static void main(String[] args)
    {
        Assignment2 DialogueBox = new Assignment2();
    }

}