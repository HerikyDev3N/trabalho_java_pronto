import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro extends JFrame {

    private JTextField emailField, usuarioField, telefoneField;
    private JPasswordField senhaField;

    public TelaCadastro() {
        setTitle("Cadastro");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Defina o fundo vermelho com baixa opacidade no painel de conteúdo
        JPanel contentPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(128, 0, 0, 128)); // Vermelho vinho com baixa opacidade
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 30));

        JLabel usuarioLabel = new JLabel("Usuário:");
        usuarioField = new JTextField();
        usuarioField.setPreferredSize(new Dimension(200, 30));

        JLabel senhaLabel = new JLabel("Senha:");
        senhaField = new JPasswordField();
        senhaField.setPreferredSize(new Dimension(200, 30));

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneField = new JTextField();
        telefoneField.setPreferredSize(new Dimension(200, 30));

        JButton cadastrarButton = new JButton("Cadastre-se");
        cadastrarButton.setBackground(new Color(255, 215, 0)); // Amarelo
        cadastrarButton.setForeground(Color.BLACK);
        cadastrarButton.setPreferredSize(new Dimension(200, 40));

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (camposEstaoPreenchidos()) {
                    cadastrar();
                } else {
                    JOptionPane.showMessageDialog(TelaCadastro.this, "Por favor, preencha todos os campos.", "Campos em Branco", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        contentPanel.add(emailLabel, constraints);

        constraints.gridy = 1;
        contentPanel.add(usuarioLabel, constraints);

        constraints.gridy = 2;
        contentPanel.add(senhaLabel, constraints);

        constraints.gridy = 3;
        contentPanel.add(telefoneLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        contentPanel.add(emailField, constraints);

        constraints.gridy = 1;
        contentPanel.add(usuarioField, constraints);

        constraints.gridy = 2;
        contentPanel.add(senhaField, constraints);

        constraints.gridy = 3;
        contentPanel.add(telefoneField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        contentPanel.add(cadastrarButton, constraints);

        setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void cadastrar() {
        // Lógica de cadastro aqui

        JOptionPane.showMessageDialog(this, "Você foi cadastrado com sucesso", "Cadastro Bem-sucedido", JOptionPane.INFORMATION_MESSAGE);

        // Limpar os campos após o cadastro
        emailField.setText("");
        usuarioField.setText("");
        senhaField.setText("");
        telefoneField.setText("");
    }

    private boolean camposEstaoPreenchidos() {
        return !emailField.getText().isEmpty() && !usuarioField.getText().isEmpty() && !new String(senhaField.getPassword()).isEmpty() && !telefoneField.getText().isEmpty();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastro());
    }
}
