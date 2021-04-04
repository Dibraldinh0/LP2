Suponha a seguinte classe escrita em Java:

```

public abstract class OperacaoMatematica {
    public abstract double calcular(double x, double y);
}

```

Esta é uma classe abstrata que representa qualquer operação matemática. Podemos imaginar diversas operações que se encaixam na sua interface como soma, subtração, multiplicação ou divisão, entre outras. Note que, mesmo que a natureza do cálculo mude, a semântica do método calcular não muda, ou seja, ele sempre calculará o resultado da operação matemática que está sendo trabalhada.

Agora vamos definir, duas subclasses, Soma e Subtracao, que extendem a classe OperacaoMatematica:

```
public class Soma extends OperacaoMatematica {
    public double calcular(double x, double y) {
        return x + y;
    }
}

public class Subtracao extends OperacaoMatematica {
    public double calcular(double x, double y) {
        return x - y;
    }
}

```

O seguinte trecho de código demonstra o uso do polimorfismo:

```

public class Contas {
    public static void mostrarCalculo(OperacaoMatematica operacao, double x, double y) {
        System.out.println("O resultado é: " + operacao.calcular(x, y));
    }

    public static void main(String args[]) {
        // Primeiro calculamos uma soma
        Contas.mostrarCalculo(new Soma(), 5, 5); // Imprime o resultado é: 10

        // Depois uma subtração
        Contas.mostrarCalculo(new Subtracao(), 5, 5); // Imprime o resultado é: 0
    }
}

```

Embora o método calcular tenha sido chamado duas vezes no interior de mostrarCalculo, os tipos utilizados como parâmetros eram diferentes. De fato, o comportamento de cada tipo era exatamente oposto.
