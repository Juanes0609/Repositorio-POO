"""
Programa que muestra un mensaje segun la altura de un jugador en centímetros
Autor: Area de Progrmación UQ
Fecha: Marzo 2024
Licencia: GNU GPL v3
"""


from apoyo import ingresar_entero, mostrar_mensaje, convertir_cms_mts


def main():
    altura = ingresar_entero("Ingrese la altura del jugador en centimetros: ")
    altura_metros = convertir_cms_mts(altura)
    mensaje_altura = determinar_mensaje_altura(altura_metros)
    mensaje = generar_mensaje(altura, mensaje_altura)
    mostrar_mensaje(mensaje)



def determinar_mensaje_altura(altura):
    if altura <1.80:
        mensaje = "Base"
    elif altura <=1.90:
        mensaje = "Escolta"
    elif altura <= 2.00:
        mensaje = "Alero"
    elif altura <= 2.10:
        mensaje = "Ala Pívot"
    else:
        mensaje = None
        
    
    return mensaje
    

def generar_mensaje(altura, mensaje_altura):
    if mensaje_altura:
        mensaje = f"Con su altura de {altura} cm puede jugar de {mensaje_altura}"

    else: 
        mensaje = "Su altura supera los estándares"

    
    return mensaje


main()