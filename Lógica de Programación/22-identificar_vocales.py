"""
Programa que permita generar un triangulo que la base y 
la altura sea la cantidad de espacios en blanco
Autor: Área de Programación UQ
Fecha: Abril 2024
Licencia: GNU GPL v3
"""

from apoyo import ingresar_texto, mostrar_mensaje


def main():
    texto = ingresar_texto("Ingrese la frase: ")
    vocal = ingresar_texto ("Ingrese la vocal: ")
    mensaje = generar_mensaje(texto, vocal)
    mostrar_mensaje (mensaje)


def generar_mensaje(texto, vocal):
    mensaje = ""
    for letra in texto:
        if letra == vocal:
            mensaje += letra.upper()
        elif letra != vocal:
            mensaje += letra.lower()
    return mensaje    

main()