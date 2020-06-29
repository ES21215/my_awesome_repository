class Critter:
    
    def __init__(self, name = "UNNAMED", hunger = 0, boredom = 0):
        self.name = name
        self.hunger = hunger
        self.boredom = boredom
        
    def __passTime(self):
        self.hunger+=1
        self.boredom-=1
        
    def mood(self):
        unhappiness = self.hunger + self.boredom
        if unhappiness <= 5:
            mood = "happy"
        elif unhappiness <= 10:
            mood = "okay"
        elif unhappiness <= 15:
            mood = "frustrated"
        else:
            mood = "mad"
        return mood
    
    def talk(self):
        print("I'm " + self.name + ", I feel", self.mood())
        self.__passTime()
        
    def eat(self, food = 4):
        print("Burp. Thank you.")
        self.hunger-=food
        if self.hunger < 0:
            self.hunger = 0
        self.__passTime()
        
    def play(self, fun = 4):
        print("Whhheee!")
        self.boredom-=fun
        if self.boredom < 0:
            self.boredom = 0
        self.__passTime()
        
def main():
    print("You are playing the Critter game!")
    name = input("Enter Critter's Name: ")
    crit = Critter(name)
    while True:
        print("""MENU:
        0 - Quit
        1 - Listen to your critter
        2 - Feed your critter
        3 - Play with your critter""")
        choice = int(input("Enter you choice: "))
        if choice == 0:
            exit()
        elif choice == 1:
            crit.talk()
        elif choice == 2:
            food = int(input("How much food would you like to feed your critter? (0-20): "))
            crit.eat(food)
        elif choice == 3:
            fun = int(input("How much fun is your critter going to have? (0-20): "))
            crit.play(fun)
main()
        
        
        
    