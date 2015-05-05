package calculator

import org.scalatest.FunSuite

/**
 * @author alespuh
 * @since 24.04.2015
 */
class CalculatorTest extends FunSuite
{
    val calc = new CalculatorImpl()

    test("test 1")
    {
        calc.compute("(4 + 4) * (9 - 3)")
    }

    test("fact")
    {
        calc.compute("!4")
    }

    test("+/")
    {
        calc.compute("1 + 4/4")
    }

    test("-/!+")
    {
        calc.compute("10 - 1 / !4 ")
    }

    test("//^")
    {
        calc.compute("10 / 2/ 9 ^ 4")
    }

    test("-/^")
    {
        calc.compute("10 - 5 / 4 ^ 4")
    }

    test("1 + 4")
    {
        assertResult(5)(calc.compute("1 + 4"))
    }

    test("1 + 4/4")
    {
        assertResult(2)(calc.compute("1 + 4/4"))
    }

    test("-6/3")
    {
        assertResult(-2)(calc.compute("-6/3"))
    }

    test("-6/(3)")
    {
        assertResult(-2)(calc.compute("-6/(3)"))
    }

    test("-(6)/(3)")
    {
        assertResult(-2)(calc.compute("-(6)/(3)"))
    }

    test("(-(6))/(3)")
    {
        assertResult(-2)(calc.compute("(-(6))/(3)"))
    }

    //    test("((-(6))/(3))")
    //    {
    //        assertResult(-2)(calc.compute("((-(6))/(3))"))
    //    }

    test("12 + -6/3")
    {
        assertResult(10)(calc.compute("12 + -6/3"))
    }

    test("12 + -6/3/2")
    {
        assertResult(11)(calc.compute("12 + -6/3/2"))
    }

    test("10 + -6/3/(1 + 1)")
    {
        assertResult(9)(calc.compute("10 + -6/3/(1 + 1)"))
    }

    test("1 + 4/4 + 2")
    {
        assertResult(4)(calc.compute("1 + 4/4 + 2"))
    }

    test("1 + 4/(4 + 4) + 2.5")
    {
        assertResult(4)(calc.compute("1 + 4/(4 + 4) + 2.5"))
    }

    test("(4 + 4)")
    {
        assertResult(8)(calc.compute("(4 + 4)"))
    }

    test("(9 - 3 * 2 + 4 /2 )")
    {
        assertResult(5)(calc.compute("(9 - 3 * 2 + 4 /2 )"))
    }

    test("(9 - 3 * (2 + 1 /2))")
    {
        assertResult(1.5)(calc.compute("(9 - 3 * (2 + 1 /2))"))
    }

    test("(4 + 4) * (9 - 3)")
    {
        assertResult(48)(calc.compute("(4 + 4) * (9 - 3)"))
    }

    test("(4 + 4) / (9 - 5/1)")
    {
        assertResult(2)(calc.compute("(4 + 4) / (9 - 5/1)"))
    }

    test("(4 + 4) / (9 - 5/(23 - 22))")
    {
        assertResult(2)(calc.compute("(4 + 4) / (9 - 5/(23 - 22))"))
    }

    test("4 + 4 / (9 - 5/(23 - 22))")
    {
        assertResult(5)(calc.compute("4 + 4 / (9 - 5/(23 - 22))"))
    }

    test("!10")
    {
        assertResult(3628800)(calc.compute("!10"))
    }

    test("sin 13")
    {
        assertResult(0.4201670368266409)(calc.compute("sin 13"))
    }

    test("sin(13 + 0)")
    {
        assertResult(0.4201670368266409)(calc.compute("sin(13 + 0)"))
    }

    test("sin(13)")
    {
        assertResult(0.4201670368266409)(calc.compute("sin(13)"))
    }

    test("-(4 + 4) / (9 - 5/(23 - 22))")
    {
        assertResult(-2)(calc.compute("-(4 + 4) / (9 - 5/(23 - 22))"))
    }

