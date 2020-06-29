from tkinter import *

window = Tk()
window.title("Grid Geometry")

lblNumYears = Label(window, text = "Number of Years:")
lblNumYears.grid(row = 0, column = 0, pady = 20) #top left

entNumYears = Entry(window, width =5)
entNumYears.grid(row = 0, column = 1, sticky = S)

btnCalculate = Button(window, text = "Calculate Montly Payment")
btnCalculate.grid(row = 1, column = 0, columnspan = 2, padx = 10, pady = 10)

window.mainloop()
