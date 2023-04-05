package org.feichai.themyleaf.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@ToString
@Data
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "姓名不能为空")
    @Length(max = 8, min=1, message = "名字不得超过8个字符")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value = 1, message = "年龄不得小于1")
    @Max(value = 150, message = "年龄不得大于150")
    private int age;
}
