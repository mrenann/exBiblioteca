class Livraria (val nome:String, val data: String){
    var livros : MutableList<Livro> = mutableListOf()
    var colecoes: MutableList<Colecao> = mutableListOf()
    fun cadastraLivro (livro: Livro){
        livros.add(livro)
    }

    fun cadastroColecao (colecao: Colecao){
        colecoes.add(colecao)
    }

    fun mostrarLivro (livro:Livro){
        println("\nLivro")
        println("CÓDIGO ${livro.codigo}")
        println("TÍTULO ${livro.titulo}")
        println("AUTOR ${livro.autor}")
        println("LANCADO EM ${livro.anoLancamento}")
        println("VENDA ${livro.precoVenda}")
        println("ALUGUEL/H ${livro.precoAluguel}")

        // println("---${livro.estadoAtual}---------------")
        when (livro.estadoAtual) {
            -1 ->  println("VENDIDO")
            1 ->  println("ALUGADO")
            0 ->  println("DISPONÍVEL")
        }
    }

    fun consulta(consulta: Any? = null){
        consultaLivro(consulta)
        consultaColecao(consulta)
    }

    fun consultaLivro (consulta: Any? = null):Livro? {
        var temLivro = false
        livros.forEach{
            if(it.equals(consulta)){
                mostrarLivro(it)
                temLivro = true
                return it
            }
        }

        if(!temLivro){
            println("Livro não encontrado")
        }
        return null
    }

    fun consultaColecao (consulta: Any? = null):Colecao? {
        var temLivro = false
        colecoes.forEach{
            if(it.equals(consulta)){
                println("\nLivros dentro da colecao ${it.codigo} com o título ${it.titulo}")
                it.livrosColecao.forEach {livro ->
                    mostrarLivro(livro)
                }
                temLivro = true
                return it
            }
        }

        if(!temLivro){
            println("Coleção não encontrado")
        }
        return null
    }

    fun alugaColecao(colecao: Colecao,cliente: Cliente){

            colecao.livrosColecao.forEach {
            cliente.historico["${it.codigo}-Alugado"] = it
                it.estadoAtual = 1
            }
        }


    fun alugaLivro (livro: Livro,cliente: Cliente){
        if(livro.estadoAtual == 0){
            livro.estadoAtual = 1
            cliente.historico["${livro.codigo}-Alugado"] = livro
        }else{
            println("Não é possível Alugar esse Livro")
        }

    }

    fun efetuarVenda(codigo: Int,cliente: Cliente){
        var livro = consultaLivro(codigo)
        livro?.let {it.estadoAtual= -1
            cliente.historico["${it.codigo}-Alugado"] = it
        }
    }

    fun estoque(){

        var contDisp = 0
        var contAlug = 0
        var contVend = 0

        var totalValores = 0.0
        livros.forEach {
            when (it.estadoAtual) {
                -1 -> contVend++
                1 -> contAlug++
                0 -> contDisp++
            }
            totalValores +=it.precoVenda
        }

        println("\nVendidos ${contVend}")
        println("Alugados ${contAlug}")
        println("Disponiveis ${contDisp}")
        println("TotalPreço ${totalValores}")
    }

}