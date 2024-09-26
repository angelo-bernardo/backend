package controller;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Apagar {
    public static void apagar() {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja apagar.");
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";
            
            if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                System.out.println("Arquivo escolhido: " + chooser.getSelectedFile().getName());
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                fileName = chooser.getSelectedFile().getName();
                System.out.println("Caminho + nome: " + fileFullPath);
                
                // Converte a string do caminho para um objeto Path
                Path path = Paths.get(fileFullPath);
                
                // Tenta apagar o arquivo
                Files.delete(path);
                System.out.println("Arquivo apagado com sucesso: " + fileName);
            } else {
                System.out.println("Abortando!");
                return;
            }
        } catch (Exception e) {
            System.out.println("Não foi possível apagar o arquivo: " + e.getMessage());
        }
    }
}
