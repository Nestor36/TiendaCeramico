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
		cboTipoDeReporte_1.setFont(new Font("arial", Font.PLAIN, 14));
		cboTipoDeReporte_1.setBounds(159, 26, 255, 27);
		getContentPane().add(cboTipoDeReporte_1);

		btnCerrar_1 = new JButton("Cerrar");
		btnCerrar_1.addActionListener(this);
		btnCerrar_1.setFont(new Font("arial", Font.PLAIN, 14));
		btnCerrar_1.setBounds(586, 26, 94, 27);
		getContentPane().add(btnCerrar_1);

		JScrollPane scp = new JScrollPane();
		scp.setBounds(10, 93, 700, 298);
		getContentPane().add(scp);

		txtS = new JTextArea();
		txtS.setFont(new Font("arial", Font.PLAIN, 14));
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
		dispose(); // no cierra la aplicación en sí misma, solo libera los recursos asociados con la ventana específica.
	}
	
	/*
	 *    
    public static String modelo0 = "Cinza Plus";
    public static double precio0 = 92.56;
    public static double ancho0 = 62.0;
    public static double largo0 = 62.0;
    public static double espesor0 = 8;
    public static int contenido0 = 6;
	 * 
	 * */
	
	
	
	private void VentasPorModelo(String modelo, int CantidadVentas, int CantidadCajasVendidas, String ImporteTotalVendido, String AporteACuotaDiaria) {
		
		txtS.append("\nModelo \t\t\t:\t " + modelo);
		txtS.append("\nCantidad de ventas \t\t:\t " + CantidadVentas);
		txtS.append("\nCantidad de cajas Vendidas \t:\t " + CantidadCajasVendidas);
		txtS.append("\nImporte total vendiodo \t\t:\t " + ImporteTotalVendido);
		txtS.append("\nAporte a la cuota diaria \t\t:\t " + AporteACuotaDiaria + "\n\n");
	}
	
	/*
	  	Object
		├── Number
		│   ├── Integer
		│   ├── Double
		│   └── ...
		├── String
		├── Boolean
		├── Character
		├── Array
		├── ...
		└── (otras clases del usuario) 
	 * 
	 */
	
	private void  ComparacionPrecioProm(String modelo, String Precio, String PrecioProm, Object object) {
	
		txtS.append("\n\nModelo \t\t\t: " + modelo);
		txtS.append("\nPrecio \t\t\t: " + Precio);
		txtS.append("\nPrecio Promedio \t\t: " + PrecioProm);
		txtS.append("\nComparación \t\t: " + object );
		
	}
	
	private void  ComparacionCajasVendidas(String modelo, int cantidadCajasVendidas0, int cantidadOptima, Object object) {
		
		txtS.append("\n\nModelo \t\t\t\t: " + modelo);
		txtS.append("\nCantidad de cajas vendidas \t\t: " + cantidadCajasVendidas0);
		txtS.append("\nCantidad óptima \t\t\t: " + cantidadOptima);
		txtS.append("\nComparación \t\t\t: " + object);
		
	}
	

	protected void actionPerformedCboTipoDeReporte(ActionEvent e) {

		switch (cboTipoDeReporte_1.getSelectedIndex()) {
		case 0:
			
			txtS.setText("Ventas por Modelo\n");
			VentasPorModelo(MenúCerámicos.modelo0, MenúCerámicos.cantidadVentas0, MenúCerámicos.cantidadCajasVendidas0, df.format(MenúCerámicos.importeTotalVendido0), df.format(MenúCerámicos.aporteACuotaDiaria0));	
			VentasPorModelo(MenúCerámicos.modelo1, MenúCerámicos.cantidadVentas1, MenúCerámicos.cantidadCajasVendidas1, df.format(MenúCerámicos.importeTotalVendido1), df.format(MenúCerámicos.aporteACuotaDiaria1));
			VentasPorModelo(MenúCerámicos.modelo2, MenúCerámicos.cantidadVentas2, MenúCerámicos.cantidadCajasVendidas2, df.format(MenúCerámicos.importeTotalVendido2), df.format(MenúCerámicos.aporteACuotaDiaria2));
			VentasPorModelo(MenúCerámicos.modelo3, MenúCerámicos.cantidadVentas3, MenúCerámicos.cantidadCajasVendidas3, df.format(MenúCerámicos.importeTotalVendido3), df.format(MenúCerámicos.aporteACuotaDiaria3));
			VentasPorModelo(MenúCerámicos.modelo4, MenúCerámicos.cantidadVentas4, MenúCerámicos.cantidadCajasVendidas4, df.format(MenúCerámicos.importeTotalVendido4), df.format(MenúCerámicos.aporteACuotaDiaria4));

			
			break;
		case 1:
			
			txtS.setText("COMPARACIÓN DE PRECIOS CON EL PRECIO PROMEDIO");
			ComparacionPrecioProm(MenúCerámicos.modelo0, df.format(MenúCerámicos.precio0), df.format(MenúCerámicos.importeTotalVendido0 / MenúCerámicos.cantidadCajasVendidas0), imprimir(MenúCerámicos.precio0, (MenúCerámicos.importeTotalVendido0 / MenúCerámicos.cantidadCajasVendidas0), 1));
			ComparacionPrecioProm(MenúCerámicos.modelo1, df.format(MenúCerámicos.precio1), df.format(MenúCerámicos.importeTotalVendido1 / MenúCerámicos.cantidadCajasVendidas1), imprimir(MenúCerámicos.precio1, (MenúCerámicos.importeTotalVendido1 / MenúCerámicos.cantidadCajasVendidas1), 1));
			ComparacionPrecioProm(MenúCerámicos.modelo2, df.format(MenúCerámicos.precio2), df.format(MenúCerámicos.importeTotalVendido2 / MenúCerámicos.cantidadCajasVendidas2), imprimir(MenúCerámicos.precio2, (MenúCerámicos.importeTotalVendido2 / MenúCerámicos.cantidadCajasVendidas2), 1));
			ComparacionPrecioProm(MenúCerámicos.modelo3, df.format(MenúCerámicos.precio3), df.format(MenúCerámicos.importeTotalVendido3 / MenúCerámicos.cantidadCajasVendidas3), imprimir(MenúCerámicos.precio3, (MenúCerámicos.importeTotalVendido3 / MenúCerámicos.cantidadCajasVendidas2), 1));
			ComparacionPrecioProm(MenúCerámicos.modelo4, df.format(MenúCerámicos.precio4), df.format(MenúCerámicos.importeTotalVendido4 / MenúCerámicos.cantidadCajasVendidas4), imprimir(MenúCerámicos.precio4, (MenúCerámicos.importeTotalVendido3 / MenúCerámicos.cantidadCajasVendidas2), 1));
			break;
		case 2:
			
			
			txtS.setText("COMPARACIÓN DE CAJAS VENDIDAS CON LA CANTIDAD ÓPTIMA");
			ComparacionCajasVendidas(MenúCerámicos.modelo0, MenúCerámicos.cantidadCajasVendidas0, MenúCerámicos.cantidadOptima, imprimir(MenúCerámicos.cantidadCajasVendidas0, MenúCerámicos.cantidadOptima, 2));
			ComparacionCajasVendidas(MenúCerámicos.modelo1, MenúCerámicos.cantidadCajasVendidas1, MenúCerámicos.cantidadOptima, imprimir(MenúCerámicos.cantidadCajasVendidas1, MenúCerámicos.cantidadOptima, 2));
			ComparacionCajasVendidas(MenúCerámicos.modelo2, MenúCerámicos.cantidadCajasVendidas2, MenúCerámicos.cantidadOptima, imprimir(MenúCerámicos.cantidadCajasVendidas2, MenúCerámicos.cantidadOptima, 2));
			ComparacionCajasVendidas(MenúCerámicos.modelo3, MenúCerámicos.cantidadCajasVendidas3, MenúCerámicos.cantidadOptima, imprimir(MenúCerámicos.cantidadCajasVendidas3, MenúCerámicos.cantidadOptima, 2));
			ComparacionCajasVendidas(MenúCerámicos.modelo4, MenúCerámicos.cantidadCajasVendidas4, MenúCerámicos.cantidadOptima, imprimir(MenúCerámicos.cantidadCajasVendidas4, MenúCerámicos.cantidadOptima, 2));
			break;
		case 3:
			txtS.setText("ESTADISTICA SOBRE EL PRECIO\n\n");
			txtS.append("\nPrecio Prom\t: S/." +(MenúCerámicos.precioProm));
			txtS.append("\nPrecio Mayor\t: S/." +(MenúCerámicos.precio0));
			txtS.append("\nPrecio Menor\t: S/"+(MenúCerámicos.precio1));
			break;
		default:
			break;
		}
	}
	
	/*
	 * void   => el método realiza alguna acción o tarea(del código), pero no produce un resultado que pueda ser utilizado después(como un return).
	 * Object => estás indicando que el método puede devolver cualquier objeto, 
	 * 
	 */

	Object imprimir(double cantidad, double valor, int bandera) {
		String msg = " la cantidad óptima\n";

		if (bandera == 1) {
			msg = " el promedio\n";
		}

		if (valor > cantidad) {
			return df.format(valor - cantidad) + " menos que" + msg;
		} else if (valor < cantidad) {
			return df.format(cantidad - valor) + " más que" + msg;
		} else if (valor == cantidad) {
			return "igual que" + msg;
		} else {
			return"\n";
		}
	

	}


}