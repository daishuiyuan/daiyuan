package com.dy.empSys.Service.imple;

import java.util.List;

import com.dy.empSys.Service.IempSysService;
import com.dy.empSys.bean.Emp;
import com.dy.empSys.dao.imple.empDao;

public class EmpSysService implements IempSysService{
     empDao empDao=new empDao();

	@Override
	public Emp findEmpByNameAndPassword(String name, String password) {
		 return empDao.findEmpByNameAndPassword(name, password);
		 
	}

	@Override
	public List<Emp> findAll() {
		return empDao.findAll();
	}

	@Override
	public Boolean AddEmp(Emp emp) {
		return empDao.AddEmp(emp);
	}

	@Override
	public Boolean DeleteEmp(Integer id) {
		return empDao.DeleteEmp(id);
	}

	@Override
	public Boolean UpdateEmp(Emp emp) {
		return empDao.UpdateEmp(emp);
	}
	
	
     
}
