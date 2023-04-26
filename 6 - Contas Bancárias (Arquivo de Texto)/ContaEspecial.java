// Importa as classes
import javax.swing.JFrame; // Classe de criação da janela
import javax.swing.JLabel; // 
import javax.swing.JTextField; // Classe de criação dos campos de texto
import javax.swing.JButton; // Classe de criação do botões da janela
import javax.swing.JPanel; 
import javax.swing.JOptionPane; // Classe de criação das mensagens da janela
import java.awt.event.ActionListener; // Classes de criação de ações
import java.awt.event.ActionEvent; // Classe de criação dos eventos das ações
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.util.Scanner; // Classe de criação das janelas JDialog
import java.io.BufferedWriter; // Importa as classes de arquivo, de leitura e escrita
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException; // Importa a classe do tratamento de exceção

public class ContaEspecial extends ContaBancaria
{
protected float limite; // Variável exclusiva da classe
private static final String FILE_NAME = "contas.txt";

// Construtor da Classe
public ContaEspecial (String cliente, int numconta, float saldo, float limite){
super(cliente,numconta,saldo);
this.limite = limite;
}

public float GetLimite (float limite){
return limite;
}

// Método do saque da conta especial
public void sacaresp() {
  JDialog telaSaque = new JDialog();
  telaSaque.setTitle("Saque");
  telaSaque.setSize(400, 300);
  telaSaque.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
  telaSaque.setLayout(null);
  telaSaque.setModal(true);

  JLabel labelQuantia = new JLabel("Quantia a sacar:");
  labelQuantia.setBounds(20, 20, 120, 25);
  telaSaque.add(labelQuantia);

  JTextField quantia2 = new JTextField(50);
  quantia2.setBounds(140, 20, 165, 25);
  telaSaque.add(quantia2);

  JLabel labelNumConta = new JLabel("Número da conta:");
  labelNumConta.setBounds(20, 50, 120, 25);
  telaSaque.add(labelNumConta);

  JTextField numConta = new JTextField(50);
  numConta.setBounds(140, 50, 165, 25);
  telaSaque.add(numConta);

  JButton sacar = new JButton("Sacar");
  sacar.setBounds(140, 80, 85, 25);
  telaSaque.add(sacar);

  sacar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      String numContaStr = numConta.getText();
      if (numContaStr.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Número da conta inválido");
      } else {
        int numConta = Integer.parseInt(numContaStr);
try {
float quantia = Float.parseFloat(quantia2.getText());            
FileReader fr = new FileReader(FILE_NAME);
BufferedReader br = new BufferedReader(fr);
FileWriter escritor = new FileWriter(FILE_NAME, true);
BufferedWriter bufferescritor = new BufferedWriter(escritor);
String leitura;
String escreve;
while ((leitura = br.readLine()) != null) {
String [] data = leitura.split(";");    
if (Integer.parseInt(data[1]) == numConta && saldo + limite > quantia) {
saldo-=quantia;
escreve = String.format("%s;%d;%f",cliente,numconta,saldo);
bufferescritor.write(escreve);
bufferescritor.newLine();
bufferescritor.close();
escritor.close();
} else if (saldo + limite < quantia){
 JOptionPane.showMessageDialog(null, "Você não tem saldo e limite suficiente.");
}
}
} catch (IOException f) {
f.printStackTrace();
}
}
}
});

  telaSaque.setVisible(true);
}


public void depositar (){
  JDialog telaDeposito = new JDialog(); // Assim como no método acima, a lógica para a janela JDialog Depósito é a mesma
  telaDeposito.setTitle("Depósito");
  telaDeposito.setSize(400, 300);
  telaDeposito.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
  telaDeposito.setLayout(null);
  telaDeposito.setModal(true);

  JLabel labelQuantia = new JLabel("Quantia a depositar:");
  labelQuantia.setBounds(20, 20, 120, 25);
  telaDeposito.add(labelQuantia);

  JTextField quantia2 = new JTextField(50);
  quantia2.setBounds(140, 20, 165, 25);
  telaDeposito.add(quantia2);

  JLabel labelNumConta = new JLabel("Número da conta:");
  labelNumConta.setBounds(20, 50, 120, 25);
  telaDeposito.add(labelNumConta);

  JTextField numConta = new JTextField(50);
  numConta.setBounds(140, 50, 165, 25);
  telaDeposito.add(numConta);

  JButton depositar = new JButton("Depositar");
  depositar.setBounds(140, 80, 85, 25);
  telaDeposito.add(depositar);

  depositar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String numContaStr = numConta.getText();
if (numContaStr.isEmpty()) {
JOptionPane.showMessageDialog(null, "Número da conta inválido");
} else {
int numConta = Integer.parseInt(numContaStr);
try {
float quantia = Float.parseFloat(quantia2.getText());            
FileReader fr = new FileReader(FILE_NAME);
BufferedReader br = new BufferedReader(fr);
FileWriter escritor = new FileWriter(FILE_NAME, true);
BufferedWriter bufferescritor = new BufferedWriter(escritor);
String leitura;
String escreve;
while ((leitura = br.readLine()) != null) {
String [] data = leitura.split(";");    
if (Integer.parseInt(data[1]) == numConta) {
saldo+=quantia;
escreve = String.format("%s;%d;%f",cliente,numconta,saldo);
bufferescritor.write(escreve);
bufferescritor.newLine();
bufferescritor.close();
escritor.close();
} 
}
} catch (IOException f) {
f.printStackTrace();
}
}
}
  });

  telaDeposito.setVisible(true);
}
}