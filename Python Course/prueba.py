
from apoyo import mostrar_mensaje, ingresar_entero_rango, ingresar_entero


def main():
    valor_minimo = ingresar_entero("Ingrese el valor mínimo: ")
    valor_maximo = ingresar_entero("Ingrese el valor máximo: ")
    suma_multiplos = calcular_suma_multiplos(valor_minimo, valor_maximo)
    mensaje = generar_mensaje(suma_multiplos, valor_minimo, valor_maximo)
    mostrar_mensaje(mensaje)


def calcular_suma_multiplos(valor_minimo, valor_maximo):
    suma = 0
    for i in range (valor_minimo, valor_maximo + 1):
        if i % 3 == 0:
            suma += i
    return suma


def generar_mensaje(suma_multiplos, valor_minimo, valor_maximo):
    mensaje = f"La suma de los multiplos de 3 en un rango de {valor_minimo} y {valor_maximo} es {suma_multiplos}"
    return mensaje


main()