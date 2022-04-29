package com.ferreteria.controller;

import com.ferreteria.dao.OfertaDao;
import com.ferreteria.model.Oferta;
import com.ferreteria.services.OfertaService;
import com.ferreteria.services.CategoriaService;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class OfertaController {
    
    @Autowired
    private OfertaService ofertaService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/oferta/listado")
    public String inicio(Model model){
        var ofertas = ofertaService.getOfertas(false);
        model.addAttribute("ofertas",ofertas);
        return "/oferta/listado";
    }
    
    @GetMapping("/oferta/nuevo")
    public String nuevoOferta(Oferta oferta,Model model){
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
        return "oferta/modificar";
    }
    
    @PostMapping("oferta/guardar")
    public String guardarOferta(Oferta oferta){
        ofertaService.save(oferta);
        return "redirect:/oferta/listado";
    }
    
    @GetMapping("oferta/modificar/{idOferta}")
    public String modificarOferta(Oferta oferta, Model model){
        oferta = ofertaService.getOferta(oferta);
        model.addAttribute("oferta", oferta);
        return "oferta/modificar"; 
    }
    
    @GetMapping("/oferta/eliminar/{idOferta}")
    public String eliminarOferta(Oferta oferta){
        ofertaService.delete(oferta);
        return "redirect:/oferta/listado"; 
    }
}
