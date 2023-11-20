package cibertec;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ModificarCerámico extends JDialog implements ActionListener {

    private final JPanel contentPanel = new JPanel();
    private static JTextField txtPrecio;
    private static JTextField txtLargo;
    private static JTextField txtEspesor;
    private static JTextField txtContenido;
    private static JTextField txtAncho;

    private JButton btnCerrar;
    private JButton btnGrabar;
    private JComboBox cboModelo;

    public static void main(String[] args) {
        try {
            ModificarCerámico dialog = new ModificarCerámico();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ModificarCerámico() {
        setTitle("Modificar Cer\u00E1mico");
        getContentPane().setFont(new Font("Dialog", Font.PLAIN, 15));
        setBounds(100, 100, 493, 216);
        getContentPane().setLayout(null);

        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setFont(new Font("Monospaced", Font.PLAIN, 14));
        lblModelo.setBounds(10, 11, 66, 14);
        getContentPane().add(lblModelo);

        JLabel lblPrecio = new JLabel("Precio (S/)");
        lblPrecio.setFont(new Font("Monospaced", Font.PLAIN, 14));
        lblPrecio.setBounds(10, 36, 105, 14);
        getContentPane().add(lblPrecio);

        JLabel lblAncho = new JLabel("Ancho (cm)");
        lblAncho.setFont(new Font("Monospaced", Font.PLAIN, 14));
        lblAncho.setBounds(10, 61, 94, 14);
        getContentPane().add(lblAncho);

        JLabel lblLargo = new JLabel("Largo(cm)");
        lblLargo.setFont(new Font("Monospaced", Font.PLAIN, 14));
        lblLargo.setBounds(10, 86, 86, 14);
        getContentPane().add(lblLargo);

        JLabel lblEspesor = new JLabel("Espesor(mm)");
        lblEspesor.setFont(new Font("Monospaced", Font.PLAIN, 14));
        lblEspesor.setBounds(10, 111, 94, 14);
        getContentPane().add(lblEspesor);

        JLabel lblContenido = new JLabel("Contenido");
        lblContenido.setFont(new Font("Monospaced", Font.PLAIN, 14));
        lblContenido.setBounds(10, 136, 80, 14);
        getContentPane().add(lblContenido);

        cboModelo = new JComboBox();
        cboModelo.addActionListener(this);

        cboModelo.setModel(new DefaultComboBoxModel(new String[]{"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalía"}));
        cboModelo.setFont(new Font("Monospaced", Font.PLAIN, 14));
        cboModelo.setBounds(125, 7, 151, 22);
        getContentPane().add(cboModelo);

        txtPrecio = new JTextField();
        txtPrecio.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtPrecio.setBounds(125, 33, 151, 20);
        getContentPane().add(txtPrecio);
        txtPrecio.setColumns(10);

        txtAncho = new JTextField();
        txtAncho.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtAncho.setBounds(125, 58, 151, 20);
        getContentPane().add(txtAncho);
        txtAncho.setColumns(10);

        txtLargo = new JTextField();
        txtLargo.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtLargo.setBounds(125, 83, 151, 20);
        getContentPane().add(txtLargo);
        txtLargo.setColumns(10);

        txtEspesor = new JTextField();
        txtEspesor.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtEspesor.setBounds(125, 108, 151, 20);
        getContentPane().add(txtEspesor);
        txtEspesor.setColumns(10);

        txtContenido = new JTextField();
        txtContenido.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtContenido.setBounds(125, 133, 151, 20);
        getContentPane().add(txtContenido);
        txtContenido.setColumns(10);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setFont(new Font("Monospaced", Font.PLAIN, 14));
        btnCerrar.setBounds(346, 7, 89, 23);
        getContentPane().add(btnCerrar);

        btnGrabar = new JButton("Grabar");
        btnGrabar.addActionListener(this);
        btnGrabar.setFont(new Font("Monospaced", Font.PLAIN, 14));
        btnGrabar.setBounds(346, 32, 89, 23);
        getContentPane().add(btnGrabar);

        txtPrecio.setText(MenúCerámicos.precio0 + "");
        txtAncho.setText(MenúCerámicos.ancho0 + "");
        txtLargo.setText(MenúCerámicos.largo0 + "");
        txtEspesor.setText(MenúCerámicos.espesor0 + "");
        txtContenido.setText(MenúCerámicos.contenido0 + "");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cboModelo) {
            actionPerformedCboModelo(e);
        }
        if (e.getSource() == btnGrabar) {
            actionPerformedBtnGrabar(e);
        }
        if (e.getSource() == btnCerrar) {
            actionPerformedBtnCerrar(e);
        }
    }

    protected void actionPerformedBtnCerrar(ActionEvent e) {
        dispose();
    }

    protected void actionPerformedBtnGrabar(ActionEvent e) {
        MenúCerámicos.precio0 = Double.parseDouble(txtPrecio.getText());
        MenúCerámicos.ancho0 = Double.parseDouble(txtAncho.getText());
        MenúCerámicos.largo0 = Double.parseDouble(txtLargo.getText());
        MenúCerámicos.espesor0 = Double.parseDouble(txtEspesor.getText());
        MenúCerámicos.contenido0 = (int) Double.parseDouble(txtContenido.getText());
        dispose();
    }

    protected void actionPerformedCboModelo(ActionEvent e) {
        switch (cboModelo.getSelectedIndex()) {
            case 0:
                txtPrecio.setText(MenúCerámicos.precio0 + "");
                txtAncho.setText(MenúCerámicos.ancho0 + "");
                txtLargo.setText(MenúCerámicos.largo0 + "");
                txtEspesor.setText(MenúCerámicos.espesor0 + "");
                txtContenido.setText(MenúCerámicos.contenido0 + "");
                break;
            case 1:
                txtPrecio.setText(MenúCerámicos.precio1 + "");
                txtAncho.setText(MenúCerámicos.ancho1 + "");
                txtLargo.setText(MenúCerámicos.largo1 + "");
                txtEspesor.setText(MenúCerámicos.espesor1 + "");
                txtContenido.setText(MenúCerámicos.contenido1 + "");
                break;
            case 2:
                txtPrecio.setText(MenúCerámicos.precio2 + "");
                txtAncho.setText(MenúCerámicos.ancho2 + "");
                txtLargo.setText(MenúCerámicos.largo2 + "");
                txtEspesor.setText(MenúCerámicos.espesor2 + "");
                txtContenido.setText(MenúCerámicos.contenido2 + "");
                break;
            case 3:
                txtPrecio.setText(MenúCerámicos.precio3 + "");
                txtAncho.setText(MenúCerámicos.ancho3 + "");
                txtLargo.setText(MenúCerámicos.largo3 + "");
                txtEspesor.setText(MenúCerámicos.espesor3 + "");
                txtContenido.setText(MenúCerámicos.contenido3 + "");
                break;
            default:
                txtPrecio.setText(MenúCerámicos.precio4 + "");
                txtAncho.setText(MenúCerámicos.ancho4 + "");
                txtLargo.setText(MenúCerámicos.largo4 + "");
                txtEspesor.setText(MenúCerámicos.espesor4 + "");
                txtContenido.setText(MenúCerámicos.contenido4 + "");
                break;
        }
    }
}
