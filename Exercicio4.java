public class Acao {
    String descricao;
    Acao anterior;
    Acao proxima;

    Acao(String descricao) {
        this.descricao = descricao;
        this.anterior = null;
        this.proxima = null;
    }
}

class EditorDeTexto {
    private Acao primeira;
    private Acao ultima;
    private Acao atual;

    public EditorDeTexto() {
        this.primeira = null;
        this.ultima = null;
        this.atual = null;
    }

    public void executarAcao(String descricao) {
        Acao novaAcao = new Acao(descricao);
        if (primeira == null) {
            primeira = novaAcao;
            ultima = novaAcao;
        } else {
            ultima.proxima = novaAcao;
            novaAcao.anterior = ultima;
            ultima = novaAcao;
        }
        atual = ultima;
    }

    public void desfazerAcao() {
        if (atual != null) {
            atual = atual.anterior;
        } else {
            System.out.println("Nenhuma ação para desfazer.");
        }
    }

    public void refazerAcao() {
        if (atual != null && atual.proxima != null) {
            atual = atual.proxima;
        } else if (atual == null && primeira != null) {
            atual = primeira;
        } else {
            System.out.println("Nenhuma ação para refazer.");
        }
    }

    public void listarAcoes() {
        Acao acao = primeira;
        while (acao != null) {
            System.out.println(acao.descricao + (acao == atual ? " <- Atual" : ""));
            acao = acao.proxima;
        }
    }

    public static void main(String[] args) {
        EditorDeTexto editor = new EditorDeTexto();
        editor.executarAcao("Escreveu 'Olá Mundo'");
        editor.executarAcao("Apagou 'Mundo'");
        editor.executarAcao("Escreveu 'Java'");
        editor.listarAcoes();
        System.out.println("Desfazendo última ação...");
        editor.desfazerAcao();
        editor.listarAcoes();
        System.out.println("Refazendo última ação...");
        editor.refazerAcao();
        editor.listarAcoes();
    }
} {
    
}
