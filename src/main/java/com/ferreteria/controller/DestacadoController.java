package com.ferreteria.controller;

import com.ferreteria.dao.DestacadoDao;
import com.ferreteria.model.Destacado;
import com.ferreteria.services.DestacadoService;
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
public class DestacadoController {
    
    @Autowired
    private DestacadoService destacadoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/destacado/listado")
    public String inicio(Model model){
        var destacados = destacadoService.getDestacados(false);
        model.addAttribute("destacados",destacados);
        return "/destacado/listado";
    }
    
    @GetMapping("/destacado/nuevo")
    public String nuevoDestacado(Destacado destacado,Model model){
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
        return "destacado/modificar";
    }
    
    @PostMapping("destacado/guardar")
    public String guardarDestacado(Destacado destacado){
        destacadoService.save(destacado);
        return "redirect:/destacado/listado";
    }
    
    @GetMapping("destacado/modificar/{idDestacado}")
    public String modificarDestacado(Destacado destacado, Model model){
        destacado = destacadoService.getDestacado(destacado);
        model.addAttribute("destacado", destacado);
        return "destacado/modificar"; 
    }
    
    @GetMapping("/destacado/eliminar/{idDestacado}")
    public String eliminarDestacado(Destacado destacado){
        destacadoService.delete(destacado);
        return "redirect:/destacado/listado"; 
    }
}
