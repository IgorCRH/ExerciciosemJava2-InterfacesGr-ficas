// Importa as classes
import javax.swing.JFrame; // Classe de criação da janela
import javax.swing.JLabel; // 
import javax.swing.JTextField; // Classe de criação dos campos de texto
import javax.swing.JButton; // Classe de criação do botões da janela
import javax.swing.JPanel; // C
import javax.swing.JOptionPane; // Classe de criação das mensagens da janela
import java.awt.event.ActionListener; // Classes de criação de ações
import java.awt.event.ActionEvent;

public class Programa {
  public static void main(String[] args) {
    JFrame titulotela = new JFrame("Sequência de Fibonacci"); // Cria a janela
    titulotela.setSize(400, 300); // Delimita tamanho da janela
    titulotela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no X
    titulotela.setLayout(null); // Delimita null no layout para poder delimitar a posição e tamanho dos componentes da janela

    JLabel label = new JLabel("Número de termos:"); // Cria o campo do título 'número de termos'
    // Delimita o tamanho e forma como título ou rótulo (label)
    label.setBounds(20, 20, 120, 25); // 1º - Coord. Horizontal (x), 2º - Coord.Vertical (y),3º - Largura, 4º - Altura 
    titulotela.add(label);

    // Cria o campo de texto para o usuário entrar com o número de termos
    JTextField field = new JTextField(10);
    field.setBounds(140, 20, 165, 25); // Delimita o tamanho e forma como campo, no caso, de texto
    titulotela.add(field);

    JButton button = new JButton("Calcular"); // Cria o botão Calcular
    button.setBounds(140, 50, 85, 25); // Delimita o tamanho e forma como botão
    titulotela.add(button);

    JLabel resultLabel = new JLabel(); // Cria o título aonde será mostrado o resultado
    resultLabel.setBounds(20, 80, 300, 25); // Delimita o tamanho e forma como título ou rótulo
    titulotela.add(resultLabel); // No caso é um título/rótulo do resultado da sequência

  // Adiciona ação ActionListener para o evento do cálculo da sequência  
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { // Evento da ação ActionListener
        int ntermos = Integer.parseInt(field.getText());

        if (ntermos == 1 || ntermos == 0) {
          resultLabel.setText("O valor da sequência Fibonacci é: 1");
        } else {
          int x = 0, y = 1, fib2 = 0, i;
          for (i = 2; i <= ntermos; i++) {
            fib2 = x + y;
            x = y;
            y = fib2;
          }
          resultLabel.setText("O valor da sequência Fibonacci é: " + fib2); // Exibe resultado
        }
      }
    });

    titulotela.setVisible(true); // Exibe a janela Sequência de Fibonacci
  }
}
