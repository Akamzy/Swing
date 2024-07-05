import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    JFrame window = new JFrame("Physics");
    JTextField tfMass = new JTextField("Enter Mass");
    JTextField tfAcceleration = new JTextField("Enter Acceleration");
    JButton btnCalculate = new JButton("Calculate");

    void drawUI() {
        window.add(tfMass);
        window.add(tfAcceleration);
        window.add(btnCalculate);

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Physics physics = new Physics();
                    Float mass = Float.valueOf(tfMass.getText());
                    Float acceleration = Float.valueOf(tfAcceleration.getText());
                    float force = physics.calculateForce(mass, acceleration);
                    JOptionPane.showMessageDialog(null, "The force is: " + force);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Enter only numeric values");
                    nfe.printStackTrace();
                }
            }
        });

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(3, 1));
        window.setSize(200, 250);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UI().drawUI();
            }
        });
    }
}


