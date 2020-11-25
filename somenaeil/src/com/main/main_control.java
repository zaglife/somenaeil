package com.main;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class main_control
 */
@WebServlet("/main_control")
public class main_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, main_able> map= new HashMap<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main_control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		String path= this.getClass().getResource("").getPath();
		path= path.substring(0,	path.indexOf("classes"));
		path+= config.getInitParameter("ConfigFile");
		
		Properties prop= new Properties();
		
		// 파일 읽기
		try(FileReader fs= new FileReader(path)) {
			prop.load(fs);
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("main_control - properties 파일 읽기 실패");
		}
		Iterator key= prop.keySet().iterator();
		while(key.hasNext()) {
			String cmd= (String)key.next();
			String value= prop.getProperty(cmd);
			try {
				Class<?> hclass= Class.forName(value);
				main_able hinst= (main_able)hclass.newInstance();
				map.put(cmd, hinst);
			} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e ) {
				System.out.println("main_control - 인터페이스 오류");
			}
		}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri= request.getRequestURI();	// 현재 접속 주소(전체)
		String cmd= uri.substring(uri.lastIndexOf("/")+1);
		
		if(cmd != null) {
			action(request, response, cmd);
		} else {
			// 첫페이지
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response, "index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response, "index.jsp");
	}
	
	protected void action(HttpServletRequest request, HttpServletResponse response, String cmd) throws ServletException, IOException {
		main_able hd= map.get(cmd);
		String view= null;
		view= hd.active(request, response);
		
		if(view == null) {
			RequestDispatcher dsp= request.getRequestDispatcher("index.jsp");
			dsp.forward(request, response);	
		} else {
			// 수정 필요
			RequestDispatcher dsp= request.getRequestDispatcher(view);
			dsp.forward(request, response);	
			// sendRedirect: request에 있는 요소들 다 삭제 = setAttribute() 무용지물
//			response.sendRedirect(view);
		}
	}
}
