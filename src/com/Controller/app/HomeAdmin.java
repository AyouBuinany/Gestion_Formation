package com.Controller.app;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class HomeAdmin {

	private JTable table;
	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeAdmin window = new HomeAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 1174, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		
		JPanel panel = new JPanel();
		panel.setBounds(53, 123, 1049, 344);
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 94, 1002, 239);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		table.setRowSelectionAllowed(false);
		table.setSurrendersFocusOnKeystroke(true);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"idEmploye", "Nom", "Prenom", "Formation"
			}
		));
		
		JLabel lblNewLabel = new JLabel("List de demande de Formations :");
		lblNewLabel.setBounds(26, 22, 334, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(260, 495, 677, 95);
		panel_1.setBackground(Color.PINK);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Management User");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Users u = new Users();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(10, 25, 188, 41);
		panel_1.add(btnNewButton);
		
		JButton btncrudformation = new JButton("Management Formation");
		btncrudformation.setBackground(Color.LIGHT_GRAY);
		btncrudformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Formation f = new Formation();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();
			}
		});
		btncrudformation.setFont(new Font("Tahoma", Font.BOLD, 15));
		btncrudformation.setBounds(231, 25, 211, 41);
		panel_1.add(btncrudformation);
		
		JButton btnSessioncrud = new JButton("Management Session");
		btnSessioncrud.setBackground(Color.LIGHT_GRAY);
		btnSessioncrud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Session session = new Session();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnSessioncrud.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSessioncrud.setBounds(475, 25, 192, 41);
		panel_1.add(btnSessioncrud);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Login lg = new Login();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogOut.setBounds(987, 22, 115, 45);
		frame.getContentPane().add(btnLogOut);
	}

	public Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}

}
