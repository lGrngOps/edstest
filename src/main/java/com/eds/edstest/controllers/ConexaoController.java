package com.eds.edstest.controllers;

import com.eds.edstest.dto.VeiculoFormAdd;
import com.eds.edstest.services.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}