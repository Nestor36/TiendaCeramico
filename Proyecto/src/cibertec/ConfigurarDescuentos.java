package cibertec;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ConfigurarDescuentos extends JDialog implements ActionListener {

    private static JTextField txtmasde15;
    private static JTextField txt11a15;
    private static JTextField txt6a10;
    private static JTextField txt1a5;
    private final JPanel contentPanel = new JPanel();
    private JButton btnAceptar;
    private JButton btnCancelar;

    public static void main(String[] args) {
        try {
            ConfigurarDescuentos dialog = new ConfigurarDescuentos();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConfigurarDescuentos() {
        setTitle("Configurar porcentajes de descuento");
        setBounds(100, 100, 463, 173);
        getContentPane().setLayout(null);

        JLabel lbl1a5 = new JLabel("1 a 5 unidades");
        lbl1a5.setFont(new Font("arial", Font.PLAIN, 12));
        lbl1a5.setBounds(10, 15, 119, 14);
        getContentPane().add(lbl1a5);

        JLabel lbl6a10 = new JLabel("6 a 10 unidades");
        lbl6a10.setFont(new Font("arial", Font.PLAIN, 12));
        lbl6a10.setBounds(10, 44, 119, 14);
        getContentPane().add(lbl6a10);

        JLabel lbl11a15 = new JLabel("11 a 15 unidades");
        lbl11a15.setFont(new Font("arial", Font.PLAIN, 12));
        lbl11a15.setBounds(10, 73, 119, 14);
        getContentPane().add(lbl11a15);

        JLabel lblmasde15 = new JLabel("Más de 15 unidades");
        lblmasde15.setFont(new Font("Garamond", Font.PLAIN, 14));
        lblmasde15.setBounds(10, 102, 119, 14);
        getContentPane().add(lblmasde15);

        txtmasde15 = new JTextField();
        txtmasde15.setFont(new Font("arial", Font.PLAIN, 12));
        txtmasde15.setBounds(128, 100, 86, 20);
        getContentPane().add(txtmasde15);
        txtmasde15.setColumns(10);

        txt11a15 = new JTextField();
        txt11a15.setFont(new Font("arial", Font.PLAIN, 12));
        txt11a15.setColumns(10);
        txt11a15.setBounds(128, 70, 86, 20);
        getContentPane().add(txt11a15);

        txt6a10 = new JTextField();
        txt6a10.setFont(new Font("arial", Font.PLAIN, 12));
        txt6a10.setColumns(10);
        txt6a10.setBounds(128, 40, 86, 20);
        getContentPane().add(txt6a10);

        txt1a5 = new JTextField();
        txt1a5.setFont(new Font("arial", Font.PLAIN, 12));
        txt1a5.setColumns(10);
        txt1a5.setBounds(128, 10, 86, 20);
        getContentPane().add(txt1a5);

        JLabel lblPorcen1a5 = new JLabel("%");
        lblPorcen1a5.setFont(new Font("arial", Font.PLAIN, 12));
        lblPorcen1a5.setBounds(224, 15, 46, 14);
        getContentPane().add(lblPorcen1a5);

        JLabel lblPorcen6a10 = new JLabel("%");
        lblPorcen6a10.setFont(new Font("arial", Font.PLAIN, 12));
        lblPorcen6a10.setBounds(224, 44, 46, 14);
        getContentPane().add(lblPorcen6a10);

        JLabel lblPorcen11a15 = new JLabel("%");
        lblPorcen11a15.setFont(new Font("arial", Font.PLAIN, 12));
        lblPorcen11a15.setBounds(224, 73, 46, 14);
        getContentPane().add(lblPorcen11a15);

        JLabel lblPorcenmasde15 = new JLabel("%");
        lblPorcenmasde15.setFont(new Font("arial", Font.PLAIN, 12));
        lblPorcenmasde15.setBounds(224, 102, 46, 14);
        getContentPane().add(lblPorcenmasde15);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        btnAceptar.setFont(new Font("arial", Font.PLAIN, 12));
        btnAceptar.setBounds(315, 11, 113, 23);
        getContentPane().add(btnAceptar);

        txt1a5.setText(MenúCerámicos.porcentaje1 + "");
        txt6a10.setText(MenúCerámicos.porcentaje2 + "");
        txt11a15.setText(MenúCerámicos.porcentaje3 + "");
        txtmasde15.setText(MenúCerámicos.porcentaje4 + "");

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setFont(new Font("arial", Font.PLAIN, 12));
        btnCancelar.setBounds(315, 40, 113, 23);
        getContentPane().add(btnCancelar);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancelar) {
            actionPerformedBtnCancelar(e);
        }
        if (e.getSource() == btnAceptar) {
            actionPerformedBtnAceptar(e);
        }
    }

    protected void actionPerformedBtnAceptar(ActionEvent e) {
        MenúCerámicos.porcentaje1 = Double.parseDouble(txt1a5.getText());
        MenúCerámicos.porcentaje2 = Double.parseDouble(txt6a10.getText());
        MenúCerámicos.porcentaje3 = Double.parseDouble(txt11a15.getText());
        MenúCerámicos.porcentaje4 = Double.parseDouble(txtmasde15.getText());
        dispose();
    }

    protected void actionPerformedBtnCancelar(ActionEvent e) {
        dispose();
    }
}
