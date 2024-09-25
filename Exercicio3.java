public class Exercicio3 {
    
}
public class Exercicio3 {

    class Acao {
        String descricao;
        Acao proxima;

        Acao(String descricao) {
            this.descricao = descricao;
            this.proxima = null;
        }
    }

    class ControleDeReversao {
        private Acao topo;

        public ControleDeReversao() {
            this.topo = null;
        }

        public void executarAcao(String descricao) {
            Acao novaAcao = new Acao(descricao);
            novaAcao.proxima = topo;
            topo = novaAcao;
        }

        public void desfazerAcao() {
            if (topo != null) {
                topo = topo.proxima;
            } else {
                System.out.println("Nenhuma ação para desfazer.");
            }
        }

        public void listarAcoes() {
            Acao atual = topo;
            while (atual != null) {
                System.out.println(atual.descricao);
                atual = atual.proxima;
            }
        }

        public static void main(String[] args) {
            ControleDeReversao controle = new ControleDeReversao();
            controle.executarAcao("Escreveu 'Olá Mundo'");
            controle.executarAcao("Apagou 'Mundo'");
            controle.executarAcao("Escreveu 'Java'");
            controle.listarAcoes();
            System.out.println("Desfazendo última ação...");
            controle.desfazerAcao();
            controle.listarAcoes();
        }
    }
}