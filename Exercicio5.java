public class Exercicio5 {
    
        class Carta {
        String valor;
        Carta anterior;
        Carta proxima;
    
        Carta(String valor) {
            this.valor = valor;
            this.anterior = null;
            this.proxima = null;
        }
    }
    
    class MaoDoJogador {
        private Carta primeira;
        private Carta ultima;
    
        public MaoDoJogador() {
            this.primeira = null;
            this.ultima = null;
        }
    
        public void adicionarCarta(String valor) {
            Carta novaCarta = new Carta(valor);
            if (primeira == null) {
                primeira = novaCarta;
                ultima = novaCarta;
            } else {
                ultima.proxima = novaCarta;
                novaCarta.anterior = ultima;
                ultima = novaCarta;
            }
        }
    
        public void removerCarta(String valor) {
            Carta atual = primeira;
            while (atual != null && !atual.valor.equals(valor)) {
                atual = atual.proxima;
            }
            if (atual != null) {
                if (atual.anterior != null) {
                    atual.anterior.proxima = atual.proxima;
                } else {
                    primeira = atual.proxima;
                }
                if (atual.proxima != null) {
                    atual.proxima.anterior = atual.anterior;
                } else {
                    ultima = atual.anterior;
                }
            }
        }
    
        public void reorganizarCarta(String valor, int novaPosicao) {
            Carta atual = primeira;
            int posicaoAtual = 0;
            while (atual != null && !atual.valor.equals(valor)) {
                atual = atual.proxima;
                posicaoAtual++;
            }
            if (atual != null) {
                removerCarta(valor);
                Carta novaCarta = new Carta(valor);
                if (novaPosicao == 0) {
                    novaCarta.proxima = primeira;
                    if (primeira != null) {
                        primeira.anterior = novaCarta;
                    }
                    primeira = novaCarta;
                    if (ultima == null) {
                        ultima = novaCarta;
                    }
                } else {
                    Carta temp = primeira;
                    for (int i = 0; i < novaPosicao - 1 && temp != null; i++) {
                        temp = temp.proxima;
                    }
                    if (temp != null) {
                        novaCarta.proxima = temp.proxima;
                        novaCarta.anterior = temp;
                        if (temp.proxima != null) {
                            temp.proxima.anterior = novaCarta;
                        }
                        temp.proxima = novaCarta;
                        if (novaCarta.proxima == null) {
                            ultima = novaCarta;
                        }
                    }
                }
            }
        }
    
        public void listarCartas() {
            Carta atual = primeira;
            while (atual != null) {
                System.out.println(atual.valor);
                atual = atual.proxima;
            }
        }
    
        public static void main(String[] args) {
            MaoDoJogador mao = new MaoDoJogador();
            mao.adicionarCarta("Ás de Espadas");
            mao.adicionarCarta("Rei de Copas");
            mao.adicionarCarta("Dama de Ouros");
            mao.listarCartas();
            System.out.println("Removendo 'Rei de Copas'...");
            mao.removerCarta("Rei de Copas");
            mao.listarCartas();
            System.out.println("Reorganizando 'Dama de Ouros' para a posição 0...");
            mao.reorganizarCarta("Dama de Ouros", 0);
            mao.listarCartas();
        }
    }
}
