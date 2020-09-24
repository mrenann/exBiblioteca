import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    var chooseYourDestiny = 0
    println("\n-------------------LIVRARIA/BIBLIOTECA-------------------\n")
    println("Qual o nome da Livraria ?")
    val nomeLivraria = input.nextLine()
    println("Quando a Livraria foi fundada ?")
    val anoFundacao = input.nextLine()

    val livraria = Livraria(nomeLivraria, anoFundacao)
    val cliente = Cliente("Joaozinho",2015454)


         println("\nSua Livraria/Bibliota está vazia, Adicione um Livro")

         println("Qual o nome do título do Livro ?")
         val titulo = input.nextLine()
         println("Qual o nome do Autor do Livro ?")
         val autor = input.nextLine()
         println("Qual foi Lançado o Livro ?")
         val lancadoEm = input.nextInt()
         println("Qual o Preço do Livro ?")
         val precoVenda = input.nextDouble()
         println("Qual o Preço do Aluguel por Hora do Livro ?")
         val precoAluguel = input.nextDouble()

    val livro1 = Livro(1, titulo, autor, lancadoEm, precoVenda, precoAluguel)
    val livro2 = Livro(2, titulo, autor, lancadoEm, precoVenda, precoAluguel)
    val colecao = Colecao(1,"ASA", mutableListOf(livro1,livro2))

    livraria.cadastraLivro(livro1)
    livraria.cadastraLivro(livro2)
    livraria.cadastroColecao(colecao)
    livraria.alugaColecao(colecao,cliente)

    //livraria.consulta(123)
    livraria.consulta(1)
    livraria.estoque()




}