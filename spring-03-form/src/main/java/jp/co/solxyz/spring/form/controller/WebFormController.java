package jp.co.solxyz.spring.form.controller;

import jp.co.solxyz.spring.form.dto.WebForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * フォーム画面のコントローラクラス。
 */
@Controller
public class WebFormController {

    /**
     * GETリクエストに応じてWebフォーム画面を表示するメソッド。
     * 新しいWebFormオブジェクトをモデルに追加し、ビューとして"web"を返す。
     *
     * @param model モデルオブジェクト
     * @return 表示するビューの名前
     */
    @GetMapping("/webform") //Getの場合
    public String get(Model model) {
        // ここで空のオブジェクトを作成して渡す
        // 初期値を設定したい場合にはここで設定可能
        model.addAttribute("webForm", new WebForm());

        return "web";
    }

    /**
     * Webフォームの送信内容を処理するメソッド。
     * 入力値にエラーがある場合にはエラーメッセージを表示し、エラーがない場合には成功メッセージを表示する。
     *
     * @param webForm フォームから送信されたデータを保持するWebFormオブジェクト
     * @param result  入力検証結果を保持するBindingResultオブジェクト
     * @param model   モデルオブジェクト
     * @return 表示するビューの名前
     */
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
