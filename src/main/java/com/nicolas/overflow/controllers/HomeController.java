package com.nicolas.overflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nicolas.overflow.models.Answer;
import com.nicolas.overflow.models.NewQuestion;
import com.nicolas.overflow.models.Question;
import com.nicolas.overflow.services.AppService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	private AppService service;

	// MAPPING
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/questions")
	public String dashboard(Model model) {
		List<Question> questions = service.findAllQuestions();
		model.addAttribute("questions", questions);
		return "indexQuestions";
	}

	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") NewQuestion q) {
		return "newQuestion";
	}

	@RequestMapping(value = "/questions", method = RequestMethod.POST)
	public String createQuestion(@Valid @ModelAttribute("question") NewQuestion q, BindingResult result) {
		if (result.hasErrors()) {
			return "newQuestion";
		} else {
			service.createQuestion(q);
			return "redirect:/questions";
		}
	}

	@RequestMapping("/questions/{id}")
	public String show(@PathVariable("id") Long id, @ModelAttribute("ans") Answer answer, Model model) {
		Question question = service.findQuestion(id);
		model.addAttribute("question", question);
		return "showQuestion";
	}

	@RequestMapping(value = "/answers", method = RequestMethod.POST)
	public String createAnswer(
			@Valid @ModelAttribute("ans") Answer answer,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			Question question = service.findQuestion(answer.getQuestion().getId());
			model.addAttribute("question", question);
			return "showQuestion";
		} else {
			service.createAnswer(answer);
			return "redirect:/questions/" + answer.getQuestion().getId();
		}
	}
}
