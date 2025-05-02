"""
Programa que permita generar un triangulo que la base y 
la altura sea la cantidad de espacios en blanco
Autor: Área de Programación UQ
Fecha: Abril 2024
Licencia: GNU GPL v3
"""

from apoyo import ingresar_entero_mayor_que, mostrar_mensaje


VALOR_INICIAL = 0


def main():
    numero = ingresar_entero_mayor_que ("Ingrese un número entero: ",VALOR_INICIAL)
    secuencia = determinar_secuencia (numero)
    espacios = determinar_espacios (secuencia)
    area = calcular_area (espacios)
    triangulo = generar_triangulo (espacios)
    mensaje = generar_mensaje(triangulo, secuencia, area)
    mostrar_mensaje (mensaje)


def determinar_secuencia (numero):
    secuencia = f"{numero}"
    while numero > 1 :
        if numero % 2 == 0: 
            numero = numero // 2
        else:
            numero = (numero * 3) + 1
        secuencia += f" {numero}"

    return secuencia


def determinar_espacios (secuencia):
    espacios = 0 
    for i in secuencia :
        if i == " ":
            espacios += 1
    return espacios 


def calcular_area (espacios):
    area = (espacios * espacios)/2
    return area 


def generar_triangulo(espacios):
    salida = ""
    i = 0
    while i < espacios:
        j = 0 
        while j <= i:
            salida += "*"
            j = j+1
        salida += "\n"
        i += 1
    return salida


def generar_mensaje(triangulo, secuencia, area):
    mensaje = f"{triangulo}La congetura = {secuencia} y el área del triangulo es {area}"
    return mensaje
    

main()