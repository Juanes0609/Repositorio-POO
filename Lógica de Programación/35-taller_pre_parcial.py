from apoyo import mostrar_mensaje, ingresar_entero, ingresar_texto
from inventario import crear_datos_inventario, convertir_producto_mensaje, crear_producto_inventario


# Ejercicio 1

def main():
    producto = crear_producto_inventario("A123", "Memorias USB 32 MB", 10)
    mostrar_mensaje(producto)


def crear_producto_inventario(codigo, nombre, cantidad):
    producto = {"codigo": codigo,
                "nombre": nombre,
                "cantidad": cantidad
                }
    return producto




# Ejercicio 2

def main():
    producto = crear_producto_inventario("A123", "Memorias USB 32 MB", 10)
    mensaje = convertir_producto_mensaje(producto)
    mostrar_mensaje(mensaje)


def crear_producto_inventario(codigo, nombre, cantidad):
    producto = {"A123": codigo,
                "Memorias USB 32 MB": nombre,
                "10": cantidad
                }
    return producto


def convertir_producto_mensaje(producto):
    mensaje = ""
    if producto != None:
        codigo, nombre, cantidad = producto
        mensaje = f"{codigo:5} : {nombre:20} {cantidad:4}"
    else:
        mensaje = "No se encontró el producto"

    return mensaje




# Ejercicio 3

def main():
    producto = ingresar_producto_inventariado(
        "Datos de un producto del inventario")
    mostrar_mensaje(producto)


def ingresar_producto_inventariado(titulo):
    mostrar_mensaje(titulo)
    producto = {
        "codigo": ingresar_texto("Ingrese el codigo: "),
        "nombre": ingresar_texto("Ingrese el nombre: "),
        "cantidad": ingresar_entero("Ingrese la cantidad: ")

    }
    print(producto)




# Ejercicio 4

def main():
    inventario = crear_datos_inventario()
    mostrar_mensaje(inventario)


def crear_datos_inventario():
    producto = {
        "USB32": crear_producto_inventario("USB32", "Memoria USB de 32 GB", 5),
        "CAB12": crear_producto_inventario("CAB12", "Cable de HDMI a VGA", 8),
        "SSD30": crear_producto_inventario("SSD30", "Unidad SSD de 300 GB", 0),
        "LAP01": crear_producto_inventario("LAP01", "Laptop i9 con 64 GB", 1) 
    }
    print (producto)




# Ejercicio 5

def main():
    inventario = crear_datos_inventario()
    mensaje = convertir_inventario_mensaje(inventario)
    mostrar_mensaje(mensaje)


def convertir_inventario_mensaje(inventario):
    mensaje = ""
    for llave_producto in inventario.keys():
        producto = inventario[llave_producto]
        mensaje += convertir_producto_mensaje(producto)
        
    return mensaje


# Ejercicio 6

def main():
    inventario = crear_datos_inventario()
    codigo_interes = ingresar_texto("Ingrese código: ")
    hay_producto = verificar_existencia(inventario, codigo_interes)
    mensaje = generar_mensaje_inventario(hay_producto)
    mostrar_mensaje(mensaje)


def verificar_existencia(inventario, codigo_interes):
    existencia = False
    if codigo_interes in inventario.keys():
        producto_interes = inventario[codigo_interes]
        cantidad = producto_interes["cantidad"]
        if cantidad > 0:
            existencia = True
    return existencia



def generar_mensaje_inventario(hay_producto):
    mensaje = ""
    if hay_producto != False:
        mensaje += "El producto está en existencia"
    else:
        mensaje += "El producto no está en el inventario o sin existencias"
    return mensaje


# Ejercicio 7

def main():
    inventario = crear_datos_inventario()
    productos_a_comprar = filtrar_productos_a_comprar(inventario)
    mostrar_mensaje(productos_a_comprar)

def filtrar_productos_a_comprar(inventario):
    productos_interes = []
    for codigo, producto in inventario.items():
        cantidad = producto["cantidad"]
        if cantidad < 3:
            productos_interes.append((codigo, cantidad))
    return productos_interes


# Ejercicio 8

def main():
    inventario = crear_datos_inventario()
    productos_a_comprar = filtrar_productos_a_comprar(inventario)
    mensaje =  convertir_productos_comprar_mensaje(productos_a_comprar)
    mostrar_mensaje(mensaje)


def filtrar_productos_a_comprar(inventario):
    productos_interes = []
    for codigo, producto in inventario.items():
        cantidad = producto["cantidad"]
        if cantidad < 3:
            productos_interes.append((codigo, cantidad))
    return productos_interes


def convertir_productos_comprar_mensaje(productos_a_comprar):
    mensaje = []
    for codigo, cantidad in productos_a_comprar:
        mensaje.append(f"Del producto {codigo} solamente hay {cantidad}")
        if productos_a_comprar == None:
            mensaje += "No se encontró producto"
    return mensaje 
        
  
main()
