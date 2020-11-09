package com.kh.product.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.product.model.vo.PageInfo;
import com.kh.product.model.vo.Product;
import com.kh.review.model.vo.Review;


public class ProductDao {
	
	private Properties prop = new Properties();
	
	public ProductDao() {
		
		String fileName = ProductDao.class.getResource("/sql/product/product_mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
		
			e.printStackTrace();
		}

		
	}
	
	public int selectListCount(Connection conn) {
		
		int listCount = 0;

		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				
				listCount = rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		
		return listCount;
	}
	
	
	public ArrayList<Product> selectAllProduct(Connection conn, PageInfo pi) {
		
		ArrayList<Product> list = new ArrayList<>();
		
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectAllProduct");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() +1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			
			rset = pstmt.executeQuery();

			
			
			while(rset.next()) {
				
				list.add(new Product(
									   rset.getInt("p_no")
									 , rset.getString("p_name")
									 , rset.getInt("p_price")
									 , rset.getInt("p_discount")
									 , rset.getString("p_detail")
									 , rset.getString("p_thumbnail")
						             )
						);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

	
	public ArrayList<Product> selectBestProduct(Connection conn, PageInfo pi) {
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt  = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBestProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1)* pi.getBoardLimit() +1 ;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Product(
									 rset.getInt("p_no")
									 , rset.getString("p_name")
									 , rset.getInt("p_price")
									 , rset.getInt("p_discount")
									 , rset.getString("p_detail")
									 , rset.getString("p_thumbnail")
									)
						);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
	
	public ArrayList<Product> selectNewProduct(Connection conn, PageInfo pi) {
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt  = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNewProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1)* pi.getBoardLimit() +1 ;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Product(
									 rset.getInt("p_no")
									 , rset.getString("p_name")
									 , rset.getInt("p_price")
									 , rset.getInt("p_discount")
									 , rset.getString("p_detail")
									 , rset.getString("p_thumbnail")
									)
						);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
	
	public ArrayList<Product> selectEventProduct(Connection conn,int eno) {
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt  = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectEventProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			

			
			pstmt.setInt(1, eno);

			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Product(
									 rset.getInt("p_no")
									 , rset.getString("p_name")
									 , rset.getInt("p_price")
									 , rset.getInt("p_discount")
									 , rset.getString("p_detail")
									 , rset.getString("p_thumbnail")
									)
						);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
	
	
	public Product selectDetailProduct(Connection conn, int pno) {
		
		Product p = new Product();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectDetailProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				 		p = new Product(
										  rset.getInt("p_no")
										, rset.getString("p_name")
										, rset.getInt("p_price")
										, rset.getInt("p_discount")
										, rset.getString("p_thumbnail")
										, rset.getString("p_image1")
										, rset.getString("p_image2")
										, rset.getString("p_unit")
										, rset.getString("p_weight")
										, rset.getString("p_deli")
										, rset.getString("p_nation")
										, rset.getString("p_packtype")
										, rset.getString("p_detail")
										);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return p;

	}
	
	
	public ArrayList<Product> selectAdminProductList(Connection conn,PageInfo pi){
		      ArrayList<Product> list = new ArrayList<>();
		      
		      PreparedStatement pstmt = null;
		      ResultSet rset = null;
		      
		      String sql = prop.getProperty("selectAdminProductList");
		      
		      try {
		         pstmt = conn.prepareStatement(sql);
		         
		         int startRow = (pi.getCurrentPage()-1)* pi.getBoardLimit()+1;
		         int endRow = startRow + pi.getBoardLimit()-1;
		         
		         pstmt.setInt(1, startRow);
		         pstmt.setInt(2, endRow);
		         
		         rset = pstmt.executeQuery();
		         
		         while(rset.next()) {
		            list.add(new Product(
		                            rset.getInt("p_no"),
		                            rset.getString("p_name"),
		                            rset.getInt("p_inventory"),
		                            rset.getString("p_company")));
		         }
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(rset);
		         close(pstmt);
		      }
		      
		      return list;
		      
		   }

	
	public ArrayList<Review> selectUserReview(Connection conn, int pno) {
		
		ArrayList<Review> list = new ArrayList<>();
		
		String sql = prop.getProperty("selectUserReview");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Review r = new Review();
				
				r.setReviewNo(rset.getInt("review_board_no"));
				r.setReviewRate(rset.getInt("review_rate"));
				r.setReviewTitle(rset.getString("review_title"));
				r.setMem(rset.getString("mem_id"));
				r.setRegDate(rset.getDate("reg_date"));
				r.setLike(rset.getInt("like_count"));
				r.setClickNo(rset.getInt("click_no"));
				
				list.add(r);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}
	
	
	public ArrayList<Review> selectPhotoReview(Connection conn, int pno) {
		
		ArrayList<Review> list = new ArrayList<>();
		
		String sql = prop.getProperty("selectPhotoReview");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Review r = new Review();
				
				r.setReviewNo(rset.getInt("review_board_no"));
				r.setReviewRate(rset.getInt("review_rate"));
				r.setReviewTitle(rset.getString("review_title"));
				r.setMem(rset.getString("mem_id"));
				r.setRegDate(rset.getDate("reg_date"));
				r.setLike(rset.getInt("like_count"));
				r.setClickNo(rset.getInt("click_no"));
				
				list.add(r);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}
	
