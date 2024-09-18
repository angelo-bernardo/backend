package controller;
import model.*;
import view.*;
import java.util.*;

public class DespertadorController extends DespertadorView {
    public static String[] verOpcoes() {
        return DespertadorModel.mostrarOpcoes();
    }

    public static void acaoDespertador(int opcaoUsuario) {
        if (adiamentoAtual < 3) {
            switch (opcaoUsuario) {
                case 1:
                    if (mostrarOpcoesAdiamentos()) {
                        if ((minutoAtual + adiar) > 59) {
                            horaDespertar++;
                            if (horaDespertar > 23) {
                                horaDespertar = 0;
                            }
                            minutoDespertar = (minutoAtual + adiar) - 59;
                        } else {
                            minutoDespertar = minutoAtual + adiar;
                        }
                        adiamentoAtual++;
                        exibirAlarmeAdiado(adiar);
                    } else {
                        break;
                    }
                    break;

                case 2:
                    sairDoSistema();
                    break;

                default:
                    mostrarOpcaoInvalida();
                    break;
            }
        } else {
            sairDoSistema();
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

    public static String horaFaltante(int horaAtual, int minutoAtual, int segundoAtual, int horaDespertar, int minutoDespertar) {
        
        int tempoAtual = 0;
        tempoAtual += (segundoAtual);
        tempoAtual += (minutoAtual * 60);
        tempoAtual += (horaAtual * 3600);
        
        int tempoDespertar = 0;
        tempoDespertar += (minutoDespertar * 60);
        tempoDespertar += (horaDespertar * 3600);

        tempoDespertar -= tempoAtual;
        
        int horaFalta = Math.floorDiv(tempoDespertar, 3600);
        tempoDespertar -= (horaFalta * 3600);
        int minutoFalta = Math.floorDiv(tempoDespertar, 60);
        tempoDespertar -= (minutoFalta * 60);
        int segundoFalta = tempoDespertar;

        // Outra opção que também funciona:                
        // if (segundoAtual == 0) {
        //     if (minutoAtual == minutoDespertar) {
        //         if (horaAtual == horaDespertar) {
        //             return "00:00:00";
        //         }
        //     }
        // }
        // int segundoFalta = 60 - segundoAtual;
        // int minutoFalta = minutoDespertar - minutoAtual - 1;
        // int horaFalta = horaDespertar - horaAtual;    
        // if (segundoAtual == 0){
        //     segundoFalta = 0;
        //     minutoFalta++;
        //     if (minutoFalta == 60) {
        //         minutoFalta = 0;
        //         horaFalta++;
        //     }
        // }
        // if (minutoFalta < 0) {
        //     minutoFalta+=60;
        //     horaFalta--;
        // }

        return String.format("%02d:%02d:%02d", horaFalta, minutoFalta, segundoFalta);
    }

}
