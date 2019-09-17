package safefood.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import safefood.controller.SafeFoodController;

@WebFilter("*.safefood")
public class SafeFoodFilter implements Filter {
	SafeFoodController controller;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		req.setCharacterEncoding("utf-8");

		String reqString = req.getServletPath();
		if (reqString.equals("/main.safefood")) {
			controller.index(req, res);
		} else if (reqString.equals("/login.safefood")) {
			controller.login(req, res);
		} else if (reqString.equals("/loginProcess.safefood")) {
			controller.loginProcess(req, res);
		} else if (reqString.equals("/logout.safefood")) {
			controller.logout(req, res);
		} else if (reqString.equals("/foodlist.safefood")) {
			controller.list(req, res);
		} else if (reqString.equals("/detail.safefood")) {
			controller.detail(req, res);
		} else if (reqString.equals("/search.safefood")) {
			controller.search(req, res);
		} else if (reqString.equals("/detailsearch.safefood")) {
			controller.detailsearch(req, res);
		} else if (reqString.equals("/join.safefood")) {
			controller.join(req, res);
		} else if (reqString.equals("/joinProcess.safefood")) {
			controller.joinProcess(req, res);
		} else if(reqString.equals("/allergy.safefood")) {
			controller.allergy(req, res);
		} else if(reqString.equals("/allergyProcess.safefood")) {
			controller.allergyProcess(req, res);
		} else if(reqString.equals("/eats.safefood")) {
			controller.eats(req, res);
		} else if(reqString.equals("/myeats.safefood")) {
			controller.myeats(req, res);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		controller = new SafeFoodController();
	}

}
