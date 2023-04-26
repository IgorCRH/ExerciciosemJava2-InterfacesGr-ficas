// Importa as classes
import javax.swing.JFrame; // Classe de criação da janela
import javax.swing.JLabel; // 
import javax.swing.JTextField; // Classe de criação dos campos de texto
import javax.swing.JButton; // Classe de criação do botões da janela
import javax.swing.JPanel; // C
import javax.swing.JOptionPane; // Classe de criação das mensagens da janela
import java.awt.event.ActionListener; // Classes de criação de ações
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.io.BufferedWriter; // Importa as classes de arquivo, de leitura e escrita
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException; // Importa a classe do tratamento de exceção

public class Contas
{
private static final String FILE_NAME = "contas.txt";
private static String clienteaux= " ";
private static int numcontaaux = 0;
private static float saldoaux = 0, limiteaux = 0;
private static ContaPoupanca cp = new ContaPoupanca(clienteaux,numcontaaux,saldoaux);
private static ContaEspecial ce = new ContaEspecial(clienteaux,numcontaaux,saldoaux,limiteaux);    
public static void main(String[] args) {
ArrayList<ContaBancaria> clientes = new ArrayList<>();   
ImageIcon icone = new ImageIcon();
  
while (true) {
Object[] options = {"Cadastrar Cliente", "Depositar", "Sacar","Ver Clientes Cadastrados","Pesquisar Cliente", "Exibir Saldo a partir de rendimento", "Sair"}; // Vetor de construir a interface do Menu Principal

int n = JOptionPane.showOptionDialog(null, // Abre a Janela e lista as opções
                    "O que deseja fazer?",
                    "Menu Principal - Contas de Banco",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    icone,
                    options, // Posições das Opções no vetor options
                    options[6]); // Quantidade de opções sem contar a "Sair"

File entrada = new File("contas.txt");
if (n == 0) { // Constrói a primeira opção
Object[] tipos = {"Conta Poupanca", "Conta Especial"}; // Tela de escolha do tipo de funcionário

int tipo = JOptionPane.showOptionDialog(null,
"Selecione o tipo de conta:",
"Tipo de Conta",
JOptionPane.YES_NO_OPTION,
JOptionPane.QUESTION_MESSAGE,
icone, // Aonde fica a imagem exibida no canto esquerdo
tipos, // Posições das Opções no Vetor
tipos[1]);

JDialog telacadastro = new JDialog(); // Cria a janela da classe JDialog
telacadastro.setTitle("Cadastro dos Clientes");
telacadastro.setSize(600, 400); // Delimita tamanho da janela
telacadastro.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
telacadastro.setLayout(null); // Delimita null no layout para poder delimitar a posição e tamanho dos componentes da janela
telacadastro.setModal(true);

JLabel label = new JLabel("Nome do Cliente:"); // Cria o campo do título 'nome do cliente'
// Delimita o tamanho e forma como título ou rótulo (label)
label.setBounds(20, 20, 120, 25); // 1º - Coord. Horizontal (x), 2º - Coord.Vertical (y),3º - Largura, 4º - Altura 
telacadastro.add(label);

JTextField cliente2 = new JTextField(50);
cliente2.setBounds(140, 20, 165, 25);  // Define a posição e o tamanho do label
telacadastro.add(cliente2); // Adiciona o campo de texto para nome do cliente a janela telacadastro

JLabel labelnumconta = new JLabel("Número da Conta:");
labelnumconta.setBounds(20, 60, 120, 25);
telacadastro.add(labelnumconta); // Adiciona o label "Número da Conta" na tela de cadastro

JTextField numconta2 = new JTextField(50);
numconta2.setBounds(140, 60, 165, 25); // Delimita o tamanho e forma como campo, no caso, de texto
telacadastro.add(numconta2); // Adiciona o campo de texto para numconta a janela telacadastro

JLabel labelsaldo = new JLabel("Saldo:");
labelsaldo.setBounds(20, 100, 120, 25); // Define a posição e o tamanho do label "Saldo"
telacadastro.add(labelsaldo); // Adiciona o label "Saldo" na tela de cadastro
            
JTextField saldo2 = new JTextField(50);
saldo2.setBounds(140, 100, 165, 25);
telacadastro.add(saldo2); // Adiciona o campo de texto para saldo a janela telacadastro

JButton cadastrar = new JButton("Cadastrar"); // Cria o botão Cadastrar
cadastrar.setBounds(140, 140, 165, 25); // Delimita o tamanho e forma como botão
telacadastro.add(cadastrar); // Adiciona o botão cadastro na janela telacadastro 
if (tipo == 0){   
cadastrar.addActionListener(new ActionListener() { // Cria ação pro botão cadastrar
public void actionPerformed(ActionEvent e) { // Evento da ação ActionListener
String cliente = cliente2.getText();
int numconta = Integer.parseInt(numconta2.getText());
float saldo = Float.parseFloat(saldo2.getText());
ContaPoupanca novocpoup = new ContaPoupanca(cliente,numconta,saldo);
clientes.add(novocpoup);

JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
telacadastro.dispose();
cliente2.setText("");
numconta2.setText("");
saldo2.setText("");
try {
FileWriter escritor = new FileWriter(entrada, true);
BufferedWriter bufferescritor = new BufferedWriter(escritor);  
String escreve;
escreve = String.format("%s;%d;%f",cliente,numconta,saldo);
bufferescritor.write(escreve);
bufferescritor.newLine();
bufferescritor.close();
escritor.close();    
} catch (IOException f) { // Tratamento de exceção para superar o erro IOException
f.printStackTrace();
}
}
});
telacadastro.setVisible(true);
} else if (tipo == 1){
JLabel labellimite = new JLabel("Limite:");
labellimite.setBounds(20, 140, 120, 25);
telacadastro.add(labellimite); // Adiciona o label "Número da Conta" na tela de cadastro

JTextField limite2 = new JTextField(50);
limite2.setBounds(140, 120, 165, 25); // Delimita o tamanho e forma como campo, no caso, de texto
telacadastro.add(limite2);    
cadastrar.addActionListener(new ActionListener() { // Cria ação pro botão cadastrar
public void actionPerformed(ActionEvent e) { // Evento da ação ActionListener
String cliente = cliente2.getText();
int numconta = Integer.parseInt(numconta2.getText());
float saldo = Float.parseFloat(saldo2.getText());
float limite = Float.parseFloat(limite2.getText());
ContaEspecial novocesp = new ContaEspecial(cliente,numconta,saldo,limite);
clientes.add(novocesp);
JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
telacadastro.dispose();

cliente2.setText("");
numconta2.setText("");
saldo2.setText("");
limite2.setText("");
try {
FileWriter escritor = new FileWriter(entrada, true);
BufferedWriter bufferescritor = new BufferedWriter(escritor);  
String escreve;
escreve = String.format("%s;%d;%f;%f",cliente,numconta,saldo,limite);
bufferescritor.write(escreve);
bufferescritor.newLine();
bufferescritor.close();
escritor.close();    
} catch (IOException f) { // Tratamento de exceção para superar o erro IOException
f.printStackTrace();
}
}
});
telacadastro.setVisible(true);
}
} else if (n == 1){   
Object[] escolhas = {"Conta Poupanca", "Conta Especial"};

int escolha = JOptionPane.showOptionDialog(null,
"Selecione o tipo de conta:",
"Tipo de Conta",
JOptionPane.YES_NO_OPTION,
JOptionPane.QUESTION_MESSAGE,
icone,
escolhas,
escolhas[1]);

if (escolha == 0){    
for (ContaBancaria cliente : clientes) {
if (cliente instanceof ContaPoupanca) {
ContaPoupanca poupanca = (ContaPoupanca) cliente;
poupanca.depositar();
break;
} 
}
}
if (escolha == 1){
for (ContaBancaria cliente : clientes) {
if (cliente instanceof ContaEspecial) {
ContaEspecial esp = (ContaEspecial) cliente;
esp.depositar();
break;
} 
}
} 
} else if (n == 2){
String[] escolhas = {"Conta Poupanca", "Conta Especial"};

int escolha = JOptionPane.showOptionDialog(null,
"Selecione o tipo de conta:",
"Tipo de Conta",
JOptionPane.YES_NO_OPTION,
JOptionPane.QUESTION_MESSAGE,
icone,
escolhas,
escolhas[1]);

ContaBancaria conta;
if (escolha == 0){    
for (ContaBancaria cliente : clientes) {
if (cliente instanceof ContaPoupanca) {
ContaPoupanca poupanca = (ContaPoupanca) cliente;
poupanca.sacar();
break;
} 
}
}
if (escolha == 1){
for (ContaBancaria cliente : clientes) {
if (cliente instanceof ContaEspecial) {
ContaEspecial esp = (ContaEspecial) cliente;
esp.sacaresp();
break;
} 
}
} 
} else if (n == 3){
try {    
BufferedReader leitor = new BufferedReader(new FileReader("contas.txt")); // Cria objeto para leitura
String leitura = leitor.readLine(); // String leitura reune a leitura do conteúdo do arquivo
while (leitura != null) { // Enquanto a string não estiver vazia
JOptionPane.showMessageDialog(null, leitura); // Imprime a string da leitura do arquivo em uma janela JOption
leitura = leitor.readLine(); // Ler todo o resto do conteúdo até o final
}
leitor.close(); // Fecha o objeto para leitura no arquivo
} catch (IOException e) {
e.printStackTrace();
}
} else if (n == 4){
String nomepesq = JOptionPane.showInputDialog(null, "Digite o nome do cliente que quer pesquisar:"); 
try {
FileReader fr = new FileReader(FILE_NAME);
BufferedReader br = new BufferedReader(fr);
String leitura;
while ((leitura = br.readLine()) != null) {
String[] data = leitura.split(";");
if (data[0].equals(nomepesq)) {
JOptionPane.showMessageDialog(null, leitura);
}
} 
} catch (IOException e) {
e.printStackTrace();
}
} else if (n == 5){
for (ContaBancaria cliente : clientes) {
if (cliente instanceof ContaPoupanca) {
ContaPoupanca poupanca = (ContaPoupanca) cliente;
poupanca.novosaldo();
break;
}
}
} else {
break;
}   
}
}
}