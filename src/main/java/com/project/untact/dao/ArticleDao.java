package com.project.untact.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.untact.dto.Article;
import com.project.untact.dto.Board;

@Mapper
public interface ArticleDao {

	public Article getArticle(@Param("id") int id);
	public void addArticle(Map<String, Object> param);
	public void deleteArticle(@Param("id") int id);
	public void modifyArticle(@Param("id") int id,@Param("title") String title,@Param("body") String body);
	public List<Article> getArticles(@Param("searchKeywordType") String searchKeywordType,@Param("searchKeyword") String searchKeyword);
	public Article getForPrintArticle(int id);
	public List<Article> getForPrintArticles(@Param("boardId") int boardId,
			@Param("searchKeywordType") String searchKeywordType, @Param("searchKeyword") String searchKeyword,
			@Param("limitStart") int limitStart, @Param("limitTake") int limitTake);
	public Board getBoard(@Param("id") int id);
	public void addReply(Map<String, Object> param);

	
}
