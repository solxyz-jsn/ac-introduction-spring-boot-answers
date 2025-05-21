package jp.co.solxyz.spring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jp.co.solxyz.spring.api.dto.BooksDto;

@Service
public class BooksService {

	/** Rest Template */
    private final RestTemplate restTemplate;


    @Autowired
    public BooksService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    /** 通信先URL */
    private static final String URL = "http://private-bde553-bookmanagementapi.apiary-mock.com/books";

	/**
	 * 書籍情報の取得
	 * @return 取得した書籍情報のリスト
	 */
	public BooksDto[] getBooks() {
        return restTemplate.getForObject(URL, BooksDto[].class);
    }

}
