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

public class ContaEspecial extends ContaBancaria
{
protected float limite; // Variável exclusiva da classe

// Construtor da Classe
public ContaEspecial (String cliente, int numconta, float saldo, float limite){
super(cliente,numconta,saldo);
this.limite = limite;
}

public float GetLimite (float limite){
return limite;
}

// Método do saque da conta especial
public void sacaresp(){
  JDialog telaSaque = new JDialog(); // Cria tela JDialog
  telaSaque.setTitle("Saque"); // Seta o título da tela
  telaSaque.setSize(400, 300); // Seta o tamanho da tela
  telaSaque.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Seta operação de desaparecer com a tecla ao clicar no símbolo X
  telaSaque.setLayout(null); // Estilo, organização e tamanho dos componentes é definida pelo programador
  telaSaque.setModal(true); // Coloca a tela em estilo modal, para aparecer após chamadas de botões.

 // Área de criação dos títulos em textos, dos campos de texto e do botão sacar
  JLabel labelQuantia = new JLabel("Quantia a sacar:");
  labelQuantia.setBounds(20, 20, 120, 25);
  telaSaque.add(labelQuantia); // Cria título da quantia e o adiciona a tela

  JTextField quantia2 = new JTextField(50);
  quantia2.setBounds(140, 20, 165, 25);
  telaSaque.add(quantia2); // Cria campo de texto para a entrada da quantia e adiciona-o a tela

  JLabel labelNumConta = new JLabel("Número da conta:");
  labelNumConta.setBounds(20, 50, 120, 25);
  telaSaque.add(labelNumConta); // Cria título do número da conta e o adiciona a tela

  JTextField numConta = new JTextField(50);
  numConta.setBounds(140, 50, 165, 25);
  telaSaque.add(numConta); // Cria campo de texto para a entrada do número da conta e o adiciona a tela

  JButton sacar = new JButton("Sacar");
  sacar.setBounds(140, 80, 85, 25);
  telaSaque.add(sacar); // Cria o botão sacar e adiciona-o a tela

  // Método de criação da ação para o botão 'sacar'
  sacar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { // Cria o evento
      String numContaStr = numConta.getText(); // Converte o valor do campo de texto para uma string
      if (numContaStr.isEmpty()) { // Se a string estiver vazia ou inválida, não poderá ser convertido para inteiro, a operação não será feita
        JOptionPane.showMessageDialog(null, "Número da conta inválido");
      } else {
        int numConta = Integer.parseInt(numContaStr);
        if (numConta == numconta) {
          try {
            float quantia = Float.parseFloat(quantia2.getText());
            if (quantia <= saldo + limite) {
              saldo -= quantia;
              JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
            } else {
              JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar o saque");
            }
          } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor inválido para a quantia");
          }
        } else {
          JOptionPane.showMessageDialog(null, "Número da conta inválido");
        }
      }
    }
  });

  telaSaque.setVisible(true); // Exibe a janela JDialog telaSaque
}


public void depositar (){
JDialog telaDeposito = new JDialog(); // Para janela deste método, a lógica é a mesma do método acima
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
        if (numConta == numconta) {
          try {
            float quantia = Float.parseFloat(quantia2.getText());
            if (quantia <= saldo) {
              saldo += quantia;
              JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
            } else {
              JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar o saque");
            }
          } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor inválido para a quantia");
          }
        } else {
          JOptionPane.showMessageDialog(null, "Número da conta inválido");
        }
      }
    }
  });

  telaDeposito.setVisible(true);
}
}