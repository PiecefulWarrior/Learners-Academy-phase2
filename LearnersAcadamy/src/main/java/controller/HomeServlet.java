package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AssignDao;
import dao.ClassDao;
import dao.SubjectDao;
import dao.TeacherDao;
import models.ClassStandard;
import models.Students;
import models.Subjects;
import models.Teachers;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/")
public class HomeServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    public SubjectDao subjectDao;   
    public TeacherDao teacherDao;
	public ClassDao classDao;
	public AssignDao assignDao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		subjectDao = new SubjectDao();
		teacherDao = new TeacherDao();
		classDao   = new ClassDao();
		assignDao  = new AssignDao();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
		
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	String action = request.getServletPath();
	//PrintWriter out =  response.getWriter();
	//out.print(action+"here you are");
	
	switch (action) {
	case "/deleteClass":
		deleteClass(request, response);
		break;
	case "/deleteSubject":
		deleteSubject(request, response);
		break;
	case "/deleteTeacher":
		deleteTeacher(request, response);
		break;
	case "/admin":
		adminOperations(request, response);
		break;
	case "/addSubject":
		subjectOperations(request, response);
		break;
	case "/addClass":
		classOperations(request, response);
		break;
	case "/addTeachers":
		teachersOperation(request, response);
		break;
	case "/addStudent":
		studentOperation(request, response);
		break;
	case "/assignSubject":
		assignSubject(request, response);
		break;
	case "/assignClass":
		assignClass(request, response);
		break;
	case "/assignTeacher":
		assignTeacher(request, response);
		break;
	case "/classReport":
		classReport(request, response);
		break;
	default:
		loginPage(request, response);
		break;
	
	}
}
	private void deleteClass(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		classDao.DeleteClass(id);
		try {
			response.sendRedirect("addClass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		teacherDao.DeleteTeacher(id);
		try {
			response.sendRedirect("addTeachers");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		subjectDao.DeleteSubject(id);
		try {
			response.sendRedirect("addSubject");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void loginPage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void adminOperations(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String admin = request.getParameter("admin");
		String pass = request.getParameter("pass");
		RequestDispatcher rd = null;
		if(admin.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {
			
			rd = request.getRequestDispatcher("adminOperations.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			rd = request.getRequestDispatcher("/");
			try {
				rd.include(request, response);
				//PrintWriter out = response.getWriter();
				//out.print("You have entered the wrong credentials...");
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}


	private void classReport(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void assignTeacher(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void assignClass(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<ClassStandard> listClasses = classDao.getAllClasses();
		List<Subjects> listSubjects = subjectDao.getAllSubjects();
		//List<String> teachers = assignDao.getAllTeachers();
		
		request.setAttribute("listSubjects", listSubjects);
		request.setAttribute("listClasses", listClasses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assignClass.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void assignSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	List<Subjects> listUser = subjectDao.getAllSubjects();
	//	request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addStudent.jsp");
		dispatcher.forward(request, response);
		
	}

	private void studentOperation(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void teachersOperation(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String teacher = request.getParameter("teacher");
		String mail = request.getParameter("mail");
		if(teacher!=null && mail!=null) {
			teacherDao.addTeachers(teacher,mail);
			
		}
		List<Teachers> teachList =teacherDao.getAllTeachers();
		request.setAttribute("teachList", teachList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addTeacher.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void classOperations(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String className = request.getParameter("className");
		if(className!=null) {
			
			classDao.addClasses(className);
			
		}
		List<ClassStandard> classList=classDao.getAllClasses();
		request.setAttribute("classList", classList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addClass.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void subjectOperations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subject = request.getParameter("subject");
		if(subject!=null) {
			subjectDao.addSubject(subject);
			
		}
		List<Subjects> subList =subjectDao.getAllSubjects();
		request.setAttribute("subList", subList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addSubject.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
