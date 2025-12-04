import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class JanelaLoginAdminitrador extends JFrame {

    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JButton btnEntrar;

    public JanelaLoginAdminitrador() {
        setTitle("Login do Administrador");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Login do Administrador", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridBagLayout());
        painelCampos.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelCampos.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        txtEmail = new JTextField(20);
        painelCampos.add(txtEmail, gbc);

        // Senha
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelCampos.add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1;
        txtSenha = new JPasswordField(20);
        painelCampos.add(txtSenha, gbc);

        add(painelCampos, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        btnEntrar = new JButton("Entrar");
        painelBotoes.add(btnEntrar);
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        add(painelBotoes, BorderLayout.SOUTH);

        btnEntrar.addActionListener(e -> logar());
        txtSenha.addActionListener(e -> logar());

        setVisible(true);
    }

    private void logar() {
        String email = txtEmail.getText();
        String senha = new String(txtSenha.getPassword());

        AdministradorDAO dao = new AdministradorDAO();

        if (dao.autenticar(email, senha)) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
            new JanelaLoginAdminitrador().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Email ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
            txtSenha.setText("");
            txtEmail.requestFocus();
        }
    }

    public static void main(String[] args) {
        new JanelaLoginAdminitrador();
    }
}
