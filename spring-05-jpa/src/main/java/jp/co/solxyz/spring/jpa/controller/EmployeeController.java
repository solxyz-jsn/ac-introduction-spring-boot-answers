package jp.co.solxyz.spring.jpa.controller;

import jp.co.solxyz.spring.jpa.entity.Employee;
import jp.co.solxyz.spring.jpa.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

/**
 * 従業員情報を扱うコントローラークラス
 */
@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * 全従業員一覧を表示
     *
     * @param model モデル
     * @return 従業員一覧ビュー
     */
    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    /**
     * 65歳以上の従業員一覧を表示
     *
     * @param model モデル
     * @return 従業員一覧ビュー
     */
    @GetMapping("/over-age")
    public String getEmployeesOverAge(Model model) {
        List<Employee> seniorEmployees = employeeService.findEmployeesOverAge();
        model.addAttribute("employees", seniorEmployees);
        return "employee-list";
    }

    /**
     * 65歳未満の従業員一覧を表示
     *
     * @param model モデル
     * @return 従業員一覧ビュー
     */
    @GetMapping("/under-age")
    public String getEmployeesUnderAge(Model model) {
        List<Employee> juniorEmployees = employeeService.findEmployeesUnderAge();
        model.addAttribute("employees", juniorEmployees);
        return "employee-list";
    }

    /**
     * 従業員詳細を表示
     *
     * @param id    従業員ID
     * @param model モデル
     * @return 従業員詳細ビュー
     */
    @GetMapping("/{id}")
    public String getEmployeeDetail(@PathVariable long id, Model model) {
        Optional<Employee> employee = employeeService.findOne(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "employee-detail";
        } else {
            // 従業員が見つからない場合は、従業員一覧にリクエストし直す(リダイレクト)
            return "redirect:/employees";
        }
    }

    /**
     * 新規従業員追加フォームを表示
     *
     * @param model モデル
     * @return 従業員フォームビュー
     */
    @GetMapping("/new")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("isNew", true);
        return "employee-form";
    }

    /**
     * 従業員編集フォームを表示
     *
     * @param id    従業員ID
     * @param model モデル
     * @return 従業員フォームビュー
     */
    @GetMapping("/{id}/edit")
    public String showEditEmployeeForm(@PathVariable long id, Model model) {
        Optional<Employee> employee = employeeService.findOne(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            model.addAttribute("isNew", false);
            return "employee-form";
        } else {
            return "redirect:/employees";
        }
    }

    /**
     * 従業員情報を保存
     *
     * @param employee 従業員情報
     * @return リダイレクト先
     */
    @PostMapping
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    /**
     * 従業員情報を削除
     *
     * @param id 従業員ID
     * @return リダイレクト先
     */
    @GetMapping("/{id}/delete")
    public String deleteEmployee(@PathVariable long id) {
        Optional<Employee> employee = employeeService.findOne(id);
        if (employee.isPresent()) {
            employeeService.delete(employee.get());
        }
        return "redirect:/employees";
    }
}
