states = ["Alabama","Maryland","Florida","California","Maine","Texas"]
rain = [34,26,29,17,31,15]
snow = [7,13,1,2,20,1]
menu = ("0 to exit\n1 to Add a State\n2 to Remove a State\n3 to Show States\n4 to Compute Average of Rainfall/Snowfall")
choice = 1
print(menu)
while choice != 0:
    choice = input("Choice: ")
    if choice == "0":
        print("You have exited.")
        break
    elif choice == "1":
        state = input("What is the State you would like to add? ")
        states.append(state)
        rainfall = int(input("Rainful of the State: "))
        rain.append(rainfall)
        snowfall = int(input("Snowfall of the State: "))
        snow.append(snowfall)
        
    elif choice =="2":
        stateToRemove = input("What is the State you would like to remove? ")
        index = states.index(stateToRemove)
        del(states[index])
        del(rain[index])
        del(snow[index])
        
    elif choice =="3":
        for i in states:
            print(i)
        state = input("Choose a state: ")
        index = states.index(state)
        print(state)
        print("Rainfall: ", rain[index])
        print("Snowfall: ", snow[index])
        
    elif choice == "4":
        sumRain = 0
        sumSnow =0
        for i in rain:
            sumRain+=i
        avgOfRain = str(sumRain/len(rain))
        for i in snow:
            sumSnow+=i
        avgOfSnow = str(sumSnow/len(snow))
        print("Average of Rainfall: ", avgOfRain)
        print("Average of Snowfall: ", avgOfSnow)
    if choice != 0:
        print(menu)
            
            
            
            
            