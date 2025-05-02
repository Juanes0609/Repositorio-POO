from apoyo import ingresar_entero_mayor_que, mostrar_mensaje

VALOR_INICIAL = 0

def main():
    numero = ingresar_entero_mayor_que("Ingrese un numero entero positivo: ", VALOR_INICIAL)
    determinar_numero = validar_numero_perfecto(numero)
    mensaje = generar_mensaje(numero, determinar_numero) 
    mostrar_mensaje(mensaje)


def validar_numero_perfecto(numero):
    suma = 0
    for i in range (numero-1, 0, -1):
        if numero % i == 0:
            suma += i    
    return suma


def generar_mensaje(numero, determinar_numero):
    if numero == determinar_numero:
        mensaje = f"{numero} es un numero perfecto"
    else:
        mensaje = f"{numero} no es un numero perfecto"
    return mensaje


main()
