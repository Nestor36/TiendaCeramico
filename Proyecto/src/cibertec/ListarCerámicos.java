package cibertec;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ListarCerámicos extends JDialog implements ActionListener {

    private final JPanel contentPanel = new JPanel();
    private JButton btnListar;
    private JButton btnCerrar;
    private JScrollPane scp;
    private JTextArea txtS;
    String modeloSeleccionado;

    void imprimir(String cad) {
        txtS.append(cad + "");
    }

    public static void main(String[] args) {
        try {
            ListarCerámicos dialog = new ListarCerámicos();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListarCerámicos() {
        setTitle("Listado de Cerámicos");
        setBounds(100, 100, 624, 503);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        btnListar = new JButton("Listar");
        btnListar.addActionListener(this);
        btnListar.setBounds(208, 438, 94, 23);
        btnListar.setFont(new Font("arial", Font.PLAIN, 12));
        contentPanel.add(btnListar);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setBounds(312, 438, 84, 23);
        btnCerrar.setFont(new Font("arial", Font.PLAIN, 12));
        contentPanel.add(btnCerrar);

        scp = new JScrollPane();
        scp.setBounds(10, 10, 590, 418);
        contentPanel.add(scp);

        txtS = new JTextArea();
        txtS.setFont(new Font("arial", Font.PLAIN, 14));
        scp.setViewportView(txtS);
    }

    void imprimirCeramico(String modelo,double precio, double ancho, double largo, double espesor, int contenido) {
    	txtS.append("\n");
        txtS.append("Modelo \t: " + modelo + "\n");
        txtS.append("Precio \t: " + precio  + "\n");
        txtS.append("Ancho(cm)\t: " + ancho + "\n");
        txtS.append("Largo(cm)\t: " + largo + "\n");
        txtS.append("Espesor(cm) \t: " + espesor + "\n");
        txtS.append("Contenido \t: " + contenido + "\n");
   }
    
    void mostrarResultados() {
        txtS.setText("LISTADO DE CERÁMICOS" + "\n");
        imprimirCeramico(MenúCerámicos.modelo0, MenúCerámicos.precio0, MenúCerámicos.ancho0, MenúCerámicos.largo0,  MenúCerámicos.espesor0 , MenúCerámicos.contenido0);
        imprimirCeramico(MenúCerámicos.modelo1, MenúCerámicos.precio1, MenúCerámicos.ancho1, MenúCerámicos.largo1,  MenúCerámicos.espesor1 , MenúCerámicos.contenido1);
        imprimirCeramico(MenúCerámicos.modelo2, MenúCerámicos.precio2, MenúCerámicos.ancho2, MenúCerámicos.largo2,  MenúCerámicos.espesor2 , MenúCerámicos.contenido2);
        imprimirCeramico(MenúCerámicos.modelo3, MenúCerámicos.precio3, MenúCerámicos.ancho3, MenúCerámicos.largo3,  MenúCerámicos.espesor3 , MenúCerámicos.contenido3);
        imprimirCeramico(MenúCerámicos.modelo4, MenúCerámicos.precio4, MenúCerámicos.ancho4, MenúCerámicos.largo4,  MenúCerámicos.espesor4 , MenúCerámicos.contenido4);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCerrar) {
            actionPerformedBtnCerrar(e);
        }
        if (e.getSource() == btnListar) {
            actionPerformedBtnListar(e);
        }
    }

    protected void actionPerformedBtnListar(ActionEvent e) {
        mostrarResultados(); // llamando al método mostrarResultados();
    }

    protected void actionPerformedBtnCerrar(ActionEvent e) {
        dispose();
    }
}
