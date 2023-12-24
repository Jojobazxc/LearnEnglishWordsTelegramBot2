import java.io.File

fun main() {

    val wordsFile = File("words.txt")

    wordsFile.createNewFile()

    val lines = wordsFile.readLines()

    val dictionary: MutableList<Word> = mutableListOf()
    for (line in lines) {
        val line = line.split("|")
        val word = Word(line[0], line[1], 0)
        dictionary.add(word)
    }

    dictionary.forEach { println(it) }

}