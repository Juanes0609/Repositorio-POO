def crear_producto_inventario(codigo, nombre, cantidad):
    producto = {"codigo": codigo,
                "nombre": nombre,
                "cantidad": cantidad
                }
    return producto


def crear_datos_inventario():
    producto = {
        "USB32": crear_producto_inventario("USB32", "Memoria USB de 32 GB", 5),
        "CAB12": crear_producto_inventario("CAB12", "Cable de HDMI a VGA", 8),
        "SSD30": crear_producto_inventario("SSD30", "Unidad SSD de 300 GB", 0),
        "LAP01": crear_producto_inventario("LAP01", "Laptop i9 con 64 GB", 1)
    }
    return producto


def convertir_producto_mensaje(producto):
        codigo = producto["codigo"]
        nombre = producto["nombre"]
        cantidad = producto["cantidad"]
        mensaje = f"{codigo:5} : {nombre:20} {cantidad:4}\n"
        return mensaje


def crear_producto_inventario(codigo, nombre, cantidad):
    producto = {"codigo": codigo,
                "nombre": nombre,
                "cantidad": cantidad
                }
    return producto