package jp.co.solxyz.spring.di.withoutdi;

import java.util.HashMap;
import java.util.Map;

/**
 * 従業員を管理するクラス
 * 従業員の追加、取得、削除、一覧表示を行う機能を提供する。
 */
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
     * 従業員を追加するメソッド
     *
     * @param employee 従業員
     */
    public void addEmployee(Employee employee) {
        this.employees.put(employee.id(), employee);
    }

    /**
     * 従業員を取得するメソッド
     *
     * @param id ID
     * @return 従業員
     */
    public Employee getEmployee(String id) {
        return this.employees.get(id);
    }

    /**
     * 従業員を削除するメソッド
     *
     * @param id ID
     */
    public void removeEmployee(String id) {
        this.employees.remove(id);
    }

    /**
     * 従業員一覧を表示するメソッド
     */
    public void listEmployees() {
        for (Employee employee : this.employees.values()) {
            System.out.println("ID: " + employee.id() + ", Name: " + employee.name());
        }
    }
}

