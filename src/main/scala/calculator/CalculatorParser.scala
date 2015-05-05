package calculator
import org.parboiled2._

/**
 * Created by Aleksey Voronets on 04.05.15.
 */
class CalculatorParser(val input: ParserInput) extends Parser
{
    def InputLine = rule { Expression ~ EOI }

    def Expression: Rule1[Double] = rule
    {
        Term ~ zeroOrMore(
            '+' ~ Term ~> ((_: Double) + _)
                | '-' ~ Term ~> ((_: Double) - _)
        )
    }

    def Term = rule
    {
        Factor ~ zeroOrMore(
            '*' ~ Factor ~> ((_: Double) * _)
                | '/' ~ Factor ~> ((_: Double) / _)
                    | '^' ~ Number ~> (math.pow(_: Double, _))
        )
    }

    def Factor = rule {Number | Parens | UnaryMinus | Sinus | Cosinus | Factorial }

    def Parens = rule { '(' ~ Expression ~ ')' }

    def UnaryMinus = rule { '-' ~ Expression ~> ((_: Double) * -1)}

    def Factorial = rule { ('!' ~ Number) ~> (fact(_:Double)) | ('!' ~ Parens) ~> (fact(_:Double))}

    def Sinus = rule { "sin" ~ Number ~> (math.sin(_: Double)) | "sin" ~ Parens ~> (math.sin(_: Double))}

    def Cosinus = rule { "cos" ~ Number ~> (math.cos(_: Double)) | "cos" ~ Parens ~> (math.cos(_: Double))}

    def Number = rule { capture(Digits | NegativeDigits) ~> (_.toDouble) }

    def Digits = rule { oneOrMore((CharPredicate.Digit ++ CharPredicate('.') ++ CharPredicate.Digit) | CharPredicate.Digit) }

    def NegativeDigits = rule {'-' ~ Digits}

    def test = rule { 'a' ~ 'b' ~ 'c' ~> ((a: Int, b: Int, c: Int) => a * b * c)}

    def fact(num: Double): Double = (1 to num.toInt).map(x => x.toDouble).foldLeft(1.toDouble)((acc, b) => acc * b)


    // Whitespace

    def SkipWS = rule(zeroOrMore(WS))

    def WS = rule(zeroOrMore(WSChar))

    val WSChar = CharPredicate(" \t")


}

