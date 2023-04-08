public class Carro extends CVeiculos
{
protected double km;

public Carro(){
this("N/A",0,0,0);
}

// Construtor da classe Carro
public Carro(String nome, int codigo, double preco, double km2){
super(nome,codigo,preco); // Chamada super para pegar os atributos da CMidia
setKm(km2);  // Constrói a variável nummusicas na classe 
}

// Se o tipo for CD, retorna por esse método, finalizando o retorno do GetTipo
// em CVeiculos.
public String getClasse (){
return "\nCarro";
}

// Devolve para o método getInfo (que prepara a impressão) da classe CMidia suas informações,
// para finalizar a impressão inicialmente criada em CMidia.
public String getInfo (){
return super.getInfo() + "\n" + "Quilometragem: " +km;
}

// Método SET para pegar a variável de quantidade das músicas
public void setKm(double km2){
km = km2;
}  
}
