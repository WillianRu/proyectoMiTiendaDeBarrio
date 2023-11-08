package org.example.entity;

public enum Category {
    ASEO_DE_HOGAR (1, "Aseo de Hogar "),
    BEBIDAS (2, "Bebidas"),
    CARNES_FRIAS_Y_CONGELADOS (3,"Carnes frias y Congelados"),
    CIGARRILLOS (4,"Cigarrillos"),
    CUIDADO_BEBE (5,"Cuidado Bebe"),
    CUIDADO_PERSONAL (6,"Cuidado Personal"),
    CUIDADO_ROPA (7,"Cuidado Ropa "),
    DESPENSA (8,"Despensa"),
    DROGERIA (9,"Drogeria"),
    DULCES_Y_POSTRES(10,"Dulces y Postres"),
    ELECTRODOMESTICOS(11,"Electrodomesticos"),
    HELADOS(12,"Helados"),
    HOGAR_Y_DECORACION(13,"Hogar y Decoracion "),
    ILUMINACION_Y_ELECTRICOS(14,"Iuminacion y Electricos"),
    LACTEO_HUEVOS_Y_REFRIGERADOS(15,"Lacteo/Huevos y refrigerados"),
    LIMPIEZA_COCINA (16,"Limpieza Cocina "),
    MASCOTAS(17,"Mascotas "),
    PANADERIA_Y_PASTELERIA(18,"Panaderia y Pasteleria"),
    PASABOCAS (19,"Pasabocas"),
    PRODUCTOS_CONGELADOS (20,"Productos Congelados"),
    VINOS_Y_LICORES(21,"Vinos y Licores"),
    DEFAULT_CATEGORY(22,"Por defecto");

    int id;
    String value;

    Category(int id, String value){
        this.id = id;
        this.value=value;
    }

    public String getValue(){return value;}
    public int getId() {return id;}
}
