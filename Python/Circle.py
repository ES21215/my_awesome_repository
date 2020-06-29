import math
class Circle:
    totalCircles = 0
    def __init__(self, radius):
        self._radius = radius
        Circle.totalCircles+=1
    def setRadius(self,radius):
        self._radius = radius
    def getRadius(self):
        return self._radius
    def area(self):
        return math.pi * (self._radius ** 2)
    def perimeter(self):
        return (2 * math.pi * self._radius)
    def __str__(self):
            return("Radius: " + str(self._radius) + "\tPerimeter: " + str(round(self.perimeter(),2))
                   + "\tArea: " + str(round(self.area(),2)))

def main():
    firstCircle = Circle(0)
    secondCircle = Circle(12)
    print(firstCircle)
    print(secondCircle)
    rad = input("Enter the Radius of the First Circle: ")
    firstCircle.setRadius(rad)
    if int(firstCircle.getRadius()) > int(secondCircle.getRadius()):
        print("The first circle has a larger radius.")
    elif int(firstCircle.getRadius()) < int(secondCircle.getRadius()):
        print("The second circle has a larger radius.")
    else:
        print("The radius of these two circles are equal.")
        
       
main()
    

        
        