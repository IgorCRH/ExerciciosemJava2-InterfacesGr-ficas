----------------------------------------------------------------------------
Programa em Java que administra um sistema de cadastro e informações de veículos de uma loja de revenda. É a mesma versão do programa 14 do diretório de Exercícios de Java, mas em versão de interface gráfica (GUI)

Enunciado (UNESP):
simular a operação de
um cadastro de veículos de uma revenda. Existem dois tipos de
veículos: Carro, e Moto. 
![](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgg8mPIX64EuCUioNnMX0uHqdjGUD0eKFnzqsJt5xV-fvb0bqp5Hmnqh79rwFa6pBdiHCAMco7blX-M3HBzeOT262nM-NK1HjOvQ2QARdZYyXrEYUsMYjS4UCnq_YU7p8WjZ2_ohbz2zp1Iwp1QPWIF5AKkxV4O0erGGF_8uBjUe8ooQfGUDuhPaukw/s668/poli2.png)
<br></br>
Interface Veiculos - string modelo e double preço
Classe CVeiculos (implementa Veiculos) - métodos getpreco() e printdados()
Classe Moto - Construtor da Classe Moto, double getpreco(), void setAno ()
Classe Carro - Construtor da Classe Carro, double getpreco(), void setKm ()

Deseja-se construir um programa que:
Item (A): O usuário decide se deseja inserir uma moto ou um carro.
Depois insere as informações necessárias e finalmente imprime o
relatório com as características de cada veículo contido no cadastro.
Item (B): Após o usuário inserir as informações deverá ser realizado
um levantamento acerca das motos e carros. Primeiro será obtido o
total preços dos veículos contidos no cadastro. Depois, é verificado e
uma moto tiver no campo ano um valor maior ou igual que 2008 seu
valor será reajustado em 10%. Se um carro tiver um valor no campo
km um valor maior que 100000, então, seu valor será reduzido em
8%. Por fim, um novo cálculo acerca do total de preços é realizada e
impressa.
----------------------------------------------------------------------------
