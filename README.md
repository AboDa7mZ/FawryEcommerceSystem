Features
Product Definition
Products have a name, price, and quantity.

Expiration Support
Some products (e.g., cheese, biscuits) can expire using LocalDate.

Shipping Support
Shippable products (e.g., cheese, TV) implement a Shippable interface with getWeight() and getName() methods.

Cart Functionality

Add products to cart with a specific quantity.

Prevent over-ordering beyond stock.

Checkout Process

Verifies:

No expired products.

Product availability.

Sufficient customer balance.

Calculates:

Subtotal (price × quantity)

Shipping fees (flat rate per item)

Total amount

Remaining customer balance

Prints:

Receipt

Shipment details

Project Structure
Product (abstract): common attributes

Cheese, TV, ScratchCard: product types

Cart, CartItem: manage items

Customer: holds balance

CheckoutService: validates and processes purchase

ShippingService: simulates item shipment

Main: demo execution

Assumptions
Shipping cost is 15 units per item.

Expiration check is done only at checkout.

Expired or out-of-stock products stop the checkout process.
