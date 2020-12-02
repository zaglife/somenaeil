package com.post;

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
 * post & vote 서블렛
 * @author gagip
 *
 */
@WebServlet("/post_control")
public class post_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String, post_able> map = new HashMap<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public post_control() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// web root path 구하기
		String path = this.getClass().getResource("").getPath();
		path = path.substring(0, path.indexOf("classes"));
		path += config.getInitParameter("ConfigFile");
		
    	Properties prop = new Properties();
    	try (FileReader fs = new FileReader(path)){
    		prop.load(fs);
    	}catch(IOException e) {
    		e.printStackTrace();
    		System.out.println("post.properties 파일 읽기 실패");
    	}
    	Iterator key = prop.keySet().iterator();
    	while(key.hasNext()) {
    		String cmd = (String)key.next();
    		String value = prop.getProperty(cmd);
    		try {
    			Class<?> hclass = Class.forName(value);
    			post_able hinst =(post_able)hclass.newInstance();
    			map.put(cmd, hinst);
    		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
    			System.out.println("post_control - init 메소드 에러");
    		}
    	}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri= request.getRequestURI();
		String p= request.getContextPath();
		String cmd = uri.substring(p.length()+1);
		
		if(cmd!=null) {
			action(request,response,cmd);
		}else {
			//첫페이지에 필요한 내용 처리
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request,response,"write.post");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request,response,"write.post");
	}

	protected void action(HttpServletRequest request, HttpServletResponse response, String cmd) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		post_able hd = map.get(cmd);
		String view=null;
		view = hd.active(request, response);		
		
		if(view==null) {
			response.sendRedirect("index.jsp");
		}else {
			if (!view.endsWith("#")) {
				RequestDispatcher dsp = request.getRequestDispatcher(view);
				dsp.forward(request, response);
			}
			else {
				view = view.substring(0, view.length()-1);
				response.sendRedirect(view);
			}
		}
	}
}
