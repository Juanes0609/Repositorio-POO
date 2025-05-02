"""
Programa que permita generar una secuencia segun la conjetura de S. Ulam
Autor: Área de Programación UQ
Fecha: Abril 2024
Licencia: GNU GPL v3
"""

from apoyo import ingresar_entero_mayor_que, mostrar_mensaje

VALOR_INICIAL = 0


def main():
    numero_entero = ingresar_entero_mayor_que ("Ingrese un número entero: ", VALOR_INICIAL)
    det_numero = determinar_par_impar (numero_entero)
    mostrar_mensaje(det_numero)


def determinar_par_impar(numero_entero):
    secuencia = f"{numero_entero}"
    while numero_entero > 1 :
        if numero_entero % 2 == 0: 
            numero_entero = numero_entero // 2
        else:
            numero_entero = (numero_entero * 3) + 1
        secuencia += f" {numero_entero}"
    
    return secuencia
   

main()