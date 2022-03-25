package com.ferreteria.services;

import com.ferreteria.model.Articulo;
import java.util.List;

public interface ArticuloService {
    
    public List<Articulo> getArticulos(boolean activo);
    
    public void save(Articulo articulo);
    
    public void  delete(Articulo articulo);
    
    public Articulo getArticulo(Articulo articulo);
    
}
