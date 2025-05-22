package jp.co.solxyz.spring.jpa.service;

import jp.co.solxyz.spring.jpa.entity.Employee;
import jp.co.solxyz.spring.jpa.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class EmployeeService{

    private final EmployeeRepository empRepository;

    /**
     * 全ての従業員リストを返す
     * @return 全従業員の情報
     */
    public List<Employee> findAll(){
        return empRepository.findAll();
    }

    /**
     * 引数に指定したIDの従業員エンティティを返す。
     * @param id 従業員ID
     * @return 検索結果の従業員情報
     */
    public Optional<Employee> findOne(long id){
        return empRepository.findById(id);
    }

    /**
     * 引数に指定した従業員エンティティを保存
     * @param employee 従業員情報
     */
    public void save(Employee employee){
        empRepository.save(employee);
    }

    /**
     * 引数に指定した従業員エンティティを削除
     * @param employee 従業員情報
     */
    public void delete(Employee employee){
        empRepository.delete(employee);
    }

    /**
     * 65歳以上の従業員リストを返す
     * @return 65歳以上の従業員情報
     */
    public List<Employee> findEmployeesOverAge() {
        return empRepository.findOverAge();
    }

    /**
     * 65歳未満の従業員リストを返す
     * @return 65歳未満の従業員情報
     */
    public List<Employee> findEmployeesUnderAge() {
        return empRepository.findUnderAge();
    }
}
