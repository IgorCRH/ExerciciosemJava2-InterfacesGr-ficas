import javax.swing.JOptionPane;
import java.util.ArrayList;
public class Programa {
    public static void main(String[] args) {

        ArrayList<CVeiculos> veiculos = new ArrayList<CVeiculos>();
        String resp = "S";
        double totalprecos = 0;
        while(resp.equals("S")) {
            String tipo = JOptionPane.showInputDialog("Qual o tipo de veículo? Moto ou Carro?");
            String nome = JOptionPane.showInputDialog("Entre com o nome do veículo:");
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do Veículo:"));
            double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do Veículo:"));

            if(tipo.equals("Moto") || tipo.equals("moto")) {
                int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano da Moto:"));
                double precoAnterior = preco;
                if (ano > 2008){
                preco *= 1.1;
                JOptionPane.showMessageDialog(null, String.format("O Preco anterior era de: %.2f\n", precoAnterior));
                JOptionPane.showMessageDialog(null, String.format("O Preco atualizado é de: %.2f\n", preco));
                }
                veiculos.add(new Moto(nome, codigo, preco, ano));
            } else if(tipo.equals("Carro") || tipo.equals("carro")) {
                double km = Double.parseDouble(JOptionPane.showInputDialog("Quilometragem do Carro:"));
                double precoAnterior = preco;
                if (km > 100000){
                preco *= 0.92;
                JOptionPane.showMessageDialog(null, String.format("O Preco anterior era de: %.2f\n", precoAnterior));
                JOptionPane.showMessageDialog(null, String.format("O Preco atualizado é de: %.2f\n", preco));
                }
                veiculos.add(new Carro(nome, codigo, preco, km));
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de Veículo Inválido.");
            }
            totalprecos += preco;
            resp = JOptionPane.showInputDialog("Deseja inserir outro veículo? (S/N)").toUpperCase();
        }
       
        StringBuilder dados = new StringBuilder();
        for(CVeiculos veiculo : veiculos) {
            dados.append(veiculo.getInfo());
            dados.append("\n");
        }
        dados.append("Total de Preço dos Veículos: R$ " +totalprecos);

        JOptionPane.showMessageDialog(null, dados.toString());
    }
}
