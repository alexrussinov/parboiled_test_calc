package calculator

import scala.util.{Failure, Success}



/**
 * Created by Aleksey Voronets on 04.05.15.
 */
trait Calculator
{
    def compute(input: String): scala.math.BigDecimal
}
class CalculatorImpl extends Calculator
{
    def compute(input: String): scala.math.BigDecimal =
    {
        new CalculatorParser(input.trim.replaceAll(" ", "")).InputLine.run() match
        {
            case Success(v) => BigDecimal(v)
            case Failure(_) => throw new Exception("Not valid input")
        }
    }
}
