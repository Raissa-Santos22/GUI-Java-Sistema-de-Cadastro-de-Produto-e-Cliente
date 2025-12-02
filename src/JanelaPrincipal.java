import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class JanelaPrincipal extends JFrame {

    // Campos Cliente
    private JTextField campoNomeCliente;
    private JTextField campoEmailCliente;
    private JTextField cpf;
    private JCheckBox checkEmail, checkNotificacao;
    private JRadioButton radioMasc, radioFem;
    private JButton btnCadastrarCliente, btnLimparCliente;

    private JTable tabelaCliente;
    private DefaultTableModel modeloTabelaCliente;
    private boolean tabelaCarregada = false;

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

        modeloTabelaCliente = new DefaultTableModel(new Object[]{"ID", "Nome", "Email", "Gênero", "CPF"}, 0);
        tabelaCliente = new JTable(modeloTabelaCliente);
        JButton btnAtualizarCliente = new JButton("Atualizar");
        JButton btnDeletarCliente = new JButton("Deletar");
        JButton btnGerarRelatorio = new JButton("Gerar Relatório");

        JPanel painelListadeBotoes = new JPanel();
        painelListadeBotoes.add(btnAtualizarCliente);
        painelListadeBotoes.add(btnDeletarCliente);
        painelListadeBotoes.add(btnGerarRelatorio);

        JPanel painelListaCliente = new JPanel(new BorderLayout());
        painelListaCliente.add(new JScrollPane(tabelaCliente), BorderLayout.CENTER);
        painelListaCliente.add(painelListadeBotoes, BorderLayout.SOUTH);
        abas.addTab("Relatório dos Cliente", painelListaCliente);

        // Painel Lista Produto

        modeloTabelaProduto = new DefaultTableModel(new Object[]{"ID", "Nome", "Descrição","Quanitidade", "Fornecedor", "Preço Unitário"}, 0);
        tabelaProduto = new JTable(modeloTabelaProduto);
        JButton btnAtualizarProduto = new JButton("Atualizar");
        JButton btnDeletarProduto = new JButton("Deletar");
        JButton btnGerarRelatórioProduto = new JButton("Gerar Relatório");

        JPanel painelListaBotoesProduto = new JPanel();
        painelListaBotoesProduto.add(btnAtualizarProduto);
        painelListaBotoesProduto.add(btnDeletarProduto);
        painelListaBotoesProduto.add(btnGerarRelatórioProduto);
        btnGerarRelatorio.addActionListener(e -> {
            tabelaCarregada = true;
            carregarTabelaCliente();
        });

        JPanel painelListaProduto = new JPanel(new BorderLayout());
        painelListaProduto.add(new JScrollPane(tabelaProduto),BorderLayout.CENTER);
        painelListaProduto.add(painelListaBotoesProduto, BorderLayout.SOUTH);
        abas.addTab("Relatório dos Produtos", painelListaProduto);
        
        // Métodos Cliente

        // Ações do Cadastro Cliente
        btnCadastrarCliente.addActionListener(e -> cadastrarCliente());
        btnLimparCliente.addActionListener(e -> limparCamposCliente());
        btnAtualizarCliente.addActionListener(e -> atualizarCliente());
        btnDeletarCliente.addActionListener(e -> deletarCliente());
        getContentPane().add(abas);
    }



    private void cadastrarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(campoNomeCliente.getText());
        cliente.setEmail(campoEmailCliente.getText());
        cliente.setCpf(cpf.getText());
        cliente.setGenero(radioMasc.isSelected() ? "Masculino" : "Feminino");
        cliente.setReceberEmail(checkEmail.isSelected());
        cliente.setReceberNotificacao(checkNotificacao.isSelected());

        new ClienteDAO().salvar(cliente);
        limparCamposCliente();
        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
    }

    private void carregarTabelaCliente() {
        modeloTabelaCliente.setRowCount(0);
        List<Cliente> lista = new ClienteDAO().listar();

        for (Cliente c : lista) {
            modeloTabelaCliente.addRow(new Object[]{c.getId(), c.getNome(), c.getEmail(), c.getGenero(), c.getCpf(),
            });
        }
        tabelaCarregada = true;
    }

    private void atualizarCliente() {

        if (!tabelaCarregada) {
            JOptionPane.showMessageDialog(this, "Clique em GERAR RELATÓRIO antes de atualizar.");
            return;
        }

        int linha = tabelaCliente.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um aluno para atualizar.");
            return;
        }

        int id = (int) tabelaCliente.getValueAt(linha, 0);
        String novoNome = JOptionPane.showInputDialog("Novo nome:", tabelaCliente.getValueAt(linha, 1));
        String novoEmail = JOptionPane.showInputDialog("Novo email:", tabelaCliente.getValueAt(linha, 2));
        String novoGenero = JOptionPane.showInputDialog("Novo gênero:", tabelaCliente.getValueAt(linha, 3));
        String novoCpf = JOptionPane.showInputDialog("Novo CPF :", tabelaCliente.getValueAt(linha, 4));

        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(novoNome);
        cliente.setEmail(novoEmail);
        cliente.setGenero(novoGenero);
        cliente.setCpf(novoCpf);


        new ClienteDAO().atualizar(cliente);

        JOptionPane.showMessageDialog(this, "Aluno atualizado com sucesso!");
    }

    private void limparCamposCliente() {
        campoNomeCliente.setText("");
        campoEmailCliente.setText("");
        radioMasc.setSelected(false);
        radioFem.setSelected(false);
        checkEmail.setSelected(false);
        checkNotificacao.setSelected(false);
    }

    private void deletarCliente() {
        if (!tabelaCarregada) {
            JOptionPane.showMessageDialog(this, "Clique em GERAR RELATÓRIO antes de excluir.");
            return;
        }

        int linha = tabelaCliente.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um aluno para excluir.");
            return;
        }

        int id = (int) tabelaCliente.getValueAt(linha, 0);

        new ClienteDAO().excluir(id);

        JOptionPane.showMessageDialog(this, "Aluno excluído com sucesso!");
    }

    public static void main(String[] args) {
        new JanelaPrincipal();
    }
}

