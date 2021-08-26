package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TradeController {

    private static Logger logger = LoggerFactory.getLogger(TradeController.class);

    // Inject Trade service
    @Autowired
    private TradeRepository tradeRepository;

    @RequestMapping("/trade/list")
    public String home(Model model) {
        // find all Trade, add to model
        logger.info("Response : Trades were found");
        model.addAttribute("trades", tradeRepository.findAll());
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade bid) {
        logger.info("Response : Add trade form was found");
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        // check data valid and save to db, after saving return Trade list
        if (!result.hasErrors()) {
            logger.info("Response : Trade was add");
            tradeRepository.save(trade);
            model.addAttribute("trades", tradeRepository.findAll());
            return "redirect:/trade/list";
        }
        return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // get Trade by Id and to model then show to the form
        logger.info("Response : Update form for trade {} was found", id);
        Trade trade = tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id:" + id));
        model.addAttribute("trades", trade);
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
        // check required fields, if valid call service to update Trade and return Trade list
        if (result.hasErrors()) {
            return "trade/update";
        }
        logger.info("Response : Trade {} was update", id);
        tradeRepository.save(trade);
        model.addAttribute("trades", tradeRepository.findAll());
        return "redirect:/trade/list";
    }

    @GetMapping("/tradeList/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        // Find Trade by Id and delete the Trade, return to Trade list
        logger.info("Response : Trade {} was delete", id);
        Trade trade = tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id" + id));
        tradeRepository.delete(trade);
        model.addAttribute("trades", tradeRepository.findAll());
        return "redirect:/trade/list";
    }

}
