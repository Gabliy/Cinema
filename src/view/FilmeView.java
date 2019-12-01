package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.Conexao;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class FilmeView extends JFrame {

    private JPanel contentPane;
    private Connection conexao;

    public static void main(String[] args) 
    {
        FilmeView frame = new FilmeView();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public FilmeView() 
    {
    	Conexao con = new Conexao();
		this.conexao = con.getConexao();
		setTitle("Filmes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension( 650, 393));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        int i = 1;
		String sql = "select * from filmes";
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

        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(18, 10, 603, 227);
        scroll.setPreferredSize(new Dimension(630, 247));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, i,10, 10));

        JButton[] btnTeste = new JButton[i];

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery(); //executa uma consulta
			int c=0;
			//int x = 36;
			//int y = 50;
			while(resultado.next()) {
				String nome = resultado.getString("titulo");
				String duracao = resultado.getString("duracao");
				String refe = resultado.getString("refe");
				//System.out.println(c);
				btnTeste[c] = new JButton("");
				btnTeste[c].setIcon(new ImageIcon(FilmeView.class.getResource(resultado.getString("refe"))));
				btnTeste[c].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
								Mid jan = new Mid(nome,duracao,refe);
								jan.setVisible(true);		
					}
				});
				//System.out.println(resultado.getString("ref"));
				//btnTeste[c].setBounds(x, 40, 124, 184);
				panel.add(btnTeste[c]);
				//x+=20;
				//y*=2;
				c++;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
        contentPane.setLayout(null);
        scroll.setViewportView(panel);
        contentPane.add(scroll);
        
        JButton btnAdicionarFilme = new JButton("Adicionar Filme");
        btnAdicionarFilme.setBounds(18, 287, 126, 41);
        contentPane.add(btnAdicionarFilme);

        pack();
    }

}