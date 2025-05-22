package jp.co.solxyz.spring.di.withdi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component //このクラスをDIコンテナに登録するために、@Componentを付与する
public class EmployeeManager {
    /**
     * 従業員リスト
     */
    private final Map<String, Employee> employees;

    /**
     * コンストラクタ
     */
    public EmployeeManager() {
        this.employees = new HashMap<>();
    }

    /**
     * 従業員を追加する
     *
     * @param employee 従業員
     */
    public void addEmployee(Employee employee) {
        this.employees.put(employee.id(), employee);
    }

    /**
     * 従業員を取得する
     * @param id ID
     * @return 従業員
     */
    public Employee getEmployee(String id) {
        return this.employees.get(id);
    }

    /**
     * 従業員を削除する
     * @param id ID
     */
    public void removeEmployee(String id) {
        this.employees.remove(id);
    }

    /**
     * 従業員一覧を表示する
     */
    public void listEmployees() {
        for (Employee employee : this.employees.values()) {
            System.out.println("ID: " + employee.id() + ", Name: " + employee.name());
        }
    }
}

