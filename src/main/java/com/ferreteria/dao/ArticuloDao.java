package com.ferreteria.dao;

import com.ferreteria.model.Articulo;
import org.springframework.data.repository.CrudRepository;

public interface ArticuloDao extends CrudRepository<Articulo,Long>{
    
    
}
