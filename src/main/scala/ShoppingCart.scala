object ShoppingCart {

  import scala.math.Integral.Implicits._
  import scala.math.BigDecimal

  val AppleCost = 0.6
  val OrangeCost = 0.25

  def main(args: Array[String]) = {
    val totalPrice = checkout(args)
    println(s"checkout: $totalPrice")
  }

  def checkout(items: Array[String]) =
    BigDecimal(
      items.groupBy(identity)
        .mapValues(_.size).toSeq
        .foldLeft(0.0) {
          (b: Double, c: (String, Int)) =>
            (c match {
              case ("apple", count) => {
                val (quotient, remainder) = count /% 2
                (quotient + remainder) * AppleCost
              }
              case ("orange", count) => {
                val (quotient, remainder) = count /% 3
                quotient * 2 * OrangeCost + remainder * OrangeCost
              }
              case _ => 0.0 // everything else is free
            }) + b
        }
    ).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
}
