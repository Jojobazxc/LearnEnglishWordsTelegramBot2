import java.io.File

fun main() {

    val wordsFile = File("words.txt")

    wordsFile.createNewFile()

    val lines = wordsFile.readLines()

    val dictionary: MutableList<Word> = mutableListOf()
    var countOfLines = 0
    for (line in lines) {
        countOfLines++
        val line = line.split("|")
        val word = Word(line[0], line[1], line[2].toInt())
        dictionary.add(word)
    }

    val quantityOfCorrectAnswers = dictionary.filter { it.countOfCorrectAnswer >= 3 }
    while (true) {
        println("Меню: 1 – Учить слова, 2 – Статистика, 0 – Выход")
        val choice = readln().toIntOrNull() ?: continue
        when (choice) {
            1 -> TODO("Добавить функционал")
            2 -> {
                val percentsOfCorrectAnswers = ((quantityOfCorrectAnswers.size.toDouble() / countOfLines) * 100).toInt()
                println("Выучено ${quantityOfCorrectAnswers.size} из $countOfLines слов | ${percentsOfCorrectAnswers}%")
            }

            0 -> return
            else -> println("Введите существующий вариант ответа")
        }
    }

}