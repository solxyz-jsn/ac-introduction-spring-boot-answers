package jp.co.solxyz.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * メイン画面のコントローラークラス
 */
@Controller
public class MainController {
    /**
     * ルートURL("/")へのリクエストを処理する。
     * 指定されたメッセージをモデルに追加し、"index"というビューを返す。
     *
     * @param model モデルオブジェクト
     * @return 表示するビューの名前
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello Spring Boot!");
        return "index";
    }
}
