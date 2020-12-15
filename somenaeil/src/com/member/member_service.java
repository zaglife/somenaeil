package com.member;



import static com.common.DBUtil.*;

import java.net.URLDecoder;
import java.sql.Connection;
import java.util.ArrayList;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.noti.noti_dao;
import com.post.post;
import com.post.post_dao;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class member_service {
	private  HttpServletRequest request;

	public member_service(HttpServletRequest request) { 
		this.request= request;
	}
	

	public void join() {		
		String id= null;
		String pw= null;
		String name= null;
		String nick= null;
		String email= null;
		String addr= null;
		int cert= 1;
		String pimg= null;
		String comt= null;
//		String path = request.getServletContext().getRealPath("/pimg");
		String path="C:/Users/sbk06/eclipse-workspace/somenaeil/somenaeil/WebContent/pimg";


		int size= 10 * 1024 * 1024;
		
		String filename= "";
		String original= "";
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, path, size, "UTF-8", new DefaultFileRenamePolicy());
			
			id= multi.getParameter("id");
			pw= multi.getParameter("pw");
			name= multi.getParameter("name");
			nick= multi.getParameter("nick");
			email= multi.getParameter("email");
			addr= multi.getParameter("addr");
			email+= "@"+addr;
			comt= multi.getParameter("comt");
			
			Enumeration files= multi.getFileNames();
			
			while(files.hasMoreElements()) {
				String file= (String)files.nextElement();
				filename= multi.getFilesystemName(file);
				original= multi.getOriginalFileName(file);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("member_service - 회원가입시 프로필 이미지 업로드 실패");
		}
		
		pimg= filename;

		if(pimg != null) {
		    pimg= pimg_change(filename, id, path);
		}
		
		member_dao md=new member_dao();
		md.insertMember(id, pw, name, nick, email, cert, pimg, comt);
		member user= md.selectMember(id);
		request.getSession().setAttribute("user", user);
	}
	
	
	public String pimg_change(String filename, String id, String path) {
		int pos = filename.lastIndexOf( "." );
		String enc = filename.substring( pos + 1 );

		String reFileName = filename;
		String newFileName = "pimg_"+id+"."+enc;
		String saveDir = path;

		if(!reFileName.equals("")) {
		     String fullFileName = saveDir + "/" + reFileName;
		     File f1 = new File(fullFileName);
		     if(f1.exists()) {
		          File newFile = new File(saveDir + "/" + newFileName);
		          f1.renameTo(newFile);
		     }
		}
		
		return newFileName;
	}
	
	
	/**
	 * user.jsp에 필요한 정보들 추출 및 가공한 뒤 request에 전달
	 * @author gagip
	 * @return
	 */
	public String user() {
		// parameter 값 추출
		String userId = request.getParameter("userId");
		String sessionId = (String) request.getSession().getAttribute("sessionId");
		String cate = request.getParameter("cate");
		
		// 추출 및 가공에 필요한 재료
		member user = null;
		ArrayList<member> followList = null;
		ArrayList<member> followerList = null;
		ArrayList<post> postList = null;
		String isFollow = null;
		
		// DAO 연결
		Connection conn = getConnection();
		member_dao memberDAO = member_dao.getInstance();
		memberDAO.setConnection(conn);
		// 해당 유저가 쓴 포스트도 가져온다
		post_dao postDAO = post_dao.getInstance();
		postDAO.setConnection(conn);
		
		// 유저를 가지고 온다
		user = memberDAO.selectMember(userId);
		
		if (user != null) {
			String follow = user.getFollow();			// data) id1:id2:id3
			String follower = user.getFollower();		// data) id1:id2:id3
			
			// 팔로우 리스트 추출
			if (follow != null)
				followList = memberDAO.selectMemberList(follow.split(":"));
			// 팔로워 리스트 추출
			if (follower != null)
				followerList = memberDAO.selectMemberList(follower.split(":"));
			
			isFollow = memberDAO.isFollow(sessionId, userId);
			
			// 포스트 리스트 추출
			postList = postDAO.getPostList(userId);
			
			if (cate != null)
				postList = (ArrayList<post>) postList.stream()
										.filter(x -> x.getCate().equals(cate))	// 해당 카테고리에 속하는 게시글만 추출
										.collect(Collectors.toList());
		}
		
		// 가공한 값들을 request에 전달
		request.setAttribute("user", user);
		request.setAttribute("followList", followList);
		request.setAttribute("followerList", followerList);
		request.setAttribute("postList", postList);
		request.setAttribute("isFollow", isFollow);
		
		close(conn);
		return String.format("user.jsp?part=user&userId=%s", userId);
	}
	
	/**
	 * 사용 안함 / 추후 삭제 예정
	 * @return
	 */
	public String userBefore() {
		// parameter 값 추출
		String userId = request.getParameter("userId");
		String cate = request.getParameter("cate");
		
		// 추출 및 가공에 필요한 재료
		member user = null;
		ArrayList<member> followList = null;
		ArrayList<member> followerList = null;
		ArrayList<post> postList = null;
		
		// DAO 연결
		Connection conn = getConnection();
		member_dao memberDAO = member_dao.getInstance();
		memberDAO.setConnection(conn);
		// 해당 유저가 쓴 포스트도 가져온다
		post_dao postDAO = post_dao.getInstance();
		postDAO.setConnection(conn);
		
		// 유저를 가지고 온다
		user = memberDAO.selectMember(userId);
		
		if (user != null) {
			String follow = user.getFollow();			// data) id1:id2:id3
			String follower = user.getFollower();		// data) id1:id2:id3
			
			// 팔로우 리스트 추출
			if (follow != null)
				followList = memberDAO.selectMemberList(follow.split(":"));
			// 팔로워 리스트 추출
			if (follower != null)
				followerList = memberDAO.selectMemberList(follower.split(":"));
			
			// 포스트 리스트 추출
			postList = postDAO.getPostList(userId);
			
			if (cate != null)
				postList = (ArrayList<post>) postList.stream()
										.filter(x -> x.getCate().equals(cate))	// 해당 카테고리에 속하는 게시글만 추출
										.collect(Collectors.toList());
		}
		
		// 가공한 값들을 request에 전달
		request.setAttribute("user", user);
		request.setAttribute("followList", followList);
		request.setAttribute("followerList", followerList);
		request.setAttribute("postList", postList);
		
		close(conn);
		
		return String.format("user.jsp?part=user&userId=%s", userId);
	}
	
	
	public boolean update() {
		String id = request.getParameter("id");
		String pw = request.getParameter("newPw");
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");
		email += "@"+request.getParameter("addr");
		int cert = Integer.parseInt(request.getParameter("cert"));
		String pimg = request.getParameter("pimg");
		String comt = request.getParameter("comt");
		
		boolean pwCheck = false;
		boolean updateCheck = false;
		
		Connection conn = getConnection();
		member_dao memberDAO = member_dao.getInstance();
		memberDAO.setConnection(conn);
		
		// DB 업데이트
		if (pw == null || pw != "")
			pwCheck = memberDAO.updateMember(id, pw);
		updateCheck = memberDAO.updateMember(id, nick, email, cert, pimg, comt);
		
		// 업데이트 후 user 객체를 업데이트하기 위해 새로 로드
		member user = memberDAO.selectMember(id);
		
		if (updateCheck) {
			request.getSession().setAttribute("user", user);	// 새로 갱신
		}
		else {
			request.setAttribute("fail", -1);
		}

		close(conn);
		return updateCheck;
	}
	
	
	/**
	 * follow 변화가 있을 시 처리
	 * @author gagip
	 */
	public void follow() {
		// parameter 추출
		String userId = request.getParameter("userId");
		String targetId = request.getParameter("targetId");
		
		// 커넥션 및 DAO 연결 
		Connection conn = getConnection();
		member_dao memberDAO = member_dao.getInstance();
		memberDAO.setConnection(conn);
		noti_dao notiDAO = noti_dao.getInstance();
		notiDAO.setConnection(conn);
		
		
		String userFollow = memberDAO.selectMember(userId).getFollow();
		String targetFollower = memberDAO.selectMember(targetId).getFollower();
		
		// user와 target의 이전관계
		String isFollow = memberDAO.isFollow(userId, targetId);
		// user와 target와 관계 업데이트
		boolean check = memberDAO.updateFollow(userId, targetId, 
							userFollow, targetFollower, isFollow);
		
		
		if (!check)
			request.setAttribute("fail", -1);		// TODO 실패 화면 처리
		else {
			// follow를 했을 경우만 알람가기 (이전 관계가 unfollow나 follower였다면)
			if (isFollow == "unfollow" || isFollow == "follower")
				notiDAO.insertNoti(userId, targetId, 1);
		}
			
		
		close(conn);
	}
	
	public String joinCheck() {
		ArrayList<String> id_list = new ArrayList<String>();
		ArrayList<String> nick_list = new ArrayList<String>();
		
		member_dao md = new member_dao();
		id_list = md.idList();
		nick_list = md.nickList();
		
		request.setAttribute("id_list", id_list);
		request.setAttribute("nick_list", nick_list);
		
		return "join_form.jsp";
	}
}