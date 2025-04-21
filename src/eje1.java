import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
/**
 * @wbp.parser.entryPoint
 */
public class eje1 {

    private JFrame frame;
    private JTextField t2;
    private JTextField t1;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                eje1 window = new eje1();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public eje1() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // ACEPTAR
        JButton bt1 = new JButton("ACEPTAR");
        bt1.setBounds(21, 206, 109, 23);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                try {
                    LocalDate nacimiento = LocalDate.parse(t1.getText().trim(), fmt);
                    LocalDate hoy = LocalDate.now();
                    if (nacimiento.isAfter(hoy)) {
                        JOptionPane.showMessageDialog(
                            frame,
                            "La fecha no puede ser futura",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                        );
                    } else {
                        int años = Period.between(nacimiento, hoy).getYears();
                        t2.setText(años + " años");
                    }
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Fecha inválida. Use el formato dd/MM/yyyy",
                        "Error de formato",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        frame.getContentPane().add(bt1);

        //  LIMPIAR
        JButton bt2 = new JButton("LIMPIAR");
        bt2.setBounds(158, 206, 109, 23);
        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("");
                t2.setText("");
            }
        });
        frame.getContentPane().add(bt2);

        //  SALIR
        JButton bt3 = new JButton("SALIR");
        bt3.setBounds(292, 206, 109, 23);
        bt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.getContentPane().add(bt3);

        // Etiquetas y campos de texto
        JLabel lblFecha = new JLabel("FECHA DE NACIMIENTO:");
        lblFecha.setVerticalAlignment(SwingConstants.BOTTOM);
        lblFecha.setBounds(33, 44, 124, 39);
        frame.getContentPane().add(lblFecha);

        t1 = new JTextField();
        t1.setBounds(160, 66, 86, 20);
        frame.getContentPane().add(t1);
        t1.setColumns(10);

        JLabel lblEdad = new JLabel("SU EDAD ES:");
        lblEdad.setBounds(87, 95, 81, 39);
        frame.getContentPane().add(lblEdad);

        t2 = new JTextField();
        t2.setBounds(160, 104, 86, 20);
        t2.setEditable(false);
        frame.getContentPane().add(t2);
        t2.setColumns(10);
    }
}
