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
		setBounds(100, 100, 459, 216);
		getContentPane().setLayout(null);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("arial", Font.PLAIN, 14));
		lblModelo.setBounds(10, 13, 66, 14);
		getContentPane().add(lblModelo);

		JLabel lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setFont(new Font("arial", Font.PLAIN, 14));
		lblPrecio.setBounds(10, 40, 105, 14);
		getContentPane().add(lblPrecio);

		JLabel lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setFont(new Font("arial", Font.PLAIN, 14));
		lblAncho.setBounds(10, 67, 94, 14);
		getContentPane().add(lblAncho);

		JLabel lblLargo = new JLabel("Largo(cm)");
		lblLargo.setFont(new Font("arial", Font.PLAIN, 14));
		lblLargo.setBounds(10, 94, 86, 14);
		getContentPane().add(lblLargo);

		JLabel lblEspesor = new JLabel("Espesor(mm)");
		lblEspesor.setFont(new Font("arial", Font.PLAIN, 14));
		lblEspesor.setBounds(10, 121, 94, 14);
		getContentPane().add(lblEspesor);

		JLabel lblContenido = new JLabel("Contenido");
		lblContenido.setFont(new Font("arial", Font.PLAIN, 14));
		lblContenido.setBounds(10, 148, 80, 14);
		getContentPane().add(lblContenido);

		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);

		cboModelo.setModel(
				new DefaultComboBoxModel(new String[] { "Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalía" }));
		cboModelo.setFont(new Font("arial", Font.PLAIN, 14));
		cboModelo.setBounds(125, 7, 151, 22);
		getContentPane().add(cboModelo);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("arial", Font.PLAIN, 14));
		txtPrecio.setBounds(125, 36, 151, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		txtAncho = new JTextField();
		txtAncho.setFont(new Font("arial", Font.PLAIN, 14));
		txtAncho.setBounds(125, 63, 151, 20);
		getContentPane().add(txtAncho);
		txtAncho.setColumns(10);

		txtLargo = new JTextField();
		txtLargo.setFont(new Font("arial", Font.PLAIN, 14));
		txtLargo.setBounds(125, 90, 151, 20);
		getContentPane().add(txtLargo);
		txtLargo.setColumns(10);

		txtEspesor = new JTextField();
		txtEspesor.setFont(new Font("arial", Font.PLAIN, 14));
		txtEspesor.setBounds(125, 117, 151, 20);
		getContentPane().add(txtEspesor);
		txtEspesor.setColumns(10);

		txtContenido = new JTextField();
		txtContenido.setFont(new Font("arial", Font.PLAIN, 14));
		txtContenido.setBounds(125, 144, 151, 20);
		getContentPane().add(txtContenido);
		txtContenido.setColumns(10);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("arial", Font.PLAIN, 14));
		btnCerrar.setBounds(346, 9, 89, 23);
		getContentPane().add(btnCerrar);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setFont(new Font("arial", Font.PLAIN, 14));
		btnGrabar.setBounds(346, 36, 89, 23);
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

	//Lee los datos ingresados con getText y los guarda en las variable Locales de Menú Ceramico
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		MenúCerámicos.precio0 = Double.parseDouble(txtPrecio.getText());
		MenúCerámicos.ancho0 = Double.parseDouble(txtAncho.getText());
		MenúCerámicos.largo0 = Double.parseDouble(txtLargo.getText());
		MenúCerámicos.espesor0 = Double.parseDouble(txtEspesor.getText());
		MenúCerámicos.contenido0 = (int) Double.parseDouble(txtContenido.getText());
		dispose();
	}

	void mostrarDatos(double precio, double ancho, double largo, double espesor, int contenido) {
		txtPrecio.setText(precio + "");
		txtAncho.setText(ancho + "");
		txtLargo.setText(largo + "");
		txtEspesor.setText(espesor + "");
		txtContenido.setText(contenido + "");
	}

	protected void actionPerformedCboModelo(ActionEvent e) {
		switch (cboModelo.getSelectedIndex()) {
		case 0:
			mostrarDatos(MenúCerámicos.precio0, MenúCerámicos.ancho0, MenúCerámicos.largo0, MenúCerámicos.espesor0,MenúCerámicos.contenido0);
			break;
		case 1:
			mostrarDatos(MenúCerámicos.precio1, MenúCerámicos.ancho1, MenúCerámicos.largo1, MenúCerámicos.espesor1,MenúCerámicos.contenido1);
			break;
		case 2:
			mostrarDatos(MenúCerámicos.precio2, MenúCerámicos.ancho2, MenúCerámicos.largo2, MenúCerámicos.espesor2,MenúCerámicos.contenido2);
			break;
		case 3:
			mostrarDatos(MenúCerámicos.precio3, MenúCerámicos.ancho3, MenúCerámicos.largo3, MenúCerámicos.espesor3,MenúCerámicos.contenido3);
			break;
		default:
			mostrarDatos(MenúCerámicos.precio4, MenúCerámicos.ancho4, MenúCerámicos.largo4, MenúCerámicos.espesor4,MenúCerámicos.contenido4);
			break;
		}
	}
}
