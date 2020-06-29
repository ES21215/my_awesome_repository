from tkinter import *
def changeColor(event):
    if entName["fg"] == "blue":
        entName["fg"] = "red"
    else:
        entName["fg"] = "blue"
def convertToUpperCase(event):
    #MyContents = contents.get()
    #MyContents = MyContents.upper()
    contents.set(contents.get().upper())
    
window = Tk()
window.title("Label")

lblName = Label(window, text = "First Name: ")
lblName.grid(padx = 100, pady = 15)

contents = StringVar()
entName = Entry(window, width = 20, textvariable = contents, state = "readonly")
contents.set("Hello World")
entName.grid(padx = 100, pady = 15)

entName.bind("<Button-3>" , changeColor) #button 3 = right click
entName.bind("<Button-1>", convertToUpperCase)

window.mainloop()