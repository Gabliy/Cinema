package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.IngressoDAO;
import model.Ingresso;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;

public class Vender extends JFrame {

	private JPanel contentPane;
	IngressoDAO ing = new IngressoDAO();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender frame = new Vender("",0,0,"",0,"","");
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
	public Vender(String colfil,int qtdIngresso, float preco, String sessao,int numSala,String ingressoData,String filme) {
		setTitle("Ingresso");


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFilme = new JLabel("Filme: "+filme);
		lblFilme.setFont(new Font("Arial", Font.BOLD, 15));
		lblFilme.setBounds(12, 26, 340, 16);
		contentPane.add(lblFilme);

		JLabel lblNewLabel = new JLabel("Sessão: "+sessao);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 55, 340, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Sala: "+numSala);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(12, 84, 340, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Data do filme: "+ingressoData);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(12, 113, 340, 16);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Preço: "+preco);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(12, 142, 340, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Qtd de ingressos: "+qtdIngresso);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_4.setBounds(12, 171, 340, 16);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Coluna e fileira: "+colfil);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5.setBounds(12, 200, 340, 16);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Estudante: ");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6.setBounds(12, 229, 80, 16);
		contentPane.add(lblNewLabel_6);

		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setFont(new Font("Arial", Font.BOLD, 15));
		buttonGroup.add(rdbtnSim);
		rdbtnSim.setBounds(44, 254, 59, 25);
		contentPane.add(rdbtnSim);

		JRadioButton rdbtnNo = new JRadioButton("Não");
		rdbtnNo.setFont(new Font("Arial", Font.BOLD, 15));
		rdbtnNo.setSelected(true);
		buttonGroup.add(rdbtnNo);
		rdbtnNo.setBounds(121, 254, 59, 25);
		contentPane.add(rdbtnNo);

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(328, 323, 152, 65);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				boolean estudante = false;
				float precoM = 0;
				Date data = new Date();
				SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
				if(rdbtnSim.isSelected()) {
					precoM =(preco/2)*qtdIngresso;
					estudante = true;
				}else {
					precoM = preco*qtdIngresso;
				}
				ing.adicionar(new Ingresso(precoM,estudante,colfil,filme,sessao,ingressoData,formatador.format( data ),numSala,qtdIngresso));
			}
		});
		contentPane.add(btnNewButton);
	}
}
