package jp.co.solxyz.spring.jpa.repository;

import jp.co.solxyz.spring.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /**
     * 65歳以上の従業員リストを返す。
     *  JPQLという特殊なSQLで指定するため、テーブルではなくEntityの情報で検索していることに注意
     * @return 検索結果の一覧
     */
    @Query(value = "from Employee where empAge >= 65")
    List<Employee> findOverAge();

    /**
     * 65歳に満たない従業員リストを返す。
     *   nativeQuery（生のSQL）を用いて記載する
     * @return 検索結果の一覧
     */
    @Query(value = "select id, name, position, age from t_emp e where e.age < 65", nativeQuery = true)
    List<Employee> findUnderAge();
}
