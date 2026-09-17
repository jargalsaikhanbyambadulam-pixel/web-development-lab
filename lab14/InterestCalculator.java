import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InterestCalculator extends JFrame implements ActionListener {
    // UI Components
    private JLabel lblBalance, lblDuration, lblRate, lblTotal;
    private JTextField txtBalance, txtDuration, txtRate, txtTotal;
    private JButton btnOK, btnDelete;
    private JRadioButton rbMonth, rbAnnual;
    private ButtonGroup group;

    public InterestCalculator() {
        // 1. a) Create JFrame
        setTitle("Interest Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 1. b) Use GridLayout manager
        setLayout(new GridLayout(6, 2, 5, 5));

        // 1. c) Initialize Components
        rbMonth = new JRadioButton("Month Rate");
        rbAnnual = new JRadioButton("Annual Rate", true); // Default selected
        group = new ButtonGroup();
        group.add(rbMonth);
        group.add(rbAnnual);

        lblBalance = new JLabel("Balance Amount");
        txtBalance = new JTextField();

        lblDuration = new JLabel("Number of Year"); // Default label
        txtDuration = new JTextField();

        lblRate = new JLabel("Annual Interest Rate");
        txtRate = new JTextField();

        lblTotal = new JLabel("Total Payment");
        txtTotal = new JTextField();
        txtTotal.setEditable(false); // Total should not be edited manually

        btnOK = new JButton("OK");
        btnDelete = new JButton("Delete");

        // d. b) RadioButton logic: change 2nd JLabel text
        rbMonth.addActionListener(e -> lblDuration.setText("Number of Month"));
        rbAnnual.addActionListener(e -> lblDuration.setText("Number of Year"));

        // Add to Frame
        add(rbMonth); add(rbAnnual);
        add(lblBalance); add(txtBalance);
        add(lblDuration); add(txtDuration);
        add(lblRate); add(txtRate);
        add(lblTotal); add(txtTotal);
        add(btnOK); add(btnDelete);

        // Add ActionListeners
        btnOK.addActionListener(this);
        btnDelete.addActionListener(this);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // d. d) Delete button logic
        if (e.getSource() == btnDelete) {
            txtBalance.setText("");
            txtDuration.setText("");
            txtRate.setText("");
            txtTotal.setText("");
        } 
        // d. c) OK button logic
        else if (e.getSource() == btnOK) {
            try {
                // e) Handle empty inputs or non-numeric values
                if (txtBalance.getText().isEmpty() || txtDuration.getText().isEmpty() || txtRate.getText().isEmpty()) {
                    throw new NumberFormatException("Empty fields");
                }

                double balance = Double.parseDouble(txtBalance.getText());
                double duration = Double.parseDouble(txtDuration.getText());
                double rate = Double.parseDouble(txtRate.getText());
                double total = 0;

                // Calculation logic based on selection
                if (rbAnnual.isSelected()) {
                    // Simple annual interest: Principal + (Principal * Rate% * Years)
                    total = balance + (balance * (rate / 100) * duration);
                } else {
                    // Monthly interest logic as shown in image_4a1fb8.png example
                    total = balance + (balance * (rate / 100) * (duration / 12));
                }

                // Formatting result (using suggestion from image_4a2010.png)
                DecimalFormat df = new DecimalFormat("#,##0.00");
                txtTotal.setText(df.format(total));

            } catch (NumberFormatException ex) {
                // e) Show JOptionPane for errors
                String msg = txtBalance.getText().isEmpty() ? "Could you please input to textfield" : "it should be number";
                JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new InterestCalculator();
    }
}