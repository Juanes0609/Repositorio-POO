from apoyo import ingresar_real, mostrar_mensaje


def ordenar_lista_n_numeros(lista_numeros):
        n = len(lista_numeros)
        for i in range (n):
            for j in range (0, n-i-1):
                if lista_numeros [j] > lista_numeros [j+1]:
                    lista_numeros [j], lista_numeros [j+1] = lista_numeros [j+1], lista_numeros [j]
                    
        return lista_numeros




lista_numeros = [1,4,2,7,8,4]
print(ordenar_lista_n_numeros(lista_numeros))
