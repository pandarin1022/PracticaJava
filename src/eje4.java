import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class eje4 {

    private JFrame frame;
    private JTextField t1; // dia
    private JTextField t2; // mes
    private JTextField t3; // año
    private JTextField t4; // salida “En letras”

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                eje4 window = new eje4();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public eje4() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Fecha en letras");
        frame.setBounds(100, 100, 350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Labels y campos
        JLabel lblDia = new JLabel("Día:");
        lblDia.setBounds(20, 20, 80, 25);
        frame.getContentPane().add(lblDia);

        t1 = new JTextField();
        t1.setBounds(100, 20, 80, 25);
        frame.getContentPane().add(t1);

        JLabel lblMes = new JLabel("Mes:");
        lblMes.setBounds(20, 60, 80, 25);
        frame.getContentPane().add(lblMes);

        t2 = new JTextField();
        t2.setBounds(100, 60, 80, 25);
        frame.getContentPane().add(t2);

        JLabel lblAño = new JLabel("Año:");
        lblAño.setBounds(20, 100, 80, 25);
        frame.getContentPane().add(lblAño);

        t3 = new JTextField();
        t3.setBounds(100, 100, 80, 25);
        frame.getContentPane().add(t3);

        // Botones
        JButton bt1 = new JButton("Aceptar");
        bt1.setBounds(210, 20, 100, 25);
        frame.getContentPane().add(bt1);

        JButton bt2 = new JButton("Limpiar");
        bt2.setBounds(210, 60, 100, 25);
        frame.getContentPane().add(bt2);

        JButton bt3 = new JButton("Salir");
        bt3.setBounds(210, 100, 100, 25);
        frame.getContentPane().add(bt3);

        // Campo de salida
        JLabel lblSalida = new JLabel("En letras:");
        lblSalida.setBounds(20, 150, 80, 25);
        frame.getContentPane().add(lblSalida);

        t4 = new JTextField();
        t4.setBounds(100, 150, 210, 25);
        t4.setEditable(false);
        frame.getContentPane().add(t4);

        //  ACEPTAR
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] meses = {
                    "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                    "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
                };
                try {
                    int dia = Integer.parseInt(t1.getText().trim());
                    int mes = Integer.parseInt(t2.getText().trim());
                    int año = Integer.parseInt(t3.getText().trim());
                    // intenta crear la fecha
                    LocalDate fecha = LocalDate.of(año, mes, dia);
                    String mesNombre = meses[mes - 1];
                    t4.setText(dia + " de " + mesNombre + " de " + año);
                } catch (NumberFormatException | DateTimeException ex) {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Error de datos......",
                        "Error de datos",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        //  LIMPIAR
        bt2.addActionListener(e -> {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        });

        //  SALIR
        bt3.addActionListener(e -> {
            int resp = JOptionPane.showConfirmDialog(
                frame,
                "¿Desea terminar la aplicación?",
                "Pregunta",
                JOptionPane.YES_NO_OPTION
            );
            if (resp == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }
}
