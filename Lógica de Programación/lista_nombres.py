from apoyo import ingresar_texto, mostrar_mensaje


def main():
    lista_nombres = ingresar_lista_nombres()
    orden = ordenar_nombres(lista_nombres)
    mostrar_mensaje(orden)


def ingresar_lista_nombres():
    lista = []
    for i in range (0, 5):
        nombres = ingresar_texto("Ingrese los nombres: ")
        lista.append(nombres)
    return lista


def ordenar_nombres(lista_nombres):
    lista_ordenada = []
    longitud_lista = len(lista_nombres) - 1 
    for i in range(len(lista_nombres)):
        nombre = lista_nombres[longitud_lista]
        lista_ordenada.append(nombre)
        longitud_lista -= 1
    
                
                
    return lista_ordenada


    
main()