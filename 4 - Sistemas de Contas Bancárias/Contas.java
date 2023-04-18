// Importa as classes
import javax.swing.JFrame; // Classe de criação da janela
import javax.swing.JLabel; // Classe de criação dos títulos em texto
import javax.swing.JTextField; // Classe de criação dos campos de texto
import javax.swing.JButton; // Classe de criação do botões da janela
import javax.swing.JPanel; // Classe da criação da janela painel JPanel
import javax.swing.JOptionPane; // Classe de criação das mensagens da janela
import java.awt.event.ActionListener; // Classes de criação de ações
import java.awt.event.ActionEvent; // Classe de criação dos eventos
import java.util.ArrayList; // Classe do ArrayList
import javax.swing.ImageIcon; // Classe do Ícone da janela painel/JOptionPane
import javax.swing.JDialog; // Classe do Ícone da janela JDialog

public class Contas
{   
public static void main(String[] args) {
ArrayList<ContaBancaria> clientes = new ArrayList<>(); // Vetor que guarda os clientes registrados
ImageIcon icone = new ImageIcon(); // Declara objeto da classe ImageIcon que fará parte da janela JOptionPane de opções, neste caso não tem nenhum icone
  
while (true) { // Lista as opções existentes em um vetor chamado options
Object[] options = {"Cadastrar Cliente", "Depositar", "Sacar","Ver Clientes Cadastrados","Pesquisar Cliente", "Exibir Saldo a partir de rendimento", "Sair"}; // Vetor de construir a interface do Menu Principal
// Variável n determina o valor de cada opção existente acima no vetor options
int n = JOptionPane.showOptionDialog(null, // Abre a Janela e lista as opções
                    "O que deseja fazer?",
                    "Menu Principal - Contas de Banco",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    icone,
                    options, // Posições das Opções no vetor options
                    options[6]); // Quantidade de opções

if (n == 0) { // Constrói a primeira opção, isto é, n tem valor 0
Object[] tipos = {"Conta Poupanca", "Conta Especial"}; // Tela de escolha do tipo de conta, lista as opções existentes em um vetor chamado tipos
// Variável tipo determina o valor de cada opção existente acima no vetor tipos
int tipo = JOptionPane.showOptionDialog(null,
"Selecione o tipo de conta:",
"Tipo de Conta",
JOptionPane.YES_NO_OPTION,
JOptionPane.QUESTION_MESSAGE,
icone, // Aonde fica a imagem exibida no canto esquerdo
tipos, // Posições das Opções no Vetor
tipos[1]); // Quantidade de contas, no caso 2, pos 0 e 1

JDialog telacadastro = new JDialog(); // Cria a janela da classe JDialog
telacadastro.setTitle("Cadastro dos Clientes"); // Seta o título da janela JDialog
telacadastro.setSize(600, 400); // Delimita tamanho da janela
telacadastro.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Seta a operação da janela JDialog para desaparecer ao clicar em X
telacadastro.setLayout(null); // Delimita null no layout para poder delimitar a posição e tamanho dos componentes da janela
telacadastro.setModal(true); // Delimita a maneira de exibição da janela para modal, para aparecer após chamada ou clique de botões.

JLabel label = new JLabel("Nome do Cliente:"); // Cria o campo do título 'nome do cliente'
// Delimita o tamanho e forma como título ou rótulo (label)
label.setBounds(20, 20, 120, 25); // 1º - Coord. Horizontal (x), 2º - Coord.Vertical (y),3º - Largura, 4º - Altura 
telacadastro.add(label); // Adiciona o título em texto de nome do cliente a tela de cadastro

JTextField cliente2 = new JTextField(50); // Cria o campo de texto para a entrada do nome do cliente
cliente2.setBounds(140, 20, 165, 25);  // Define a posição e o tamanho do label
telacadastro.add(cliente2); // Adiciona o campo de texto para nome do cliente a janela telacadastro

JLabel labelnumconta = new JLabel("Número da Conta:");  // Cria o campo do título 'Numero da Conta'
labelnumconta.setBounds(20, 60, 120, 25);
telacadastro.add(labelnumconta); // Adiciona o label "Número da Conta" na tela de cadastro

JTextField numconta2 = new JTextField(50); // Cria o campo de texto para a entrada do número da conta
numconta2.setBounds(140, 60, 165, 25); 
telacadastro.add(numconta2); // Adiciona o campo de texto para numconta a janela telacadastro

JLabel labelsaldo = new JLabel("Saldo:"); // Cria o campo do título para Saldo
labelsaldo.setBounds(20, 100, 120, 25); 
telacadastro.add(labelsaldo); // Adiciona o label "Saldo" na tela de cadastro
            
JTextField saldo2 = new JTextField(50); // Cria o campo de texto para a entrada do saldo
saldo2.setBounds(140, 100, 165, 25);
telacadastro.add(saldo2); // Adiciona o campo de texto para saldo a janela telacadastro

JButton cadastrar = new JButton("Cadastrar"); // Cria o botão Cadastrar
cadastrar.setBounds(140, 140, 165, 25); // Delimita o tamanho e forma como botão
telacadastro.add(cadastrar); // Adiciona o botão cadastro na janela telacadastro 
if (tipo == 0){ // Se a escolha for por cadastrar uma conta poupança
cadastrar.addActionListener(new ActionListener() { // Cria ação pro botão cadastrar
public void actionPerformed(ActionEvent e) { // Evento da ação ActionListener
String cliente = cliente2.getText(); // Declara as variáveis para a ação do botão baseado no valor extraído dos campos de texto
int numconta = Integer.parseInt(numconta2.getText());
float saldo = Float.parseFloat(saldo2.getText());
ContaPoupanca novocpoup = new ContaPoupanca(cliente,numconta,saldo); // Cria objeto instanciado da classe ContaPoupanca
clientes.add(novocpoup); // Adiciona cliente ao vetor ArrayList que registra clientes por meio do objeto novocpoup criado

JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
telacadastro.dispose(); // Fecha a tela de cadastro
cliente2.setText(""); // Limpa os campos de texto após o cadastro de um cliente
numconta2.setText("");
saldo2.setText("");
}
});
telacadastro.setVisible(true); // Exibe a janela telacadastro
} else if (tipo == 1){ // Se a escolha for por cadastrar uma conta especial
JLabel labellimite = new JLabel("Limite:"); // Cria o título em texto para limite
labellimite.setBounds(20, 140, 120, 25);
telacadastro.add(labellimite); // Adiciona o label "limite" na tela de cadastro caso o cadastro seja de uma conta especial

JTextField limite2 = new JTextField(50); // Cria o campo de texto para o limite
limite2.setBounds(140, 120, 165, 25); 
telacadastro.add(limite2); // Adiciona o campo de texto para a entrada do limite na tela de cadastro caso o cadastro seja de uma conta especial    
cadastrar.addActionListener(new ActionListener() { // Cria ação pro botão cadastrar
public void actionPerformed(ActionEvent e) { // Evento da ação ActionListener
String cliente = cliente2.getText(); // Declara as variáveis para a ação do botão baseado no valor extraído dos campos de texto
int numconta = Integer.parseInt(numconta2.getText());
float saldo = Float.parseFloat(saldo2.getText());
float limite = Float.parseFloat(limite2.getText());
ContaEspecial novocesp = new ContaEspecial(cliente,numconta,saldo,limite); // Cria objeto instanciado da classe ContaEspecial
clientes.add(novocesp); // Adiciona cliente ao vetor ArrayList que registra clientes por meio do objeto novocesp criado
JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
telacadastro.dispose(); // Fecha a tela de cadastro

cliente2.setText(""); // Limpa os campos de texto após o cadastro de um cliente
numconta2.setText("");
saldo2.setText("");
limite2.setText("");
}
});
telacadastro.setVisible(true);
}
} else if (n == 1){ // Opção Depositar  
Object[] escolhas = {"Conta Poupanca", "Conta Especial"}; // Guarda as escolhas possíveis pros tipos de contas em um vetor chamado escolhas
// Variável escolha determina o valor de cada opção existente acima no vetor escolhas
int escolha = JOptionPane.showOptionDialog(null,
"Selecione o tipo de conta:",
"Tipo de Conta",
JOptionPane.YES_NO_OPTION,
JOptionPane.QUESTION_MESSAGE,
icone,
escolhas,
escolhas[1]);

if (escolha == 0){    
for (ContaBancaria cliente : clientes) { // Percorre todo o vetor ArrayLista pesquisando os clientesregistrados
if (cliente instanceof ContaPoupanca) { // instanceof é usado para determinar se o cliente é de uma contapoupanca, ou seja se a variável cliente é da classe ContaPoupanca
ContaPoupanca poupanca = (ContaPoupanca) cliente; // Cria objeto instanciado da classe ContaPoupanca
poupanca.depositar(); // Chama o método
break;
} 
}
}
if (escolha == 1){
for (ContaBancaria cliente : clientes) { // Mesma logica acima, só que para o método do depósito da conta especial
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
if (clientes.isEmpty()) { // Caso nenhum funcionário estiver cadastrado
JOptionPane.showMessageDialog(null, "Nenhum cliente registrado");
} else {
String listaClientes = ""; // Cria a string
for (ContaBancaria c : clientes) { // Percorre o vetor de clientes
listaClientes += "Nome: " +c.getCliente() + "\n" + "Número da Conta:" + c.getNumConta() + "\n" + "Saldo:" + c.getSaldo() + "\n\n"; // Incrementa a string com as informações a serem exibidas
}
JOptionPane.showMessageDialog(null, listaClientes); // Imprime a string
}
} else if (n == 4){
String nomepesq = JOptionPane.showInputDialog(null, "Digite o nome do cliente que quer pesquisar:"); 
String listaClientes = "";
for (ContaBancaria c : clientes) {
if (nomepesq.equals(c.getCliente())){    
listaClientes += "Nome: " +c.getCliente() + "\n" + "Número da Conta:" + c.getNumConta() + "\n" + "Saldo:" + c.getSaldo() + "\n\n";
} else if (!nomepesq.equals(c.getCliente())){
JOptionPane.showMessageDialog(null, "Conta não encontrada!");
}
}
JOptionPane.showMessageDialog(null, listaClientes);
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
