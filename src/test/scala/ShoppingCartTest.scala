import org.scalatest.FlatSpec
import org.scalatest._

class ShoppingCartTest extends FlatSpec with Matchers {

  "A Shopping Cart checkout" should "produce 0 for an empty cart " in {
    ShoppingCart.checkout(Array()) should be(0)
  }

  it should "calculate the cost of the cart with only oranges" in {
    ShoppingCart.checkout(Array("orange", "orange")) should be(0.5)
  }

  it should "calculate the cost of the cart with only apples" in {
    ShoppingCart.checkout(Array("apple", "apple")) should be(1.2)
  }

  it should "calculate the cost of the cart with mixture of oranges and apples" in {
    ShoppingCart.checkout(Array("apple", "apple", "orange", "apple")) should be(2.05)
  }

}
