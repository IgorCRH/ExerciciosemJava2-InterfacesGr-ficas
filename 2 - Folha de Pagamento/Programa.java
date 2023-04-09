import javax.swing.JOptionPane;  // Importa a classe Swing para construir a interface gráfica
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Programa {
public static void main(String[] args) {
ArrayList<CEmployee> funcionarios = new ArrayList<CEmployee>(); // Vetor que vai listar os funcionários registrados
double totalfolha = 0;
ImageIcon icone = new ImageIcon("img.png");
while (true) {
Object[] options = {"Cadastrar Funcionário", "Ver Funcionários Registrados", "Sair"}; // Vetor de construir a interface do Menu Principal

int n = JOptionPane.showOptionDialog(null, // Abre a Janela e lista as opções
                    "O que deseja fazer?",
                    "Menu Principal - Sistema de Folha de Pagamento",
                    JOptionPane.YES_NO_CANCEL_OPTION, // Primeira Opção - Entrada de Dados, então YES_NO_CANCEL_OPTION
                    JOptionPane.QUESTION_MESSAGE, // Segunda Opção - Lista Funcionários. Como será apenas listar, será uma QUESTION_MESSAGE
                    icone, // Aonde fica a imagem exibida no menu
                    options, // Posições das Opções no vetor options
                    options[2]);

if (n == 0) { // Constrói a primeira opção
                String[] tipos = {"Assalariado", "Por Horas"}; // Tela de escolha do tipo de funcionário

                int tipo = JOptionPane.showOptionDialog(null,
                        "Selecione o tipo de funcionário:",
                        "Tipo de Funcionário",
                        JOptionPane.YES_NO_OPTION, // Primeira Opção
                        JOptionPane.QUESTION_MESSAGE, // Segunda Opção
                        icone, // Aonde fica a imagem exibida no canto esquerdo
                        tipos, // Posições das Opções no Vetor
                        tipos[1]);

                String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionário:"); // Área de leitura do nome

                if (tipo == 0) { // Se o tipo for a primeira opção, assalariado:
                double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o salário do funcionário:")); // Leitura do salário

                    Salaried funcionario = new Salaried(nome, salario); // Cria objeto funcionario da classe Salaried
                    funcionarios.add(funcionario); // Cria novo elemento Salaried na lista(vetor) de funcionários.

                    JOptionPane.showMessageDialog(null, "Funcionário registrado com sucesso!");
                } else { // Se o tipo for a segunda opção, por horas:
                    // Leitura do valor da hora e da quantidade de horas trabalhadas
                    double valorHora = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor da hora do funcionário:"));
                    double horasTrabalhadas = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o número de horas trabalhadas do funcionário:"));

                    Hourly funcionario = new Hourly(nome, valorHora, horasTrabalhadas); // Cria objeto funcionario da classe Hourly
                    funcionarios.add(funcionario); // Cria novo elemento Hourly na lista(vetor) de funcionários.

                    JOptionPane.showMessageDialog(null, "Funcionário registrado com sucesso!");
                }
            } else if (n == 1) { // Constrói a segunda opção, listar os funcionários
                if (funcionarios.isEmpty()) { // Caso nenhum funcionário estiver cadastrado
                    JOptionPane.showMessageDialog(null, "Nenhum funcionário registrado");
                } else {
                    String listaFuncionarios = "";
                    for (CEmployee f : funcionarios) {
                        listaFuncionarios += f.getInfo() + "\n\n"; // Monta e aumenta a string de acordo com a quantidade de informações de funcionários cadastrados
                        totalfolha += f.getPay(); // Calcula o total da folha pelo GetPay
                    }

                    JOptionPane.showMessageDialog(null, listaFuncionarios + "Total da folha de pagamento: " + totalfolha);
                }
            } else { // A terceira opção, sair do programa
                break;
            }
        }
    }
}
