import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class B extends JFrame 
{ 
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JButton b1, b2;
    JRadioButton c1, c2;
    ButtonGroup bgroup;

    public B()
    {
        setTitle("Loan Calculator");

        setLayout(new GridLayout(7, 2, 5, 5)); // мөр нэмсэн

        bgroup = new ButtonGroup();    
        c1 = new JRadioButton("Month Rate");
        c2 = new JRadioButton("Annual Rate", true);

        bgroup.add(c1);
        bgroup.add(c2);

        add(c1);
        add(c2);

        l1 = new JLabel("Balance Amount");
        add(l1);
        t1 = new JTextField();
        add(t1);

        l2 = new JLabel("Number of Year");
        add(l2);
        t2 = new JTextField();
        add(t2);

        l3 = new JLabel("Annual Interest Rate");
        add(l3);
        t3 = new JTextField();
        add(t3);

        l4 = new JLabel("Total Payment");
        add(l4);
        t4 = new JTextField();
        t4.setEditable(false);
                add(t4);

        b1 = new JButton("OK");
        add(b1);

        b2 = new JButton("Delete");
        add(b2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); 
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new B();
    }
}