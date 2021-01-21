package com.Controller.app;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.Config;


public class HomeUser {

	private JFrame frame;
	private JTable table;
	Config connect;
    public Connection conn;
    public PreparedStatement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeUser window = new HomeUser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public HomeUser() throws Exception {
		connect=new Config("jdbc:mysql://localhost:3306/gestion_formations","root","","com.mysql.jdbc.Driver");
		conn=connect.ConnectionLoad();
		initialize();
		 show();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBounds(100, 100, 1309, 671);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(81, 149, 1116, 330);
		panel.setBackground(new Color(255, 255, 240));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List Formations :");
		lblNewLabel.setBounds(33, 11, 169, 36);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 82, 1055, 237);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IDFormation", "Libelle", "Description"
			}
		));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(81, 39, 377, 45);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(360, 490, 586, 87);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Demander Formation");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(38, 22, 232, 42);
		panel_1.add(btnNewButton);
		
		JButton btnDetailsFormation = new JButton("Details Formation");
		btnDetailsFormation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDetailsFormation.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDetailsFormation.setBounds(311, 22, 232, 42);
		panel_1.add(btnDetailsFormation);
		
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
		btnLogOut.setBounds(1099, 27, 115, 45);
		frame.getContentPane().add(btnLogOut);
	}
	public void show() {
		try {
					 if(conn!=null) {
			 stmt = conn.prepareStatement("SELECT * FROM formation");
				
			 ResultSet result = stmt.executeQuery();
			 

			 DefaultTableModel df = (DefaultTableModel)table.getModel();
			 
			 df.setRowCount(0);
			 
			 while(result.next()) {
				int id = result.getInt("idFormation");
				String libellé = result.getString("libelle");
				String description = result.getString("description");
			
				
	            df.addRow(new Object[] {id,libellé,description});
			 }
	         }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
