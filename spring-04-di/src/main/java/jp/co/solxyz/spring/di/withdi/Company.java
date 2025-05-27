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
     * 会社の動作を実行するメソッド。
     * 従業員オブジェクトを作成し、従業員管理クラスに追加した後、登録されている従業員一覧を表示する。
     */
    public void run() {
        Employee emp1 = new Employee("001", "ソルク太郎");
        Employee emp2 = new Employee("002", "ソルク花子");

        manager.addEmployee(emp1);
        manager.addEmployee(emp2);

        manager.listEmployees();
    }
}
