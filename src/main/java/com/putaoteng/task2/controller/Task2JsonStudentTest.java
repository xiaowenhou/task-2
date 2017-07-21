package com.putaoteng.task2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.putaoteng.task2.dao.StudentDao;
import com.putaoteng.task2.model.BasicVo;
import com.putaoteng.task2.model.Student;

@Controller
public class Task2JsonStudentTest {
	@Resource (name="studentDao")
	private StudentDao studentDao;
	
	@RequestMapping (value="/a/student/list", method=RequestMethod.GET)
	public @ResponseBody List<BasicVo> queryAll(){
		List<BasicVo> list = new ArrayList<BasicVo>();
		
	
		list = studentDao.queryAll();
		
		return list;
	}
	
	@RequestMapping (value="/a/student/list", method=RequestMethod.POST)
	public @ResponseBody List<BasicVo> addOne(Student student){
		studentDao.addData(student);
		
		List<BasicVo> list = new ArrayList<BasicVo>();
		list = studentDao.queryAll();
		return list;
	}
	
	@RequestMapping (value="/a/student/id/{id}", method=RequestMethod.GET)
	public @ResponseBody Student queryOne(@PathVariable (value="id") Integer id){
		Student student = (Student)studentDao.queryOneById(id);
		
		return student;
		//return student;
	}
	
	@RequestMapping (value="/a/student/id/{id}", method=RequestMethod.PUT)
	public @ResponseBody List<BasicVo> updateOne(@PathVariable (value="id") Integer id, Student student){
		studentDao.updateData(student);
		
		List<BasicVo> list = new ArrayList<BasicVo>();
		list = studentDao.queryAll();
		return list;
	}
	
	@RequestMapping (value="/a/student/id/{id}", method=RequestMethod.DELETE)
	public @ResponseBody List<BasicVo> deleteOne(@PathVariable (value="id") Integer id){
		studentDao.deleteData(id);
		
		List<BasicVo> list = new ArrayList<BasicVo>();
		list = studentDao.queryAll();
		return list;
	}
}
