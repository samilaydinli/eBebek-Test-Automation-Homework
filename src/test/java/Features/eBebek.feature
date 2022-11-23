Feature: Add Product to Cart
  @addproduct
  Scenario: Go to eBebek and add product to cart
    Given go to eBebek
    And search for biberon
    And click the first product
    And click add to cart
    When show cart
    Then check if the product added
    And driver close