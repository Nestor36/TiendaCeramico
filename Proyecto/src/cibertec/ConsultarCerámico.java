package cibertec;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarCerámico extends JDialog implements ActionListener {

    private final JPanel contentPanel = new JPanel();
    private static JTextField txtPrecio;
    private static JTextField txtAncho;
    private static JTextField txtLargo;
    private static JLabel lblEspesor;
    private JTextField txtEspesor;
    private JTextField txtContenido;
    String modeloSeleccionado;
    private JComboBox cboModelo;
    private JButton btnCerrar;

    public static void main(String[] args) {
        try {
            ConsultarCerámico dialog = new ConsultarCerámico();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConsultarCerámico() {
        setTitle("Consultar Cerámico");
        setBounds(100, 100, 500, 261);
        getContentPane().setLayout(null);
        contentPanel.setBounds(0, 0, 0, 0);
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);

        JLabel lblModelo = new JLabel("Modelo ");
        lblModelo.setFont(new Font("arial", Font.PLAIN, 12));
        lblModelo.setBounds(10, 26, 68, 21);
        getContentPane().add(lblModelo);

        cboModelo = new JComboBox();
        cboModelo.addActionListener(this);
        cboModelo.setFont(new Font("arial", Font.PLAIN, 12));
        cboModelo.setModel(new DefaultComboBoxModel(new String[]{"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalía"}));
        cboModelo.setBounds(129, 23, 220, 21);
        getContentPane().add(cboModelo);

        txtPrecio = new JTextField();
        txtPrecio.setFont(new Font("arial", Font.PLAIN, 12));
        txtPrecio.setEditable(false);
        txtPrecio.setBounds(129, 56, 220, 19);
        getContentPane().add(txtPrecio);
        txtPrecio.setColumns(10);

        JLabel lblPrecio = new JLabel("Precio (S/)");
        lblPrecio.setFont(new Font("arial", Font.PLAIN, 12));
        lblPrecio.setBounds(10, 57, 89, 21);
        getContentPane().add(lblPrecio);

        JLabel lblContenido = new JLabel("Contenido");
        lblContenido.setFont(new Font("arial", Font.PLAIN, 12));
        lblContenido.setBounds(10, 181, 68, 21);
        getContentPane().add(lblContenido);

        JLabel lblAncho = new JLabel("Ancho (cm)");
        lblAncho.setFont(new Font("arial", Font.PLAIN, 12));
        lblAncho.setBounds(10, 88, 89, 21);
        getContentPane().add(lblAncho);

        JLabel lblLargo = new JLabel("Largo (cm)");
        lblLargo.setFont(new Font("arial", Font.PLAIN, 12));
        lblLargo.setBounds(10, 119, 89, 21);
        getContentPane().add(lblLargo);

        lblEspesor = new JLabel("Espesor (mm)");
        lblEspesor.setFont(new Font("arial", Font.PLAIN, 12));
        lblEspesor.setBounds(10, 150, 109, 21);
        getContentPane().add(lblEspesor);

        txtAncho = new JTextField();
        txtAncho.setFont(new Font("arial", Font.PLAIN, 12));
        txtAncho.setEditable(false);
        txtAncho.setColumns(10);
        txtAncho.setBounds(129, 87, 220, 19);
        getContentPane().add(txtAncho);

        txtLargo = new JTextField();
        txtLargo.setFont(new Font("arial", Font.PLAIN, 12));
        txtLargo.setEditable(false);
        txtLargo.setColumns(10);
        txtLargo.setBounds(129, 118, 220, 19);
        getContentPane().add(txtLargo);

        txtEspesor = new JTextField();
        txtEspesor.setFont(new Font("arial", Font.PLAIN, 12));
        txtEspesor.setEditable(false);
        txtEspesor.setColumns(10);
        txtEspesor.setBounds(129, 151, 220, 19);
        getContentPane().add(txtEspesor);

        txtContenido = new JTextField();
        txtContenido.setFont(new Font("arial", Font.PLAIN, 12));
        txtContenido.setEditable(false);
        txtContenido.setColumns(10);
        txtContenido.setBounds(129, 182, 220, 19);
        getContentPane().add(txtContenido);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setFont(new Font("arial", Font.PLAIN, 12));
        btnCerrar.setBounds(391, 24, 85, 21);
        getContentPane().add(btnCerrar);

        txtPrecio.setText(MenúCerámicos.precio0 + "");
        txtAncho.setText(MenúCerámicos.ancho0 + "");
        txtLargo.setText(MenúCerámicos.largo0 + "");
        txtEspesor.setText(MenúCerámicos.espesor0 + "");
        txtContenido.setText(MenúCerámicos.contenido0 + "");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCerrar) {
            actionPerformedBtnCerrar(e);
        }
        if (e.getSource() == cboModelo) {
            actionPerformedCboModelo(e);
        }
    }
    
    void imprimirDatosDeCeramica(double precio, double ancho, double largo, double espesor, int contenido) {
    	 txtPrecio.setText(precio + "");
         txtAncho.setText(ancho + "");
         txtLargo.setText(largo + "");
         txtEspesor.setText(espesor + "");
         txtContenido.setText(contenido + "");
    }

    protected void actionPerformedCboModelo(ActionEvent e) {
        switch (cboModelo.getSelectedIndex()) {
            case 0:
                imprimirDatosDeCeramica(MenúCerámicos.precio0, MenúCerámicos.ancho0, MenúCerámicos.largo0, MenúCerámicos.espesor0, MenúCerámicos.contenido0);
                modeloSeleccionado = "0";
                break;
            case 1:
            	imprimirDatosDeCeramica(MenúCerámicos.precio1, MenúCerámicos.ancho1, MenúCerámicos.largo1, MenúCerámicos.espesor1, MenúCerámicos.contenido1);
                modeloSeleccionado = "1";
                break;
            case 2:
            	imprimirDatosDeCeramica(MenúCerámicos.precio2, MenúCerámicos.ancho2, MenúCerámicos.largo2, MenúCerámicos.espesor2, MenúCerámicos.contenido2);
                modeloSeleccionado = "2";
                break;
            case 3:
            	imprimirDatosDeCeramica(MenúCerámicos.precio3, MenúCerámicos.ancho3, MenúCerámicos.largo3, MenúCerámicos.espesor3, MenúCerámicos.contenido3);
                modeloSeleccionado = "3";
                break;
            default:
            	imprimirDatosDeCeramica(MenúCerámicos.precio4, MenúCerámicos.ancho4, MenúCerámicos.largo4, MenúCerámicos.espesor4, MenúCerámicos.contenido0);
                modeloSeleccionado = "4";
                break;
        }
    }

    protected void actionPerformedBtnCerrar(ActionEvent e) {
        dispose();
    }
}
