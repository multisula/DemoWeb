package com.ssamz.biz.board;

import com.ssamz.biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
  private Connection conn;
  private PreparedStatement pstmt;
  private ResultSet rs;


  private static String BOARD_INSERT = "INSERT INTO DEMO_BOARD(seq, title, writer, content) VALUES(SEQ_BOARD_SEQ.NEXTVAL, ?, ?, ?)";
  private static String BOARD_UPDATE = "UPDATE DEMO_BOARD SET title=?, content=? WHERE seq=?";
  private static String BOARD_DELETE = "DELETE DEMO_BOARD WHERE seq=?";
  private static String BOARD_GET = "SELECT * FROM DEMO_BOARD WHERE seq = ?";
  private static String BOARD_LIST = "SELECT * FROM DEMO_BOARD ORDER BY seq DESC";
  private static String BOARD_LIST_T = "SELECT * FROM DEMO_BOARD WHERE TITLE LIKE '%'||?||'%' ORDER BY SEQ DESC";
  private static String BOARD_LIST_C = "SELECT * FROM DEMO_BOARD WHERE CONTENT LIKE '%'||?||'%' ORDER BY SEQ DESC";


  public void insertBoard(BoardVO vo) {
    try {
      conn = JDBCUtil.getConnection();
      pstmt=conn.prepareStatement(BOARD_INSERT);
      pstmt.setString(1, vo.getTitle());
      pstmt.setString(2, vo.getWriter());
      pstmt.setString(3, vo.getContent());
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtil.close(pstmt, conn);
    }
  }

  public void updateBoard(BoardVO vo) {
    try {
      conn = JDBCUtil.getConnection();
      pstmt=conn.prepareStatement(BOARD_UPDATE);
      pstmt.setString(1, vo.getTitle());
      pstmt.setString(2, vo.getContent());
      pstmt.setString(3, Integer.toString(vo.getSeq()));
      pstmt.executeUpdate();
    } catch(SQLException e){
      e.printStackTrace();
    } finally {
      JDBCUtil.close(pstmt, conn);
    }
  }

  public void deleteBoard(BoardVO vo) {
    try {
      conn = JDBCUtil.getConnection();
      pstmt = conn.prepareStatement(BOARD_DELETE);
      pstmt.setString(1, Integer.toString(vo.getSeq()));
      pstmt.executeUpdate();
    } catch(SQLException e){
      e.printStackTrace();
    } finally {
      JDBCUtil.close(pstmt, conn);
    }
  }

  public BoardVO getBoard(BoardVO vo) {
    BoardVO result = new BoardVO();
    try {
      conn = JDBCUtil.getConnection();
      pstmt = conn.prepareStatement(BOARD_GET);
      pstmt.setString(1, Integer.toString(vo.getSeq()));
      rs = pstmt.executeQuery();

      if(rs.next()){
        result.setSeq(rs.getInt("seq"));
        result.setTitle(rs.getString("title"));
        result.setWriter(rs.getString("writer"));
        result.setContent(rs.getString("content"));
        result.setRegDate(rs.getDate("regdate"));
        result.setCnt(rs.getInt("cnt"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtil.close(rs, pstmt, conn);
    }
    return result;
  }

  public List<BoardVO> getBoardList() {
    List<BoardVO> boardList = new ArrayList<>();
    try{
      conn = JDBCUtil.getConnection();
      pstmt = conn.prepareStatement(BOARD_LIST);
      rs = pstmt.executeQuery();
      while(rs.next()){
        BoardVO vo = new BoardVO();
        vo.setSeq(rs.getInt("seq"));
        vo.setTitle(rs.getString("title"));
        vo.setWriter(rs.getString("writer"));
        vo.setContent(rs.getString("content"));
        vo.setRegDate(rs.getDate("regdate"));
        vo.setCnt(rs.getInt("cnt"));
        boardList.add(vo);
      }
    } catch(SQLException e){
      e.printStackTrace();
    } finally {
      JDBCUtil.close(rs, pstmt, conn);
    }

    return boardList;
  }

  public List<BoardVO> getBoardList(BoardVO vo) {
    List<BoardVO> boardList = new ArrayList<>();
    try{
      conn = JDBCUtil.getConnection();
      if(vo.getSearchCondition().equals("TITLE"))
        pstmt = conn.prepareStatement(BOARD_LIST_T);
      else if(vo.getSearchCondition().equals("CONTENT"))
        pstmt = conn.prepareStatement(BOARD_LIST_C);
      pstmt.setString(1, vo.getSearchKeyword());
      rs = pstmt.executeQuery();
      while(rs.next()){
        vo = new BoardVO();
        vo.setSeq(rs.getInt("seq"));
        vo.setTitle(rs.getString("title"));
        vo.setWriter(rs.getString("writer"));
        vo.setContent(rs.getString("content"));
        vo.setRegDate(rs.getDate("regdate"));
        vo.setCnt(rs.getInt("cnt"));
        boardList.add(vo);
      }
    } catch(SQLException e){
      e.printStackTrace();
    } finally {
      JDBCUtil.close(rs, pstmt, conn);
    }

    return boardList;
  }
}