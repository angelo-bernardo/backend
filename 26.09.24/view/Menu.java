package view;
import controller.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    public static void main(String[] args) {
        // Cria a janela principal
        JFrame frame = new JFrame("Escolha sua opção");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Cria um menu
        JMenuBar menuBar = new JMenuBar();
        
        // Cria um menu
        JMenu menu = new JMenu("Arquivo");
        
        // Cria as opções do menu
        JMenuItem copiar = new JMenuItem("Copiar");
        JMenuItem mover = new JMenuItem("Mover");
        JMenuItem apagar = new JMenuItem("Apagar");
        JMenuItem renomear = new JMenuItem("Renomear");

        // Adiciona ActionListeners para as opções
        copiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Copiar.copiar();
                } catch (Exception ex) {}
            }
        });
        
        mover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Mover.mover();
                } catch (Exception ex) {}
            }
        });
        
        apagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Apagar.apagar();
                } catch (Exception ex) {}
            }
        });
        
        renomear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Renomear.renomear();
                } catch (Exception ex) {}
            }
        });

        // Adiciona as opções ao menu
        menu.add(copiar);
        menu.add(mover);
        menu.add(apagar);
        menu.add(renomear);

        // Adiciona o menu ao menuBar
        menuBar.add(menu);
        
        // Adiciona o menuBar à janela
        frame.setJMenuBar(menuBar);
        
        // Define o layout e torna a janela visível
        frame.setVisible(true);
    }
}
