object ShoppingCart {

  import scala.math.BigDecimal

  def main(args: Array[String]) = {

  }

  val OrangeCost = 0.25
  val AppleCost = 0.6

  def checkout(items: Array[String]) =
    BigDecimal(
      items.foldLeft(0.0) { (sum, i) =>
        sum + (
          if (i == "orange")
            OrangeCost
          else if (i == "apple")
            AppleCost
          else
            0.0 // all other items are free
          )
      }
    ).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
}
