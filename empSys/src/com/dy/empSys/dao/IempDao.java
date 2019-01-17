package com.dy.empSys.dao;

import java.util.List;

import com.dy.empSys.bean.Emp;

public interface IempDao {
	/**
	 * 通过姓名和密码找到员工信息
	 * @return
	 */
	Emp findEmpByNameAndPassword(String name,String password);
	
	/**
	 * 获取所有员工信息
	 * @return
	 */
	List<Emp> findAll();
	
	/**
	 * 添加员工
	 * @return
	 */
     Boolean AddEmp(Emp emp);
     
     /**
      * 删除员工
      * @param emp
      * @return
      */
     Boolean DeleteEmp(Integer id);
     
     /**
      * 修改用户
      * @return
      */
     Boolean UpdateEmp(Emp emp);
}
