// Classes Moto e Carro possuem quase os mesmos métodos em comum, pois a maioria
// dos atributos é o mesmo, por serem produtos ou itens bem parecidos, isto é,
// constróem a mesma coisa ao retornar.
public class Moto extends CVeiculos
{
protected int ano;

// Método para construir a classe sem parâmetros, para definir o tipo posteriormente.
public Moto(){
this("N/A",0,0,0);
}

// Construtor da classe Moto.
public Moto(String nome, int codigo, double preco, int ano2){
super(nome,codigo,preco); // Chamada super para pegar os atributos da CVeiculos
setAno(ano2);  // Constrói a variável ano na classe 
}

// Se o tipo for CD, retorna por esse método, finalizando o retorno do GetTipo
// em CMidia.
public String getClasse (){
return "\nMoto";
}

// Devolve para o método getInfo (que prepara a impressão) da classe CVeiculos suas informações,
// para finalizar a impressão inicialmente criada em CVeiculos.
public String getInfo (){
return super.getInfo() + "\n" + "Ano: " +ano;
}

// Método SET para pegar a variável dos anos da moto.
public void setAno(int ano2){
ano = ano2;
}    
}
