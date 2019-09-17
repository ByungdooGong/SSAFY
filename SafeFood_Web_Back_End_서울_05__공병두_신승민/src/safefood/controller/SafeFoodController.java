package safefood.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import safefood.dao.MemberDao;
import safefood.dao.MemberDaoImpl;
import safefood.service.FoodService;
import safefood.service.FoodServiceImpl;
import safefood.vo.Food;
import safefood.vo.FoodPageBean;
import safefood.vo.Member;

public class SafeFoodController {
	MemberDao mdao;

	public SafeFoodController() {
		mdao = new MemberDaoImpl();
//		mdao.add(new Member("ssafy@naver.com", "1111", "ssafy", "010-1234-5678", null, new ArrayList<>()));
	}

	public void index(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/main.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void login(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/login.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void loginProcess(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("id");
		String pass = req.getParameter("pwd");

		if (mdao.search(id, pass)) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/view/main.jsp");
			try {
				dispatcher.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				res.sendRedirect("/view/login.safefood");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/main.jsp");
		try {
			HttpSession session = req.getSession(false);
			session.invalidate();
			dispatcher.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void list(HttpServletRequest req, HttpServletResponse res) {
		FoodService fs = new FoodServiceImpl();
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		req.setAttribute("id", id);
		List<Food> li = fs.searchAll(new FoodPageBean());
		req.setAttribute("mode", "product");
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/list.jsp");
		try {
			session.setAttribute("list", li);
			dispatcher.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void detail(HttpServletRequest req, HttpServletResponse res) {
		FoodService fs = new FoodServiceImpl();
		String code = req.getParameter("code");
		Food f = fs.search(Integer.parseInt(code));
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		req.setAttribute("id", id);
		req.setAttribute("f", f);
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/detail.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void search(HttpServletRequest req, HttpServletResponse res) {
		FoodService fs = new FoodServiceImpl();
		String word = req.getParameter("word");
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		req.setAttribute("id", id);

		List<Food> li = fs.searchAll(new FoodPageBean("name", word, null, 1));

		req.setAttribute("list", li);
		req.setAttribute("mode", "product");
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/list.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void detailsearch(HttpServletRequest req, HttpServletResponse res) {
		FoodService fs = new FoodServiceImpl();
		String word = req.getParameter("word");
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		String key = req.getParameter("key");
		req.setAttribute("id", id);

		List<Food> li = fs.searchAll(new FoodPageBean(key, word, null, 1));

		req.setAttribute("list", li);
		req.setAttribute("mode", "product");
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/list.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void join(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/join.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void joinProcess(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("id");
		String pass = req.getParameter("pwd");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String[] allergies = req.getParameterValues("allergy");

		mdao.add(new Member(id, pass, name, phone, allergies));

		// main 화면으로 돌아가기
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/login.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void allergy(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		req.setAttribute("id", id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/allergy.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
		}
	}

	public void allergyProcess(HttpServletRequest req, HttpServletResponse res) {
//		HttpSession session = req.getSession(false);
//		String id = (String) session.getAttribute("id");
//		req.setAttribute("id", id);
//		String[] allergies = req.getParameterValues("allergy");
////		System.out.println(id);
//		mdao.search(id).setAllergies(allergies);
//		System.out.println(Arrays.toString(mdao.search(id).getAllergies()));
//		RequestDispatcher dispatcher = req.getRequestDispatcher("view/main.jsp");
//		try {
//			dispatcher.forward(req, res);
//		} catch (Exception e) {
//		}
	}

	public void eats(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
//		req.setAttribute("id", id);
		String code = req.getParameter("code");
		mdao.eats(id, code);

		FoodService fs = new FoodServiceImpl();
		Food f = fs.search(Integer.parseInt(req.getParameter("code")));
		String fallergy = f.getAllergy();
		Member m = mdao.search(id);
		String[] mallergy = m.getAllergies();
		boolean flag = false;
		System.out.println(fallergy);
		if (mallergy != null && fallergy != null) {
			for (int j = 0; j < mallergy.length; j++) {
				if (fallergy.contains(mallergy[j])) {
					flag = true;
				}
			}
		}

		if (flag) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("view/alert.jsp");
			try {
				dispatcher.forward(req, res);
			} catch (Exception e) {
			}
		} else {
			req.setAttribute("mode", "product");
			req.setAttribute("id", id);
			List<Food> li = fs.searchAll(new FoodPageBean(null, null, null, 1));

			req.setAttribute("list", li);
			req.setAttribute("mode", "product");
			RequestDispatcher dispatcher = req.getRequestDispatcher("view/list.jsp");
			try {
				dispatcher.forward(req, res);
			} catch (Exception e) {
			}
		}
	}

	public void myeats(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		req.setAttribute("id", id);
		FoodService fs = new FoodServiceImpl();
		List<String> myeats = mdao.myeats(id);
		List<Food> li = new LinkedList<>();
		for (String fid : myeats) {
			li.add(fs.search(Integer.parseInt(fid)));
		}
		req.setAttribute("list", li);
		req.setAttribute("mode", "my");
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/list.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
		}
	}

}
