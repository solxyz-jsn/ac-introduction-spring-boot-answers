package jp.co.solxyz.spring.di.withdi;

import org.springframework.stereotype.Component;

/**
 * 会社クラス
 */
@Component
public class Company {
    /**
     * 従業員管理クラス
     */
    private final EmployeeManager manager;

    /**
     * コンストラクタ
     */
    public Company(EmployeeManager employeeManager) {
        // コンストラクタの引数にDIしたいクラスを定義することで、Springが自動でフィールドにインスタンスを注入する
        this.manager = employeeManager;
    }

    /**
     * 実行
     */
    public void run() {
        Employee emp1 = new Employee("001", "ソルク太郎");
        Employee emp2 = new Employee("002", "ソルク花子");

        manager.addEmployee(emp1);
        manager.addEmployee(emp2);

        manager.listEmployees();
    }
}
