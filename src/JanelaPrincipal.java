import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class JanelaPrincipal extends JFrame {

    // Campos Cliente
    private JTextField campoNomeCliente, campoEmailCliente;
    private JTextField cpf;
    private JCheckBox checkEmail, checkNotificacao;
    private JRadioButton radioMasc, radioFem;
    private JButton btnCadastrarCliente, btnLimparCliente;

    private JTable tabelaCliente;
    private DefaultTableModel modeloTabelaCliente;

    // Campos Produto
    private JTextField campoNomeProduto, campoDescricaoProduto,
            quantidade, precoUnitario, fornecedor;
    private JButton btnCadastrarProduto, btnLimparProduto;

    private JTable tabelaProduto;
    private DefaultTableModel modeloTabelaProduto;

    private JanelaPrincipal(){
        setTitle("Sistema de Cadastro de Produto e Cliente");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar barra = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(e -> System.exit(0));
        menuArquivo.add(itemSair);
        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem itemSobre = new JMenuItem("Sobre");
        itemSobre.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Sistema de Cadastro de Cliente e Produto\nCRUD Completo\nVersão 2.0"));
        menuAjuda.add(itemSobre);
        barra.add(menuArquivo);
        barra.add(menuAjuda);
        setJMenuBar(barra);

        // Abas

        JTabbedPane abas = new JTabbedPane();

        // Painel Cadastro Cliente

        JPanel painelCadastroCliente = new JPanel(new GridLayout(7,2));

        painelCadastroCliente.add(new JLabel("Nome :"));
        campoNomeCliente = new JTextField(10);
        painelCadastroCliente.add(campoNomeCliente);

        painelCadastroCliente.add(new JLabel("Email:"));
        campoEmailCliente = new JTextField(10);
        painelCadastroCliente.add(campoEmailCliente);

        painelCadastroCliente.add(new JLabel("CPF:"));
        cpf = new JTextField(20);
        painelCadastroCliente.add(cpf);

       JPanel painelGenero = new JPanel();

       radioMasc = new JRadioButton("Masculino");
       radioFem = new JRadioButton("Feminino");

       ButtonGroup grupoGenero = new ButtonGroup();
       grupoGenero.add(radioMasc);
       grupoGenero.add(radioFem);
       painelGenero.add(radioMasc);
       painelGenero.add(radioFem);
       painelCadastroCliente.add(painelGenero);

       checkEmail = new JCheckBox("Receber Emails");
       checkNotificacao = new JCheckBox("Ativar notificação");
       painelCadastroCliente.add(checkNotificacao);
       painelCadastroCliente.add(checkEmail);

       JPanel painelBotoes = new JPanel();
       btnLimparCliente = new JButton("Limpar Campos");
       btnCadastrarCliente = new JButton("Cadastrar");
       painelBotoes.add(btnLimparCliente);
       painelBotoes.add(btnCadastrarCliente);

       JPanel painelCadastroClienteCompleto = new JPanel(new BorderLayout());
       painelCadastroClienteCompleto.add(painelCadastroCliente, BorderLayout.CENTER);
       painelCadastroClienteCompleto.add(painelBotoes, BorderLayout.SOUTH);

        abas.addTab("Cliente", painelCadastroClienteCompleto);

        // Painel Cadastro Produto

        JPanel painelCadastroProduto = new JPanel(new GridLayout(7, 2));

        painelCadastroProduto.add(new JLabel("Nome :"));
        campoNomeProduto = new JTextField(10);
        painelCadastroProduto.add(campoNomeProduto);

        painelCadastroProduto.add(new JLabel("Descrição"));
        campoDescricaoProduto = new JTextField(10);
        painelCadastroProduto.add(campoDescricaoProduto);

        painelCadastroProduto.add(new JLabel("Quantidade"));
        quantidade = new JTextField(10);
        painelCadastroProduto.add(quantidade);

        painelCadastroProduto.add(new JLabel("Preço Unitário"));
        precoUnitario = new JTextField(10);
        painelCadastroProduto.add(precoUnitario);

        painelCadastroProduto.add(new JLabel("Fornecedor"));
        fornecedor = new JTextField(10);
        painelCadastroProduto.add(fornecedor);

        JPanel painelBotoesProduto = new JPanel();
        btnLimparProduto = new JButton("Limpar Campos");
        btnCadastrarProduto = new JButton("Cadastrar");
        painelBotoesProduto.add(btnLimparProduto);
        painelBotoesProduto.add(btnCadastrarProduto);

        JPanel painelCadastroProdutoCompleto = new JPanel(new BorderLayout());
        painelCadastroProdutoCompleto.add(painelCadastroProduto, BorderLayout.CENTER);
        painelCadastroProdutoCompleto.add(painelBotoesProduto, BorderLayout.SOUTH);


        add(abas);
        setLocationRelativeTo(null);
        setVisible(true);
        abas.addTab("Produto", painelCadastroProdutoCompleto);

        // Painel Lista Cliente

        modeloTabelaCliente = new DefaultTableModel(new Object[]{"ID", "Nome", "Email", "CPF", "Gênero"}, 0);
        tabelaCliente = new JTable(modeloTabelaCliente);
        JButton btnAtualizarCliente = new JButton("Atualizar");
        JButton btnDeletarCliente = new JButton("Deletar");
        JButton btnGerarRelatorio = new JButton("Gerar Relatório");

        JPanel painelListadeBotões = new JPanel();
        painelListadeBotões.add(btnAtualizarCliente);
        painelListadeBotões.add(btnDeletarCliente);
        painelListadeBotões.add(btnGerarRelatorio);

        JPanel painelListaCliente = new JPanel(new BorderLayout());
        painelListaCliente.add(new JScrollPane(tabelaCliente), BorderLayout.CENTER);
        painelListaCliente.add(painelListadeBotões, BorderLayout.SOUTH);
        abas.addTab("Relatório dos Cliente", painelListaCliente);





    }

    public static void main(String[] args) {
        new JanelaPrincipal();
    }


}
