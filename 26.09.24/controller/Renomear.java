package controller;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Renomear {
    public static void renomear() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Selecione o arquivo que deseja renomear.");
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";

            if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                System.out.println("Arquivo escolhido: " + chooser.getSelectedFile().getName());
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                fileName = chooser.getSelectedFile().getName();
                System.out.println("Caminho + nome: " + fileFullPath);
                
                // Pede ao usuário o novo nome do arquivo
                String newFileName = JOptionPane.showInputDialog("Digite o novo nome do arquivo (com extensão):");
                if (newFileName == null || newFileName.trim().isEmpty()) {
                    System.out.println("Nome de arquivo inválido.");
                    return; // Aborta se o novo nome for inválido
                }

                // Define o caminho de destino
                Path pathOrigin = Paths.get(fileFullPath);
                Path pathDestination = Paths.get(pathOrigin.getParent().toString(), newFileName);

                // Tenta renomear o arquivo
                Files.move(pathOrigin, pathDestination);
                System.out.println("Arquivo renomeado com sucesso para: " + newFileName);
            } else {
                System.out.println("Abortando!");
                return;
            }
        } catch (Exception e) {
            System.out.println("Não foi possível renomear o arquivo: " + e.getMessage());
        }
    }
}
