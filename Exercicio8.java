class Processo {
    int id;
    String nome;
    Processo proximo;

    Processo(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.proximo = null;
    }
}

class FilaDeProcessos {
    private Processo primeiro;
    private Processo ultimo;

    public FilaDeProcessos() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public void adicionarProcesso(int id, String nome) {
        Processo novoProcesso = new Processo(id, nome);
        if (primeiro == null) {
            primeiro = novoProcesso;
            ultimo = novoProcesso;
        } else {
            ultimo.proximo = novoProcesso;
            ultimo = novoProcesso;
        }
    }

    public Processo removerProcesso() {
        if (primeiro == null) {
            System.out.println("Nenhum processo na fila.");
            return null;
        } else {
            Processo processoRemovido = primeiro;
            primeiro = primeiro.proximo;
            if (primeiro == null) {
                ultimo = null;
            }
            return processoRemovido;
        }
    }

    public void listarProcessos() {
        Processo atual = primeiro;
        while (atual != null) {
            System.out.println("ID: " + atual.id + ", Nome: " + atual.nome);
            atual = atual.proximo;
        }
    }

    public static void main(String[] args) {
        FilaDeProcessos fila = new FilaDeProcessos();
        fila.adicionarProcesso(1, "Processo A");
        fila.adicionarProcesso(2, "Processo B");
        fila.adicionarProcesso(3, "Processo C");
        fila.listarProcessos();
        System.out.println("Removendo processo mais antigo...");
        Processo processoRemovido = fila.removerProcesso();
        if (processoRemovido != null) {
            System.out.println("Processo removido: ID: " + processoRemovido.id + ", Nome: " + processoRemovido.nome);
        }
        fila.listarProcessos();
    }
}