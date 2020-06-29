#ask for a word and then see if the word is alphabetical
#ask them for a word and see if it has all the vowels in the word
word = input("Enter a word: ")
word = word.lower()
vowels = ["a","e","i","o","u"]
yesVowels =[]
allVowels =""
determine = "true"
for i in vowels:
    if i in word:
        allVowels = "true"
        yesVowels.append(i)
    else:
        allVowels = "false"
        determine = "false"
if determine == "false":
    print('The word "' + word+ '" DOES NOT have all the vowels.')
    print("But it does have the vowels: ", yesVowels)
elif determine == "true":
    print('The word "' + word+ '" DOES have all the vowels.')  

    
    
    
    
    