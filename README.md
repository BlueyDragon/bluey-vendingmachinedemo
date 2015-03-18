# Vending Machine Demo
This Java program runs in a command prompt and demonstrates a basic vending machine. The user is able to interact with the machine by inserting money, viewing products, and purchasing items. The program is written in an object-oriented manner, with two classes, Product and VendingMachine, that interact with one another. It also uses three Java utility classes - Vector, Scanner, and Iterator - to simplify code and streamline debugging.

## Product
The product object describes one product that is held by the machine. Every product has a name, a price, and a description as flavor text.

## VendingMachine
The vending machine object controls the inner workings of the machine. The machine's inventory of product objects is stored as a Vector. The machine also keeps track of how much money has been currently inserted, so it can be displayed to the user. Products cannot be purchased unless the machine has enough money inserted, just like a physical vending machine.
