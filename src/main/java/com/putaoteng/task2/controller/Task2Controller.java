package com.putaoteng.task2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.putaoteng.task2.dao.UserDao;
import com.putaoteng.task2.model.BasicVo;
import com.putaoteng.task2.model.User;
import com.putaoteng.task2.utils.Log;
import com.putaoteng.task2.utils.LogLevel;

@Controller
public class Task2Controller {
	@Resource(name = "userDao")
	private UserDao userDao;

	// 查询所有数据,用get方法
	@RequestMapping(value = "/a/user/list", method = RequestMethod.GET)
	public String queryAll(Model model) {
		List<BasicVo> list = new ArrayList<BasicVo>();

		list = userDao.queryAll();
		
		model.addAttribute("userList", list);
		
		Log.loggerCreate(LogLevel.INFO, "查询一组数据");

		return "usersList";
	}

	// 添加一条数据,用post方法
	@RequestMapping(value = "/a/user/list", method = RequestMethod.POST)
	public String addOne(Model model, User user) {
		model.addAttribute("user", user);

		return "addUser";
	}

	// 点提交后,增加数据成功,返回成功页面
	@RequestMapping(value = "/a/user/add", method = RequestMethod.POST)
	public String addSuccess(Model model, User user) {
		userDao.addData(user);

		model.addAttribute("user", user);

		return "success";
	}

	// 根据ID查询一条数据,用get方法
	@RequestMapping(value = "/a/user/id/{id}", method = RequestMethod.GET)
	public String queryOne(@PathVariable(value = "id") Integer id, Model model) {
		User user = (User) userDao.queryOneById(id);

		List<User> list = new ArrayList<User>();
		list.add(user);

		model.addAttribute("userList", list);

		return "user";
	}

	// 根据姓名查询一組数据,用get方法
	@RequestMapping(value = "/a/user/name/{name}", method = RequestMethod.GET)
	public String queryByName(@PathVariable(value = "name") String name, Model model) {
		List<BasicVo> list = new ArrayList<BasicVo>();

		list = userDao.queryListByName(name);

		model.addAttribute("userList", list);

		return "user";
	}

	// 删除一条数据,应该用delete方法,但是前端指定delete方法时要用JavaScript,所以,这里暂用非restful风格的接口
	@RequestMapping(value = "/a/user/id/{id}/delete", method = RequestMethod.GET)
	public String deleteOne(@PathVariable(value = "id") Integer id, Model model) {
		userDao.deleteData(id);

		return "success";
	}

	// 更新一条数据,用post方法
	@RequestMapping(value = "/a/user/id/{id}", method = RequestMethod.POST)
	public String updateOne(@PathVariable(value = "id") Integer id, Model model) {
		User user = (User) userDao.queryOneById(id);

		model.addAttribute("user", user);

		return "editUser";
	}

	// 点击提交,更新执行,返回成功页面
	@RequestMapping(value = "/a/user/id/{id}/update", method = RequestMethod.POST)
	public String updateSuccess(@PathVariable(value = "id") Integer id, Model model, User user) {
		userDao.updateData(user);

		return "success";
	}

}
