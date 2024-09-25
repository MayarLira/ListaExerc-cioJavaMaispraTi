public class Exercicio2 {
    
}
class Pagina {
    String url;
    Pagina proxima;

    Pagina(String url) {
        this.url = url;
        this.proxima = null;
    }
}

class HistoricoDeNavegacao {
    private Pagina primeira;
    private int tamanhoMaximo;
    private int tamanhoAtual;

    public HistoricoDeNavegacao(int tamanhoMaximo) {
        this.primeira = null;
        this.tamanhoMaximo = tamanhoMaximo;
        this.tamanhoAtual = 0;
    }

    public void adicionarPagina(String url) {
        Pagina novaPagina = new Pagina(url);
        if (primeira == null) {
            primeira = novaPagina;
        } else {
            Pagina atual = primeira;
            while (atual.proxima != null) {
                atual = atual.proxima;
            }
            atual.proxima = novaPagina;
        }
        tamanhoAtual++;
        if (tamanhoAtual > tamanhoMaximo) {
            removerPaginaAntiga();
        }
    }

    private void removerPaginaAntiga() {
        if (primeira != null) {
            primeira = primeira.proxima;
            tamanhoAtual--;
        }
    }

    public void listarHistorico() {
        Pagina atual = primeira;
        while (atual != null) {
            System.out.println(atual.url);
            atual = atual.proxima;
        }
    }

    public static void main(String[] args) {
        HistoricoDeNavegacao historico = new HistoricoDeNavegacao(3);
        historico.adicionarPagina("http://exemplo1.com");
        historico.adicionarPagina("http://exemplo2.com");
        historico.adicionarPagina("http://exemplo3.com");
        historico.listarHistorico();
        System.out.println("Adicionando nova página...");
        historico.adicionarPagina("http://exemplo4.com");
        historico.listarHistorico();
    }
}