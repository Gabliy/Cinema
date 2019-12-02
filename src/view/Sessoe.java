package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.Conexao;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Sessoe extends JFrame {

	private JPanel contentPane;
	private Connection conexao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sessoe frame = new Sessoe("",0,"","");
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
	public Sessoe(String nomeSes, int sala, String data, String nomeFilme) {
		Conexao con = new Conexao();
		this.conexao = con.getConexao();
		setTitle(nomeSes+" - Sala "+sala);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 771, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(49, 50, 652, 328);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 5, 0, 0));
		
		JLabel lblEscolhaAsPoltronas = new JLabel("Escolha as poltronas:");
		lblEscolhaAsPoltronas.setFont(new Font("Arial", Font.BOLD, 15));
		lblEscolhaAsPoltronas.setBounds(49, 13, 211, 16);
		contentPane.add(lblEscolhaAsPoltronas);
		
		JCheckBox[][] ch = new JCheckBox[5][5];
		String colfil;
		char fil = 'A';
		int col = 1;
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[i].length; j++) {
				
				colfil = fil+" - "+col;
				
				ch[i][j] = new JCheckBox(colfil);
				panel.add(ch[i][j]);
				col++;
			}
			fil++;
		}
		
		String sql = "select * from sessaos where horario ='"+nomeSes+"' and numSala ="+sala;
		
		JLabel lblEstudante = new JLabel("Estudante: ");
		lblEstudante.setFont(new Font("Arial", Font.BOLD, 15));
		lblEstudante.setBounds(49, 401, 97, 16);
		contentPane.add(lblEstudante);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setBounds(59, 429, 58, 25);
		contentPane.add(rdbtnSim);
		
		JRadioButton rdbtnNo = new JRadioButton("Não");
		rdbtnNo.setBounds(133, 429, 58, 25);
		rdbtnNo.setSelected(true);
		contentPane.add(rdbtnNo);
		
		JButton btnNewButton = new JButton("Gerar ingresso");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 19));
		btnNewButton.setBounds(457, 391, 244, 74);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String resu = "";
					int cont = 0;
					for (int i = 0; i < ch.length; i++) {
						for (int j = 0; j < ch[i].length; j++) {
							if(ch[i][j].isSelected()) {
								resu+=ch[i][j].getText()+"   ";
								cont++;
							}
						}
					}
					if(cont!=0){
						float preco = 0; 
						PreparedStatement stmt = conexao.prepareStatement(sql);
						ResultSet resultado = stmt.executeQuery();
						float precoM;
						boolean estudante = false;
						while(resultado.next()) {
							preco = resultado.getFloat("preco");
						}
						if(rdbtnSim.isSelected()) {
							precoM =(preco/2)*cont;
							estudante = true;
						}else {
							precoM = preco*cont;
						}
						Vender ven = new Vender(resu,cont,precoM,nomeSes,sala,data,nomeFilme,estudante);
						ven.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null,"Escolha uma poltrona antes");
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("TELA");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(324, 433, 97, 37);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
