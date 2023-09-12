package com.eds.edstest.controllers;

import com.eds.edstest.dto.VeiculoDTO;
import com.eds.edstest.dto.VeiculoFormAdd;
import com.eds.edstest.dto.VeiculoFormUpdate;
import com.eds.edstest.entities.Veiculos;
import com.eds.edstest.services.VeiculoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;
import java.util.Date;

@Controller
@RequestMapping("/")
public class ConexaoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/novo")
    public String adicionarVeiculo(Model model) {
        model.addAttribute("veiculoFormAdd", new VeiculoFormAdd());
        return "/cadastro";
    }

    @PostMapping("/salvar")
    public String salvarVeiculo(@Valid VeiculoFormAdd veiculoFormAdd, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            attributes.addFlashAttribute("mensagem");
            return "/cadastro";
        }
        veiculoFormAdd.setCreated(Date.from(Instant.now()));
        veiculoFormAdd.setUpdated(Date.from(Instant.now()));
        veiculoService.addVeiculo(veiculoFormAdd);
        attributes.addFlashAttribute("mensagem","Veículo cadastrado com sucesso!");
        return "redirect:/novo";
    }

    // ORIGINAL
    //@GetMapping("/listar")
    //public String listarVeiculo(Model model) {
    //    model.addAttribute("veiculo", veiculoService.getVeiculos());
    //    return "/consulta";
    //}

    @GetMapping("/listar")
    public String listarVeiculo(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<Veiculos> page = veiculoService.getVeiculos(pageable);
        model.addAttribute("page", page);
        return "/consulta";
    }


    //@GetMapping("/list")
    //public String paginacao(){
    //    Page<Veiculos> page = veiculoService.listAll(PageRequest.of(0,5));
    //    return Page<Veiculos> page = page.getContent().toString();
    //    return page.getContent().toString();
    //}

    //@GetMapping("/testar")
    //public ResponseEntity<Page<Veiculos>> list(Pageable pageable){
    //    return ResponseEntity.ok(veiculoService.findAllVeiculos(pageable));
    //}


    //@GetMapping("/buscar") *** ORIGINAL ****
    //public String buscarVeiculo(@RequestParam("marca") String marca, Model model){
    //    model.addAttribute("veiculo", veiculoService.searchVeiculo(marca.trim().toUpperCase()));
    //    return "/busca";
    //}

    @GetMapping("/buscar")
    public String buscarVeiculo(@PageableDefault(size = 5) @RequestParam("marca") String marca, Model model){
        model.addAttribute("veiculo", veiculoService.searchVeiculo(marca.trim().toUpperCase()));
        return "/busca";
    }

    @GetMapping("/apagar/{id}")
    public String apagarVeiculo(@PathVariable("id") long id) {
        VeiculoDTO veiculoDTO = veiculoService.findVeiculoById(id);
        veiculoService.deleteById(id);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarVeiculo(@PathVariable("id") long id, Model model) {
        VeiculoDTO veiculoVelho = veiculoService.findVeiculoById(id);
        model.addAttribute("veiculoVelho",veiculoVelho);
        return "/alteracao";
    }

    @PostMapping("/editar/{id}")
    public String editarVeiculo(@PathVariable("id") long id,@Valid VeiculoFormUpdate veiculoFormUpdate, BindingResult problem, RedirectAttributes attributes) {
        if (problem.hasErrors()) {
            attributes.addFlashAttribute("xabu","Deu Xabu. Revise suas alterações");
            return "redirect:/editar/{id}";
        }
        veiculoFormUpdate.setUpdated(Date.from(Instant.now()));
        veiculoService.updateById(veiculoFormUpdate, id);
        attributes.addFlashAttribute("mensagem","Alterações realizadas com sucesso!");
        return "redirect:/editar/{id}";
    }
}