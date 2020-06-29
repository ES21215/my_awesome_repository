from tkinter import *
def changeBackgroundColor(event):
    lstColors["bg"] = lstColors.get(lstColors.curselection()) #gets the current selection of the listbox
    window["bg"] = lstColors.get(lstColors.curselection())
def sort(event):
    L.sort()
    contents.set(L)
    
window = Tk()
window.title("Colors")

L = ["red", "yellow", "light blue", "orange"]

contents = StringVar()
lstColors = Listbox(window, width = 10, height = 4, listvariable = contents)
lstColors.grid(padx = 100, pady = 15)
contents.set(L)

lstColors.bind("<<ListboxSelect>>", changeBackgroundColor)
lstColors.bind("<Button - 1>", sort)

window.mainloop()