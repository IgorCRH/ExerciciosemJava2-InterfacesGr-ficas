// Importa as classes
import javax.swing.JFrame; // Classe de criação da janela
import javax.swing.JLabel; // Classe de criação dos títulos em texto
import javax.swing.JTextField; // Classe de criação dos campos de texto
import javax.swing.JButton; // Classe de criação do botões da janela
import javax.swing.JPanel; 
import javax.swing.JOptionPane; // Classe de criação das mensagens da janela
import java.awt.event.ActionListener; // Classes de criação de ações
import java.awt.event.ActionEvent; // Classe de criação dos eventos das ações
import javax.swing.ImageIcon;
import javax.swing.JDialog; // Classe de criação das janelas JDialog

public class ContaPoupanca extends ContaBancaria
{
protected float diarendimento; // Variável exclusivamente usada na classe ContaPoupanca

// Método GET para pegar o valor do rendimento
public float GetDiaRend (float diarendimento){
return diarendimento;
}

// Construtor da Classe ContaPoupanca
public ContaPoupanca (String cliente, int numconta, float saldo){
super(cliente,numconta,saldo);
this.diarendimento = diarendimento;
}

// Método de calcular novo saldo a partir do rendimento
public void novosaldo(){
JDialog telarend = new JDialog(); // Cria tela JDialog
  telarend.setTitle("Novo saldo a partir do rendimento"); // Seta o título da tela
  telarend.setSize(600,400); // Seta o tamanho da tela
  telarend.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Seta operação de desaparecer com a tecla ao clicar no símbolo X
  telarend.setLayout(null); // Estilo, organização e tamanho dos componentes é definida pelo programador
  telarend.setModal(true); // Coloca a tela em estilo modal, para aparecer após chamadas de botões.

  // Área de criação dos títulos em textos, dos campos de texto e do botão calcnovosaldo
  JLabel labelrendimento = new JLabel("Rendimento Desejado:");
  labelrendimento.setBounds(20, 20, 195, 25);
  telarend.add(labelrendimento); // Cria título do rendimento e o adiciona a tela

  JTextField rend2 = new JTextField(50);
  rend2.setBounds(240, 20, 165, 25);
  telarend.add(rend2); // Cria campo de texto para a entrada do rendimento e o adiciona a tela

  JLabel labelNumConta = new JLabel("Número da conta que deseja analisar:");
  labelNumConta.setBounds(20, 50, 265, 25);
  telarend.add(labelNumConta);  // Cria título do número da conta e o adiciona a tela

  JTextField numConta = new JTextField(50);
  numConta.setBounds(240, 50, 165, 25);
  telarend.add(numConta); // Cria campo de texto para a entrada do número da conta e o adiciona a tela

  JButton calcnovosaldo = new JButton("Calcular Novo Saldo a partir do Rendimento");
  calcnovosaldo.setBounds(140, 80, 295, 25);
  telarend.add(calcnovosaldo); // Cria o botão para calcular novo saldo e o adiciona a tela
// Método de criação da ação para o botão 'calcnovosaldo'
  calcnovosaldo.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { // Cria o evento da ação
      String numContaStr = numConta.getText(); // Converte o valor do campo de texto para uma string
      if (numContaStr.isEmpty()) { // Se a string estiver vazia ou inválida, não poderá ser convertido para inteiro, a operação não será feita
        JOptionPane.showMessageDialog(null, "Número da conta inválido");
      } else {
        int numConta = Integer.parseInt(numContaStr);
        if (numConta == numconta) {
          try {
            float rend = Float.parseFloat(rend2.getText());
            float novosaldo = 0;
              novosaldo = saldo*rend;
              JOptionPane.showMessageDialog(null, "Futuro saldo a partir do rendimento: " +novosaldo);
            } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor inválido para o rendimento");
          }
        } else {
          JOptionPane.showMessageDialog(null, "Número da conta inválido");
        }
      }
    }
  });

  telarend.setVisible(true); // Exibe a janela JDialog telarend
}

public void sacar() {
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
        if (numConta == numconta) {
          try {
            float quantia = Float.parseFloat(quantia2.getText());
            if (quantia <= saldo) {
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