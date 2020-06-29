from tkinter import *

window = Tk()
window.title("New England")
yscroll = Scrollbar(window, orient = VERTICAL)
yscroll.grid(row = 0, column = 2, rowspan = 4, padx = (0,100), pady = 5, sticky = NS)

stateList = ["Conneticut", "Maine", "Massachussets", "New Hampshire", "Vermont", "Rhode Island"]
contents = StringVar()
lstNE = Listbox(window, width = 14, height = 4, listvariable = contents, yscrollcommand = yscroll.set)
lstNE.grid(row =0, column = 1, rowspan = 4, padx = (100,0), pady = 5, sticky = E)
contents.set(stateList)
yscroll["command"] = lstNE.yview #makes you be able to scroll not through down/up keys