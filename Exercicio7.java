class TrabalhoDeImpressao {
    String nome;
    TrabalhoDeImpressao proximo;

    TrabalhoDeImpressao(String nome) {
        this.nome = nome;
        this.proximo = null;
    }
}

class FilaDeImpressao {
    private TrabalhoDeImpressao primeiro;
    private TrabalhoDeImpressao ultimo;

    public FilaDeImpressao() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public void adicionarTrabalho(String nome) {
        TrabalhoDeImpressao novoTrabalho = new TrabalhoDeImpressao(nome);
        if (primeiro == null) {
            primeiro = novoTrabalho;
            ultimo = novoTrabalho;
        } else {
            ultimo.proximo = novoTrabalho;
            ultimo = novoTrabalho;
        }
    }

    public TrabalhoDeImpressao processarProximoTrabalho() {
        if (primeiro == null) {
            System.out.println("Nenhum trabalho de impressão na fila.");
            return null;
        } else {
            TrabalhoDeImpressao trabalhoProcessado = primeiro;
            primeiro = primeiro.proximo;
            if (primeiro == null) {
                ultimo = null;
            }
            return trabalhoProcessado;
        }
    }

    public void listarTrabalhos() {
        TrabalhoDeImpressao atual = primeiro;
        while (atual != null) {
            System.out.println(atual.nome);
            atual = atual.proximo;
        }
    }

    public static void main(String[] args) {
        FilaDeImpressao fila = new FilaDeImpressao();
        fila.adicionarTrabalho("Documento 1");
        fila.adicionarTrabalho("Documento 2");
        fila.adicionarTrabalho("Documento 3");
        fila.listarTrabalhos();
        System.out.println("Processando próximo trabalho...");
        TrabalhoDeImpressao trabalhoProcessado = fila.processarProximoTrabalho();
        if (trabalhoProcessado != null) {
            System.out.println("Processando: " + trabalhoProcessado.nome);
        }
        fila.listarTrabalhos();
    }
}