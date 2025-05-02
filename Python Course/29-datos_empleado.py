"""
Programa que lee e imprime datos del empleado
Autor: Área de Programación UQ
Fecha: Mayo 2024
Licencia: GNU GPL v3

"""

from apoyo import ingresar_texto, ingresar_entero, mostrar_mensaje


def main():
    empleado = ingresar_empleado ("Ingrese los datos del empleado: ")
    mensaje = convertir_empleado_mensaje (empleado)
    mostrar_mensaje (mensaje)


def ingresar_empleado (mensaje):
    mostrar_mensaje(mensaje)
    cod_empleado = ingresar_texto ("Ingrese el código del empleado: ")
    nombres = ingresar_texto ("Ingrese los nombres del empleado: ")
    apellidos = ingresar_texto ("Ingrese los apellidos del empleado: ")
    edad = ingresar_entero ("Ingrese la edad del empleado: ")
    sueldo = ingresar_entero ("Ingrese el sueldo del empleado: ")
    empleado = (cod_empleado, nombres, apellidos, edad, sueldo)
    return (empleado)


def convertir_empleado_mensaje (empleado):
    cod_empleado, nombres, apellidos, edad, sueldo = empleado
    mensaje = f"{cod_empleado}:\n {nombres} {apellidos} tiene  una edad de {edad} y un sueldo de {sueldo}\n"
    
    return mensaje

main()