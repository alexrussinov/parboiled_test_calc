import scala.math.BigDecimal

val a  = -(1-2)*5

def fact(num: Double): Double = (1 to num.toInt).map(x => x.toDouble).foldLeft(1.toDouble)((acc, b) => acc * b)

fact(5.0)
"1".toDouble