    //    test("-(4 + 4) / (9 + - 5/(23 - 22))")
    //    {
    //        assertResult(-2)(calc.compute("-(4 + 4) / (9 + - 5/(23 - 22))"))
    //    }

    test("!(4 + 4) / (9 + - 5/(23 - 22))")
    {
        assertResult(10080)(calc.compute("!(4 + 4) / (9 + - 5/(23 - 22))"))
    }

    test("10 - 1 / !4 ")
    {
        assertResult(BigDecimal("9.95833333333333333333333333333333333"))(calc.compute("10 - 1 / !4 "))
    }

    test("10 - 1/ !(4 + 4) / (9 + -5/(23 - 22))")
    {
        assertResult(BigDecimal("9.999993799603174603174603174603174603175"))(calc.compute("10 - 1/ !(4 + 4) / (9 + -5/(23 - 22))"))
    }

    test("cos(sin(13 - 1/ !1))")
    {
        assertResult(0.859465627274523)(calc.compute("cos(sin(13 - 1/ !1))"))
    }

    test("10 - 1/ !(4 + 4) ^ 0.5")
    {
        assertResult(BigDecimal("9.995019880794440026214545571121604894"))(calc.compute("10 - 1/ !(4 + 4) ^ 0.5"))
    }

    //    test("10 - 10 / 2/ (9 + -5/(23 - 22)) ^ 2")
    //    {
    //        assertResult(9.6875)(calc.compute("10 - 10 / 2/ (9 + -5/(23 - 22)) ^ 2"))
    //    }

    test("10 - 10 / 2/ (9 + -5/1) ^ 2")
    {
        assertResult(9.6875)(calc.compute("10 - 10 / 2/ (9 + -5/1) ^ 2"))
    }

    test("10 - 5/ (9 + -5/1) ^ 2")
    {
        assertResult(9.6875)(calc.compute("10 - 5/ (9 + -5/1) ^ 2"))
    }

    test("10 - 5/ (9 + -5) ^ 2")
    {
        assertResult(9.6875)(calc.compute("10 - 5/ (9 + -5) ^ 2"))
    }

    test(" - 5/ (9 + -5) ^ 2")
    {
        assertResult(-0.3125)(calc.compute(" - 5/ (9 + -5) ^ 2"))
    }

    test("5/ (9 + -5) ^ 2")
    {
        assertResult(0.3125)(calc.compute("5/ (9 + -5) ^ 2"))
    }

    test("5/ (9 - 5) ^ 2")
    {
        assertResult(0.3125)(calc.compute("5/ (9 -5) ^ 2"))
    }

    test("10 - 5/ 4 ^ 2")
    {
        assertResult(9.6875)(calc.compute("10 - 5/ 4 ^ 2"))
    }

    test("10 - 5/ (4) ^ 2")
    {
        assertResult(9.6875)(calc.compute("10 - 5/ (4) ^ 2"))
    }

    test("10 / 2/ 9 ^ 4")
    {
        assertResult(BigDecimal("0.0007620789513793629019966468526139308"))(calc.compute("10 / 2/ 9 ^ 4"))
    }

    test("10 / 2 * 9 ^ 4")
    {
        assertResult(32805)(calc.compute("10 / 2 * 9 ^ 4"))
    }

    test("10 - 5 / 4 ^ 4")
    {
        assertResult(9.98046875)(calc.compute("10 - 5 / 4 ^ 4"))
    }

    test("(10 - 5) / 4 ^ 4 * (2 + 3 - 10 /6) / (2 + -4)")
    {
        assertResult(BigDecimal("-0.03255208333333333333333333333333333"))(calc.compute("(10 - 5) / 4 ^ 4 * (2 + 3 - 10 /6) / (2 + -4)"))
    }

    test("(10 - 5) / 4 ^ 4 * (2 + 3 - 10 /6) + (2 + -4)")
    {
        assertResult(BigDecimal("-1.93489583333333333333333333333333334"))(calc.compute("(10 - 5) / 4 ^ 4 * (2 + 3 - 10 /6) + (2 + -4)"))
    }
}