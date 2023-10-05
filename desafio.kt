// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
enum class Nivel(val nome: String) { BASICO("Básico"), INTERMEDIARIO("Intermediário"), DIFICIL("Avançado") }
enum class DuracaoMinutos(val minutos: Int) {
    CINCO(5), QUINZE(15), MEIA_HORA(30), UMA_HORA(60);
}

data class Usuario(val email: String, val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: DuracaoMinutos = DuracaoMinutos.UMA_HORA)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableSetOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        this.inscritos.add(usuario)
    }
}

fun main() {
    println("teste")
    // Criando alguns conteúdos educacionais
    val conteudoIntroducao = ConteudoEducacional("Introdução cursos DIO", DuracaoMinutos.CINCO)
    val conteudoIntroducaoKotlin = ConteudoEducacional("Introdução curso Kotlin", DuracaoMinutos.CINCO)
    val conteudo1Kotlin = ConteudoEducacional("Estrutura de Dados em Kotlin", DuracaoMinutos.QUINZE)
    val conteudo2Kotlin = ConteudoEducacional("Orientação Objetos em Kotlin", DuracaoMinutos.QUINZE)
    val conteudo3Kotlin = ConteudoEducacional("Usando banco de dados em Kotlin", DuracaoMinutos.MEIA_HORA)
    val listaConteudoKotlin = listOf(conteudoIntroducao, conteudoIntroducaoKotlin, conteudo1Kotlin, conteudo2Kotlin, conteudo3Kotlin)

    val conteudoIntroducaoJava = ConteudoEducacional("Introdução curso Java", DuracaoMinutos.CINCO)
    val conteudo1Java = ConteudoEducacional("Estrutura de Dados em Java", DuracaoMinutos.QUINZE)
    val conteudo2Java = ConteudoEducacional("Orientação Objetos em Java", DuracaoMinutos.MEIA_HORA)
    val listaConteudoJava = listOf(conteudoIntroducao, conteudoIntroducaoJava, conteudo1Java, conteudo2Java)
    
    // Cria as formações
    val formacaoKotlin = Formacao("Curso Avançado de Kotlin", Nivel.DIFICIL, listaConteudoKotlin)
    val formacaoJava = Formacao("Curso iniciando em Java", Nivel.BASICO, listaConteudoJava)
    
    val listaFormacoes = listOf(formacaoKotlin, formacaoJava)
    
    // Criando alguns usuários e inscrevendo-os em formações
    val usuario1 = Usuario("endereco1@email.teste.com", "Edson de Sobrenome X")
    val usuario2 = Usuario("endereco2@email.teste.com", "Maria de Sobrenome Y")
    val usuario3 = Usuario("endereco2@email.teste.com", "Pedro de Sobrenome Z")
    val usuario4 = Usuario("endereco2@email.teste.com", "Juliana de Sobrenome B")
    
    // Inscrever os usuários em formações.
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario3)
    formacaoKotlin.matricular(usuario4)

    // Print das formações, conteúdos e usuários inscritos
    for (formacao in listaFormacoes) {
        println("O curso de formação \"${formacao.nome}\", de nível ${formacao.nivel.nome} é composto pelo conteúdo:")
        for (conteudo in formacao.conteudos) {
        	println("- ${conteudo.nome} (duração: ${conteudo.duracao.minutos} minutos)")
        }
        val tempoTotal = formacao.conteudos.sumBy {it.duracao.minutos}
        println("Duração total: ${tempoTotal} minutos")
        println("----------------------------------------------------")
        
        if (formacao.inscritos.count() == 0)
        	println("Nenhum inscrito até o momento")
        else {
            println("${formacao.inscritos.count()} alunos inscritos:")
        }
        
        for (aluno in formacao.inscritos) {
            println("-- ${aluno.nome}")
        }
        println("====================================================")
    }
}
