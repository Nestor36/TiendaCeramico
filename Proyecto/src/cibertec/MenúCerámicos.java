package cibertec;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class MenúCerámicos extends JFrame implements ActionListener {

    private JPanel contentPane;

    // Datos mínimos del primer producto
    public static String modelo0 = "Cinza Plus";
    public static double precio0 = 92.56;
    public static double ancho0 = 62.0;
    public static double largo0 = 62.0;
    public static double espesor0 = 8;
    public static int contenido0 = 6;

    // Datos mínimos del segundo producto
    public static String modelo1 = "Luxury";
    public static double precio1 = 42.77;
    public static double ancho1 = 60;
    public static double largo1 = 60;
    public static double espesor1 = 8.5;
    public static int contenido1 = 4;
    // Datos mínimos del tercer producto
    public static String modelo2 = "Austria";
    public static double precio2 = 52.45;
    public static double ancho2 = 45;
    public static double largo2 = 45;
    public static double espesor2 = 6.5;
    public static int contenido2 = 12;
    // Datos mínimos del cuarto producto
    public static String modelo3 = "Yungay Mix";
    public static double precio3 = 55.89;
    public static double ancho3 = 80;
    public static double largo3 = 120;
    public static double espesor3 = 6.8;
    public static int contenido3 = 9;
    // Datos mínimos del quinto producto
    public static String modelo4 = "Thalía";
    public static double precio4 = 45;
    public static double ancho4 = 45;
    public static double largo4 = 11.8;
    public static double espesor4 = 7.2;
    public static int contenido4 = 10;
    // Porcentajes de descuento
    public static double porcentaje1 = 7.5;
    public static double porcentaje2 = 10.0;
    public static double porcentaje3 = 12.5;
    public static double porcentaje4 = 15.0;
    // Obsequio
    public static String tipoObsequio = "Lapicero";
    public static int obsequioCantidad1 = 2;
    public static int obsequioCantidad2 = 3;
    public static int obsequioCantidad3 = 4;
    // Cantidad óptima de unidades vendidas por día
    public static int cantidadOptima = 10;
    // Cuota diaria
    public static double cuotaDiaria = 30000;
    
    //Variables Totales de GenerarReportes
    public static int cantidadVentas0;
    public static int cantidadVentas1;
    public static int cantidadVentas2;
    public static int cantidadVentas3;
    public static int cantidadVentas4;
    
    public static int cantidadCajasVendidas0;
    public static int cantidadCajasVendidas1;
    public static int cantidadCajasVendidas2;
    public static int cantidadCajasVendidas3;
    public static int cantidadCajasVendidas4;
    
    public static double importeTotalVendido0;
    public static double importeTotalVendido1;
    public static double importeTotalVendido2;
    public static double importeTotalVendido3;
    public static double importeTotalVendido4;
    
    public static double aporteACuotaDiaria0;
    public static double aporteACuotaDiaria1;
    public static double aporteACuotaDiaria2;
    public static double aporteACuotaDiaria3;
    public static double aporteACuotaDiaria4;
    
    
    // para poder obtener el promedio de los precios para "Ventas/GenerarReportes" en la pestaña de estadisticas.
    public static double precioProm=(precio0+precio1+precio2+precio3+precio4)/5;
    
    private JMenuItem mntmSalir;
    private JMenuItem mntmConsultarceramico;
    private JMenuItem mntmModificarceramico;
    private JMenuItem mntmListarceramico;
    private JMenuItem mntmVender;
    private JMenuItem mntmGenerarreportes;
    private JMenuItem mntmConfigurardescuentos;
    private JMenuItem mntmConfigurarobsequios;
    private JMenuItem mntmConfigurarcantidadoptima;
    private JMenuItem mntmConfigurarcuotadiaria;
    private JMenuItem mntmAcerdadetienda;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenúCerámicos frame = new MenúCerámicos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MenúCerámicos() {
    	setTitle("Venta de Cerámicos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 646, 434);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(new Font("Monospaced", Font.PLAIN, 12));
        setJMenuBar(menuBar);

        JMenu mnArchivo = new JMenu("Archivo");
        mnArchivo.setFont(new Font("Monospaced", Font.PLAIN, 12));
        menuBar.add(mnArchivo);

        mntmSalir = new JMenuItem("Salir");
        mntmSalir.setIcon(new ImageIcon(MenúCerámicos.class.getResource("/Media/boton-x.png")));
        mntmSalir.addActionListener(this);
        mntmSalir.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mnArchivo.add(mntmSalir);

        JMenu mnMantenimiento = new JMenu("Mantenimiento");
        mnMantenimiento.setFont(new Font("Monospaced", Font.PLAIN, 12));
        menuBar.add(mnMantenimiento);

        mntmConsultarceramico = new JMenuItem("Consultar cerámico");
        mntmConsultarceramico.setIcon(new ImageIcon(MenúCerámicos.class.getResource("/Media/consulta.png")));
        mntmConsultarceramico.addActionListener(this);
        mntmConsultarceramico.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mnMantenimiento.add(mntmConsultarceramico);

        mntmModificarceramico = new JMenuItem("Modificar cerámico");
        mntmModificarceramico.setIcon(new ImageIcon(MenúCerámicos.class.getResource("/Media/editar.png")));
        mntmModificarceramico.addActionListener(this);
        mntmModificarceramico.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mnMantenimiento.add(mntmModificarceramico);

        mntmListarceramico = new JMenuItem("Listar cerámicos");
        mntmListarceramico.setIcon(new ImageIcon(MenúCerámicos.class.getResource("/Media/lista-de-verificacion.png")));
        mntmListarceramico.addActionListener(this);
        mntmListarceramico.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mnMantenimiento.add(mntmListarceramico);

        JMenu mnVentas = new JMenu("Ventas");
        mnVentas.setFont(new Font("Monospaced", Font.PLAIN, 12));
        menuBar.add(mnVentas);

        mntmVender = new JMenuItem("Vender");
        mntmVender.setIcon(new ImageIcon(MenúCerámicos.class.getResource("/Media/tienda.png")));
        mntmVender.addActionListener(this);
        mntmVender.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mnVentas.add(mntmVender);

        mntmGenerarreportes = new JMenuItem("Generar reportes");
        mntmGenerarreportes.setIcon(new ImageIcon(MenúCerámicos.class.getResource("/Media/reporte-de-negocios.png")));
        mntmGenerarreportes.addActionListener(this);
        mntmGenerarreportes.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mnVentas.add(mntmGenerarreportes);

        JMenu mnConfiguracion = new JMenu("Configuración");
        mnConfiguracion.setFont(new Font("Monospaced", Font.PLAIN, 12));
        menuBar.add(mnConfiguracion);

        mntmConfigurardescuentos = new JMenuItem("Configurar descuentos");
        mntmConfigurardescuentos.setIcon(new ImageIcon(MenúCerámicos.class.getResource("/Media/descuento.png")));
        mntmConfigurardescuentos.addActionListener(this);
        mntmConfigurardescuentos.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mnConfiguracion.add(mntmConfigurardescuentos);

        mntmConfigurarobsequios = new JMenuItem("Configurar obsequios");
        mntmConfigurarobsequios.setIcon(new ImageIcon(MenúCerámicos.class.getResource("/Media/obsequio.png")));
        mntmConfigurarobsequios.addActionListener(this);
        mntmConfigurarobsequios.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mnConfiguracion.add(mntmConfigurarobsequios);

        mntmConfigurarcantidadoptima = new JMenuItem("Configurar cantidad óptima");
        mntmConfigurarcantidadoptima.setIcon(new ImageIcon(MenúCerámicos.class.getResource("/Media/desbordamiento.png")));
        mntmConfigurarcantidadoptima.addActionListener(this);
        mntmConfigurarcantidadoptima.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mnConfiguracion.add(mntmConfigurarcantidadoptima);

        mntmConfigurarcuotadiaria = new JMenuItem("Configurar cuota diaria");
        mntmConfigurarcuotadiaria.setIcon(new ImageIcon(MenúCerámicos.class.getResource("/Media/rutina.png")));
        mntmConfigurarcuotadiaria.addActionListener(this);
        mntmConfigurarcuotadiaria.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mnConfiguracion.add(mntmConfigurarcuotadiaria);

        JMenu mnAyuda = new JMenu("Ayuda");
        mnAyuda.setFont(new Font("Monospaced", Font.PLAIN, 12));
        menuBar.add(mnAyuda);

        mntmAcerdadetienda = new JMenuItem("Acerca de Tienda");
        mntmAcerdadetienda.setIcon(new ImageIcon(MenúCerámicos.class.getResource("/Media/pregunta.png")));
        mntmAcerdadetienda.addActionListener(this);
        mntmAcerdadetienda.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mnAyuda.add(mntmAcerdadetienda);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    public void actionPerformed(ActionEvent e) { // eventos para uso de interacción
        if (e.getSource() == mntmAcerdadetienda) { // comprobar sí e.getSource() es igual al objeto mntmAcercadadetienda
            actionPerformedMntmAcerdadetienda(e); // se le pasa el evento "e" a actionPerfomedMntmAcercadadetienda para poder manejar las acciones luego de la interacción.
        }
        if (e.getSource() == mntmConfigurarcuotadiaria) {
            actionPerformedMntmConfigurarcuotadiaria(e);
        }
        if (e.getSource() == mntmConfigurarcantidadoptima) {
            actionPerformedMntmConfigurarcantidadoptima(e);
        }
        if (e.getSource() == mntmConfigurarobsequios) {
            actionPerformedMntmConfigurarobsequios(e);
        }
        if (e.getSource() == mntmConfigurardescuentos) {
            actionPerformedMntmConfigurardescuentos(e);
        }
        if (e.getSource() == mntmGenerarreportes) {
            actionPerformedMntmGenerarreportes(e);
        }
        if (e.getSource() == mntmVender) {
            actionPerformedMntmVender(e);
        }
        if (e.getSource() == mntmListarceramico) {
            actionPerformedMntmListarceramico(e);
        }
        if (e.getSource() == mntmModificarceramico) {
            actionPerformedMntmModificarceramico(e);
        }
        if (e.getSource() == mntmConsultarceramico) {
            actionPerformedMntmConsultarceramico(e);
        }
        if (e.getSource() == mntmSalir) {
            actionPerformedMntmSalir(e);
        }
    }

    protected void actionPerformedMntmSalir(ActionEvent e) { // Acción del Salir
        
    	// Importamos esto "import javax.swing.JOptionPane;" para poder utilizar la función de JOptionPane.showConfirmDialog
    	/*
    	    OptionPane.showConfirmDialog(Component parentComponent, -- Componente sobre el que se abre el cuadro de diálogo (this para el componente actual)
			Object message, -- El mensaje
			String title, -- Titulo
			int optionType, -- OK_CANCEL_OPTION(Botones Aceptar y Cancelar), CLOSED_OPTION(Botón Aceptar), YES_NO_OPTION(Botones Sí y No), YES_NO_CANCEL_OPTION(Botones Sí, No y Cancelar)
			int messageType, -- optional INFORMATION_MESSAGE. Icono de información. WARNING_MESSAGE. Icono de advertencia.ERROR_MESSAGE. Icono de error QUESTION_MESSAGE. Icono de pregunta. PLAIN_MESSAGE. Sin icono DEFAULT_OPTION. Sin icono.
			Icon icon);     -- optional Url del icono (necesario estar dentro del package)
    	 * 
    	 * */
    	
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea salir?", "Salir",JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0); // Para poder cerrar la aplicación completamente
        }
    }

    protected void actionPerformedMntmConsultarceramico(ActionEvent e) { // la acción de apertura de ventana
        ConsultarCerámico d = new ConsultarCerámico(); // se inicia la instancia y se le asigna a la variable "d"
        d.setLocationRelativeTo(mntmConsultarceramico); // para ubicar la ventana de otro componente "mntmConsultarceramico"
        d.setVisible(true); // poder hacer visible la ventana ubicada de "mntmConsultarceramico"
    }

    protected void actionPerformedMntmModificarceramico(ActionEvent e) {
        ModificarCerámico d = new ModificarCerámico();
        d.setLocationRelativeTo(mntmModificarceramico);
        d.setVisible(true);
    }

    protected void actionPerformedMntmListarceramico(ActionEvent e) {
        ListarCerámicos d = new ListarCerámicos();
        d.setLocationRelativeTo(mntmListarceramico);
        d.setVisible(true);
    }

    protected void actionPerformedMntmVender(ActionEvent e) {
        Vender d = new Vender();
        d.setLocationRelativeTo(mntmListarceramico);
        d.setVisible(true);
    }

    protected void actionPerformedMntmGenerarreportes(ActionEvent e) {
        GenerarReportes d = new GenerarReportes();
        d.setLocationRelativeTo(mntmListarceramico);
        d.setVisible(true);
    }

    protected void actionPerformedMntmConfigurardescuentos(ActionEvent e) {
        ConfigurarDescuentos d = new ConfigurarDescuentos();
        d.setLocationRelativeTo(mntmConfigurardescuentos);
        d.setVisible(true);
    }

    protected void actionPerformedMntmConfigurarobsequios(ActionEvent e) {
        ConfigurarObsequios d = new ConfigurarObsequios();
        d.setLocationRelativeTo(mntmConfigurarobsequios);
        d.setVisible(true);
    }

    protected void actionPerformedMntmConfigurarcantidadoptima(ActionEvent e) {
        ConfigurarCantidadOptima d = new ConfigurarCantidadOptima();
        d.setLocationRelativeTo(mntmConfigurarcantidadoptima);
        d.setVisible(true);
    }

    protected void actionPerformedMntmConfigurarcuotadiaria(ActionEvent e) {
        ConfigurarCuotaDiaria d = new ConfigurarCuotaDiaria();
        d.setLocationRelativeTo(mntmConfigurarcuotadiaria);
        d.setVisible(true);
    }

    protected void actionPerformedMntmAcerdadetienda(ActionEvent e) {
        AcercaDeTienda d = new AcercaDeTienda();
        d.setLocationRelativeTo(mntmAcerdadetienda);
        d.setVisible(true);
    }
}
