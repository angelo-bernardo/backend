package controller;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Mover {
    public static void mover() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Selecione o arquivo que deseja mover.");
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            String fileName = "";

            if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                System.out.println("Você escolheu abrir este arquivo: " + chooser.getSelectedFile().getName());
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
                fileName = chooser.getSelectedFile().getName();
                System.out.println("Caminho completo do arquivo: " + fileFullPath);
            } else {
                System.out.println("Abortando!");
                return; // Aborta se nenhum arquivo for selecionado
            }

            chooser.setDialogTitle("Selecione a pasta de destino.");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal2 = chooser.showOpenDialog(null);
            String folderFullPath = "";

            if (returnVal2 == JFileChooser.APPROVE_OPTION) {
                folderFullPath = chooser.getSelectedFile().getAbsolutePath();
                System.out.println("Você escolheu abrir esta pasta: " + chooser.getSelectedFile().getName());
                System.out.println("Caminho completo da pasta: " + folderFullPath);
            } else {
                System.out.println("Abortando!");
                return; // Aborta se nenhuma pasta for selecionada
            }

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath, fileName); // Novo caminho no diretório de destino
            Files.move(pathOrigin, pathDestination); // Move o arquivo

            System.out.println("Arquivo movido com sucesso para: " + pathDestination.toString());
        } catch (Exception e) {
            System.out.println("Não foi possível mover o arquivo: " + e.getMessage());
        }
    }
}
