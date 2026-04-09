/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import entidad.Producto;
import java.util.List;

public class ProductoService {

    private ProductoDAO dao = new ProductoDAOImpl();

    public void registrar(Producto producto) {
        if (producto.getCantidad() >= 0 && producto.getPrecio() > 0) {
            dao.guardar(producto);
        }
    }

    public List<Producto> listar() {
        return dao.listar();
    }

    public Producto buscar(int id) {
        return dao.buscarPorId(id);
    }

    public void actualizar(Producto producto) {
        dao.actualizar(producto);
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }
}
