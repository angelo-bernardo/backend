public class Inicio {
    public static void main(String[] args) {
        // this.setVisible(false);
        // Cadastro Cadastro = new Cadastro(this); // Passa a janela principal para a nova janela
        // Cadastro.setVisible(true);
        new Login();
        new Cadastro("Login");
        new Cadastro("Cadastrar");
        new Cadastro("Alterar");
        new Cadastro("Pesquisar");
        new Cadastro("Excluir");
    }
}
