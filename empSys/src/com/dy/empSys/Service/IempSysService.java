package com.dy.empSys.Service;

import java.util.List;

import com.dy.empSys.bean.Emp;

public interface IempSysService {
	
	/**
	 * 登录验证,通过密码和用户名来查找用户
	 * @param name
	 * @param password
	 * @return
	 */
	Emp findEmpByNameAndPassword(String name, String password);
    
	/**
	 * 获取所有员工信息
	 * @return
	 */
	List<Emp> findAll();
	
	/**
	 * 添加员工
	 * @param emp
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
