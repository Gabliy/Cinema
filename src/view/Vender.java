package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ClienteDAO;
import DAO.Conexao;
import DAO.IngressoDAO;
import model.Cliente;
import model.Ingresso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Vender extends JFrame {

	private JPanel contentPane;
	IngressoDAO ing = new IngressoDAO();
	ClienteDAO cli = new ClienteDAO();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField nomeCli;
	private JTextField cpf;
	private JTextField ende;
	private JTextField tele;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private Connection conexao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender frame = new Vender("",0,0,"",0,"","",false);
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
	public Vender(String colfil,int qtdIngresso, float preco, String sessao,int numSala,String ingressoData,String filme,boolean estudante) {
		setTitle("Ingresso");
		Conexao con = new Conexao();
		this.conexao = con.getConexao();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 647, 480);
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

		if(estudante== true) {
			JLabel lblNewLabel_6 = new JLabel("Estudante: "+ "Sim");
			lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_6.setBounds(12, 229, 80, 16);
			contentPane.add(lblNewLabel_6);
		}else {
			JLabel lblNewLabel_6 = new JLabel("Estudante: "+"Não");
			lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_6.setBounds(12, 229, 130, 16);
			contentPane.add(lblNewLabel_6);
		}

		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 15));
		lblCliente.setBounds(352, 26, 87, 16);
		contentPane.add(lblCliente);

		JLabel lblNewLabel_7 = new JLabel("Nome:");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(362, 55, 56, 16);
		contentPane.add(lblNewLabel_7);

		nomeCli = new JTextField();
		nomeCli.setBounds(413, 52, 116, 22);
		contentPane.add(nomeCli);
		nomeCli.setColumns(10);

		JLabel lblCpf = new JLabel("Cpf: ");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCpf.setBounds(364, 96, 43, 16);
		contentPane.add(lblCpf);

		cpf = new JTextField();
		cpf.setBounds(413, 93, 116, 22);
		contentPane.add(cpf);
		cpf.setColumns(10);

		JLabel lblEndereo = new JLabel("Endereço: ");
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEndereo.setBounds(364, 142, 75, 16);
		contentPane.add(lblEndereo);

		ende = new JTextField();
		ende.setBounds(442, 139, 116, 22);
		contentPane.add(ende);
		ende.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTelefone.setBounds(364, 182, 68, 16);
		contentPane.add(lblTelefone);

		tele = new JTextField();
		tele.setBounds(442, 179, 116, 22);
		contentPane.add(tele);
		tele.setColumns(10);

		JLabel lblFormaDePagamento = new JLabel("Forma de pagamento: ");
		lblFormaDePagamento.setBounds(12, 270, 178, 16);
		contentPane.add(lblFormaDePagamento);

		JRadioButton rdbtnCartoDeDebito = new JRadioButton("Cartão de débito ou credito");
		buttonGroup_1.add(rdbtnCartoDeDebito);
		rdbtnCartoDeDebito.setBounds(32, 294, 214, 25);
		rdbtnCartoDeDebito.setSelected(true);
		contentPane.add(rdbtnCartoDeDebito);

		JRadioButton rdbtnAVista = new JRadioButton("A vista");
		buttonGroup_1.add(rdbtnAVista);
		rdbtnAVista.setBounds(32, 324, 127, 25);
		contentPane.add(rdbtnAVista);



		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(328, 323, 152, 65);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int opt = JOptionPane.showConfirmDialog(null, "O cliente efetuou o pagamento??");
				if(opt ==0) {
					cli.adicionar(new Cliente(cpf.getText(),nomeCli.getText(),ende.getText(),tele.getText()));
					String sql = "select idCliente from Clientes where cpf = '"+cpf.getText()+"'";
					PreparedStatement stmt;
					int idCliente = 0;
					try {
						stmt = conexao.prepareStatement(sql);
						ResultSet resultado = stmt.executeQuery();

						while(resultado.next()) {
							idCliente = resultado.getInt("idCliente");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					String pagamento = "";
					if(rdbtnCartoDeDebito.isSelected()) {
						pagamento = "Cartão";
					}else {
						pagamento = "A vísta";
					}
					Date data = new Date();
					SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
					ing.adicionar(new Ingresso(preco,estudante,colfil,filme,sessao,ingressoData,formatador.format( data ),numSala,qtdIngresso,idCliente,pagamento));
					JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso na data: "+formatador.format(data));
					dispose();
				}
			}
		});
		contentPane.add(btnNewButton);


	}
}
