import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    private JButton btnCliente;
    private JButton btnProduto;

    public JanelaPrincipal() {
        setTitle("Clientes e Produtos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Título
        JLabel lblTitulo = new JLabel("Bem vindo ao Sistema!", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(lblTitulo, BorderLayout.NORTH);

        // Painel de botões
        JPanel painelBotoes = new JPanel(); // FlowLayout padrão
        btnCliente = new JButton("Escolher Cliente");
        btnProduto = new JButton("Escolher Produto");

        painelBotoes.add(btnCliente);
        painelBotoes.add(btnProduto);

        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        add(painelBotoes, BorderLayout.CENTER); // Centraliza os botões

        // Ações
        btnCliente.addActionListener(e -> escolherCliente());
        btnProduto.addActionListener(e -> escolherProduto());

        setVisible(true);
    }

    private void escolherProduto() {
        JOptionPane.showMessageDialog(this, "Você escolheu o Produto");

    }

    private void escolherCliente() {
        JOptionPane.showMessageDialog(this, "Você escolheu o cliente!");
        JanelaCliente janelaCliente = new JanelaCliente();
        janelaCliente.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        new JanelaPrincipal();
    }
}
