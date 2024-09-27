package controller;

import javax.swing.*;
import java.nio.file.*;

public class Copiar {
    public static void copiar() throws Exception {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Selecione o arquivo que deseja copiar.");
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";
            if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                fileName = chooser.getSelectedFile().getName();
            } else {
                System.out.println("Abortando!");
                return;
            }

            chooser.setDialogTitle("Selecione a pasta de destino.");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal2 = chooser.showOpenDialog(null);
            String folderFullPath = "";
            if (returnVal2 == JFileChooser.APPROVE_OPTION) {
                folderFullPath = chooser.getSelectedFile().getAbsolutePath();
            } else {
                System.out.println("Abortando!");
                return;
            }

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath, fileName);
            
            // Verifica se o arquivo já existe e modifica o nome, se necessário
            int count = 1;
            while (Files.exists(pathDestination)) {
                String newFileName = fileName.substring(0, fileName.lastIndexOf('.')) + " - cópia" + count 
                    + fileName.substring(fileName.lastIndexOf('.'));
                pathDestination = Paths.get(folderFullPath, newFileName);
                count++;
            }

            // Copia o arquivo
            Files.copy(pathOrigin, pathDestination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arquivo copiado para: " + pathDestination.toString());
        } catch (Exception e) {
            System.out.println("Não foi possível copiar o arquivo: " + e.getMessage());
        }
    }
}