	public ArrayList<Review> selectSortReview(Connection conn, int pno, String sort) {
		
		ArrayList<Review> list = new ArrayList<>();
		
		String sql = prop.getProperty("selectSortReview") + " ORDER BY "+ sort + " DESC";
		
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Review r = new Review();
				
				r.setReviewNo(rset.getInt("review_board_no"));
				r.setReviewRate(rset.getInt("review_rate"));
				r.setReviewTitle(rset.getString("review_title"));
				r.setMem(rset.getString("mem_id"));
				r.setRegDate(rset.getDate("reg_date"));
				r.setLike(rset.getInt("like_count"));
				r.setClickNo(rset.getInt("click_no"));
				
				list.add(r);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}
	
	
	public Product selectAdminProductDetail(Connection conn, int pno) {
			
			Product p = null;
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectAdminProductDetail");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pno);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					p = new Product(rset.getInt("p_no"),
									rset.getString("category_name"),
									rset.getString("e_title"),
									rset.getString("p_name"),
									rset.getInt("p_price"),
									rset.getInt("p_discount"),
									rset.getString("p_image1"),
									rset.getString("p_image2"),
									rset.getInt("p_inventory"),
									rset.getString("p_company"),
									rset.getString("p_unit"),
									rset.getString("p_weight"),
									rset.getString("p_detail"),
									rset.getString("dis_yn"),
									rset.getString("e_yn"),
									rset.getString("p_smalldetail"),
									rset.getString("p_deli"),
									rset.getString("p_nation"),
									rset.getString("p_packtype"),
									rset.getString("p_thumbnail"),
									rset.getInt("p_out"));
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return p;
		}
	
	
	public int insertProduct(Connection conn, Product p) {
		//insert 처리문 => 처리된 행수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getCategory());
			pstmt.setInt(2, Integer.parseInt(p.getEno()));
			pstmt.setString(3, p.getpName());
			pstmt.setInt(4, p.getPrice());
			pstmt.setInt(5, p.getDiscount());
			pstmt.setString(6, p.getImg1());
			pstmt.setString(7, p.getImg2());
			pstmt.setInt(8, p.getInventory());
			pstmt.setString(9, p.getCompany());
			pstmt.setString(10, p.getUnit());
			pstmt.setString(11, p.getWeight());
			pstmt.setString(12, p.getDetail());
			pstmt.setString(13, p.getDisYn());
			pstmt.setString(14, p.geteYn());
			pstmt.setString(15, p.getSmallDetail());
			pstmt.setString(16, p.getDeli());
			pstmt.setString(17, p.getNation());
			pstmt.setString(18, p.getPacktype());
			pstmt.setString(19, p.getThumbnail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	
}

