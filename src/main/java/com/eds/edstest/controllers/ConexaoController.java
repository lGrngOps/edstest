package com.eds.edstest.controllers;

import com.eds.edstest.dto.VeiculoDTO;
import com.eds.edstest.dto.VeiculoFormAdd;
import com.eds.edstest.dto.VeiculoFormUpdate;
import com.eds.edstest.services.VeiculoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/listar")
    public String listarVeiculo(Model model) {
        model.addAttribute("veiculo", veiculoService.findAllVeiculos());
        return "/consulta";
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