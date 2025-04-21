import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;

public class eje3 {

    private JFrame frame;
    private JTextField t1;   
    private JTextField t2;   
    private JTextField t3;   
    private JTextField t4;   
    private JTextField t5;   
    private JTextField t6;   
    private JTextField t7;   
    private JTextField t8;   

    private JRadioButton rDia, rNoc;        // Turno
    private JCheckBox ckRenta, ckFonavi, ckAfp; // Descuentos

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                eje3 window = new eje3();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public eje3() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Boleta de pago");
        frame.setBounds(100, 100, 400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // --- Labels ---
        JLabel lblTrab = new JLabel("TRABAJADOR:");
        lblTrab.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTrab.setBounds(10, 11, 100, 30);
        frame.getContentPane().add(lblTrab);

        JLabel lblSB = new JLabel("SUELDO S/.");
        lblSB.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblSB.setBounds(10, 83, 100, 30);
        frame.getContentPane().add(lblSB);

        JLabel lblHE = new JLabel("HORAS EXTRA:");
        lblHE.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblHE.setBounds(10, 132, 120, 30);
        frame.getContentPane().add(lblHE);

        JLabel lblPHE = new JLabel("Pago hora extra S/.");
        lblPHE.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPHE.setBounds(10, 181, 150, 30);
        frame.getContentPane().add(lblPHE);

        JLabel lblTurn = new JLabel("Turno:");
        lblTurn.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTurn.setBounds(249, 52, 100, 30);
        frame.getContentPane().add(lblTurn);

        JLabel lblDesc = new JLabel("Descuentos:");
        lblDesc.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDesc.setBounds(10, 222, 120, 30);
        frame.getContentPane().add(lblDesc);

        JLabel lblNeto = new JLabel("Sueldo neto S/.");
        lblNeto.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNeto.setBounds(10, 349, 120, 30);
        frame.getContentPane().add(lblNeto);

      
        t1 = new JTextField();      // Trabajador
        t1.setBounds(107, 21, 168, 20);
        frame.getContentPane().add(t1);

        t2 = new JTextField();      // Sueldo 
        t2.setBounds(143, 93, 86, 20);
        frame.getContentPane().add(t2);

        t3 = new JTextField();      // Horas extras
        t3.setBounds(143, 142, 86, 20);
        frame.getContentPane().add(t3);

        t4 = new JTextField();      // Pago hora extra
        t4.setBounds(143, 191, 86, 20);
        t4.setEditable(false);
        frame.getContentPane().add(t4);

        t5 = new JTextField();      // Renta
        t5.setBounds(143, 252, 86, 20);
        t5.setEditable(false);
        frame.getContentPane().add(t5);

        t6 = new JTextField();      // Fonavi
        t6.setBounds(143, 282, 86, 20);
        t6.setEditable(false);
        frame.getContentPane().add(t6);

        t7 = new JTextField();      // AFP
        t7.setBounds(143, 312, 86, 20);
        t7.setEditable(false);
        frame.getContentPane().add(t7);

        t8 = new JTextField();      // Sueldo neto
        t8.setBounds(143, 359, 86, 20);
        t8.setEditable(false);
        frame.getContentPane().add(t8);

        // --- RadioButtons de turno ---
        rDia = new JRadioButton("Diurno");
        rDia.setBounds(253, 92, 100, 23);
        frame.getContentPane().add(rDia);

        rNoc = new JRadioButton("Nocturno");
        rNoc.setBounds(253, 124, 100, 23);
        frame.getContentPane().add(rNoc);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rDia);
        bg.add(rNoc);

        // --- Checkboxes de descuentos ---
        ckRenta  = new JCheckBox("Renta");
        ckRenta.setBounds(28, 255, 80, 23);
        frame.getContentPane().add(ckRenta);

        ckFonavi = new JCheckBox("Fonavi");
        ckFonavi.setBounds(28, 285, 80, 23);
        frame.getContentPane().add(ckFonavi);

        ckAfp    = new JCheckBox("AFP");
        ckAfp.setBounds(28, 315, 80, 23);
        frame.getContentPane().add(ckAfp);

        // --- Botones ---
        JButton bt1 = new JButton("ACEPTAR");
        bt1.setBounds(267, 239, 89, 23);
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double sb = Double.parseDouble(t2.getText().trim());
                    int he  = Integer.parseInt(t3.getText().trim());
                    // tarifa por turno
                    int tarifa = rDia.isSelected() ? 10
                                : rNoc.isSelected() ? 15
                                : 0;
                    if (tarifa==0) {
                        JOptionPane.showMessageDialog(frame,
                            "Seleccione un turno",
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    t4.setText(String.valueOf(tarifa));

                    // descuentos
                    double renta  = ckRenta.isSelected()  ? sb * 0.10 : 0;
                    double fonavi = ckFonavi.isSelected() ? sb * 0.07 : 0;
                    double afp    = ckAfp.isSelected()    ? sb * 0.03 : 0;

                    t5.setText(String.format("%.2f", renta));
                    t6.setText(String.format("%.2f", fonavi));
                    t7.setText(String.format("%.2f", afp));

                    // neto = ingresos - egresos
                    double ingresos = sb + he * tarifa;
                    double egresos  = renta + fonavi + afp;
                    double neto     = ingresos - egresos;
                    t8.setText(String.format("%.2f", neto));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                        "Revise los valores numéricos",
                        "Error de formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.getContentPane().add(bt1);

        JButton bt2 = new JButton("LIMPIAR");
        bt2.setBounds(267, 277, 89, 23);
        bt2.addActionListener(e -> {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
            rDia.setSelected(false);
            rNoc.setSelected(false);
            ckRenta.setSelected(false);
            ckFonavi.setSelected(false);
            ckAfp.setSelected(false);
        });
        frame.getContentPane().add(bt2);

        JButton bt3 = new JButton("SALIR");
        bt3.setBounds(267, 317, 89, 23);
        bt3.addActionListener(e -> System.exit(0));
        frame.getContentPane().add(bt3);
    }
}
