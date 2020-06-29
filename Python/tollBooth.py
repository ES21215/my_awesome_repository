from time import sleep
def main():
    count = 0
    totalBooth = 0;
    vehicles = []
    amount = int(input("How many vehicle may pass through your toll in 1 day? "))
    while (count<amount):
        vehicle = input("Vehicle type? (Car/Truck)\n")
        v = TollBooth()
        v.setType(vehicle)
        vehicles.append(v)
        totalBooth+=v.calcPrice()
        count+=1
    print("Reciept:")
    for i in vehicles:
        print(i)
    print("Toll Closed.")
    print("Total of the Day: " + "$" + str(totalBooth) + ".00")
    
class TollBooth:
    def __init__(self, typeOfVehicle = ""): #initialization method
        self._typeOfVehicle = typeOfVehicle.upper() #instance
      
    def setType(self, typeOfVehicle):
        self._typeOfVehicle = typeOfVehicle.upper()
      
    def getType(self,typeOfVehicle):
        return self._typeOfVehicle
    
    def calcPrice(self):
        if (self._typeOfVehicle == "CAR"):
            return 1
        elif (self._typeOfVehicle == "TRUCK"):
            return 2

    def __str__(self):
        return(self._typeOfVehicle + "\t$" + str(self.calcPrice()) + ".00")
    
main()  

    
