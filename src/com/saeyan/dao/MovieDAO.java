package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.MovieVO;

import oracle.jdbc.proxy.annotation.Pre;
import util.DBManager;

public class MovieDAO {
	
	private MovieDAO() {}
	
	private static MovieDAO instance = new MovieDAO();
	
	public static MovieDAO getInstance() {
		return instance;
	}
	
	public List<MovieVO> selectAllMovies(){
		
		String sql = "select * from movie order by code desc";
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				MovieVO mVO = new MovieVO();
				mVO.setCode(rs.getInt("code"));
				mVO.setTitle(rs.getString("title"));
				mVO.setPrice(rs.getInt("price"));
				mVO.setDirector(rs.getString("director"));
				mVO.setActor(rs.getString("actor"));
				mVO.setPoster(rs.getString("poster"));
				mVO.setSynopsis(rs.getString("synopsis"));
				
				list.add(mVO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public void insertMovie(MovieVO mVO) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql="insert into movie values(movie_seq.nextval,?,?,?,?,?,?)";
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mVO.getTitle());
			pstmt.setInt(2, mVO.getPrice());
			pstmt.setString(3, mVO.getDirector());
			pstmt.setString(4, mVO.getActor());
			pstmt.setString(5, mVO.getPoster());
			pstmt.setString(6, mVO.getSynopsis());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		
	}
	
	public MovieVO selectMovieByCode(String code) {
		
		String sql= "select * from movie where code=?";
		
		MovieVO mVO=null;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				mVO=new MovieVO();
				mVO.setCode(rs.getInt("code"));
				mVO.setTitle(rs.getString("title"));
				mVO.setPrice(rs.getInt("price"));
				mVO.setDirector(rs.getString("director"));
				mVO.setActor(rs.getString("actor"));
				mVO.setPoster(rs.getString("poster"));
				mVO.setSynopsis(rs.getString("synopsis"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
			return mVO;
	}
	
	public void updateMovie(MovieVO mVO) {
		
		String sql="update movie set title=?, price=?, director=?, actor=?, poster=?, synopsis=? where code=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, mVO.getTitle());
			pstmt.setInt(2, mVO.getPrice());
			pstmt.setString(3, mVO.getDirector());
			pstmt.setString(4, mVO.getActor());
			pstmt.setString(5, mVO.getPoster());
			pstmt.setString(6, mVO.getSynopsis());
			pstmt.setInt(7, mVO.getCode());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	
	}
	
	public void deleteMovie(String code) {
		
		String sql="delete from movie where code=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}













