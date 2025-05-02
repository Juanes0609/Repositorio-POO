n = 5
dibujo = ""
for i in range (n, -1, -1):
    for j in range (i):
        dibujo += "* "
    dibujo += f"{i}" + "\n"
    
print (dibujo)
