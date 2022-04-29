package com.ferreteria.services;
import com.ferreteria.dao.OfertaDao;
import com.ferreteria.model.Oferta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OfertaServiceImpl implements OfertaService {
    
    @Autowired
    private OfertaDao ofertaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Oferta> getOfertas(boolean activo) {
        var lista = (List<Oferta>) ofertaDao.findAll();
        if(activo){
            
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional
    public void save(Oferta oferta) {
        ofertaDao.save(oferta);
    }

    @Override
    @Transactional
    public void delete(Oferta oferta) {
        ofertaDao.delete(oferta);
    }

    @Override
    @Transactional(readOnly = true)
    public Oferta getOferta(Oferta oferta) {
        return ofertaDao.findById(oferta.getIdOferta()).orElse(null);
    }
    
}
