package view;
import java.util.*;
import controller.*;

public class DespertadorView {
    public static int horaAtual;
    public static int minutoAtual;
    public static int segundoAtual;
    public static int horaDespertar;
    public static int minutoDespertar;
    public static int maxHora = 23;
    public static int maxMinuto = 59;
    public static int adiar;
    public static int[] adiamentos = {1, 5, 10, 15};
    public static int qtdAdiamento = 3;
    public static int adiamentoAtual = 0;
    public static Date date = null;
    public static Calendar calendar = null;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static Scanner scnInput = new Scanner(System.in);
    public static Scanner scnInputString = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;
        int respostaUsuario;
        DespertadorController.getHMS();
        DespertadorController.limparTela();

        System.out.println(
            String.format(
                "Agora são: %s%02d:%02d:%02d%s.", 
                ANSI_BLUE,
                horaAtual, 
                minutoAtual, 
                segundoAtual,
                ANSI_RESET
            )
        );

        configurarDespertador();
        DespertadorController.limparTela();

        while (sair == false) {
            DespertadorController.getHMS();
            System.out.println(
                String.format(
                    "O próximo alarme irá despertar às: %s%02d:%02d:00%s\n" + //
                    "Agora são........................: %s%02d:%02d:%02d%s\n" + // 
                    "Tempo que falta para o alarme....: %s%s%s\n" + //
                    "Adiado %s%d%s vez" + (adiamentoAtual > 1 ? "es" : "") + ".", 
                    ANSI_GREEN,
                    horaDespertar, 
                    minutoDespertar, 
                    ANSI_RESET,
                    ANSI_YELLOW,
                    horaAtual, 
                    minutoAtual, 
                    segundoAtual,
                    ANSI_RESET, 
                    ANSI_RED,
                    DespertadorController.horaFaltante(horaAtual, minutoAtual, segundoAtual, horaDespertar, minutoDespertar),
                    ANSI_RESET,
                    ANSI_BLUE,
                    adiamentoAtual,
                    ANSI_RESET
                )
            );

            if (horaAtual >= horaDespertar) {
                if (minutoAtual >= minutoDespertar) {
                    if (podeAdiar()) {
                        System.out.println("Acorda, seu despertador está chamando.");
                        String[] opcoes = DespertadorController.verOpcoes();
                        for (int c = 0; c < opcoes.length; c++) {
                            System.out.println(
                                String.format(
                                    "[%d] >> %s", 
                                    c + 1, 
                                    opcoes[c]
                                )
                            );
                        }
                        System.out.print("Escolha sua opção: [ ]\b\b");
                        respostaUsuario = scnInput.nextInt();
                        DespertadorController.acaoDespertador(respostaUsuario);
                    } else {
                        novoDespertador();
                    }
                }
            }
            contador(1000);
            System.out.print("\033[H\033[2J");  
            System.out.flush();
        }
        scnInput.close();
        scnInputString.close();
    }

    public static void mostrarOpcaoInvalida() {
        System.err.println("Opção inválida.");
    }

    public static void contador(int milisseg) {
        try {
            Thread.sleep(milisseg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void configurarDespertador() {
        adiamentoAtual = 0;
        configurarHora();
        configurarMinuto();
    }

    public static void configurarHora() {
        System.out.print("Digite a hora que você deseja configurar o despertador e tecle Enter: [  ]\b\b\b");
        horaDespertar = scnInput.nextInt();
        if (horaDespertar < horaAtual) {
            System.err.println("Digite um número igual ou maior que: " + horaAtual + " e tente novamente.");
            configurarHora();
        } else if (horaDespertar > maxHora) {
            System.err.println("Digite um número igual ou menor que " + maxHora + " e tente novamente.");
            configurarHora();
        }
    }

    public static void configurarMinuto() {
        System.out.print("Digite o minuto que você deseja configurar o despertador e tecle Enter: [  ]\b\b\b");
        minutoDespertar = scnInput.nextInt();
        if (horaDespertar == horaAtual) {
            if (minutoDespertar < minutoAtual) {
                System.err.println("Digite um número igual ou maior que: " + minutoAtual + " e tente novamente.");
                configurarMinuto();
            }
        }
        if (minutoDespertar > maxMinuto) {
            System.err.println("Digite um número igual ou menor que " + maxMinuto + " e tente novamente.");
            configurarMinuto();
        }
    }

    public static void sairDoSistema() {
        System.out.println("Ok! Alarme parado.");
        System.exit(0);
    }

    public static boolean mostrarOpcoesAdiamentos() {
        for (int a = 0; a < adiamentos.length; a++) {
            System.out.println(
                String.format(
                    "[%d] >> adiar %d minuto(s)", 
                    a + 1, 
                    adiamentos[a]
                )
            );
        }
        System.out.print("Escolha sua opção e tecle enter: [ ]\b\b");
        int respostaUsuario = scnInput.nextInt();
        if (respostaUsuario <= adiamentos.length) {
            adiar = adiamentos[respostaUsuario - 1];
            return true;
        } else {
            System.out.println("Opção inválida, tente novamente.");
            return false;
        }
    }

    public static boolean novoDespertador() {
        System.out.println("[1] >> Sim");
        System.out.println("[2] >> Não");
        System.out.print("Deseja configurar um novo despertador? Escolha sua opção e tecle enter: [ ]\b\b");
        int respostaUsuario = scnInput.nextInt();
        if (respostaUsuario == 1) {
            configurarDespertador();
        } else {
            sairDoSistema();
        }
        return true;
    }

    public static boolean podeAdiar() {
        if (adiamentoAtual < 3) {
            return true;
        } else {
            return false;
        }
    }

    public static void exibirAlarmeAdiado(int adiamentoInteger) {
        System.out.println("Ok! Despertador adiado em: " + adiamentoInteger + " minutos.");
        System.out.println("Você poderá adiar mais " + (qtdAdiamento - adiamentoAtual) + " vez" + ((qtdAdiamento - adiamentoAtual) > 1 ? "es" : "") + ".");
    }
}