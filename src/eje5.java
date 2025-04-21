import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class eje5 {

    private JFrame frame;
    private JTextField t1; // Consumo
    private JTextField t2; // Descuento
    private JTextField t3; // Total a pagar

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                eje5 window = new eje5();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public eje5() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Pago con descuento");
        frame.setBounds(100, 100, 386, 230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Etiqueta y campo de consumo
        JLabel lblConsumo = new JLabel("Consumo S/.:");
        lblConsumo.setBounds(20, 20, 100, 25);
        frame.getContentPane().add(lblConsumo);

        t1 = new JTextField();
        t1.setBounds(130, 20, 120, 25);
        frame.getContentPane().add(t1);
        t1.setColumns(10);

        // Etiqueta y campo de descuento
        JLabel lblDescuento = new JLabel("Descuento S/.:");
        lblDescuento.setBounds(20, 60, 100, 25);
        frame.getContentPane().add(lblDescuento);

        t2 = new JTextField();
        t2.setBounds(130, 60, 120, 25);
        t2.setEditable(false);
        frame.getContentPane().add(t2);
        t2.setColumns(10);

        // Etiqueta y campo de total
        JLabel lblTotal = new JLabel("Total a pagar S/.:");
        lblTotal.setBounds(20, 100, 120, 25);
        frame.getContentPane().add(lblTotal);

        t3 = new JTextField();
        t3.setBounds(130, 100, 120, 25);
        t3.setEditable(false);
        frame.getContentPane().add(t3);
        t3.setColumns(10);

        // Boton ACEPTAR
        JButton bt1 = new JButton("ACEPTAR");
        bt1.setBounds(270, 20, 90, 25);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double consumo = Double.parseDouble(t1.getText().trim());
                    double porcentaje;
                    // aplicar regla de descuento
                    if (consumo >= 30.0 && consumo <= 50.0) {
                        porcentaje = 0.10;
                    } else if (consumo > 50.0) {
                        porcentaje = 0.20;
                    } else {
                        porcentaje = 0.0;
                    }
                    double descuento = consumo * porcentaje;
                    double total = consumo - descuento;
                    t2.setText(String.format("%.2f", descuento));
                    t3.setText(String.format("%.2f", total));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Ingrese un numero valido para consumo",
                        "Error de formato",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        frame.getContentPane().add(bt1);

        // Boton LIMPIAR
        JButton bt2 = new JButton("LIMPIAR");
        bt2.setBounds(270, 60, 90, 25);
        bt2.addActionListener(e -> {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        });
        frame.getContentPane().add(bt2);

        // Boton SALIR
        JButton bt3 = new JButton("SALIR");
        bt3.setBounds(270, 100, 90, 25);
        bt3.addActionListener(e -> System.exit(0));
        frame.getContentPane().add(bt3);
    }
}
