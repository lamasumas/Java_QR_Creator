package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Qr.QrManager;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel pnFondo;
	private JPanel pnTitle;
	private JLabel lblTuFabulosaAplicacion;
	private JPanel pnPrincipal;
	private JLabel lblMeteElUrl;
	private JTextField textUrl;
	private JButton btnListo;
	private JLabel lblNombre;
	private JTextField textNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnFondo(), BorderLayout.CENTER);
	}

	private JPanel getPnFondo() {
		if (pnFondo == null) {
			pnFondo = new JPanel();
			pnFondo.setLayout(null);
			pnFondo.add(getPnTitle());
			pnFondo.add(getPnPrincipal());
		}
		return pnFondo;
	}
	private JPanel getPnTitle() {
		if (pnTitle == null) {
			pnTitle = new JPanel();
			pnTitle.setBounds(29, 23, 370, 62);
			pnTitle.setLayout(new BorderLayout(0, 0));
			pnTitle.add(getLblTuFabulosaAplicacion(), BorderLayout.CENTER);
		}
		return pnTitle;
	}
	private JLabel getLblTuFabulosaAplicacion() {
		if (lblTuFabulosaAplicacion == null) {
			lblTuFabulosaAplicacion = new JLabel("Tu fabulosa aplicacion para QR Mama");
			lblTuFabulosaAplicacion.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTuFabulosaAplicacion;
	}
	private JPanel getPnPrincipal() {
		if (pnPrincipal == null) {
			pnPrincipal = new JPanel();
			pnPrincipal.setBounds(12, 100, 416, 158);
			pnPrincipal.setLayout(null);
			pnPrincipal.add(getLblMeteElUrl());
			pnPrincipal.add(getTextUrl());
			pnPrincipal.add(getBtnListo());
			pnPrincipal.add(getLblNombre());
			pnPrincipal.add(getTextField_1());
		}
		return pnPrincipal;
	}
	private JLabel getLblMeteElUrl() {
		if (lblMeteElUrl == null) {
			lblMeteElUrl = new JLabel("Mete el url aqui:");
			lblMeteElUrl.setBounds(12, 12, 158, 15);
		}
		return lblMeteElUrl;
	}
	private JTextField getTextUrl() {
		if (textUrl == null) {
			textUrl = new JTextField();
			textUrl.setBounds(161, 10, 243, 19);
			textUrl.setColumns(10);
		}
		return textUrl;
	}
	private JButton getBtnListo() {
		if (btnListo == null) {
			btnListo = new JButton("Listo");
			btnListo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					QrManager qr = new QrManager();
					String nombre = textNombre.getText();
					String url = textUrl.getText();
					JFileChooser chooser = new JFileChooser();
					chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					chooser.showOpenDialog(contentPane);
					String path =  chooser.getSelectedFile().toString();
					qr.writeQRCode(url,path, nombre);
										
				}
			});
			btnListo.setBounds(259, 121, 117, 25);
		}
		return btnListo;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Mete el nombre del archivo:");
			lblNombre.setBounds(0, 51, 228, 15);
		}
		return lblNombre;
	}
	private JTextField getTextField_1() {
		if (textNombre == null) {
			textNombre = new JTextField();
			textNombre.setBounds(161, 75, 243, 19);
			textNombre.setColumns(10);
		}
		return textNombre;
	}
}
