def showSelection(Register, Candy, Chips, Gum, Cookies):
    print()
    print("***Welcome to " + name + "'s Candy Shop***")
    print("To select an item, enter")
    print('''             1 for Candy
             2 for Chips
             3 for Gum
             4 for Cookies
             9 to exit''')
    choice = int(input("Enter your choice: "))
    if choice == 1:
        sellProduct(Candy, Register)
    elif choice == 2:
        sellProduct(Chips, Register)
    elif choice == 3:
        sellProduct(Gum, Register)
    elif choice == 4:
        sellProduct(Cookies, Register)
    elif choice == 9:
        exit()
    else:
        print("Invalid Selection")
        showSelection(Register, Candy, Chips, Gum, Cookies)
def sellProduct(product, register):
    if  int(product.getCount()) <= 0:
        print("Sorry, this item is sold out.")
        showSelection(Register, Candy, Chips, Gum, Cookies)
    elif int(product.getCount()) > 0:
        totalCost = int(product.getProductCost())
        cost = int(product.getProductCost())
        deposit = 0
        while cost>0:
            deposit = input("Please deposit " + str(cost) + " cents: ")
            cost = cost - int(deposit)
        register.acceptAmount(totalCost)
        product.makeSale()
        print("Collect your item at the bottom and enjoy.")
        showSelection(Register, Candy, Chips, Gum, Cookies)
        
class CashRegister:
    def __init__(self, cashOnHand = 500):
        if cashOnHand < 500:
            self._cashOnHand = 500
        else:
            self._cashOnHand = cashOnHand
    def currentBalance(self):
        return self._cashOnHand
    def acceptAmount(self, amountPaid):
        self._cashOnHand += amountPaid
        
class Dispenser:
    def __init__(self, numberOfItems = 50, cost = 50):
        if numberOfItems<0:
            self._numberOfItems = 50
        else:
            self._numberOfItems = numberOfItems
        if cost<0:
            self._cost = 50
        else:
            self._cost = cost
    def getCount(self):
        return self._numberOfItems
    def getProductCost(self):
        return self._cost
    def makeSale(self):
        self._numberOfItems-=1
        
Register = CashRegister()
Candy = Dispenser(100,50)
Chips = Dispenser(100,65)
Gum = Dispenser(74,45)
Cookies = Dispenser(100,85)            
name = input("Enter your name: ")
showSelection(Register, Candy, Chips, Gum, Cookies)
            
        
    
        
        