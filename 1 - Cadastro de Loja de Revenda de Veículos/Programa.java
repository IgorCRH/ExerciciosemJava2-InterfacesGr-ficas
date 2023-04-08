import javax.swing.JOptionPane; // Importa a classe Swing para construir a interface gráfica
import java.util.ArrayList;
public class Programa {
    public static void main(String[] args) {

        ArrayList<CVeiculos> veiculos = new ArrayList<CVeiculos>(); // Vetor que vai listar os veículos registrados
        String resp = "S"; // De forma semelhante ao programa anterior em versão console, registra enquanto a condição for atendida.
        double totalprecos = 0;
        while(resp.equals("S")) {
            String tipo = JOptionPane.showInputDialog("Qual o tipo de veículo? Moto ou Carro?"); // Entrada e leitura dos dados
            String nome = JOptionPane.showInputDialog("Entre com o nome do veículo:");
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do Veículo:"));
            double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do Veículo:"));

            if(tipo.equals("Moto") || tipo.equals("moto")) {
                int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano da Moto:"));
                double precoAnterior = preco;
                if (ano > 2008){ // IF de reajuste do valor da moto, caso a condição do ano seja atendida
                preco *= 1.1;
                JOptionPane.showMessageDialog(null, String.format("O Preco anterior era de: %.2f\n", precoAnterior));
                JOptionPane.showMessageDialog(null, String.format("O Preco atualizado é de: %.2f\n", preco));
                }
                veiculos.add(new Moto(nome, codigo, preco, ano)); // Cria novo elemento moto na lista(vetor) de veículos, com o preço já atualizado.
            } else if(tipo.equals("Carro") || tipo.equals("carro")) {
                double km = Double.parseDouble(JOptionPane.showInputDialog("Quilometragem do Carro:"));
                double precoAnterior = preco;
                if (km > 100000){ // IF de reajuste do valor do carro, caso a condição da quilometragem seja atendida
                preco *= 0.92;
                JOptionPane.showMessageDialog(null, String.format("O Preco anterior era de: %.2f\n", precoAnterior));
                JOptionPane.showMessageDialog(null, String.format("O Preco atualizado é de: %.2f\n", preco));
                }
                veiculos.add(new Carro(nome, codigo, preco, km)); // Cria novo elemento carro na lista(vetor) de veículos, com o preço já atualizado.
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de Veículo Inválido.");
            }
            totalprecos += preco; // Atualiza o preço total dos veículos em geral conforme novos veículos forem sendo registrados.
            resp = JOptionPane.showInputDialog("Deseja inserir outro veículo? (S/N)").toUpperCase();
        }
       
        StringBuilder dados = new StringBuilder(); // Construtor para listar as informações de todos os veiculos
        for(CVeiculos veiculo : veiculos) { // Ele vai imprimir as informações até a quantidade total de veículos registrados
            dados.append(veiculo.getInfo());
            dados.append("\n");
        }
        dados.append("Total de Preço dos Veículos: R$ " +totalprecos); // Exibe total de preços

        JOptionPane.showMessageDialog(null, dados.toString());
    }
}
