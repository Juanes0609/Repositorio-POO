"""
Programa que descomponga los factores primos de un número
Autor: Área de Programación UQ
Fecha: Abril 2024
Licencia: GNU GPL v3
"""

from apoyo import ingresar_entero, mostrar_mensaje


def main():
    numero = ingresar_entero("Ingrese el número: ")
    factores_primos = calcular_factores_primos(numero)
    mensaje = generar_mensaje(numero, factores_primos)
    mostrar_mensaje(mensaje)


def calcular_factores_primos(numero):
    factores_primos = []
    i = 2
    while numero > 1:
        while numero % i == 0:
            factores_primos += [i]
            numero //= i
            i += 1
        return factores_primos


def generar_mensaje(numero, factores_primos):
    mensaje = f"Los factores primos de {numero} son {factores_primos}"
    return mensaje

main()
