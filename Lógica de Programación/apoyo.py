"""
Modulo con las funciones de apoyo
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3
"""

USAR_TK = None


if USAR_TK:
    from tkinter import Tk, messagebox, simpledialog
    tk = Tk()
    tk.geometry("0x0")


def ingresar_texto(mensaje):
    if USAR_TK:
        texto = simpledialog.askstring("Entrada", mensaje)
    else:
        texto = input(mensaje)
    return texto


def ingresar_entero(mensaje):
    repetir = True
    while repetir:
        try:
            valor = int(ingresar_texto(mensaje))
            repetir = False
        except:
            mostrar_error("No es una entrada válida para un número entero")
    return valor


def ingresar_real(mensaje):
    repetir = True
    while repetir:
        try:
            valor = float(ingresar_texto(mensaje))
            repetir = False
        except:
            mostrar_error("No es una entrada válida para un número real")
    return valor


def mostrar_error(mensaje):
    if USAR_TK:
        messagebox.showerror("Error", mensaje)
    else:
        print(mensaje)


def mostrar_mensaje(mensaje):
    if USAR_TK:
        messagebox.showinfo("Información", mensaje)
    else:
        print(mensaje)


def calcular_promedio(valor1, valor2, valor3, valor4, valor5):
    promedio = (valor1 + valor2 + valor3 + valor4 + valor5) / 5
    return promedio


def convertir_cms_mts(centimetros):
    metros = centimetros / 100
    return metros


def calcular_promedio_ponderado(n1, n2, n3, n4):
    definitiva = (n1 * 0.1) + (n2 * 0.2) + (n3 * 0.3) + (n4 * 0.4)
    return definitiva


def calcular_promedio_amplio(valor1, valor2, valor3, valor4, valor5, valor6, valor7, valor8, valor9, valor10):
    promedio = (valor1 + valor2 + valor3 + valor4 + valor5
                + valor6 + valor7 + valor8 + valor9 + valor10) / 10
    return promedio


def ingresar_real_rango(mensaje, valor_minimo, valor_maximo):
    repetir = True
    while repetir:
        valor = ingresar_real(mensaje)
        if valor < valor_minimo or valor > valor_maximo:
            mostrar_error(
                f"EL valor no está entre {valor_minimo} y {valor_maximo}")
        else:
            repetir = False
    return valor


def ingresar_entero_rango(mensaje, valor_minimo, valor_maximo):
    repetir = True
    while repetir:
        valor = ingresar_entero(mensaje)
        if valor < valor_minimo or valor > valor_maximo:
            mostrar_error(f"EL valor no está entre {valor_minimo} y {valor_maximo}")
        else:
            repetir = False
    return valor


def ingresar_entero_mayor_que(mensaje, valor_minimo):
    repetir = True
    while repetir:
        valor = ingresar_entero(mensaje)
        if valor <= valor_minimo:
            mostrar_error(f"El valor no es mayor que {valor_minimo}")
        else:
            repetir = False
    return valor


def verificar_vocal(letra):
    vocal = letra.lower() in "aeiou"
    return vocal


def repetir_caracter(caracter, cantidad):
    mensaje = ""
    for i in range(0, cantidad):
        mensaje += caracter

    return mensaje


def ingresar_empleado(mensaje):
    mostrar_mensaje(mensaje)
    cod_empleado = ingresar_texto("Ingrese el código del empleado: ")
    nombres = ingresar_texto("Ingrese los nombres del empleado: ")
    apellidos = ingresar_texto("Ingrese los apellidos del empleado: ")
    edad = ingresar_entero("Ingrese la edad del empleado: ")
    sueldo = ingresar_entero("Ingrese el sueldo del empleado: ")
    empleado = (cod_empleado, nombres, apellidos, edad, sueldo)
    return (empleado)


def convertir_empleado_mensaje(empleado):
    mensaje = ""
    if empleado != None:
        cod_empleado, nombres, apellidos, edad, sueldo = empleado
        mensaje = f"{cod_empleado}: {nombres} {apellidos} tiene  una edad de {edad} y un sueldo de {sueldo}\n"
    else:
        mensaje += "No se encontró el empleado"
    return mensaje


def buscar_empleados(empleados, nombres_interes, apellidos_interes):
    empleado_interes = None
    for empleado in empleados:
        nombres = empleado[1]
        apellidos = empleado[2]
        if nombres == nombres_interes and apellidos == apellidos_interes:
            empleado_interes = empleado

    return empleado_interes


