package himedia.kdt.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import learnbyteaching.emaillist.dao.EmailListDao;
import learnbyteaching.emaillist.dao.EmailListDaoImpl;
import learnbyteaching.emaillist.vo.EmailVo;

@WebServlet(name = "Emaillist", urlPatterns = "/el")
public class EmaillistServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");

		// 만약 a=form -> form.jsp로 요청 제어권 이전
		if ("form".equals(actionName)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/form.jsp");
			rd.forward(req, resp);
		} else if ("delete".equals(actionName)) {
			EmailListDao dao = new EmailListDaoImpl(dbUser, dbPass);
			Long no = Long.valueOf(req.getParameter("no"));

			dao.delete(no);

			// 게시물 홈으로 Redirect
			resp.sendRedirect(req.getContextPath() + "/el");

		} else {
			// DAO로부터 데이터 객체를 불러옴
			EmailListDao dao = new EmailListDaoImpl(dbUser, dbPass);
			List<EmailVo> list = dao.getList();

			// 요청에 속성으로 추가
			req.setAttribute("list", list);

			// 목록 표시 페이지 index.jsp로 요청을 전달
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String lastName = req.getParameter("ln");
		String firstName = req.getParameter("fn");
		String email = req.getParameter("email");

		EmailListDao dao = new EmailListDaoImpl(dbUser, dbPass);
		EmailVo vo = new EmailVo(lastName, firstName, email);

		boolean success = dao.insert(vo);

		if (success) {
			System.out.println("INSERT SUCCESS!");
		} else {
			System.err.println("INSERT FAILED!");
		}

		// 목록 페이지로 리다이렉트
		resp.sendRedirect(req.getContextPath() + "/el");
	}

}
