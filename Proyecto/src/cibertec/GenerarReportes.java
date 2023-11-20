package cibertec;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class GenerarReportes extends JDialog implements ActionListener {

	// Formateador
	DecimalFormat df = new DecimalFormat("0.00");

	private final JPanel contentPanel = new JPanel();
	private static JTextArea txtS;
	private JButton btnCerrar_1;
	private JComboBox cboTipoDeReporte_1;

	public static void main(String[] args) {
		try {
			GenerarReportes dialog = new GenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GenerarReportes() {
		setTitle("Generar Reportes");
		setBounds(100, 100, 734, 438);
		getContentPane().setLayout(null);
		{
			JLabel lblTipoDeReporte = new JLabel("Tipo de reporte");
			lblTipoDeReporte.setFont(new Font("Garamond", Font.PLAIN, 14));
			lblTipoDeReporte.setBounds(31, 23, 118, 30);
			getContentPane().add(lblTipoDeReporte);
		}

		cboTipoDeReporte_1 = new JComboBox();
		cboTipoDeReporte_1.addActionListener(this);
		cboTipoDeReporte_1.setModel(new DefaultComboBoxModel(
				new String[] { "Ventas por modelo", "Comparación de precios con el precio promedio",
						"Comparación de cajas vendidas con la cantidad óptima ", "Estadística sobre el precio" }));
		cboTipoDeReporte_1.setFont(new Font("Monospaced", Font.PLAIN, 14));
		cboTipoDeReporte_1.setBounds(159, 26, 255, 27);
		getContentPane().add(cboTipoDeReporte_1);

		btnCerrar_1 = new JButton("Cerrar");
		btnCerrar_1.addActionListener(this);
		btnCerrar_1.setFont(new Font("Monospaced", Font.PLAIN, 14));
		btnCerrar_1.setBounds(586, 26, 94, 27);
		getContentPane().add(btnCerrar_1);

		JScrollPane scp = new JScrollPane();
		scp.setBounds(10, 93, 700, 298);
		getContentPane().add(scp);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scp.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboTipoDeReporte_1) {
			actionPerformedCboTipoDeReporte(e);
		}
		if (e.getSource() == btnCerrar_1) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedCboTipoDeReporte(ActionEvent e) {

		switch (cboTipoDeReporte_1.getSelectedIndex()) {
		case 0:
			txtS.setText("VENTAS POR MODELO" + "\n\nModelo \t\t: " + MenúCerámicos.modelo0 + "\nCantidad de ventas \t: "
					+ MenúCerámicos.cantidadVentas0 + "\nCantidad de cajas vendidas \t: "
					+ MenúCerámicos.cantidadCajasVendidas0 + "\nImporte total vendido \t: S/."
					+ df.format(MenúCerámicos.importeTotalVendido0) + "\nAporte a la cuota diaria \t: %"
					+ df.format(MenúCerámicos.aporteACuotaDiaria0) + "\n"

					+ "\nModelo \t\t: " + MenúCerámicos.modelo1 + "\nCantidad de ventas \t: "
					+ MenúCerámicos.cantidadVentas1 + "\nCantidad de cajas vendidas \t: "
					+ MenúCerámicos.cantidadCajasVendidas1 + "\nImporte total vendido \t: S/."
					+ df.format(MenúCerámicos.importeTotalVendido1) + "\nAporte a la cuota diaria \t: %"
					+ df.format(MenúCerámicos.aporteACuotaDiaria1) + "\n"

					+ "\nModelo \t\t: " + MenúCerámicos.modelo2 + "\nCantidad de ventas \t: "
					+ MenúCerámicos.cantidadVentas2 + "\nCantidad de cajas vendidas \t: "
					+ MenúCerámicos.cantidadCajasVendidas2 + "\nImporte total vendido \t: S/."
					+ df.format(MenúCerámicos.importeTotalVendido2) + "\nAporte a la cuota diaria \t: %"
					+ df.format(MenúCerámicos.aporteACuotaDiaria2) + "\n"

					+ "\nModelo \t\t: " + MenúCerámicos.modelo3 + "\nCantidad de ventas \t: "
					+ MenúCerámicos.cantidadVentas3 + "\nCantidad de cajas vendidas \t: "
					+ MenúCerámicos.cantidadCajasVendidas3 + "\nImporte total vendido \t: S/."
					+ df.format(MenúCerámicos.importeTotalVendido3) + "\nAporte a la cuota diaria \t: %"
					+ df.format(MenúCerámicos.aporteACuotaDiaria3) + "\n"

					+ "\nModelo \t\t: " + MenúCerámicos.modelo4 + "\nCantidad de ventas \t: "
					+ MenúCerámicos.cantidadVentas4 + "\nCantidad de cajas vendidas \t: "
					+ MenúCerámicos.cantidadCajasVendidas4 + "\nImporte total vendido \t: S/."
					+ df.format(MenúCerámicos.importeTotalVendido4) + "\nAporte a la cuota diaria \t: %"
					+ df.format(MenúCerámicos.aporteACuotaDiaria4) + "\n"

			);
			break;
		case 1:
			txtS.setText("COMPARACIÓN DE PRECIOS CON EL PRECIO PROMEDIO" + "\n\nModelo \t\t: " + MenúCerámicos.modelo0
					+ "\nPrecio \t\t: " + df.format(MenúCerámicos.precio0) + "\nPrecio Promedio \t: "
					+ df.format(MenúCerámicos.importeTotalVendido0 / MenúCerámicos.cantidadCajasVendidas0)
					+ "\nComparación \t\t: ");
			imprimir(MenúCerámicos.precio0, (MenúCerámicos.importeTotalVendido0 / MenúCerámicos.cantidadCajasVendidas0),
					1);

			txtS.append("\nModelo \t\t: " + MenúCerámicos.modelo1 + "\nPrecio \t\t: " + df.format(MenúCerámicos.precio1)
					+ "\nPrecio Promedio \t: "
					+ df.format(MenúCerámicos.importeTotalVendido1 / MenúCerámicos.cantidadCajasVendidas1)
					+ "\nComparación \t\t: ");
			imprimir(MenúCerámicos.precio1, (MenúCerámicos.importeTotalVendido1 / MenúCerámicos.cantidadCajasVendidas1),
					1);

			txtS.append("\nModelo \t\t: " + MenúCerámicos.modelo2 + "\nPrecio \t\t: " + df.format(MenúCerámicos.precio2)
					+ "\nPrecio Promedio \t: "
					+ df.format(MenúCerámicos.importeTotalVendido2 / MenúCerámicos.cantidadCajasVendidas2)
					+ "\nComparación \t\t: ");
			imprimir(MenúCerámicos.precio2, (MenúCerámicos.importeTotalVendido2 / MenúCerámicos.cantidadCajasVendidas2),
					1);

			txtS.append("\nModelo \t\t: " + MenúCerámicos.modelo3 + "\nPrecio \t\t: " + df.format(MenúCerámicos.precio3)
					+ "\nPrecio Promedio \t: "
					+ df.format(MenúCerámicos.importeTotalVendido3 / MenúCerámicos.cantidadCajasVendidas3)
					+ "\nComparación \t\t: ");
			imprimir(MenúCerámicos.precio3, (MenúCerámicos.importeTotalVendido3 / MenúCerámicos.cantidadCajasVendidas3),
					1);

			txtS.append("\nModelo \t\t: " + MenúCerámicos.modelo4 + "\nPrecio \t\t: " + df.format(MenúCerámicos.precio4)
					+ "\nPrecio Promedio \t: "
					+ df.format(MenúCerámicos.importeTotalVendido4 / MenúCerámicos.cantidadCajasVendidas4)
					+ "\nComparación \t\t: ");
			imprimir(MenúCerámicos.precio4, (MenúCerámicos.importeTotalVendido4 / MenúCerámicos.cantidadCajasVendidas4),
					1);

			break;
		case 2:
			txtS.setText("COMPARACIÓN DE CAJAS VENDIDAS CON LA CANTIDAD ÓPTIMA" + "\n\nModelo \t\t: "
					+ MenúCerámicos.modelo0 + "\nCantidad de cajas vendidas \t: " + MenúCerámicos.cantidadCajasVendidas0
					+ "\nCantidad óptima \t: " + MenúCerámicos.cantidadOptima + "\nComparación \t\t: ");
			imprimir(MenúCerámicos.cantidadCajasVendidas0, MenúCerámicos.cantidadOptima, 2);

			txtS.append("\nModelo \t\t: " + MenúCerámicos.modelo1 + "\nCantidad de cajas vendidas \t: "
					+ MenúCerámicos.cantidadCajasVendidas1 + "\nCantidad óptima \t: " + MenúCerámicos.cantidadOptima
					+ "\nComparación \t\t: ");
			imprimir(MenúCerámicos.cantidadCajasVendidas1, MenúCerámicos.cantidadOptima, 2);

			txtS.append("\nModelo \t\t: " + MenúCerámicos.modelo2 + "\nCantidad de cajas vendidas \t: "
					+ MenúCerámicos.cantidadCajasVendidas2 + "\nCantidad óptima \t: " + MenúCerámicos.cantidadOptima
					+ "\nComparación \t\t: ");
			imprimir(MenúCerámicos.cantidadCajasVendidas2, MenúCerámicos.cantidadOptima, 2);

			txtS.append("\nModelo \t\t: " + MenúCerámicos.modelo3 + "\nCantidad de cajas vendidas \t: "
					+ MenúCerámicos.cantidadCajasVendidas3 + "\nCantidad óptima \t: " + MenúCerámicos.cantidadOptima
					+ "\nComparación \t\t: ");
			imprimir(MenúCerámicos.cantidadCajasVendidas3, MenúCerámicos.cantidadOptima, 2);

			txtS.append("\nModelo \t\t: " + MenúCerámicos.modelo4 + "\nCantidad de cajas vendidas \t: "
					+ MenúCerámicos.cantidadCajasVendidas4 + "\nCantidad óptima \t: " + MenúCerámicos.cantidadOptima
					+ "\nComparación \t\t: ");
			imprimir(MenúCerámicos.cantidadCajasVendidas4, MenúCerámicos.cantidadOptima, 2);
			break;
		case 3:
			txtS.setText("ESTAD�?STICA SOBRE EL PRECIO\n\n");
			txtS.append("\nPrecio Prom\t: S/." +(MenúCerámicos.precioProm));
			txtS.append("\nPrecio Mayor\t: S/." +(MenúCerámicos.precio0));
			txtS.append("\nPrecio Menor\t: S/"+(MenúCerámicos.precio1));
			break;
		default:
			break;
		}
	}

	void imprimir(double cantidad, double valor, int bandera) {
		String msg = " la cantidad óptima\n";

		if (bandera == 1) {
			msg = " el promedio\n";
		}

		if (valor > cantidad) {
			txtS.append(df.format(valor - cantidad) + " menos que" + msg);
		} else if (valor < cantidad) {
			txtS.append(df.format(cantidad - valor) + " más que" + msg);
		} else if (valor == cantidad) {
			txtS.append("igual que" + msg);
		} else {
			txtS.append("\n");
		}

	}


}