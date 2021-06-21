package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Conexion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Principal extends JFrame {
	private JPanel btnReporte2;
	private JTextField txtDistrito;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 404);
		btnReporte2 = new JPanel();
		btnReporte2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(btnReporte2);
		btnReporte2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ingrese distrito:");
		lblNewLabel.setBounds(20, 31, 108, 14);
		btnReporte2.add(lblNewLabel);
		
		txtDistrito = new JTextField();
		txtDistrito.setBounds(160, 28, 239, 20);
		btnReporte2.add(txtDistrito);
		txtDistrito.setColumns(10);
		
		JButton btnReporteCliente = new JButton("Buscar por distrito");
		btnReporteCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String distrito=txtDistrito.getText();
				Conexion cnx=new Conexion();
				cnx.reporte_cliente("ReporteCliente","SELECT * FROM T_CLIENTE WHERE distrito=$P{distrito}", distrito);
			}
		});
		btnReporteCliente.setBounds(182, 59, 178, 23);
		btnReporte2.add(btnReporteCliente);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese categoria de producto:");
		lblNewLabel_1.setBounds(20, 138, 178, 14);
		btnReporte2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(182, 135, 217, 20);
		btnReporte2.add(textField);
		textField.setColumns(10);
		
		JButton btnReporteProducto = new JButton("Buscar por categor\u00EDa");
		btnReporteProducto.setBounds(192, 164, 168, 23);
		btnReporte2.add(btnReporteProducto);
		
		JLabel lblNewLabel_2 = new JLabel("Ingrese ");
		lblNewLabel_2.setBounds(20, 237, 147, 14);
		btnReporte2.add(lblNewLabel_2);
	}
}

