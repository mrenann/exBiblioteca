class Colecao (var codigo: Int, var titulo: String, var livrosColecao: MutableList<Livro>){

    override fun equals(other: Any?): Boolean {
        return (other as? Int)?.let {
            it == codigo
        }?: (other as? String)?.let {
            it == titulo
        }?: false
    }

}