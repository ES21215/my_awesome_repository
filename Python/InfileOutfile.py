def main():
    file = "Presidents.txt"
    presidents = makeLists(file)
    file = "Vice.txt"
    vices = makeLists(file)
    outfile = open("PresidentsAndVices.txt" , "w")
    findSimilarCreateFile(outfile,presidents,vices)

def makeLists(file):
    infile = open(file,'r') #can only open once other one is closed unless have 2 seperate variables
    list1 = [line.strip() for line in infile]
    infile.close()
    return list1
             

def findSimilarCreateFile(outfile, presidents,vices):
    similar = []
    for i in presidents:
        if i in vices:
            similar.append(i) 
    for i in range(len(similar)):
        similar[i] = similar[i] + "\n"
    outfile.writelines(similar)
    outfile.close()
main()

