/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Implementación del DAO con persistencia en archivo txt
package dao;

import entidad.Producto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    private final String ARCHIVO = "productos.txt";

    @Override
    public void guardar(Producto producto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(producto.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar");
        }
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");
                productos.add(new Producto(
                        Integer.parseInt(d[0]),
                        d[1],
                        Integer.parseInt(d[2]),
                        Double.parseDouble(d[3])
                ));
            }
        } catch (IOException e) {
            System.out.println("Error al listar");
        }
        return productos;
    }

    @Override
    public Producto buscarPorId(int id) {
        for (Producto p : listar()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Producto producto) {
        eliminar(producto.getId());
        guardar(producto);
    }

    @Override
    public void eliminar(int id) {
        List<Producto> productos = listar();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Producto p : productos) {
                if (p.getId() != id) {
                    bw.write(p.toString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al eliminar");
        }
    }
}
