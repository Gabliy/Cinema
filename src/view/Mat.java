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
		setBounds(100, 100, 286, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Conexao con = new Conexao();
		this.conexao = con.getConexao();

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				func.criarTabelaFuncionarios();
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
					Index in = new Index();
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
		btnNewButton.setBounds(88, 70, 89, 23);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(10, 36, 249, 23);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
		lblMatrcula.setBounds(10, 11, 69, 14);
		contentPane.add(lblMatrcula);
	}
}
