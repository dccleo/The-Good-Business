// Imports 
import java.util.ArrayList 
import java.util.HashMap

// Variables 
var inventory = HashMap<String, Int>()
var customers = HashMap<String, Int>()
var employees = ArrayList<String>() 

// Functions
fun addItemToInventory(item: String, quantity: Int) { 
    // Add item to the inventory with specified quantity
    inventory[item] = quantity
}

fun addCustomer(name: String, loyaltyPoints: Int) {
    // Add customer to customers list with the given loyalty points
    customers[name] = loyaltyPoints
}

fun addEmployees(name: String) { 
    // Add an employee to the employees list
    employees.add(name)
}

fun updateInventory(item: String, quantity: Int) { 
    // Update the existing inventory with the given item and quantity
    inventory[item] = quantity
}

fun updateCustomerLoyaltyPoints(name: String, loyaltyPoints: Int) { 
    // Update the existing customer's loyalty points with the given points 
    customers[name] = loyaltyPoints
}

fun removeEmployee(name: String) {
    // Remove the employee from the employees list
    employees.remove(name)
}

fun checkInventory(item: String): Int { 
    // Return the quantity of the given item in the inventory
    return inventory[item] ?: 0
}

fun checkCustomerLoyaltyPoints(name: String): Int { 
    // Return the loyalty points of the given customer
    return customers[name] ?: 0
}

fun processTransaction(customerName: String, payment: Int) {
    // Process the customer transaction and add loyalty points accordingly 
    var loyaltyPoints = payment / 10
    customers[customerName]?.let {
        loyaltyPoints += it
    }
    customers[customerName] = loyaltyPoints
}

fun purchaseItem(customerName: String, item: String, quantity: Int) {
    // Process the purchase of an item from customers and update inventory accordingly 
    var loyaltyPoints = customers[customerName] ?: 0
    if (inventory[item] ?: 0 >= quantity) {
        loyaltyPoints += 5
        inventory[item] = inventory[item]?.minus(quantity) ?: 0
        customers[customerName] = loyaltyPoints
    }
}

// Main Function 
fun main() {
    // Add items to inventory
    addItemToInventory("Shirt", 100)
    addItemToInventory("Jeans", 50)
    addItemToInventory("Hat", 40)
    
    // Add customers 
    addCustomer("John", 20)
    addCustomer("Mary", 30)
    addCustomer("Dave", 10)
    
    // Add employees 
    addEmployees("Tom")
    addEmployees("Harry")
    
    // Process customer transactions 
    processTransaction("John", 100)
    processTransaction("Mary", 50)
    processTransaction("Dave", 200)
    
    // Purchase items 
    purchaseItem("John", "Shirt", 10)
    purchaseItem("Mary", "Jeans", 5)
    purchaseItem("Dave", "Hat", 2)
    
    // Check Inventory 
    println("Shirt Inventory: " + checkInventory("Shirt").toString())
    println("Jeans Inventory: " + checkInventory("Jeans").toString())
    println("Hat Inventory: " + checkInventory("Hat").toString())
    
    // Check customers loyalty points
    println("John Loyalty Points: " + checkCustomerLoyaltyPoints("John").toString())
    println("Mary Loyalty Points: " + checkCustomerLoyaltyPoints("Mary").toString())
    println("Dave Loyalty Points: " + checkCustomerLoyaltyPoints("Dave").toString())
}