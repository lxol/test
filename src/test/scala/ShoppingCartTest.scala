import org.scalatest.FlatSpec
import org.scalatest._

class ShoppingCartTest extends FlatSpec with Matchers {

  "A Shopping Cart checkout" should "produce 0 for an empty cart " in {
    ShoppingCart.checkout(Array()) should be(0)
  }

  it should "calculate the cost of the cart that don't meet the offer conditions" in {
    ShoppingCart.checkout(Array("apple", "orange")) should be(0.85)
  }

  it should "calculate the cost of the cart when oranges meet the offer condition " in {
    ShoppingCart.checkout(Array("apple", "orange", "orange", "orange")) should be(1.1)
  }

  it should "calculate the cost of the cart when apple meet the offer condition " in {
    ShoppingCart.checkout(Array("apple", "apple", "orange", "orange" )) should be(1.1)
  }

  it should "calculate the cost of the cart when both oranges and apple meet the offer condition " in {
    ShoppingCart.checkout(Array("apple", "apple", "orange", "orange", "orange" )) should be(1.1)
  }

  it should "calculate the cost of the cart when apples meet offer condition multiple times" in {
    ShoppingCart.checkout(Array("apple", "apple", "apple", "apple", "apple" )) should be(1.8)
  }

  it should "calculate the cost of the cart when oranges meet offer condition multiple times" in {
    ShoppingCart.checkout(Array("orange", "orange", "orange", "orange", "orange", "orange", "orange" )) should be(1.25)
  }
}
