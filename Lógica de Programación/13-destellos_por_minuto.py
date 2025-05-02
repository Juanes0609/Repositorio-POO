"""
Programa que calcule cuántos destellos de
luz se han dado en total durante un periodo determinado
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3

"""


from apoyo import ingresar_entero, mostrar_mensaje


DESTELLOS_MINUTO = 20


def main():
    tiempo_horas = ingresar_entero ("Ingrese la cantidad de horas que ha funcionado el faro: ")
    tiempo_minutos = ingresar_entero ("Ingrese la cantidad de minutos (sin contar las horas anteriores) que ha funcionado el faro : ")
    tiempo_total = calcular_tiempo_minutos (tiempo_horas, tiempo_minutos)
    destellos = calcular_destellos_minuto (tiempo_total, DESTELLOS_MINUTO)
    mensaje = generar_mensaje (destellos, tiempo_horas, tiempo_minutos, DESTELLOS_MINUTO)
    mostrar_mensaje(mensaje)


def calcular_tiempo_minutos (tiempo_horas, tiempo_minutos):
    tiempo = (tiempo_horas * 60) + tiempo_minutos
    return tiempo


def calcular_destellos_minuto (tiempo_total, destellos_minuto):
    destellos = tiempo_total * destellos_minuto
    return destellos


def generar_mensaje (destellos, tiempo_horas, tiempo_minutos, destellos_minuto):
    mensaje = (f"""Apreciado público, el planetario le informa que el faro produce {destellos} 
  destellos para {tiempo_horas} horas y {tiempo_minutos} minutos, teniendo en cuenta que son
                 {DESTELLOS_MINUTO} destellos por minuto""")
    
    return mensaje



main()