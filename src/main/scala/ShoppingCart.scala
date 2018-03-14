object ShoppingCart {
  import scala.math.Integral.Implicits._
  def main(args: Array[String]) = {
    val totalPrice = checkout(args)
    println(s"checkout: $totalPrice")
  }

  def checkout(items: Array[String]) =
    items.groupBy(identity)
      .mapValues(_.size).toSeq
        .foldLeft(0.0) {
        (b:Double,c:(String,Int)) =>
          (c match  {
            case ("apple", count) => {
              val (quotient, remainder) = count /% 2
              (quotient + remainder) * 0.6
            }
            case ("orange", count) =>  {
              val (quotient, remainder) = count /% 3
              quotient * 1.2  + remainder * 0.6
            }
            case _ => 0.0 // everything else is free
          }) + b
        }
}
