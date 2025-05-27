package jp.co.solxyz.spring.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_emp")
@Data
public class Employee {
    /**
     * 従業員ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long empId;

    /**
     * 名前
     */
    @Column(name = "name")
    String empName;

    /**
     * 役職
     */
    @Column(name = "position")
    String empPosition;

    /**
     * 年齢
     */
    @Column(name = "age")
    int empAge;

}
