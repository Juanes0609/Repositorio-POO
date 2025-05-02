"""
Programa que calcule el mínimo común múltiplo de dos numeros
Autor: Área de Programación UQ
Fecha: Abril 2024
Licencia: GNU GPL v3
"""

from apoyo import ingresar_entero, mostrar_mensaje

def main():
    n1 = ingresar_entero("Ingrese el numero mayor: ")
    n2 = ingresar_entero("Ingrese el numero menor: ")
    mcm = calcular_mcm(n1, n2)
    mostrar_mensaje(mcm)


def calcular_mcm(n1, n2):
    for i in range(1, n1 * n2 + 1):
        if i % n1 == 0 and i % n2 == 0:
            return i
        

main()


