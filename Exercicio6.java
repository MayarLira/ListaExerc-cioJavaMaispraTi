public class Exercicio6 {
        public class Exercicio6 {
    
        class Cliente {
            String nome;
            Cliente proximo;
    
            Cliente(String nome) {
                this.nome = nome;
                this.proximo = null;
            }
        }
    
        class FilaDeAtendimento {
            private Cliente primeiro;
            private Cliente ultimo;
    
            public FilaDeAtendimento() {
                this.primeiro = null;
                this.ultimo = null;
            }
    
            public void adicionarCliente(String nome) {
                Cliente novoCliente = new Cliente(nome);
                if (primeiro == null) {
                    primeiro = novoCliente;
                    ultimo = novoCliente;
                } else {
                    ultimo.proximo = novoCliente;
                    ultimo = novoCliente;
                }
            }
    
            public Cliente chamarProximoCliente() {
                if (primeiro == null) {
                    System.out.println("Nenhum cliente na fila.");
                    return null;
                } else {
                    Cliente clienteAtendido = primeiro;
                    primeiro = primeiro.proximo;
                    if (primeiro == null) {
                        ultimo = null;
                    }
                    return clienteAtendido;
                }
            }
    
            public void listarClientes() {
                Cliente atual = primeiro;
                while (atual != null) {
                    System.out.println(atual.nome);
                    atual = atual.proximo;
                }
            }
    
            public static void main(String[] args) {
                FilaDeAtendimento fila = new FilaDeAtendimento();
                fila.adicionarCliente("Cliente 1");
                fila.adicionarCliente("Cliente 2");
                fila.adicionarCliente("Cliente 3");
                fila.listarClientes();
                System.out.println("Chamando próximo cliente...");
                Cliente clienteAtendido = fila.chamarProximoCliente();
                if (clienteAtendido != null) {
                    System.out.println("Atendendo: " + clienteAtendido.nome);
                }
                fila.listarClientes();
            }
        }
    }
}
