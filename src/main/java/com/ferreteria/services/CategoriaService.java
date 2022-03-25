package com.ferreteria.services;

import com.ferreteria.model.Categoria;
import java.util.List;

public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activo);
    
    public void save(Categoria categoria);
    
    public void  delete(Categoria categoria);
    
    public Categoria getCategoria(Categoria categoria);
    
}