def convertir_empleados_mensaje(empleados):
    mensaje = ""
    for empleado in empleados:
        mensaje += convertir_empleado_mensaje(empleado)
    return mensaje


def cargar_datos_empleados():
    empleados = {
        "3021": ("3021", "Diana", "Jaramillo", 23, 1700000),
        "4086": ("4086", "Luisa", "Giraldo", 28, 3200000),
        "5039": ("5039", "Ana", " Montes", 34, 4500000),
        "6712": ("6712", "Sofía", "Tamayo", 25, 2300000),
        "8001": ("8001", "Carolina", "Rivera", 39, 5200000)
    }
    return empleados


def buscar_empleado_codigo(empleados, codigo_interes):
    if codigo_interes in empleados.keys():
        empleados_interes = empleados[codigo_interes]
    else:
        empleados_interes = None
    return empleados_interes


def leer_empleados(mensaje_global, mensaje_empleado):
    mostrar_mensaje(mensaje_global)
    empleados = set()
    numero_empleado = 1
    mas_empleados = "Si"
    while mas_empleados == "Si":
        empleado = ingresar_empleado(
            f"{mensaje_empleado} N°{numero_empleado}: ")
        empleados.add(empleado)
        numero_empleado += 1
        mas_empleados = ingresar_texto(
            "¿Desea ingresar más empleados? (SI/NO)")
    return empleados


def leer_empleados_diccionario(mensaje_global, mensaje_empleado):
    mostrar_mensaje(mensaje_global)
    empleados = dict()
    numero_empleado = 1
    mas_empleados = "S"
    while mas_empleados == "S":
        empleado = ingresar_empleado(
            f"{mensaje_empleado} :N° {numero_empleado}")
        codigo = empleado["codigo"]
        empleados[codigo] = empleado
        numero_empleado += 1
        mas_empleados = ingresar_texto("¿Desea ingresar más empleados? (S/N)")
    return empleados


def convertir_empleados_mensaje_diccionario(empleados):
    mensaje = ""
    for llave_empleado in empleados.keys():
        empleado = empleados[llave_empleado]
        mensaje += convertir_empleado_mensaje(empleado)
    return mensaje


def cargar_conjuntos_empleados():
    empleados = {
        "3021": {"codigo": "3021", "nombre": "Diana", "apellido": "Jaramillo", "edad": 23, "sueldo": 1700000},
        "4056": {"codigo": "4086", "nombre": "Luisa", "apellido": "Giraldo", "edad": 28, "sueldo": 3200000},
        "5039": {"codigo": "5039", "nombre": "Ana", "apellido": "Montes", "edad": 34, "sueldo": 4500000},
        "6712": {"codigo": "6712", "nombre": "Sofía", "apellido": "Tamayo", "edad": 25, "sueldo": 2300000},
        "8001": {"codigo": "8001", "nombre": "Carolina", "apellidos": "Rivera", "edad": 39, "sueldo": 5200000}
    }
    return empleados


def leer_empleados_diccionario(mensaje_global, mensaje_empleado):
    mostrar_mensaje(mensaje_global)
    empleados = dict()
    numero_empleado = 1
    mas_empleados = "S"
    while mas_empleados == "S":
        empleado = ingresar_empleado(
            f"{mensaje_empleado} :N° {numero_empleado}")
        codigo = empleado["codigo"]
        empleados[codigo] = empleado
        numero_empleado += 1
        mas_empleados = ingresar_texto("¿Desea ingresar más empleados? (S/N)")
    return empleados


def ingresar_empleado_diccionario(mensaje):
    mostrar_mensaje(mensaje)
    empleado = {
        "codigo": ingresar_texto("Ingrese el código del empleado: "),
        "nombres": ingresar_texto("Ingrese los nombres del empleado: "),
        "apellidos": ingresar_texto("Ingrese los apellidos del empleado: "),
        "edad": ingresar_entero("Ingrese la edad del empleado: "),
        "sueldo": ingresar_entero("Ingrese el sueldo del empleado: ")
    }
    return (empleado)


def convertir_empleado_mensaje(empleado):
    if empleado != None:
        mensaje = (f"{empleado['codigo']}: "
                   f"{empleado['nombres']}: "
                   f"{empleado['apellidos']}: "
                   f"{empleado['edad']}: "
                   f"{empleado['sueldo']}: "

                   )
    else:
        mensaje += "No se encontró el empleado"
    return mensaje
