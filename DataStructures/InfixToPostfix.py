def inputInfix():
    inputInfix = input("Enter Infix: ")
    infixArray = []
    for letter in inputInfix:
        infixArray.append(letter)
    convertInfix(infixArray)
    
def convertInfix(infixArray):
    global myStack, postfix, operators
    for value in infixArray:
        if value not in operators:
            postfix+=value
        if value in operators:
            if myStackFull() != True:
                if value == ")":
                    myStackPop()
                elif myStackEmpty() == True:
                    myStackPush(value)
                else:
                    if value == "(":
                        myStackPush(value)
                    elif checkValue(value)<=checkValue(myStack[len(myStack)-1]):
                        myStackPop()
                        myStackPush(value)
                    else:
                        myStackPush(value)
    myStackPop()
    print("Postfix: " + postfix)
    
def myStackEmpty():
    if len(myStack) == 0:
        return True
    else:
        return False
    
def myStackFull():
    if len(myStack) > 10:
        return True
    else:
        return False
    
def myStackPush(value):
    global myStack
    myStack.append(value)
    
def myStackPop():
    global myStack,postfix
    for val in reversed(myStack):
        if val != ")" and val != "(":
            postfix+=val
    del myStack[:]
    
def checkValue(value):
    if value == "^":
        return 3
    elif value == "*" or value == "/":
        return 2
    elif value == "+" or value == "-":
        return 1
    else:
        return 0
    
postfix = ""
myStack = []
operators = ["^", "/", "*", "-", "+",")","("]
inputInfix()   
    