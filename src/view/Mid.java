package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.Conexao;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.GridLayout;

public class Mid extends JFrame {

	private JPanel contentPane;
	private Connection conexao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mid frame = new Mid("","","");
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
	public Mid(String nomeFilme, String duracao, String ref) {
		Conexao con = new Conexao();
		this.conexao = con.getConexao();
		setTitle(nomeFilme);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 630, 247);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel foto = new JLabel("");
		foto.setBounds(26, 50, 124, 184);
		panel.add(foto);
		foto.setIcon(new ImageIcon(Mid.class.getResource(ref)));

		JLabel lblUmaSegundaChance = new JLabel(nomeFilme);
		lblUmaSegundaChance.setFont(new Font("Arial", Font.BOLD, 15));
		lblUmaSegundaChance.setBounds(26, 13, 258, 24);
		panel.add(lblUmaSegundaChance);

		JLabel lblNome = new JLabel("Nome: "+nomeFilme);
		lblNome.setFont(new Font("Arial", Font.BOLD, 15));
		lblNome.setBounds(173, 70, 252, 16);
		panel.add(lblNome);

		JLabel lblDuracao = new JLabel("Duração: "+duracao);
		lblDuracao.setFont(new Font("Arial", Font.BOLD, 15));
		lblDuracao.setBounds(173, 99, 185, 16);
		panel.add(lblDuracao);

		String sql = "select * from sessaos where nome_filme='"+nomeFilme+"'";
		int i = 0;
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery(); //executa uma consulta

			while(resultado.next()) {
				//System.out.println(i);
				i++;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		JButton[] btnSessao = new JButton[i];

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(37, 308, 318, 97);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, i, 10, 10));
		
				JLabel lblSesses = new JLabel("Sessões: ");
				lblSesses.setBounds(37, 273, 80, 34);
				contentPane.add(lblSesses);
				lblSesses.setFont(new Font("Arial", Font.BOLD, 15));
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery(); //executa uma consulta
			int c=0;
			if(i!=0) {
				while(resultado.next()) {
					//System.out.println(c);
					int sala = resultado.getInt("numSala");
					String nomeSes = resultado.getString("horario");
					String data = resultado.getString("data");
					btnSessao[c] = new JButton(resultado.getString("horario"));
					btnSessao[c].setFont(new Font("Arial", Font.BOLD, 15));
					btnSessao[c].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Sessoe ses = new Sessoe(nomeSes,sala,data,nomeFilme);
							ses.setVisible(true);
						}
					});
					panel_1.add(btnSessao[c]);
					c++;
				}
			}else {
				JLabel label = new JLabel("Nenhuma sessão no momento");
				panel_1.add(label);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}


		

	}
}
