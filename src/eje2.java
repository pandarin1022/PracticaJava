import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class eje2 {

    private JFrame frame;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                eje2 window = new eje2();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public eje2() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 365, 424);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // etiquetas
        JLabel lblCantidad = new JLabel("Cantidad a retirar:");
        lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblCantidad.setBounds(30, 56, 120, 29);
        frame.getContentPane().add(lblCantidad);

        JLabel lbl10 = new JLabel("Billetes de S/.10");
        lbl10.setFont(new Font("Tahoma", Font.BOLD, 12));
        lbl10.setBounds(30, 107, 120, 29);
        frame.getContentPane().add(lbl10);

        JLabel lbl20 = new JLabel("Billetes de S/.20");
        lbl20.setFont(new Font("Tahoma", Font.BOLD, 12));
        lbl20.setBounds(30, 162, 120, 29);
        frame.getContentPane().add(lbl20);

        JLabel lbl50 = new JLabel("Billetes de S/.50");
        lbl50.setFont(new Font("Tahoma", Font.BOLD, 12));
        lbl50.setBounds(30, 225, 120, 29);
        frame.getContentPane().add(lbl50);

        JLabel lbl100 = new JLabel("Billetes de S/.100");
        lbl100.setFont(new Font("Tahoma", Font.BOLD, 12));
        lbl100.setBounds(30, 278, 120, 29);
        frame.getContentPane().add(lbl100);

        JLabel lbl200 = new JLabel("Billetes de S/.200");
        lbl200.setFont(new Font("Tahoma", Font.BOLD, 12));
        lbl200.setBounds(30, 328, 120, 29);
        frame.getContentPane().add(lbl200);

        // campos de texto
        t1 = new JTextField();
        t1.setBounds(160, 61, 86, 20);
        frame.getContentPane().add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setBounds(160, 112, 86, 20);
        t2.setEditable(false);  
        frame.getContentPane().add(t2);

        t3 = new JTextField();
        t3.setBounds(160, 167, 86, 20);
        t3.setEditable(false); 
        frame.getContentPane().add(t3);

        t4 = new JTextField();
        t4.setBounds(160, 230, 86, 20);
        t4.setEditable(false);  
        frame.getContentPane().add(t4);

        t5 = new JTextField();
        t5.setBounds(160, 283, 86, 20);
        t5.setEditable(false);   
        frame.getContentPane().add(t5);

        t6 = new JTextField();
        t6.setBounds(160, 333, 86, 20);
        t6.setEditable(false);   
        frame.getContentPane().add(t6);


        // botón ACEPTAR (bt1)
        JButton bt1 = new JButton("ACEPTAR");
        bt1.setBounds(256, 60, 89, 23);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // lee la cantidad como double y redondea a entero
                    double importe = Double.parseDouble(t1.getText().trim());
                    int monto = (int) Math.round(importe);
                    // debe ser multiplo de 10
                    if (monto < 10 || monto % 10 != 0) {
                        JOptionPane.showMessageDialog(frame,
                                "La cantidad debe ser un múltiplo de 10",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    // calcula minimo billetes
                    int c200 = monto / 200; monto %= 200;
                    int c100 = monto / 100; monto %= 100;
                    int c50  = monto / 50;  monto %= 50;
                    int c20  = monto / 20;  monto %= 20;
                    int c10  = monto / 10;  monto %= 10;
                    // asigna a los campos
                    t6.setText(String.valueOf(c200));
                    t5.setText(String.valueOf(c100));
                    t4.setText(String.valueOf(c50));
                    t3.setText(String.valueOf(c20));
                    t2.setText(String.valueOf(c10));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Ingrese un número válido",
                            "Error de formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.getContentPane().add(bt1);

        //  LIMPIAR (bt2)
        JButton bt2 = new JButton("LIMPIAR");
        bt2.setBounds(256, 111, 89, 23);
        bt2.addActionListener(e -> {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
        });
        frame.getContentPane().add(bt2);

        // SALIR (bt3)
        JButton bt3 = new JButton("SALIR");
        bt3.setBounds(256, 166, 89, 23);
        bt3.addActionListener(e -> System.exit(0));
        frame.getContentPane().add(bt3);
    }
}
