import pages.AcessarLivros;

public static void main(String[] args) {
    AcessarLivros livros = new AcessarLivros();
    livros.acessarLivros();

    if (livros.getResponse() != null) {
        System.out.println("ISBN: " + livros.getResponse().path("books[0].isbn"));
    } else {
        System.out.println("❌ Sem resposta da API.");
    }
}
