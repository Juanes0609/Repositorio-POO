"""
Programa que le permite ingresar los datos 
de un numero NO DEFINIDO de empleados
Autor: Área de Programación UQ
Fecha: Mayo 2024
Licencia: GNU GPL v3

"""

from apoyo import convertir_empleado_mensaje, mostrar_mensaje, ingresar_empleado, ingresar_texto


def main():
    empleados = leer_empleados("Ingrese los datos del empleado: ", ingresar_empleado)
    nombre_interes = ingresar_texto("Ingrese el nombre del empleado: ")
    apellido_interes = ingresar_texto("Ingrese el apellido del empleado: ")
    mensaje = buscar_empleados (empleados, nombre_interes, apellido_interes)
    mostrar_mensaje(mensaje)


def leer_empleados (mensaje_global, mensaje_empleado):
    mostrar_mensaje(mensaje_global)
    empleados = set()
    numero_empleado = 1
    mas_empleados = "S"
    while mas_empleados == "S":
        empleado = ingresar_empleado(f"{mensaje_empleado} N°{numero_empleado}: ")
        empleados.add(empleado)
        numero_empleado += 1
        mas_empleados = ingresar_texto("¿Desea ingresar más empleados? (S/N)")
    return empleados


def buscar_empleados(empleados, nombres_interes, apellidos_interes):
    empleado_interes = None
    for empleado in empleados:
        nombres = empleado [1]
        apellidos = empleado [2]
        if nombres == nombres_interes and apellidos == apellidos_interes:
            empleado_interes = empleado
            
    return empleado_interes

    
main()