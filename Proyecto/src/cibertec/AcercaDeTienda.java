package cibertec;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AcercaDeTienda extends JDialog implements ActionListener {

    private final JPanel contentPanel = new JPanel();
    private JButton btnCerrar;

    public static void main(String[] args) {
        try {
            AcercaDeTienda dialog = new AcercaDeTienda();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AcercaDeTienda() {
        setTitle("Acerca de Tienda");
        setBounds(100, 100, 360, 335);
        getContentPane().setLayout(null);

        JLabel lblJesusChavez = new JLabel("Johnny Nestor Jair Ramos Paucar (i202334672) ");
        lblJesusChavez.setFont(new Font("Garamond", Font.PLAIN, 16));
        lblJesusChavez.setBounds(21, 71, 328, 26);
        getContentPane().add(lblJesusChavez);

        JLabel lblAutores = new JLabel("Autores");
        lblAutores.setFont(new Font("Garamond", Font.PLAIN, 27));
        lblAutores.setBounds(119, 11, 156, 63);
        getContentPane().add(lblAutores);

        JLabel lblBetsyPantaleon = new JLabel("Laysson Jamir Polo De La Cruz (i202225224)");
        lblBetsyPantaleon.setFont(new Font("Garamond", Font.PLAIN, 16));
        lblBetsyPantaleon.setBounds(31, 108, 330, 26);
        getContentPane().add(lblBetsyPantaleon);

        JLabel lblJuniorRodriguez = new JLabel("Mijael Jefferson Esquivel Almanza");
        lblJuniorRodriguez.setFont(new Font("Garamond", Font.PLAIN, 16));
        lblJuniorRodriguez.setBounds(58, 145, 328, 26);
        getContentPane().add(lblJuniorRodriguez);

        JLabel lblMelannyAtoche = new JLabel("Juan Sebastian Guzman Ramos");
        lblMelannyAtoche.setFont(new Font("Garamond", Font.PLAIN, 16));
        lblMelannyAtoche.setBounds(68, 182, 328, 26);
        getContentPane().add(lblMelannyAtoche);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(this);
        btnCerrar.setFont(new Font("Garamond", Font.PLAIN, 16));
        btnCerrar.setBounds(108, 238, 91, 26);
        getContentPane().add(btnCerrar);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCerrar) {
            actionPerformedBtnCerrar(e);
        }
    }

    protected void actionPerformedBtnCerrar(ActionEvent e) {
        dispose();
    }
}
