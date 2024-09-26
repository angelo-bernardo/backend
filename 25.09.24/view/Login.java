import java.awt.*;
import javax.swing.*;

public class Login extends JFrame {
    

    public Login() {
        super("Tela de Login");
        setLayout(new GridLayout(11, 1, 5, 5));
        GridLayout linha = new GridLayout(1, 1, 5, 5);
        JPanel linha0 = new JPanel(linha); // espaço em branco
        JPanel linha1 = new JPanel(linha); // loginJLabel
        JPanel linha2 = new JPanel(linha); // loginTextField
        JPanel linha3 = new JPanel(linha); // espaço em branco
        JPanel linha4 = new JPanel(linha); // senhaJLabel
        JPanel linha5 = new JPanel(linha); // senhaPasswordField
        JPanel linha6 = new JPanel(linha); // espaço em branco
        JPanel linha7 = new JPanel(new GridLayout(1, 2, 5, 5)); // botões
        JPanel linha8 = new JPanel(linha); // espaço em branco
        JPanel linha9 = new JPanel(linha); // checkbox termosButton
        JPanel linha10 = new JPanel(new FlowLayout(FlowLayout.LEFT)); //notificações

        final JLabel loginJLabel = new JLabel("Usuário", SwingConstants.CENTER);
        final JTextField loginTextField = new JTextField();
        final JLabel senhaJLabel = new JLabel("Digite a senha:", SwingConstants.CENTER);
        final JPasswordField senhaPasswordField = new JPasswordField();
        final JButton entrarJButton = new JButton("Entrar");
        final JButton incluirJButton = new JButton("Incluir");
        final JCheckBox termosButton = new JCheckBox("Aceito os termos");
        final JLabel notificacaoJLabel = new JLabel("Bem vindo, faço o login ou cadastre-se");    

        entrarJButton.addActionListener(e -> {
        });

        incluirJButton.addActionListener(e -> {
        });

        linha0.add(new JLabel());
        add(linha0);

        linha1.add(loginJLabel);
        add(linha1);

        linha2.add(loginTextField);
        add(linha2);

        linha3.add(new JLabel());
        add(linha3);

        linha4.add(senhaJLabel);
        add(linha4);

        linha5.add(senhaPasswordField);
        add(linha5);

        linha6.add(new JLabel());
        add(linha6);

        linha7.add(entrarJButton);
        linha7.add(incluirJButton);
        add(linha7);
        
        linha8.add(new JLabel());
        add(linha8);
        
        linha9.add(termosButton);
        add(linha9);

        linha10.add(new JLabel("Notificações:"));
        notificacaoJLabel.setText("<html><body>" + notificacaoJLabel.getText() + "</body></html>");
        linha10.add(notificacaoJLabel);
        add(linha10);

        setSize(350, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}