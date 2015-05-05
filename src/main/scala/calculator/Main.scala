package calculator

/**
 * Created by Aleksey Voronets on 04.05.15.
 */
object Main {
    def main(args: Array[String]): Unit =
    {
        val result = new CalculatorImpl().compute("!5")
        println(result)
    }
}
