// Classe ItemCosplay para representar os itens de cosplay
class ItemCosplay {
    // Atributos da classe
    private int codigo;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;

    // Construtor da classe
    public ItemCosplay(int codigo, String descricao, double preco, int quantidadeEstoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Métodos para modificar e obter os valores dos atributos
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    // Método para imprimir as informações do item de cosplay
    public void imprimirInformacoes() {
        System.out.println("=== Informações do Item de Cosplay ===");
        System.out.println("Código: " + codigo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Preço: R$" + preco);
        System.out.println("Quantidade em Estoque: " + quantidadeEstoque);
        System.out.println("=====================================");
    }
}

// Classe ArmarioCosplay para gerenciar os itens de cosplay
public class ArmarioCosplay {
    // Atributo para armazenar os itens de cosplay
    private ItemCosplay[] itens;
    private int capacidade;
    private int tamanhoAtual;

    // Construtor da classe ArmarioCosplay
    public ArmarioCosplay(int capacidade) {
        this.capacidade = capacidade;
        this.itens = new ItemCosplay[capacidade];
        this.tamanhoAtual = 0;
    }

    // Método para adicionar um novo item de cosplay ao armário
    public void adicionarItem(ItemCosplay item) {
        if (tamanhoAtual < capacidade) {
            itens[tamanhoAtual] = item;
            tamanhoAtual++;
            System.out.println("Item adicionado com sucesso!");
        } else {
            System.out.println("Não foi possível adicionar o item. Armário de cosplay está cheio.");
        }
    }

    // Método para verificar a disponibilidade de um item pelo código
    public void verificarDisponibilidade(int codigo) {
        boolean encontrado = false;
        for (ItemCosplay item : itens) {
            if (item != null && item.getCodigo() == codigo) {
                encontrado = true;
                if (item.getQuantidadeEstoque() > 0) {
                    System.out.println("Item disponível!");
                } else {
                    System.out.println("Item indisponível. Estoque esgotado.");
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Item não encontrado no armário de cosplay.");
        }
    }

    // Método para atualizar a quantidade em estoque de um item conforme a demanda
    public void atualizarEstoque(int codigo, int quantidadeVendida) {
        boolean encontrado = false;
        for (ItemCosplay item : itens) {
            if (item != null && item.getCodigo() == codigo) {
                encontrado = true;
                if (item.getQuantidadeEstoque() >= quantidadeVendida) {
                    item.setQuantidadeEstoque(item.getQuantidadeEstoque() - quantidadeVendida);
                    System.out.println("Estoque atualizado com sucesso.");
                } else {
                    System.out.println("Quantidade insuficiente em estoque para realizar a venda.");
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Item não encontrado no armário de cosplay.");
        }
    }

    // Método para imprimir todas as informações dos itens de cosplay no armário
    public void imprimirItens() {
        System.out.println("=== Itens no Armário de Cosplay ===");
        for (ItemCosplay item : itens) {
            if (item != null) {
                item.imprimirInformacoes();
            }
        }
        System.out.println("===================================");
    }

    // Método main para testar as classes
    public static void main(String[] args) {
        // Criando uma instância do armário de cosplay
        ArmarioCosplay armario = new ArmarioCosplay(5);

        // Criando e adicionando itens de cosplay
        ItemCosplay item1 = new ItemCosplay(1, "Espada de Kirito", 150.0, 3);
        ItemCosplay item2 = new ItemCosplay(2, "Colar da Sailor Moon", 80.0, 5);
        ItemCosplay item3 = new ItemCosplay(3, "Varinha de Harry Potter", 120.0, 2);

        armario.adicionarItem(item1);
        armario.adicionarItem(item2);
        armario.adicionarItem(item3);

        // Imprimindo todos os itens no armário
        armario.imprimirItens();

        // Verificando a disponibilidade de um item
        armario.verificarDisponibilidade(2);

        // Atualizando o estoque de um item
        armario.atualizarEstoque(1, 2);

        // Imprimindo novamente os itens no armário após atualização
        armario.imprimirItens();
    }
}
