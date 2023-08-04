import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ControleProducao {
    // Variáveis de instância privadas (encapsulamento)
    private String nomeProduto; // Nome do produto
    private int codigoIdentificacao; // Código de identificação do produto
    private int quantidadeMeta; // Quantidade que deve ser produzida do produto
    private int quantidadeProduzida; // Quantidade já produzida do produto
    private LocalDate prazoEntrega; // Data de prazo de entrega do produto

    // Método para cadastrar novo produto
    public void cadastrarProduto() {
        Scanner scanner = new Scanner(System.in);

        // Solicita informações do produto ao usuário
        System.out.println("Digite o nome do produto:");
        nomeProduto = scanner.nextLine();

        System.out.println("Digite o código de identificação:");
        codigoIdentificacao = scanner.nextInt();

        System.out.println("Digite a quantidade a ser produzida:");
        quantidadeMeta = scanner.nextInt();

        System.out.println("Digite a data de prazo de entrega (formato: dd/MM/yyyy):");
        String dataPrazoEntrega = scanner.next();
        prazoEntrega = LocalDate.parse(dataPrazoEntrega, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // Inicializa a quantidade produzida como 0
        quantidadeProduzida = 0;
    }

    // Método para exibir o status de produção do produto
    public void exibirStatusProducao() {
        System.out.println("Status de Produção do Produto " + nomeProduto + ":");
        System.out.println("Código de Identificação: " + codigoIdentificacao);
        System.out.println("Quantidade Meta: " + quantidadeMeta);
        System.out.println("Quantidade Produzida: " + quantidadeProduzida);
        System.out.println("Quantidade Restante: " + (quantidadeMeta - quantidadeProduzida));
        System.out.println("Prazo de Entrega: " + prazoEntrega.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    // Método para verificar o prazo de entrega do produto
    public void verificarPrazoEntrega() {
        LocalDate dataAtual = LocalDate.now();

        // Verifica se a data atual é posterior à data de prazo de entrega
        if (dataAtual.isAfter(prazoEntrega)) {
            System.out.println("O prazo de entrega para o produto " + nomeProduto + " foi atingido.");
        } else {
            System.out.println("O prazo de entrega para o produto " + nomeProduto + " ainda não foi atingido.");
        }
    }

    // Método para realizar a contagem regressiva para o prazo de entrega
    public void contagemRegressivaPrazoEntrega() {
        LocalDate dataAtual = LocalDate.now();
        int diasRestantes = (int) dataAtual.until(prazoEntrega).getDays();

        System.out.println("Contagem regressiva para o prazo de entrega do produto " + nomeProduto + ":");
        // Loop para exibir a contagem regressiva
        for (int i = diasRestantes; i >= 0; i--) {
            System.out.println("Faltam " + i + " dias para o prazo de entrega.");
        }
        System.out.println("Produto " + nomeProduto + " pronto para entrega!");
    }

    public static void main(String[] args) {
        ControleProducao sistema = new ControleProducao();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            // Exibindo o menu de opções ao usuário
            System.out.println("\n====== MENU ======");
            System.out.println("1. Cadastrar novo produto");
            System.out.println("2. Exibir status de produção de um produto");
            System.out.println("3. Verificar prazo de entrega de um produto");
            System.out.println("4. Contagem regressiva para o prazo de entrega de um produto");
            System.out.println("0. Sair");
            System.out.println("==================");
            System.out.println("Digite a opção desejada:");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    sistema.cadastrarProduto();
                    break;
                case 2:
                    sistema.exibirStatusProducao();
                    break;
                case 3:
                    sistema.verificarPrazoEntrega();
                    break;
                case 4:
                    sistema.contagemRegressivaPrazoEntrega();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}


/*    Modificadores de Acesso: public e private
        No Java, temos quatro modificadores de acesso: public, private, protected e o padrão (sem especificar nenhum).
        Os modificadores de acesso definem a visibilidade dos membros de uma classe (campos e métodos) para outras classes.
        public: Os membros marcados como public são acessíveis de qualquer lugar, ou seja, outras classes podem acessá-los diretamente. 
        Neste código, os métodos cadastrarProduto(), exibirStatusProducao(), verificarPrazoEntrega() e contagemRegressivaPrazoEntrega() 
        são públicos, permitindo que o programa principal os chame.
        private: Os membros marcados como private só são acessíveis dentro da própria classe. Neste código, as variáveis de instância 
        nomeProduto, codigoIdentificacao, quantidadeMeta, quantidadeProduzida e prazoEntrega são privadas, o que significa que apenas os métodos dentro da classe ControleProducao podem acessá-las diretamente.
        O encapsulamento é uma prática importante de programação, pois protege os detalhes internos da implementação de uma classe e 
        evita que outras classes acessem ou modifiquem diretamente seus atributos, reduzindo a possibilidade de erros e tornando a 
        manutenção mais fácil.

    Método cadastrarProduto():
        Este método é responsável por solicitar ao usuário as informações sobre o novo produto e armazená-las nos 
        campos correspondentes (variáveis de instância).
        Cada campo é preenchido por meio de entradas do usuário, utilizando um objeto Scanner para a leitura das informações.

    Método exibirStatusProducao():
        Este método exibe na saída padrão (console) as informações de status do produto, como nome, código de identificação, 
        quantidade meta, quantidade produzida, quantidade restante e prazo de entrega.
        As informações são obtidas diretamente das variáveis de instância da classe, que são privadas, 
        mas podem ser acessadas pelos métodos da própria classe.

    Método verificarPrazoEntrega():
        Este método compara a data atual com a data de prazo de entrega do produto e informa se o prazo já foi atingido ou não.
        A data atual é obtida usando LocalDate.now(), e a comparação é feita com o método isAfter().

    Método contagemRegressivaPrazoEntrega():
        Este método realiza uma contagem regressiva a partir da data atual até a data de prazo de entrega do produto.
        A diferença em dias entre as duas datas é obtida usando o método until() de LocalDate.
        O método utiliza um loop for para imprimir os dias restantes até o prazo de entrega chegar a zero.

    Método main():
        O método main é o ponto de entrada do programa e é executado quando o programa é iniciado.
        Ele cria uma instância da classe ControleProducao chamada sistema e um objeto Scanner para a entrada do usuário.
        O programa entra em um loop do-while, onde exibe um menu de opções e aguarda a entrada do usuário para executar a 
        funcionalidade desejada.
        Os métodos públicos da classe ControleProducao são chamados com base na opção selecionada pelo usuário, 
        permitindo que ele cadastre produtos, verifique status, prazos de entrega e faça a contagem regressiva. 
        O programa só é encerrado quando a opção 0 (Sair) é selecionada. 
        */