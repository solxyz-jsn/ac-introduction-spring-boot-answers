package jp.co.solxyz.spring.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * メイン画面のコントローラークラス
 */
@Controller
public class MainController {
    /**
     * ルートURL("/")へのリクエストを処理するメソッド
     * 指定したメッセージをモデルに追加し、ビューとして"index"を返す。
     *
     * @param model モデルオブジェクト
     * @return 表示するビューの名前
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello Thymeleaf");
        return "index";
    }
}
