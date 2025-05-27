package jp.co.solxyz.spring.api.restcontroller;

import jp.co.solxyz.spring.api.dto.BooksDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 書籍一覧を取得するAPI
 */
@RestController
public class APIController {

    /**
     * RestAPI実装
     */
    @RequestMapping("/call")
    public BooksDto callApi() {
        BooksDto book = new BooksDto();
        book.setAuthor("佐藤太郎");
        book.setTitle("やさしいSpring Boot");
        book.setId("106");
        book.setPublisher("第一出版社");
        return book;
    }

}
