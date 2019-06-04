package modelo;

public class ProductoFinal {

    //Atributos
    private String idProductoFinal;
    private String nombreProducto;
    private int cantidad;
    private double precio;
    private String talla;
    private String caracteristicaPrincipal;//Falta

    //Constructores
    public ProductoFinal(String idProductoFinal, String caracteristicaPrincipal, String nombreProducto, String talla, int cantidad, double precio) {
        this.idProductoFinal = idProductoFinal;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.talla = talla;
        this.caracteristicaPrincipal = caracteristicaPrincipal;
    }

    //GETTERS
    public String getIdProductoFinal() { return idProductoFinal; }
    public String getNombreProducto() { return nombreProducto; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }
    public String getTalla() { return talla; }
    public String getCaracteristicaPrincipal() { return caracteristicaPrincipal; }

    //SETTERS
    public void setIdProductoFinal(String idProductoFinal) { this.idProductoFinal = idProductoFinal; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setTalla(String talla) { this.talla = talla; }
    public void setCaracteristicaPrincipal(String caracteristicaPrincipal) { this.caracteristicaPrincipal = caracteristicaPrincipal; }
}