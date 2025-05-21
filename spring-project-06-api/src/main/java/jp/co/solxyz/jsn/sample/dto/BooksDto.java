package jp.co.solxyz.jsn.sample.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * 書籍情報Dto
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class BooksDto {

	/** 書籍ID */
	String id;

	/** 書籍タイトル */
	String title;

	/** 出版社名 */
	String publisher;

	/** 著者ID */
	String author;

}
