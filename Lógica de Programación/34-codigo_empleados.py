"""
Programa que carga un conjunto de datos predeterminados
Autor: Área de Programación UQ
Fecha: Mayo 2024
Licencia: GNU GPL v3
"""

from apoyo import mostrar_mensaje, ingresar_texto, convertir_empleado_mensaje, buscar_empleado_codigo, leer_empleados_diccionario


def main():
    empleados = leer_empleados_diccionario("DATOS EMPLEADO", "Ingresar empleados")
    codigo_interes = ingresar_texto("Ingrese el código que desea buscar: ")
    empleado_interes = buscar_empleado_codigo(empleados ,codigo_interes)
    mensaje = convertir_empleado_mensaje(empleado_interes)
    mostrar_mensaje(mensaje)


# def cargar_datos_empleados():
#     empleados = {
#     "3021": ("3021", "Diana", "Jaramillo", 23, 1700000), 
#     "4086": ("4086", "Luisa", "Giraldo", 28, 3200000), 
#     "5039": ("5039", "Ana", " Montes", 34, 4500000), 
#     "6712": ("6712", "Sofía", "Tamayo", 25, 2300000), 
#     "8001": ("8001", "Carolina", "Rivera", 39, 5200000)
#     }
#     return empleados


# def buscar_empleado_codigo(empleados, codigo_interes):
#     if codigo_interes in empleados.keys():
#         empleados_interes = empleados [codigo_interes]
#     else:
#         empleados_interes = None
#     return empleados_interes





main()