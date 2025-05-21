package jp.co.solxyz.spring.form.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class WebForm {
    /** 氏名 */
    @NotEmpty(message = "氏名を入力してください")
    private String name;

    /** 年齢 */
    @NotNull(message = "年齢を入力してください")
    @Min(value=0, message = "生後の年齢を入力してください")
    private Integer age;

    /** 郵便番号 */
    @NotNull(message = "郵便番号を入力してください")
    @Pattern(regexp = "[0-9]{3}[-]?[0-9]{4}", message = "郵便番号の形式で入力してください")
    private String postal;
}
