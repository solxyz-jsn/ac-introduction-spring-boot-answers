package jp.co.solxyz.spring.api.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.solxyz.spring.api.dto.BooksDto;
import jp.co.solxyz.spring.api.service.BooksService;

/**
 * メイン画面のコントローラークラス
 */
@Controller
public class MainController {

	/**
	 * 書籍情報を管理するサービス
	 */
	@Autowired
	BooksService booksservice;

	/**
	 * 外部API利用結果画面
	 * @param model モデル情報
	 * @return 表示ページ
	 */
	@RequestMapping("/booklist")
	public String bookList(Model model) {
		BooksDto [] books = booksservice.getBooks();
		model.addAttribute("books",Arrays.asList(books));
		return "booklist";
	}

	/**
	 * API呼び出し
	 * @return 表示するページ
	 */
	@RequestMapping("/books")
	public String books() {
		return "books";
	}
}
