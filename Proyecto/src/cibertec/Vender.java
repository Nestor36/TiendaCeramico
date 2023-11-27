package cibertec;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Vender extends JDialog {

	static String modeloSeleccionado;
	int modeloSeleccionadoInt;
	int acumuladorVender = 0;
	double importeTotalGeneralAcumulado = 0;

	DecimalFormat df = new DecimalFormat("0.00"); // para usar el formatear números decimales, se debe importar (import
													// java.text.DecimalFormat)

	double importeCompra = 0, importeDescuento = 0, precioSeleccionado = 0, importePagar = 0, porcentajeCuotaDiaria = 0;
	int cantidad, cantidadObsequios = 0;

	private JTextField txtCantidad;
	private static JTextField txtPrecio;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			Vender dialog = new Vender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Vender() {
		setTitle("Vender");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		JButton btnVender = new JButton("Vender");
		btnVender.setFont(new Font("arial", Font.PLAIN, 12));

		btnVender.setBounds(335, 11, 89, 23);
		getContentPane().add(btnVender);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("arial", Font.PLAIN, 12));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(335, 38, 89, 23);
		getContentPane().add(btnCerrar);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("arial", Font.PLAIN, 12));
		lblModelo.setBounds(10, 15, 46, 14);
		getContentPane().add(lblModelo);

		JLabel lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setFont(new Font("Georgia", Font.PLAIN, 12));
		lblPrecio.setBounds(10, 42, 68, 14);
		getContentPane().add(lblPrecio);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("arial", Font.PLAIN, 12));
		lblCantidad.setBounds(10, 67, 59, 14);
		getContentPane().add(lblCantidad);

		JComboBox cboModelo = new JComboBox();
		cboModelo.setFont(new Font("arial", Font.PLAIN, 12));
		cboModelo.setToolTipText("Selecciona un tipo");
		cboModelo.setModel(
				new DefaultComboBoxModel(new String[] { "Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalía" }));
		cboModelo.setSelectedIndex(0);
		cboModelo.setBounds(76, 11, 190, 22);
		getContentPane().add(cboModelo);

		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("arial", Font.PLAIN, 12));

		txtCantidad.setBounds(79, 64, 187, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("arial", Font.PLAIN, 12));
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(79, 39, 187, 20);
		getContentPane().add(txtPrecio);

		JScrollPane scp = new JScrollPane();
		scp.setBounds(10, 94, 414, 159);
		getContentPane().add(scp);

		JTextArea txtS = new JTextArea();
		txtS.setFont(new Font("arial", Font.PLAIN, 12));
		scp.setViewportView(txtS);

		// Valores de Modelo0 por default...
		txtPrecio.setText(MenúCerámicos.precio0 + "");
		modeloSeleccionado = "0";

		cboModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Código a ejecutar cuando se selecciona un elemento en cboModelo
				switch (cboModelo.getSelectedIndex()) {
				case 0:
					txtPrecio.setText(MenúCerámicos.precio0 + "");
					modeloSeleccionadoInt = 0;
					modeloSeleccionado = "0";
					break;
				case 1:
					txtPrecio.setText(MenúCerámicos.precio1 + "");
					modeloSeleccionadoInt = 1;
					modeloSeleccionado = "1";
					break;
				case 2:
					txtPrecio.setText(MenúCerámicos.precio2 + "");
					modeloSeleccionadoInt = 2;
					modeloSeleccionado = "2";
					break;
				case 3:
					txtPrecio.setText(MenúCerámicos.precio3 + "");
					modeloSeleccionadoInt = 3;
					modeloSeleccionado = "3";
					break;
				case 4:
					txtPrecio.setText(MenúCerámicos.precio4 + "");
					modeloSeleccionadoInt = 4;
					modeloSeleccionado = "4";
					break;
				}
			}
		});

		btnVender.addActionListener(new ActionListener() {

			// -----------------------------------------------------------------------------------------
			// Metodos

			void calcularImporteDescuento() {
				if (cantidad <= 5) {
					importeDescuento = (MenúCerámicos.porcentaje1 * importeCompra) / 100;
				} else if (cantidad <= 10) {
					importeDescuento = (MenúCerámicos.porcentaje2 * importeCompra) / 100;
				} else if (cantidad <= 15) {
					importeDescuento = (MenúCerámicos.porcentaje3 * importeCompra) / 100;
				} else {
					importeDescuento = (MenúCerámicos.porcentaje4 * importeCompra) / 100;
				}

			}

			void calcularImporteCompra(double precio) {
				importeCompra = precio * cantidad;
			}

			void calcularImportePagar() {
				importePagar = importeCompra - importeDescuento;
			}

			void calcularObsequios() {
				if (cantidad <= 5) {
					cantidadObsequios = cantidad * MenúCerámicos.obsequioCantidad1;
				} else if (cantidad <= 10) {
					cantidadObsequios = cantidad * MenúCerámicos.obsequioCantidad2;
				} else {
					cantidadObsequios = cantidad * MenúCerámicos.obsequioCantidad3;
				}
			}

			void guardarDatosGenerar(int cantidadCajas, int cantidadVentas, double importeTotalVendido, double aporteCuota) {
				cantidadCajas += cantidad;
				cantidadVentas += 1;
				importeTotalVendido += importePagar;
				aporteCuota= (importeTotalVendido / MenúCerámicos.cuotaDiaria)
						* 100;
			}

			
			// ----------------------------------------------------
			
			
			public void actionPerformed(ActionEvent e) {
				// Código a ejecutar cuando se selecciona un elemento en btnVender

				// Al poner Vender verifica si la cantidad introducida es un numero
				if (!isNumeric(txtCantidad.getText())) {
					txtS.setText("Debe introducir un número");
					return; // para salir del método devolviendo un valor o no (en este caso no.)
				}

				cantidad = Integer.parseInt(txtCantidad.getText());

				if (cantidad < 1) {
					txtS.setText("Debe introducir un número mayor a 0");
					return;
				}

				// Saber que modelo es
				switch (modeloSeleccionado) {
				case "0":
					modeloSeleccionado = MenúCerámicos.modelo0;
					precioSeleccionado = MenúCerámicos.precio0;

					calcularImporteCompra(MenúCerámicos.precio0);
					calcularImporteDescuento();
					calcularImportePagar();
					calcularObsequios();

					break;
				case "1":
					modeloSeleccionado = MenúCerámicos.modelo1;
					precioSeleccionado = MenúCerámicos.precio1;

					calcularImporteCompra(MenúCerámicos.precio1);
					calcularImporteDescuento();
					calcularImportePagar();
					calcularObsequios();
					break;

				case "2":
					modeloSeleccionado = MenúCerámicos.modelo2;
					precioSeleccionado = MenúCerámicos.precio2;

					calcularImporteCompra(MenúCerámicos.precio2);
					calcularImporteDescuento();
					calcularImportePagar();
					calcularObsequios();
					break;

				case "3":
					modeloSeleccionado = MenúCerámicos.modelo3;
					precioSeleccionado = MenúCerámicos.precio3;

					calcularImporteCompra(MenúCerámicos.precio3);
					calcularImporteDescuento();
					calcularImportePagar();
					calcularObsequios();
					break;

				case "4":
					modeloSeleccionado = MenúCerámicos.modelo4;
					precioSeleccionado = MenúCerámicos.precio4;

					calcularImporteCompra(MenúCerámicos.precio4);
					calcularImporteDescuento();
					calcularImportePagar();
					calcularObsequios();
					break;
				}

				// Para evitar que el usuario no se confunda con la descripcion al comprar del
				// mismo modelo y misma cantidad...

				String modeloSeleccionado1 = modeloSeleccionado;

				txtS.setText("Generando...");

				// Para poder ejecutar lo siguiente luego de 0.5 segundos. mientras sigue
				// ejecutando el código posterior sin retraso alguno.
				CompletableFuture.delayedExecutor(500, TimeUnit.MILLISECONDS).execute(() -> {

					txtS.setText("BOLETA DE VENTA" + "\n\n");
					txtS.append("Modelo\t\t: " + modeloSeleccionado1 + "\n");
					txtS.append("Precio\t\t: S/." + df.format(precioSeleccionado) + "\n");
					txtS.append("Cantidad adquirida\t: " + cantidad + "\n");
					txtS.append("Importe de Compra\t: S/." + df.format(importeCompra) + "\n");
					txtS.append("Importe de Descuento\t: S/." + df.format(importeDescuento) + "\n");
					txtS.append("Importe a Pagar\t: S/." + df.format(importePagar) + "\n");
					txtS.append("Tipo de Obsequio\t: " + MenúCerámicos.tipoObsequio + "\n");
					txtS.append("Unidades Obsequiadas\t: " + cantidadObsequios + "\n");
				});

				
				// Guardando datos de Vender en las variables globales para Generar Reportes...
				
				if (modeloSeleccionadoInt == 0) {
					guardarDatosGenerar(MenúCerámicos.cantidadCajasVendidas0,MenúCerámicos.cantidadVentas0,MenúCerámicos.importeTotalVendido0,MenúCerámicos.aporteACuotaDiaria0);
				} else if (modeloSeleccionadoInt == 1) {
					MenúCerámicos.cantidadCajasVendidas1 += cantidad;
					MenúCerámicos.cantidadVentas1 += 1;
					MenúCerámicos.importeTotalVendido1 += importePagar;
					MenúCerámicos.aporteACuotaDiaria1 = (MenúCerámicos.importeTotalVendido1 / MenúCerámicos.cuotaDiaria)
							* 100;
				} else if (modeloSeleccionadoInt == 2) {
					MenúCerámicos.cantidadCajasVendidas2 += cantidad;
					MenúCerámicos.importeTotalVendido2 += importePagar;
					MenúCerámicos.cantidadVentas2 += 1;
					MenúCerámicos.aporteACuotaDiaria2 = (MenúCerámicos.importeTotalVendido2 / MenúCerámicos.cuotaDiaria)
							* 100;
				} else if (modeloSeleccionadoInt == 3) {
					MenúCerámicos.cantidadCajasVendidas3 += cantidad;
					MenúCerámicos.cantidadVentas3 += 1;
					MenúCerámicos.importeTotalVendido3 += importePagar;
					MenúCerámicos.aporteACuotaDiaria3 = (MenúCerámicos.importeTotalVendido3 / MenúCerámicos.cuotaDiaria)
							* 100;
				} else {
					MenúCerámicos.cantidadCajasVendidas4 += cantidad;
					MenúCerámicos.cantidadVentas4 += 1;
					MenúCerámicos.importeTotalVendido4 += importePagar;
					MenúCerámicos.aporteACuotaDiaria4 = (MenúCerámicos.importeTotalVendido4 / MenúCerámicos.cuotaDiaria)
							* 100;
				}

				acumuladorVender++;

				// Calcular Importe General Acumulado y Porcentaje de la cuota diaria
				importeTotalGeneralAcumulado = importeTotalGeneralAcumulado + importePagar;
				porcentajeCuotaDiaria = (importeTotalGeneralAcumulado / MenúCerámicos.cuotaDiaria) * 100;

				// Alerta cada 5 ventas
				if (acumuladorVender % 5 == 0) {
					JOptionPane.showConfirmDialog(null,
							"Venta Nro. " + acumuladorVender + "\nImporte total general acumulado: S/. "
									+ df.format(importeTotalGeneralAcumulado) + "\nPorcentaje de la cuota diaria: "
									+ df.format(porcentajeCuotaDiaria) + "%",
							"Avance de ventas", JOptionPane.OK_OPTION);
				}

				// Reiniciar la selección - Todo
				cboModelo.setSelectedIndex(0);
				txtCantidad.setText("");

			}

			private boolean isNumeric(String text) { // Private (para poder usar solo en esta clase) boolean (verdadero
														// o falso) isNumeric (función)
				try {
					Integer.parseInt(text); // Convertir la cadena a un número entero
					return true; // Si la conversión tiene éxito, retorna true
				} catch (Exception e) {
					return false; // Si ocurre alguna excepción durante la conversión, retorna false
				}
			}
		});
	}
}
