class Livro (var codigo: Int, var titulo: String, val autor: String, var  anoLancamento: Int,
             var precoVenda: Double, var precoAluguel: Double, var estadoAtual: Int = 0){

    override fun equals(other: Any?): Boolean {
        return (other as? Int)?.let {
            it == codigo
        }?: (other as? String)?.let {
            it == titulo
        }?: false
    }

}