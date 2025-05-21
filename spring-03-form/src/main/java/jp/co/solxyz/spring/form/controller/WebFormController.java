package jp.co.solxyz.spring.form.controller;

import jp.co.solxyz.spring.form.dto.WebForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebFormController {

    @GetMapping("/webform") //Getの場合
    public String get(Model model) {
        // ここで空のオブジェクトを作成して渡す
        // 初期値を設定したい場合にはここで設定可能
        model.addAttribute("webForm", new WebForm());

        return "web";
    }

    @PostMapping("/webform") //Postの場合
    public String post(@Validated @ModelAttribute("webForm") WebForm webForm, BindingResult result, Model model) {
        // 入力された情報を表示するために再投入
        model.addAttribute("webForm", webForm);

        if (result.hasErrors()) {
            // エラーがある場合にはその旨を表示する
            model.addAttribute("message", "エラーを修正してください");

            return "web";
        } else {
            // エラーがなければ問題ないことを表示
            model.addAttribute("message", "問題ありません！");

            return "web";
        }
    }
}
