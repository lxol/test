object ShoppingCart {
  def main(args: Array[String]) = {

  }

  def checkout(items: Array[String]) =
    items.foldLeft(0.0) {(sum, i) =>
      sum + (
        if (i == "orange")
         0.25
        else if (i == "apple")
         0.6
        else
          0.0 // all other items are free
        )
    }
}
