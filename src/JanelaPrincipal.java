import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        setTitle("Sistema de Cadastro - Principal");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // -------------------- TÍTULO --------------------
        JLabel lblTitulo = new JLabel("Bem-vindo ao Sistema!", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(lblTitulo, BorderLayout.NORTH);

        // -------------------- PAINEL CENTRAL --------------------
        JPanel painelCentral = new JPanel(new GridLayout(2, 1, 20, 20));
        painelCentral.setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));

        JButton btnCliente = new JButton("Cadastro de Cliente");
        btnCliente.setFont(new Font("Arial", Font.BOLD, 16));
        btnCliente.addActionListener(e -> new JanelaCliente().setVisible(true));

        JButton btnProduto = new JButton("Cadastro de Produto");
        btnProduto.setFont(new Font("Arial", Font.BOLD, 16));
        btnProduto.addActionListener(e -> new JanelaProduto().setVisible(true));

        painelCentral.add(btnCliente);
        painelCentral.add(btnProduto);

        add(painelCentral, BorderLayout.CENTER);

        // -------------------- MENU --------------------
        setJMenuBar(criarMenu());

        setVisible(true);
    }

    // ==========================================
    // MÉTODO PARA CRIAR O MENU COMPLETO
    // ==========================================
    private JMenuBar criarMenu() {
        JMenuBar barra = new JMenuBar();

        // ---------- MENU ARQUIVO ----------
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(e -> System.exit(0));
        menuArquivo.add(itemSair);

        // ---------- MENU CADASTROS ----------
        JMenu menuCadastros = new JMenu("Cadastros");

        JMenuItem itemCadCliente = new JMenuItem("Cadastro de Cliente");
        itemCadCliente.addActionListener(e -> new JanelaCliente().setVisible(true));

        JMenuItem itemCadProduto = new JMenuItem("Cadastro de Produto");
        itemCadProduto.addActionListener(e -> new JanelaProduto().setVisible(true));

        menuCadastros.add(itemCadCliente);
        menuCadastros.add(itemCadProduto);


        // ---------- MENU AJUDA ----------
        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem itemSobre = new JMenuItem("Sobre");
        itemSobre.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Sistema de Cadastro\nCRUD Completo\nVersão 2.0"));
        menuAjuda.add(itemSobre);

        return barra;
    }

    public static void main(String[] args) {
        new JanelaPrincipal();
    }
}
