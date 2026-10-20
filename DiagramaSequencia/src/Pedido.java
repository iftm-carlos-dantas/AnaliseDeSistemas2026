import java.util.List;

public class Pedido {

    private Cliente cliente;

    private List<LinhaDePedido> linhasDePedido;

    public Double calcularPreco() {
        Double precoTotal = 0.0;
        for (LinhaDePedido linha: linhasDePedido) {
            Integer quantidade = linha.obterQuantidade();
            Produto produto = linha.obterProduto();
            Double preco = produto.obterDetalhesDoPreco();
            precoTotal += calcularPrecoBase(preco, quantidade);
        }
        precoTotal = calcularDescontos(precoTotal);
        return precoTotal;
    }

    private Double calcularPrecoBase(Double preco, Integer quantidade) {
        return preco * quantidade;
    }

    private Double calcularDescontos(Double precoTotal) {
        Double informacaoDesconto = cliente.obterInformacaoDesconto();
        return precoTotal - (precoTotal * (informacaoDesconto / 100));
    }


}