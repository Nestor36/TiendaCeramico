package cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarObsequios extends JDialog implements ActionListener {

    private final JPanel contentPanel = new JPanel();
    private static JTextField txtTipodeobsequio;
    private static JTextField txt1a5;
    private static JTextField txt6a10;
    private static JTextField txt11amas;
    private JButton btnCancelar;
    private JButton btnAceptar;

    public static void main(String[] args) {
        try {
            ConfigurarObsequios dialog = new ConfigurarObsequios();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConfigurarObsequios() {
        setFont(new Font("Dialog", Font.PLAIN, 14));
        setTitle("Configurar obsequios");
        setBounds(100, 100, 450, 180);
        getContentPane().setLayout(null);

        {
            JLabel lblTipodeobsequio = new JLabel("Tipo de obsequio");
            lblTipodeobsequio.setFont(new Font("Monospaced", Font.PLAIN, 12));
            lblTipodeobsequio.setBounds(10, 20, 130, 31);
            getContentPane().add(lblTipodeobsequio);
        }
        {
            JLabel lbl1a5unidades = new JLabel("1 a 5 unidades");
            lbl1a5unidades.setFont(new Font("Monospaced", Font.PLAIN, 12));
            lbl1a5unidades.setBounds(10, 45, 130, 31);
            getContentPane().add(lbl1a5unidades);
        }
        {
            JLabel lbl6a10unidades = new JLabel("6 a 10 unidades");
            lbl6a10unidades.setFont(new Font("Monospaced", Font.PLAIN, 12));
            lbl6a10unidades.setBounds(10, 74, 130, 31);
            getContentPane().add(lbl6a10unidades);
        }
        {
            JLabel lbl11amasunidades = new JLabel("11 a más unidades");
            lbl11amasunidades.setFont(new Font("Monospaced", Font.PLAIN, 12));
            lbl11amasunidades.setBounds(10, 102, 130, 31);
            getContentPane().add(lbl11amasunidades);
        }
        {
            txtTipodeobsequio = new JTextField();
            txtTipodeobsequio.setFont(new Font("Monospaced", Font.PLAIN, 12));
            txtTipodeobsequio.setBounds(153, 24, 160, 19);
            getContentPane().add(txtTipodeobsequio);
            txtTipodeobsequio.setColumns(10);
        }
        {
            txt1a5 = new JTextField();
            txt1a5.setFont(new Font("Monospaced", Font.PLAIN, 12));
            txt1a5.setColumns(10);
            txt1a5.setBounds(153, 49, 160, 19);
            getContentPane().add(txt1a5);
        }
        {
            txt6a10 = new JTextField();
            txt6a10.setFont(new Font("Monospaced", Font.PLAIN, 12));
            txt6a10.setColumns(10);
            txt6a10.setBounds(153, 78, 160, 19);
            getContentPane().add(txt6a10);
        }
        {
            txt11amas = new JTextField();
            txt11amas.setFont(new Font("Monospaced", Font.PLAIN, 12));
            txt11amas.setColumns(10);
            txt11amas.setBounds(153, 106, 160, 19);
            getContentPane().add(txt11amas);
        }

        txtTipodeobsequio.setText(MenúCerámicos.tipoObsequio + "");
        txt1a5.setText(MenúCerámicos.obsequioCantidad1 + "");
        txt6a10.setText(MenúCerámicos.obsequioCantidad2 + "");
        txt11amas.setText(MenúCerámicos.obsequioCantidad3 + "");

        {
            btnCancelar = new JButton("Cancelar");
            btnCancelar.addActionListener(this);
            btnCancelar.setFont(new Font("Monospaced", Font.PLAIN, 12));
            btnCancelar.setBounds(323, 48, 103, 24);
            getContentPane().add(btnCancelar);
        }
        {
            btnAceptar = new JButton("Aceptar");
            btnAceptar.addActionListener(this);
            btnAceptar.setFont(new Font("Monospaced", Font.PLAIN, 12));
            btnAceptar.setBounds(323, 23, 103, 24);
            getContentPane().add(btnAceptar);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            actionPerformedBtnAceptar(e);
        }
        if (e.getSource() == btnCancelar) {
            actionPerformedBtnCancelar(e);
        }
    }

    protected void actionPerformedBtnCancelar(ActionEvent e) {
        dispose();
    }

    protected void actionPerformedBtnAceptar(ActionEvent e) {
        MenúCerámicos.tipoObsequio = String.valueOf(txtTipodeobsequio.getText());
        MenúCerámicos.obsequioCantidad1 = Integer.parseInt(txt1a5.getText());
        MenúCerámicos.obsequioCantidad2 = Integer.parseInt(txt6a10.getText());
        MenúCerámicos.obsequioCantidad3 = Integer.parseInt(txt11amas.getText());
        dispose();
    }
}
