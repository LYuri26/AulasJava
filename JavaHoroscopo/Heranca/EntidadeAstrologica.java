package Heranca; // Este é o pacote onde a classe EntidadeAstrologica está definida

abstract class EntidadeAstrologica {
    protected String dataNascimento; // Atributo protegido, acessível pela classe e suas subclasses

    // Construtor da classe EntidadeAstrologica, recebe a data de nascimento como argumento
    public EntidadeAstrologica(String data) {
        this.dataNascimento = data;
    }

    // Método abstrato para determinar o signo, será implementado pelas subclasses
    public abstract String determinarSigno();
}

// A classe é definida como abstrata porque não faz sentido criar uma instância direta de EntidadeAstrologica,
// ela serve como uma base para outras classes que vão definir o comportamento específico.

