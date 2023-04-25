import javax.swing.JOptionPane;  // Importa a classe Swing para construir a interface gráfica
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.io.BufferedWriter; // Importa as classes de arquivo, de leitura e escrita
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException; // Importa a classe do tratamento de exceção

public class Programa {
private static final String FILE_NAME = "folhapagamento.txt"; // Declara a variável FILE_NAME    
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
                File entrada = new File("folhapagamento.txt");

                int tipo = JOptionPane.showOptionDialog(null,
                        "Selecione o tipo de funcionário:",
                        "Tipo de Funcionário",
                        JOptionPane.YES_NO_OPTION, // Primeira Opção
                        JOptionPane.QUESTION_MESSAGE, // Segunda Opção
                        icone, // Aonde fica a imagem exibida no canto esquerdo
                        tipos, // Posições das Opções no Vetor
                        tipos[1]);

                String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionário:"); // Área de leitura do nome
                String escreve;

if (tipo == 0) { // Se o tipo for a primeira opção, assalariado:
double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o salário do funcionário:")); // Leitura do salário
Salaried funcionario = new Salaried(nome, salario); // Cria objeto funcionario da classe Salaried
funcionarios.add(funcionario); // Cria novo elemento Salaried na lista(vetor) de funcionários.
try {
FileWriter escritor = new FileWriter(entrada, true);
BufferedWriter bufferescritor = new BufferedWriter(escritor);    
escreve = String.format("%s;%.2f", nome, salario);
bufferescritor.write(escreve);
bufferescritor.newLine();
bufferescritor.close();
escritor.close();
} catch (IOException e) { // Tratamento de exceção para superar o erro IOException
e.printStackTrace();
}
JOptionPane.showMessageDialog(null, "Funcionário registrado com sucesso!");
} else { // Se o tipo for a segunda opção, por horas:
// Leitura do valor da hora e da quantidade de horas trabalhadas
double valorHora = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor da hora do funcionário:"));
double horasTrabalhadas = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o número de horas trabalhadas do funcionário:"));

Hourly funcionario = new Hourly(nome, valorHora, horasTrabalhadas); // Cria objeto funcionario da classe Hourly
funcionarios.add(funcionario); // Cria novo elemento Hourly na lista(vetor) de funcionários.                    
try {
FileWriter escritor = new FileWriter(entrada, true); // Cria os objetos para escrita das informações no arquivo de texto
BufferedWriter bufferescritor = new BufferedWriter(escritor);    
escreve = String.format("%s;%f;%f;%.2f", nome, valorHora, horasTrabalhadas,funcionario.getPay()); // String pra reunir as informações
bufferescritor.write(escreve); // Escreve a string com as informações no arquivo
bufferescritor.newLine();
bufferescritor.close(); // Fecha os objetos FileWriter e BufferedWriter
escritor.close();
} catch (IOException e) { // Tratamento de exceção para superar o erro IOException
e.printStackTrace();
}
JOptionPane.showMessageDialog(null, "Funcionário registrado com sucesso!");
}
} else if (n == 1) { // Constrói a segunda opção, listar os funcionários
try {    
BufferedReader leitor = new BufferedReader(new FileReader("folhapagamento.txt")); // Cria objeto para leitura
String leitura = leitor.readLine(); // String leitura reune a leitura do conteúdo do arquivo
while (leitura != null) { // Enquanto a string não estiver vazia
JOptionPane.showMessageDialog(null, leitura); // Imprime a string da leitura do arquivo em uma janela JOption
leitura = leitor.readLine(); // Ler todo o resto do conteúdo até o final
}
leitor.close(); // Fecha o objeto para leitura no arquivo
} catch (IOException e) {
e.printStackTrace();
}
} else { // A terceira opção, sair do programa
break;
}
}
}
}
