import java.util.Scanner;
import java.util.Random;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class trabalho1 {

    private static final String[] PALAVRAS = {"JAVA", "PYTHON", "CPLUSPLUS", "PROGRAMACAO", "DESENVOLVIMENTO"};
    
    PrintStream out = System.out;
    
    private static final int MAX_TENTATIVAS = 6; // Número máximo de tentativas
    
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static List<String> jogadores = new ArrayList<>();
    private static List<Integer> pontuacoes = new ArrayList<>();
    
    public static void main(String[] args) {
        
        PrintStream out = System.out;

        int EscolhaOpcao;
        do {
            // Menu de opções de 1 a 3 seguido da opção escolhida com o retonro em EscolhaOpcao = scanner.nextInt();
            out.println("-------- MENU de OPÇÕES ---------");
            out.println("|-------------------------------|");
            out.println("|----- 1. Iniciar jogo  --------|");
            out.println("|----- 2. Verificar pontuações -|");
            out.println("|----- 3. Sair do jogo ---------|");
            out.println("---------------------------------");
            out.print("Escolha uma opção de 1 até 3: ");
            EscolhaOpcao = scanner.nextInt();// Neste momento é escolhida a opção de 1 a 3
            out.print("\n");
            
            switch (EscolhaOpcao) { // Switch é uma estrutura de controle que avala um valor e execute um bloco de código com base em diferentes casos desse valor (switch = trocar), a exppressão "EscolhaOpcao" cujo valor será avaliado para determinar qual bloco de código será, case 1: até case: 3.  
                case 1:         // Caso digite 1 um jogo se iniciará.
                    novoJogo(); 
                    break;      // Após a execução do código dentro de um case vem a instrução break para sair do bloco switch, evitando erros e loops.
                case 2:         // Caso digite 2 serão verificadas as pontuações.
                    exibirPontuacoes(); 
                    break;      // Após a execução do código dentro de um case vem a instrução break para sair do bloco switch, evitando erros e loops.
                case 3:
                    out.println("Obrigado por jogar!\n"); // Caso 3, o jogo terminará e será exibida a mensagem "Obrigado por jogar!".
                    break;      // Após a execução do código dentro de um case vem a instrução break para sair do bloco switch, evitando erros e loops.
                default: out.println("Opção inválida. Escolha novamente.\n"); // Caso opcional, executado se nenhum dos valores dos case acima, corresponder ao valor de EscolhaOpcao. É uma espécie de "else" para lidar com situações não previstas.
            }
        } while (EscolhaOpcao != 3); // While (enquanto) é uma estrutura de controle de fluxo que permite repetir um bloco de código enquanto uma condição especificada for verdadeira, no caso EscolhaOpcao != 3: e verifica se EscolhaOpcao é diferente de 3.
    }
    
    private static void novoJogo() {
        PrintStream out = System.out;
        String palavra = PALAVRAS[random.nextInt(PALAVRAS.length)];
        
        int vidas = MAX_TENTATIVAS;
        
        out.println("O Jogo começou, você terá direito a " + MAX_TENTATIVAS + " tentativas."); // Aqui demonstra de forma direta a quantidade de tentativas.
        
        StringBuilder PalavraAdivinhar = new StringBuilder("_".repeat(palavra.length())); // Criada a variável "PalavraAdivinhar" usada para armazenar o objeto StringBuilder (classe que permite a criação e manipulação de strings mutáveis, maneira mais eficiente de construir strings modificáveis) criando uma string com apenas um caractere sublinhado, que será usada como ponto de partida para a construção da nova string. NO caos de repeat(palavra.length()): O método repeat é chamado na string _, sendo usado para criar uma nova string repetindo o conteúdo da string original x vezes. Nesse caso, a string _ será repetida até o tamanho da palavra.length() quantas vezes for necessária, ou seja, a linha de código cria uma nova string usando o caractere sublinhado _ repetido um número de vezes igual ao comprimento da string palavra. A nova string é então usada para inicializar um objeto StringBuilder chamado PalavraAdivinhar, que pode ser posteriormente manipulado para construir a representação desejada da palavra com sublinhados. Pode ser usado o FOR no lugar de REPEAT.
        
        // Resumo: o loop continuará a ser executado enquanto houver vidas disponíveis e enquanto ainda houver letras não adivinhadas na palavra. A cada iteração do loop, a representação da palavra, o número de vidas restantes e a solicitação para digitar uma letra serão exibidos, e o programa aguardará a entrada do usuário para adivinhar a próxima letra.
        while (vidas > 0 && PalavraAdivinhar.toString().contains("_")) { // While (enquanto) que continuará executando o bloco de código dentro das chaves enquanto duas condições  forem verdadeiras: variável vidas > 0 (ou seja, o jogador ainda tem vidas restantes) e a string resultante da chamada PalavraAdivinhar.toString() contém pelo menos um caractere de sublinhado "_" (pois haverá letras desconhecidas na palavra que o jogador precisa adivinhar).O método toString() é chamado para obter uma representação de string dessa palavra atual, e o método contains("_") verifica se a palavra contém pelo menos um caractere "_", indicando que há espaços vazios ou letras a serem adivinhadas na palavra, e enquanto houver letras não adivinhadas (indicadas pelo caractere "_"), o loop continuará a ser executado.
        out.println("Palavra: " + PalavraAdivinhar); // Imprime a representação atual da palavra, com letras adivinhadas corretamente e espaços vazios para letras não adivinhadas.
        out.println("Vidas restantes: " + vidas); // Imprime o número de vidas restantes.
        out.print("Digite uma letra: "); // Exibe uma mensagem para o usuário, para que o usuário digite uma letra. 
        char letra = scanner.next().toUpperCase().charAt(0); // Entrada do usuário usando um objeto Scanner (provavelmente já declarado em algum lugar do código) e converte a primeira letra inserida em maiúscula. Essa letra é armazenada na variável letra.
        
        // Resumo: esse trecho de código verifica se a entrada do usuário (a variável letra) não é uma letra do alfabeto e se não for, uma mensagem de erro é exibida, sendo a iteração atual do loop interrompida, dando ao usuário uma nova oportunidade de inserir uma entrada válida.
        
            if (!Character.isLetter(letra)) { // No Java, Character.isLetter() é um método estático da classe Character que verifica se um caractere dado é uma letra do alfabeto. O método retorna true se o caractere for uma letra e false caso contrário. O operador ! (negação) é usado para inverter o resultado do método, ou seja, se o método retornar true, a negação torna-se false, e vice-versa. A classe Character faz parte da biblioteca padrão do Java (java.lang.Character), que é automaticamente importada em todos os programas Java. Portanto, você não precisa fazer um import explícito para usar métodos estáticos dessa classe.

                out.println("Entrada inválida. Digite apenas letras."); // Se o caractere não for uma letra, imprime uma mensagem de erro (entrada é inválida).
                continue; // Palavra-chave continue usada para interromper a iteração atual do loop e passar para a próxima iteração, no contexto do código, se a entrada do usuário não for uma letra do alfabeto, a mensagem de erro será exibida, e o loop avançará para a próxima iteração, evitando que o restante do código dentro do loop seja executado. Isso dá ao usuário uma nova chance de fornecer uma entrada válida.
            }
            
                // Resumindo: o trecho verifica se a letra fornecida pelo usuário não está presente na palavra que está sendo adivinhada. Se a letra não estiver na palavra, o número de vidas é reduzido, indicando que o jogador errou a tentativa de adivinhar a letra.
                if (palavra.indexOf(letra) == -1) { //  O código verifica se o resultado de palavra.indexOf(letra) é igual a -1. Isso significa que o caractere letra não foi encontrado na string palavra.
                vidas--; // Se o caractere letra não estiver na palavra (ou seja, palavra.indexOf(letra) retornou -1), isso indica que a tentativa do usuário foi incorreta. Nesse caso, o número de vidas é decrementado.

                } 
                // Resumo: o bloco else (outro) é executado quando a letra fornecida pelo usuário está na palavra. Ele percorre cada posição na palavra e, se encontrar a letra correta, atualiza a representação da palavra adivinhada PalavraAdivinhar para mostrar a letra nas posições corretas. Parte de um processo de "feedback" ao jogador, informando que a adivinhação foi correta e mostrando a letra nos locais corretos na palavra.
                else { // Indica que se o caractere letra estiver presente na palavra, ou seja, a tentativa foi correta, o código nesse bloco será executado.
                    for (int i = 0; i < palavra.length(); i++) { // Loop for que percorre cada posição na string palavra para verificar se a letra está presente.
                    if (palavra.charAt(i) == letra) { // O código verifica se o caractere na posição i da string palavra é igual à letra fornecida pelo usuário.
                        PalavraAdivinhar.setCharAt(i, letra); // Se a letra estiver presente na posição i da palavra, o código atualiza a string PalavraAdivinhar (que é uma representação da palavra sendo adivinhada) substituindo o caractere vazio ou sublinhado (que indica uma letra não adivinhada) pelo caractere letra. Isso ajuda a mostrar as letras corretas adivinhadas pelo jogador.
                    }
                 }
            }
        }

        if (vidas == 0) { // // Verifica se o número de vidas chegou a zero, indicando que o jogador perdeu, se vidas se igualar a 0 (vidas == 0). 
            out.println("Você perdeu! A palavra era: " + palavra); // Exibe uma mensagem informando que o jogador perdeu, mostrando também a palavra correta.
        } else {
            String nomeJogador; // Variável para armazenar o nome do jogador.
            do { // Loop "do-while" que solicita o nome do jogador até que um nome único seja fornecido.
                out.print("Digite seu nome para salvar sua pontuação: "); // Mensagem solicitando que digite seu nome para salvar a pontuação.
                nomeJogador = scanner.next(); // Lê/recebe a entrada do jogador e armazena na variável "nomeJogador".
                if (jogadores.contains(nomeJogador)) { // Verifica se o nome do jogador já existe na lista de jogadores.
                    out.println("O nome de usuário já existe, digite outro diferente."); // Se existir, exibe mensagem "o nome de usuário já existe".
                }
            } while (jogadores.contains(nomeJogador)); // O loop continua enquanto o nome de jogador já existir, para que seja digitado um novo e o loop termine.
            salvarPontuacao(nomeJogador, vidas); // Após obter um nome que não existe, chama a função para salvar a pontuação do jogador.
        }

    }
    
    // Essa função é responsável por salvar o nome do jogador e o número de vidas associado a essa pontuação nas listas correspondentes. Ela também exibe uma mensagem para informar que a pontuação foi salva com sucesso.
    private static void salvarPontuacao(String jogador, int vidas) { // Função para salvar a pontuação do jogador.
        PrintStream out = System.out; // Criação de um objeto PrintStream para a saída padrão.
        jogadores.add(jogador); // Adiciona o nome do jogador à lista de jogadores.
        pontuacoes.add(vidas); // Adiciona o número de vidas à lista de pontuações.
        out.println("Pontuação salva com sucesso!"); // Exibe uma mensagem indicando que a pontuação foi salva com
                                                     // sucesso.
    }
    
   private static void exibirPontuacoes() {// Função para exibir as pontuações dos jogadores.
    PrintStream out = System.out; // Criação de um objeto PrintStream para a saída padrão.
    out.println("PONTUAÇÕES:"); // Exibe o cabeçalho indicando que as pontuações serão mostradas.

    
    for (int i = 0; i < jogadores.size(); i++) { // Loop que percorre as listas de jogadores e pontuações.
        out.println(jogadores.get(i) + ": " + pontuacoes.get(i) + " vidas restantes"); // Exibe o nome do jogador e sua pontuação correspondente e Utiliza os índices "i" para acessar as posições nas listas.
        }
    }
}