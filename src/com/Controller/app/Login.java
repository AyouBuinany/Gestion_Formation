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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import Connection.Config;


public class Login {
	private JFrame frmLoginForm;
    private JTextField log;
	private JPasswordField password;
    private JButton btnLogin;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_3_1;
    private JComboBox comboBox;
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
					Login window = new Login();
					window.frmLoginForm.setVisible(true);
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
	public Login() throws Exception {
		connect=new Config("jdbc:mysql://localhost:3306/gestion_formations","root","","com.mysql.jdbc.Driver");
		conn=connect.ConnectionLoad();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginForm = new JFrame();
		frmLoginForm.setResizable(false);
		frmLoginForm.setVisible(true);
		
	

		frmLoginForm.setTitle("login Form");
		frmLoginForm.setAlwaysOnTop(true);
		frmLoginForm.getContentPane().setBackground(UIManager.getColor("activeCaption"));
		frmLoginForm.setBounds(100, 100, 754, 425);
		frmLoginForm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmLoginForm.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(SystemColor.info);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(41, 11, 86, 42);
		frmLoginForm.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(66, 70, 86, 26);
		frmLoginForm.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Passwod   :");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(66, 143, 97, 26);
		frmLoginForm.getContentPane().add(lblNewLabel_1_1);
		
		log = new JTextField();
		log.setHorizontalAlignment(SwingConstants.LEFT);
		log.setFont(new Font("Tahoma", Font.BOLD, 15));
		log.setForeground(Color.BLACK);
		log.setBounds(175, 68, 345, 31);
		frmLoginForm.getContentPane().add(log);
		log.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLUE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Type :", "admin", "user"}));
		comboBox.setBounds(178, 215, 342, 31);
		frmLoginForm.getContentPane().add(comboBox);
		
		JButton btnLogin = new JButton("Connect");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String login = log.getText();
		        String mot_de_passe = password.getText();
				String type = (String) comboBox.getSelectedItem();
				
			try {
				
				if(conn!=null) {
					String req="Select login, password,type_user from employe where login=? and password=? and type_user=?";
				
		        PreparedStatement st =  conn.prepareStatement(req);

		        st.setString(1, login);
		        st.setString(2, mot_de_passe);
		        st.setString(3, type);
					
		        ResultSet rs = st.executeQuery();
				
				if(rs.next()) {
					if(type.equals("admin")) {
				
						// JOptionPane.showMessageDialog(null, "Your welcome in Page home <Admin>");
						 HomeAdmin Home_Admin = new HomeAdmin();
							frmLoginForm.dispose();
						 
					}
					else if(type.equals("user")) {
		
						HomeUser home_user = new HomeUser();
						frmLoginForm.dispose();
					}
					else {
						JOptionPane.showMessageDialog(frmLoginForm, "invalid username or password ");
					}

				}
				}
				} catch (SQLException sqlException) {
					// TODO Auto-generated catch block
					sqlException.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				 }
				
//			}
		
			

		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBounds(102, 315, 126, 37);
		frmLoginForm.getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("Register");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					RegisterEmp register_form = new RegisterEmp();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frmLoginForm.dispose();
				
		
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(262, 315, 132, 37);
		frmLoginForm.getContentPane().add(btnCancel);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.BOLD, 15));
		password.setForeground(Color.BLACK);
		password.setBounds(175, 141, 345, 31);
		frmLoginForm.getContentPane().add(password);
		
		JLabel lblNewLabel_2 = new JLabel("Type           :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(66, 215, 109, 26);
		frmLoginForm.getContentPane().add(lblNewLabel_2);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLoginForm.dispose();
			}
		});
		btnClose.setForeground(Color.BLACK);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setBounds(429, 315, 132, 37);
		frmLoginForm.getContentPane().add(btnClose);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(185, 110, 292, 20);
		frmLoginForm.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setForeground(Color.RED);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(185, 183, 292, 20);
		frmLoginForm.getContentPane().add(lblNewLabel_3_1);
		

		
	}

}
