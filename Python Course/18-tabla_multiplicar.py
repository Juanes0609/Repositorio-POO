"""
"""

from apoyo import ingresar_entero_rango, mostrar_mensaje


MINIMO_VALOR_TABLA = 0
MAXIMO_VALOR_TABLA = 10
TABLA_MINIMA = 0
TABLA_MAXIMA = 10
def main():
    numero_tabla = ingresar_entero_rango("Ingrese la tabla a generar: ", TABLA_MINIMA, TABLA_MAXIMA)
    mensaje = generar_mensaje (numero_tabla, MINIMO_VALOR_TABLA, MAXIMO_VALOR_TABLA)
    mostrar_mensaje(mensaje)


def generar_mensaje(numero_tabla, valor_minimo, valor_maximo):
    mensaje = f"\nTABLA DE MULTIPLICAR DEL {numero_tabla}\n\n"
    for i in range (valor_minimo, valor_maximo+1):
        producto = numero_tabla * i
        mensaje += f"{numero_tabla:2d} x {i:2d} = {producto}\n"
    return mensaje

main()