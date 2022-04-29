package com.ferreteria.services;

import com.ferreteria.model.Destacado;
import java.util.List;

public interface DestacadoService {
    
    public List<Destacado> getDestacados(boolean activo);
    
    public void save(Destacado destacado);
    
    public void  delete(Destacado destacado);
    
    public Destacado getDestacado(Destacado destacado);
    
}
