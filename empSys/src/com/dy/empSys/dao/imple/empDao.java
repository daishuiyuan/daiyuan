package com.dy.empSys.dao.imple;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.dy.empSys.bean.Emp;
import com.dy.empSys.dao.IempDao;
import com.dy.empSys.utils.C3p0;

public class empDao implements IempDao{

	@Override
	public Emp findEmpByNameAndPassword(String name,String password) {
	   QueryRunner runner=new QueryRunner(C3p0.getDataSource());
	   try {
		 return runner.query("select * from emp where name=? and password=?", new BeanHandler<Emp>(Emp.class),name,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        return null;
	}

	@Override
	public List<Emp> findAll() {
		 QueryRunner runner=new QueryRunner(C3p0.getDataSource());
		 try {
		   return runner.query("select * from emp",new BeanListHandler<Emp>(Emp.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}

	@Override
	public Boolean AddEmp(Emp emp) {
		 QueryRunner runner=new QueryRunner(C3p0.getDataSource());
		 try {
			int update = runner.update("insert into emp values(null,?,?,?,?,?,?,?,?)",emp.getName(),emp.getPassword(),emp.getGender(),
			emp.getAge(),emp.getHiredate(),emp.getSalary(),emp.getPhone(),emp.getEmail());
			if (update!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return false;
	}

	@Override
	public Boolean DeleteEmp(Integer id) {
		 QueryRunner runner=new QueryRunner(C3p0.getDataSource());
		 try {
			int update = runner.update("delete from emp where id=?", id);
			if (update!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return false;
	}

	@Override
	public Boolean UpdateEmp(Emp emp) {
		QueryRunner runner=new QueryRunner(C3p0.getDataSource());
		try {
			int update = runner.update("update from emp set name=?,password=?,gender=?,age=?,hiredate=?,salary=?,phone=?,email=?", emp.getName(),
			emp.getPassword(),emp.getGender(),emp.getAge(),emp.getHiredate(),emp.getSalary(),emp.getPhone(),emp.getEmail());
			if (update!=0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

