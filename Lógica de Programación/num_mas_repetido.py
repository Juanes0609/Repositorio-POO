def num_mas_repetido(lista_numeros):
    max_repeticiones = 0
    mas_repetido = lista_numeros[0]

    for i in range (len(lista_numeros)):
        repeticiones = 0
        for j in range (len(lista_numeros)):
            if lista_numeros [i] == lista_numeros [j]:
                repeticiones += 1

        if repeticiones > max_repeticiones:
            max_repeticiones = repeticiones
            mas_repetido = lista_numeros [i]

    return mas_repetido


    

lista_numeros = [1,3,3,2,2,1,1,3]
print (num_mas_repetido(lista_numeros))
 