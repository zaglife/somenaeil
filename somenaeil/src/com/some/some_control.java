package com.some;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

import com.dm.chat;


/**
 * Servlet implementation class some_control
 */
@WebServlet("/some_control")
public class some_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, some_able> map = new HashMap<>();
       
    public some_control() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// web root path 구하기
		String path = this.getClass().getResource("").getPath();
		path = path.substring(0, path.indexOf("classes"));
		path += config.getInitParameter("ConfigFile");
		
    	Properties prop = new Properties();
    	try (FileReader fs = new FileReader(path)){
    		prop.load(fs);
    		System.out.println("some.properties 파일 읽기 성공");
    	}catch(IOException e) {
    		e.printStackTrace();
    		System.out.println("some.properties 파일 읽기 실패");
    	}
    	Iterator key = prop.keySet().iterator();
    	while(key.hasNext()) {
    		String cmd = (String)key.next();
    		String value = prop.getProperty(cmd);
    		try {
    			Class<?> hclass = Class.forName(value);
    			some_able hinst =(some_able)hclass.newInstance();
    			map.put(cmd, hinst);
    		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
    			System.out.println("핸들러 클래스 문제있다.");
    		}
    	}
	}

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request,response,"dm.some");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request,response,"dm.some");
	}

	protected void action(HttpServletRequest request, HttpServletResponse response, String cmd) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		some_able hd = map.get(cmd);
		String view=null;
		view = hd.active(request, response);
		if(view==null) {
			response.sendRedirect("index.jsp");
		}else {
			if (!view.contains("#")) {
				if(request.getAttribute("chatlist")!=null)
					System.out.println("c"+((ArrayList<chat>)request.getAttribute("chatlist")).get(0).getChatcontent());
				RequestDispatcher dsp = request.getRequestDispatcher(view);
				dsp.forward(request, response);
			}
		}
	}

	
	


}
