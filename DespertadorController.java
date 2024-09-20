package controller;
import model.*;
import view.*;
import java.util.*;

public class DespertadorController extends DespertadorView {
    public static String[] verOpcoes() {
        return DespertadorModel.mostrarOpcoes();
    }

    public static void acaoDespertador(int opcaoUsuario) {
        if (adiamentoAtual >= 3) sairDoSistema();
        switch (opcaoUsuario) {
            case 1:
                if (mostrarOpcoesAdiamentos()) {
                    minutoDespertar = minutoAtual + adiar;
                    if ((minutoDespertar) > 59) {
                        minutoDespertar -= 60;
                        horaDespertar++;
                        if (horaDespertar > 23) {
                            horaDespertar = 0;
                        }
                    }
                    adiamentoAtual++;
                    exibirAlarmeAdiado(adiar);
                }
                break;

            case 2:
                sairDoSistema();
                break;

            default:
                mostrarOpcaoInvalida();
                break;
        }
    }

    public static void getHMS() {
        date = new Date();
        calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        horaAtual = calendar.get(Calendar.HOUR_OF_DAY);
        minutoAtual = calendar.get(Calendar.MINUTE);
        segundoAtual = calendar.get(Calendar.SECOND);
    }

    public static void limparTela() {
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (final Exception e) {}
    }

    public static String horaFaltante(int horaAtual, int minutoAtual, int segundoAtual, int horaDespertar, int minutoDespertar) {

        if (horaAtual >= horaDespertar) {
            if (minutoAtual >= minutoDespertar) {
                if (segundoAtual >= 0) {
                    return "00:00:00";
                }
            }
        }
        
        // Uma opção que funciona:
        // int tempoAtual = 0;
        // tempoAtual += (segundoAtual);
        // tempoAtual += (minutoAtual * 60);
        // tempoAtual += (horaAtual * 3600);
        
        // int tempoDespertar = 0;
        // tempoDespertar += (minutoDespertar * 60);
        // tempoDespertar += (horaDespertar * 3600);

        // tempoDespertar -= tempoAtual;
        // tempoDespertar = Math.max(0, tempoDespertar);
        
        // int horaFalta = Math.floorDiv(tempoDespertar, 3600);
        // tempoDespertar -= (horaFalta * 3600);
        // int minutoFalta = Math.floorDiv(tempoDespertar, 60);
        // tempoDespertar -= (minutoFalta * 60);
        // int segundoFalta = tempoDespertar;

        // Outra opção que também funciona:
        int segundoFalta = 60 - segundoAtual;
        int minutoFalta = minutoDespertar - minutoAtual - 1;
        int horaFalta = horaDespertar - horaAtual;    
        if (segundoAtual == 0){
            segundoFalta = 0;
            minutoFalta++;
            if (minutoFalta == 60) {
                minutoFalta = 0;
                horaFalta++;
            }
        }
        if (minutoFalta < 0) {
            minutoFalta+=60;
            horaFalta--;
        }

        return String.format("%02d:%02d:%02d", horaFalta, minutoFalta, segundoFalta);
    }

}
