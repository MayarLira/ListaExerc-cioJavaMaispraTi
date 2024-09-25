class Tarefa {
    String descricao;
    boolean concluida;
    Tarefa proxima;

    Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
        this.proxima = null;
    }
}

class GerenciadorDeTarefas {
    private Tarefa primeira;

    public GerenciadorDeTarefas() {
        this.primeira = null;
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        if (primeira == null) {
            primeira = novaTarefa;
        } else {
            Tarefa atual = primeira;
            while (atual.proxima != null) {
                atual = atual.proxima;
            }
            atual.proxima = novaTarefa;
        }
    }

    public void removerTarefa(int indice) {
        if (primeira == null) {
            System.out.println("Lista vazia.");
            return;
        }
        if (indice == 0) {
            primeira = primeira.proxima;
            return;
        }
        Tarefa atual = primeira;
        for (int i = 0; i < indice - 1; i++) {
            if (atual.proxima == null) {
                System.out.println("Índice fora dos limites.");
                return;
            }
            atual = atual.proxima;
        }
        if (atual.proxima == null) {
            System.out.println("Índice fora dos limites.");
            return;
        }
        atual.proxima = atual.proxima.proxima;
    }

    public void marcarTarefaComoConcluida(int indice) {
        Tarefa atual = primeira;
        for (int i = 0; i < indice; i++) {
            if (atual == null) {
                System.out.println("Índice fora dos limites.");
                return;
            }
            atual = atual.proxima;
        }
        if (atual != null) {
            atual.concluida = true;
        } else {
            System.out.println("Índice fora dos limites.");
        }
    }

    public void listarTarefas() {
        Tarefa atual = primeira;
        int indice = 0;
        while (atual != null) {
            System.out.println(indice + ": " + atual.descricao + " [" + (atual.concluida ? "Concluída" : "Pendente") + "]");
            atual = atual.proxima;
            indice++;
        }
    }

    public static void main(String[] args) {
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
        gerenciador.adicionarTarefa("Comprar leite");
        gerenciador.adicionarTarefa("Estudar para a prova");
        gerenciador.listarTarefas();
        gerenciador.marcarTarefaComoConcluida(1);
        gerenciador.listarTarefas();
        gerenciador.removerTarefa(0);
        gerenciador.listarTarefas();
    }
}