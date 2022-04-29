package com.ferreteria.services;
import com.ferreteria.dao.DestacadoDao;
import com.ferreteria.model.Destacado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DestacadoServiceImpl implements DestacadoService {
    
    @Autowired
    private DestacadoDao destacadoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Destacado> getDestacados(boolean activo) {
        var lista = (List<Destacado>) destacadoDao.findAll();
        if(activo){
            
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional
    public void save(Destacado destacado) {
        destacadoDao.save(destacado);
    }

    @Override
    @Transactional
    public void delete(Destacado destacado) {
        destacadoDao.delete(destacado);
    }

    @Override
    @Transactional(readOnly = true)
    public Destacado getDestacado(Destacado destacado) {
        return destacadoDao.findById(destacado.getIdDestacado()).orElse(null);
    }
    
}
