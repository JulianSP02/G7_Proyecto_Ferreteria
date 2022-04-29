package com.ferreteria.services;

import com.ferreteria.model.Oferta;
import java.util.List;

public interface OfertaService {
    
    public List<Oferta> getOfertas(boolean activo);
    
    public void save(Oferta oferta);
    
    public void  delete(Oferta oferta);
    
    public Oferta getOferta(Oferta oferta);
    
}
