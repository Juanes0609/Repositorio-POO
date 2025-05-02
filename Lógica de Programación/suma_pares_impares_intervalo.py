"""
Programa que permita ingresar un valor inicial y final, y que sume los impares y pares entre ese intervalo
Autor: Área de Programación
Fecha: Octubre 2024
Licencia: GNU GPL v3

"""

from apoyo import ingresar_entero_mayor_que, mostrar_mensaje

INICIO = 0


def main():
    valor_inicial = ingresar_entero_mayor_que(
        "Ingrese el valor inicial: ", INICIO)
    valor_final = ingresar_entero_mayor_que(
        "Ingrese el valor final: ", valor_inicial)
    suma_pares = calcular_suma_pares(valor_inicial, valor_final)
    suma_impares = calcular_suma_impares(valor_inicial, valor_final)
    mensaje = generar_mensaje(
        valor_inicial, valor_final, suma_pares, suma_impares)
    mostrar_mensaje(mensaje)


def calcular_suma_pares(inicial, final):
    suma_pares = 0
    for i in range(inicial, final + 1):
        if i % 2 == 0:
            suma_pares += i
    return suma_pares


def calcular_suma_impares(inicial, final):
    suma_impares = 0
    for i in range(inicial, final + 1):
        if i % 2 != 0:
            suma_impares += i
    return suma_impares


def generar_mensaje(valor_inicial, valor_final, suma_pares, suma_impares):
    mensaje = f"Del intervalo {valor_inicial} y {valor_final}, la suma de pares es {suma_pares} y la suma de impares es {suma_impares}"
    return mensaje


main()
