package cibertec;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarCuotaDiaria extends JDialog implements ActionListener {

    private final JPanel contentPanel = new JPanel();
    private JLabel lblCuota;
    private static JTextField txtCuotaD;
    private JButton btnAceptar;
    private JButton btnCancelar;

    public static void main(String[] args) {
        try {
            ConfigurarCuotaDiaria dialog = new ConfigurarCuotaDiaria();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConfigurarCuotaDiaria() {
        setTitle("Configurar cuota diaria");
        setBounds(100, 100, 450, 141);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        lblCuota = new JLabel("Cuota diaria esperada (S/.)");
        lblCuota.setFont(new Font("Garamond", Font.PLAIN, 14));
        lblCuota.setBounds(10, 22, 162, 20);
        contentPanel.add(lblCuota);

        txtCuotaD = new JTextField();
        txtCuotaD.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtCuotaD.setBounds(182, 22, 108, 20);
        contentPanel.add(txtCuotaD);
        txtCuotaD.setColumns(10);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        btnAceptar.setFont(new Font("Monospaced", Font.PLAIN, 12));
        btnAceptar.setBounds(324, 21, 89, 23);
        contentPanel.add(btnAceptar);

        txtCuotaD.setText(MenúCerámicos.cuotaDiaria + "");

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setFont(new Font("Monospaced", Font.PLAIN, 12));
        btnCancelar.setBounds(324, 55, 89, 23);
        contentPanel.add(btnCancelar);
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
        MenúCerámicos.cuotaDiaria = Double.parseDouble(txtCuotaD.getText());
    }
}
