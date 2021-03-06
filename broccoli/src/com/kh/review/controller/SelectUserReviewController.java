package com.kh.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.product.model.service.ProductService;
import com.kh.review.model.vo.Review;

/**
 * Servlet implementation class SelectUserReviewController
 */
@WebServlet("/selectReview.rv")
public class SelectUserReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		String sort = request.getParameter("sort");

		ArrayList<Review> list = new ArrayList<>();
		
		if(sort.equals("all")) {
			
			list = new ProductService().selectUserReview(pno);
			
		}else if(sort.equals("photo")) {
			
			list = new ProductService().selectPhotoReview(pno);
			
		}else {
			list = new ProductService().selectSortReview(pno,sort);
		}
		

		response.setContentType("application/json; charset=utf-8");
		
		Gson gson = new Gson();
		
		gson.toJson(list, response.getWriter());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
