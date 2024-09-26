// package view;
// import controller.*;
// import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Cadastro extends JFrame {

    public Cadastro(String acao) {
        super(acao);

        setLayout(new GridLayout(6, 1, 5, 5));

        FlowLayout linha = new FlowLayout(FlowLayout.LEFT);
        JPanel linha1 = new JPanel(linha);
        JPanel linha2 = new JPanel(linha);
        JPanel linha3 = new JPanel(linha);
        JPanel linha4 = new JPanel(linha);
        JPanel linha5 = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel linha6 = new JPanel(linha);

        final JTextField idTextField = new JTextField(10);
        final JTextField nomeTextField = new JTextField(50);
        final JTextField emailTextField = new JTextField(50);
        final JPasswordField senhaPasswordField = new JPasswordField(15);
        final JPasswordField confirmesenhaPasswordField = new JPasswordField(15);
        final JLabel idJLabel = new JLabel("ID:");
        final JLabel nomeJLabel = new JLabel("Digite o nome:");
        final JLabel emailJLabel = new JLabel("Digite o email:");
        final JLabel senhaJLabel = new JLabel("Digite a senha:");
        final JLabel confirmesenhaJLabel = new JLabel("Confirme a senha:");
        final JCheckBox termosButton = new JCheckBox("Aceito os termos");
        final JLabel notificacaoJLabel = new JLabel("");
        final JButton acaoJButton = new JButton(acao);
        final JButton cancelarJButton = new JButton("Cancelar");

        if (acao == "Pesquisar" || acao == "Excluir") {
            senhaJLabel.setVisible(false);
            senhaPasswordField.setEditable(false);
            senhaPasswordField.setFocusable(false);
            senhaPasswordField.setVisible(false);
        }

        if (acao == "Login") {
            idJLabel.setVisible(false);
            idTextField.setVisible(false);
            emailJLabel.setVisible(false);
            emailTextField.setEditable(false);
            emailTextField.setFocusable(false);
            emailTextField.setVisible(false);
        } else {
            termosButton.setVisible(false);
        }

        confirmesenhaJLabel.setVisible(false);
        confirmesenhaPasswordField.setEditable(false);
        confirmesenhaPasswordField.setFocusable(false);
        confirmesenhaPasswordField.setVisible(false);

        idTextField.setEditable(false);
        idTextField.setFocusable(false);

        acaoJButton.addActionListener(e -> {
        });

        cancelarJButton.addActionListener(e -> {
        });

        senhaPasswordField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { habilitarConfirmacao();}
            public void removeUpdate(DocumentEvent e) { habilitarConfirmacao();}
            public void insertUpdate(DocumentEvent e) { habilitarConfirmacao();}
            void habilitarConfirmacao() {
                if (acao == "Cadastrar" || acao == "Alterar") {
                    confirmesenhaJLabel.setVisible(true);
                    confirmesenhaPasswordField.setEditable(true);
                    confirmesenhaPasswordField.setFocusable(true);
                    confirmesenhaPasswordField.setVisible(true);    
                }
            }
        });

        linha1.add(idJLabel);
        linha1.add(idTextField);
        add(linha1);

        linha2.add(nomeJLabel);
        linha2.add(nomeTextField);
        add(linha2);

        linha3.add(emailJLabel);
        linha3.add(emailTextField);
        add(linha3);

        linha4.add(senhaJLabel);
        linha4.add(senhaPasswordField);
        linha4.add(confirmesenhaJLabel);
        linha4.add(confirmesenhaPasswordField);
        linha4.add(termosButton);
        add(linha4);


        linha5.add(new JLabel());
        linha5.add(acaoJButton);
        linha5.add(cancelarJButton);
        linha5.add(new JLabel());
        add(linha5);

        linha6.add(new JLabel("Notificações:"));
        notificacaoJLabel.setText("<html><body>" + notificacaoJLabel.getText() + "</body></html>");
        linha6.add(notificacaoJLabel);
        add(linha6);

        setSize(700, 250);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}