package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.Conexao;
import DAO.FuncionarioDAO;
import model.Funcionario;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Mat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Connection conexao;

	/**
	 * Launch the application.
	 */
	FuncionarioDAO func = new FuncionarioDAO();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mat frame = new Mat();
					frame.setLocationRelativeTo(null);
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
	public Mat() {
		setTitle("Login");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 673, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Conexao con = new Conexao();
		this.conexao = con.getConexao();

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBackground(new Color(245, 222, 179));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String nome = textField.getText();
				boolean state = false;
				String sql = "select * from Funcionarios where nome like ?";

				try {
					PreparedStatement stmt = conexao.prepareStatement(sql);
					stmt.setString(1,'%'+nome+'%');

					ResultSet resultado = stmt.executeQuery();//executa uma consulta
					while(resultado.next()) {
						if(resultado.getString("nome").equals(nome)) {
							state = true;
						}
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				if(state==true) {
					JOptionPane.showMessageDialog(null, "O nome foi encontrado!!!");
					FilmeView in = new FilmeView();
					in.setVisible(true);
					in.setLocationRelativeTo(null);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "O nome não foi encontrado!!");
					int opt= JOptionPane.showConfirmDialog(null, "Deseja se cadastrar?????");
					if(opt==0) {
						String nomefunc = JOptionPane.showInputDialog(null,"Digita o seu nome: ");
						String endefunc = JOptionPane.showInputDialog(null,"Digita o seu endereço: ");
						String telefunc = JOptionPane.showInputDialog(null,"Digita o seu telefone: ");
						func.adicionar(new Funcionario(nomefunc,endefunc,telefunc));
						

					}
				}
			}
		});
		btnNewButton.setBounds(28, 211, 285, 123);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(28, 111, 285, 34);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblMatrcula = new JLabel("Matrícula:");
		lblMatrcula.setFont(new Font("Arial", Font.BOLD, 17));
		lblMatrcula.setBounds(28, 69, 121, 14);
		contentPane.add(lblMatrcula);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(188, 143, 143));
		panel.setBounds(0, 0, 354, 347);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Mat.class.getResource("/img/iconCamera.png")));
		label.setBounds(427, 158, 137, 136);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(427, 30, 137, 115);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Mat.class.getResource("/img/iconGlass.png")));
	}
}
