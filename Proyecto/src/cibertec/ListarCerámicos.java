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
        btnListar.setFont(new Font("Monospaced", Font.PLAIN, 12));
        contentPanel.add(btnListar);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setBounds(312, 438, 84, 23);
        btnCerrar.setFont(new Font("Monospaced", Font.PLAIN, 12));
        contentPanel.add(btnCerrar);

        scp = new JScrollPane();
        scp.setBounds(10, 10, 590, 418);
        contentPanel.add(scp);

        txtS = new JTextArea();
        txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
        scp.setViewportView(txtS);
    }

    void mostrarResultados() {
        txtS.setText("LISTADO DE CER�?MICOS" + "\n");
        imprimir("\n");
        imprimir("Modelo \t: " + MenúCerámicos.modelo0 + "\n");
        imprimir("Precio \t: " + MenúCerámicos.precio0 + "\n");
        imprimir("Ancho(cm)\t: " + MenúCerámicos.ancho0 + "\n");
        imprimir("Largo(cm)\t: " + MenúCerámicos.largo0 + "\n");
        imprimir("Espesor(cm) \t: " + MenúCerámicos.espesor0 + "\n");
        imprimir("Contenido \t: " + MenúCerámicos.contenido0 + "\n");
        imprimir("\n");
        imprimir("Modelo \t: " + MenúCerámicos.modelo1 + "\n");
        imprimir("Precio \t: " + MenúCerámicos.precio1 + "\n");
        imprimir("Ancho(cm)\t: " + MenúCerámicos.ancho1 + "\n");
        imprimir("Largo(cm)\t: " + MenúCerámicos.largo1 + "\n");
        imprimir("Espesor(cm) \t: " + MenúCerámicos.espesor1 + "\n");
        imprimir("Contenido \t: " + MenúCerámicos.contenido1 + "\n");
        imprimir("\n");
        imprimir("Modelo \t: " + MenúCerámicos.modelo2 + "\n");
        imprimir("Precio \t: " + MenúCerámicos.precio2 + "\n");
        imprimir("Ancho(cm)\t: " + MenúCerámicos.ancho2 + "\n");
        imprimir("Largo(cm)\t: " + MenúCerámicos.largo2 + "\n");
        imprimir("Espesor(cm) \t: " + MenúCerámicos.espesor2 + "\n");
        imprimir("Contenido \t: " + MenúCerámicos.contenido2 + "\n");
        imprimir("\n");
        imprimir("Modelo \t: " + MenúCerámicos.modelo3 + "\n");
        imprimir("Precio \t: " + MenúCerámicos.precio3 + "\n");
        imprimir("Ancho(cm)\t: " + MenúCerámicos.ancho3 + "\n");
        imprimir("Largo(cm)\t: " + MenúCerámicos.largo3 + "\n");
        imprimir("Espesor(cm) \t: " + MenúCerámicos.espesor3 + "\n");
        imprimir("Contenido \t: " + MenúCerámicos.contenido3 + "\n");
        imprimir("\n");
        imprimir("Modelo \t: " + MenúCerámicos.modelo4 + "\n");
        imprimir("Precio \t: " + MenúCerámicos.precio4 + "\n");
        imprimir("Ancho(cm)\t: " + MenúCerámicos.ancho4 + "\n");
        imprimir("Largo(cm)\t: " + MenúCerámicos.largo4 + "\n");
        imprimir("Espesor(cm) \t: " + MenúCerámicos.espesor4 + "\n");
        imprimir("Contenido \t: " + MenúCerámicos.contenido4 + "\n");
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
        mostrarResultados();
    }

    protected void actionPerformedBtnCerrar(ActionEvent e) {
        dispose();
    }
}
