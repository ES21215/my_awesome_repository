import random
import time
import os.path
from os import path

def updateScore():
    global allScores, name, points
    entry = (name.upper(), points)
    allScores.append(entry)
    allScores = sorted(allScores, key=lambda x: x[1], reverse = True)
    allScores = allScores[:10]
    outfile(allScores)
    printHighScores()
    return
    
def printHighScores():
    print("HIGH SCORES: ")
    if path.exists("highScores.txt"):
        infile = open("highScores.txt", 'r') 
        for line in infile.readlines():
            tuples=line.split()
            print(tuples[0].upper(), int(tuples[1]))
        infile.close()
    else:
        print("There is no High Score list as of now.")
    return

def menu():
    global allScores
    allScores = []
    print('''
         1. Play the Game
         2. See the High Scores
         3. Quit the Game
          ''')
    choice = int(input("Enter your choice: "))
    if choice == 1:
        createRandomGrid()
    elif choice == 2:
        printHighScores()
        menu()
    elif choice == 3:
        exit()
    else:
        print("Invalid choice. Choose again.")
        menu()
        
def outfile(allScores):
    clearFile = open("highScores.txt", 'w').close()
    count = 0
    outfile = open("highScores.txt", 'a')
    for i in allScores:
        outfile.write(str(allScores[count][0]) + "\t" + str(allScores[count][1]))
        outfile.write("\n")
        count+=1
    outfile.close()
    return
    

def highScores():
    global allScores, name, points
    if path.exists("highScores.txt"):
        infile = open("highScores.txt", 'r') 
        for line in infile.readlines():
            tuples=line.split()
            toAdd = (tuples[0].upper(), int(tuples[1]))
            allScores.append(toAdd)
        allScores = sorted(allScores, key=lambda x: x[1], reverse = True)
        infile.close()
    if points>allScores[len(allScores)-1][1] or len(allScores)<10:
        print("This is a High Score.")
        name = input("Enter your Name: ")
        updateScore()
    else:
        print("This is NOT a High Score.")
        printHighScores()
    menu()
        
def createRandomGrid():
    global grid, name, points
    points = 0
    grid = []
    while len(grid)<20:
        x = random.randint(65,90)
        char = chr(x)
        grid.append(char)
    if "A" and "O" and "I" and "U" and "E" not in grid:
        createRandomGrid()
    printGrid()
    timer()
    
def printGrid():
    count = 0
    global grid
    for i in grid:
        if count%5 != 0:
            print(" "+ i + " ",end = "")
        else: 
            print(" "+ "\n" + i + " ", end = "")
        count+=1
    print(" ")
    
def timer():
    global guess
    initial_time = time.time()
    while time.time()-initial_time < 60:
        guess = input("Enter a word: ")
        guess = guess.upper()
        checkWord()
        if checkWord():
            resetBoard()
            calcPoints()
        else:
            print("Invalid Entry.")
        printGrid()
    print("Time is up!")
    highScores()
            
def resetBoard():
    global guess, grid
    for i in guess:
        newChar = chr(random.randint(65,90))
        index = grid.index(i)
        grid[index] = newChar.upper()
        
def checkWord():
    valid = True
    global guess
    if len(guess)<3:
        valid = False
    for i in guess:
        if guess.count(i) > grid.count(i):
            valid = False
        infile = open("usa.txt", "r")
        dictionary = [line.strip() for line in infile]
        if guess.lower() not in dictionary:
            valid = False
    if valid == False:
        return False
    else:
        return True
        
def calcPoints():
    global points
    points+=len(guess)
    
grid = []
allScores = []
guess = ""
name = ""
points = 0
choice = 0
menu()
