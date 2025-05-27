package jp.co.solxyz.spring.di.withoutdi;

/**
 * 会社クラス
 */
public class Company {
    /**
     * 従業員管理クラス
     */
    private final EmployeeManager manager;

    /**
     * コンストラクタ
     */
    public Company() {
        this.manager = new EmployeeManager();
    }

    /**
     * 従業員を追加し、その一覧を表示するメソッド。
     * 従業員オブジェクトを従業員管理クラスに追加し、全従業員の情報を出力する。
     */
    public void run() {
        Employee emp1 = new Employee("001", "ソルク太郎");
        Employee emp2 = new Employee("002", "ソルク花子");

        manager.addEmployee(emp1);
        manager.addEmployee(emp2);

        manager.listEmployees();
    }
}
