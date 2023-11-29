package com.projects.easymarket.persistence;

import com.projects.easymarket.persistence.crud.ProductoCrudRepository;
import com.projects.easymarket.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository    //También podríamos haber usado @Component pero este es apenas una generalización, entonces es mejor práctica usar @Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getProductsByCategoriaId(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombre(idCategoria);
    }

    public Optional<List<Producto>> getScarceItems(int cantidadMinima){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadMinima, true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

}
