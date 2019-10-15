package com.mvc.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.service.FoodService;
import com.mvc.vo.Food;
import com.mvc.vo.Member;

@Controller

public class SafeFoodController {
	@Autowired
	FoodService service;

	@RequestMapping(value = "/foodlist.safefood", method = RequestMethod.GET)
	public String list(Model model) {
		List<Food> list = service.searchAll(null);
		model.addAttribute("list", list);
		model.addAttribute("mode", "product");
		return "list";
	}

	public void login(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/login.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
		}
	}

	@RequestMapping(value = "/loginProcess.safefood", method = RequestMethod.GET)
	public String loginProcess(HttpSession session, String id, String pass) {
		if (service.findMember(id, pass)) {
			session.setAttribute("id", id);
			return "redirect:/index.safefood";
		} else {
			return "redirect:/login.safefood";
		}

	}

	@RequestMapping(value = "/logout.safefood", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index.safefood";
	}

	/*
	 * public void list(HttpServletRequest req, HttpServletResponse res) {
	 * FoodService fs = new FoodServiceImpl(); HttpSession session =
	 * req.getSession(false); String id = (String) session.getAttribute("id");
	 * req.setAttribute("id", id); List<Food> li = fs.searchAll(new FoodPageBean());
	 * req.setAttribute("mode", "product"); RequestDispatcher dispatcher =
	 * req.getRequestDispatcher("view/list.jsp"); try { session.setAttribute("list",
	 * li); dispatcher.forward(req, res); } catch (Exception e) { } }
	 */
	@RequestMapping(value = "/detail.safefood", method = RequestMethod.POST)
	public String detail(Model model, int code) {
		Food f = service.search(code);
		model.addAttribute("f", f);
		return "detail";
	}

	@RequestMapping(value = "/search.safefood", method = RequestMethod.GET)
	public String searchByName(Model model, String word) {
		List<Food> list = service.searchByName(word);
		model.addAttribute("list", list);
		model.addAttribute("mode", "product");
		return "list";
	}

	@RequestMapping(value = "/detailsearch.safefood", method = RequestMethod.GET)
	public String detailsearch(Model model, String key, String word) {
		List<Food> list = service.searchByKey(key, word);
		model.addAttribute("list", list);
		model.addAttribute("mode", "product");
		return "list";
	}

	@RequestMapping(value = "/joinProcess.safefood", method = RequestMethod.GET)
	public String joinProcess(String id, String pass, String name, String phone, String[] allergy) {
		service.add(new Member(id, pass, name, phone, allergy));

		return "redirect:/index.safefood";
	}

	@RequestMapping(value = "/eats.safefood", method = RequestMethod.POST)
	public String eats(HttpSession session, String code, Model model) {
		String id = (String) session.getAttribute("id");
		String allergiesInId[] = service.allergiesInId(id);
		String allergiesInFood = service.allergiesInFood(code);

		if (allergiesInFood != null) {
			for (int i = 0; i < allergiesInId.length; i++) {
				if (allergiesInFood.contains(allergiesInId[i])) {
					return "alert";
				}
			}
		}

		service.eats(id, code);
		List<Food> list = service.searchAll(null);
		model.addAttribute("list", list);
		model.addAttribute("mode", "product");
		return "list";
	}

	@RequestMapping(value = "/myeats.safefood", method = RequestMethod.GET)
	public String myeats(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		List<Food> list = service.myeats(id);
		model.addAttribute("mode", "my");
		model.addAttribute("list", list);
		return "list";
	}

	@RequestMapping(value = "/pick.safefood", method = RequestMethod.POST)
	public String pick(HttpSession session, Model model, int code) {
		String mid = (String) session.getAttribute("id");
		service.pick(mid, code);
		List<Food> list = service.searchAll(null);
		model.addAttribute("list", list);
		model.addAttribute("mode", "product");
		return "list";
	}

	@RequestMapping(value = "/mypick.safefood", method = RequestMethod.GET)
	public String mypick(HttpSession session, Model model) {
		String mid = (String) session.getAttribute("id");
		model.addAttribute("mode", "my");
		List<Food> list = service.mypick(mid);
		model.addAttribute("list", list);
		model.addAttribute("mode", "my");
		return "list";
	}
}
