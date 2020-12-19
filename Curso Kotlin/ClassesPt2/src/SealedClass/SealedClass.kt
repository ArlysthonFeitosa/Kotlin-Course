package SealedClass

//Open para herdar a classe de dentro do arquivo e de fora
//Sealed para apenas herdar de dentro do arquivo
sealed class Result {
    class Success(val message: String) : Result() {}
    class Error(val message: String, val errorCode: Int) : Result() {}
}

class Repo() {
    fun execute(): Result {
        //return Result.Success("Deu Certo!")
        return Result.Error("Deu Erro!", 404)
    }
}

fun main(args: Array<String>) {
    val r1 = Repo()
    val result: Result = r1.execute()

    when (result) {
        is Result.Success -> {
            println("Deu Certo!")
        }
        is Result.Error -> {
            println("Deu Erro!")
        }
    }
}